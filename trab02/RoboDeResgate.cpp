#include "RoboDeResgate.hpp"
#include "Modulo.hpp"
#include "ModuloComAstronauta.hpp"
#include <algorithm>
#include <queue>
#include <iostream>
#include <fstream>
#include <list>

RoboDeResgate::RoboDeResgate(EstacaoEspacial& estacao, int x_inicial, int y_inicial)
    : estacao(estacao), x(x_inicial), y(y_inicial), passos(0) {}

void RoboDeResgate::gerarRelatorio(std::ofstream& arquivoSaida) const {
    arquivoSaida << "Relatório de Resgate\n";
    arquivoSaida << "Passos realizados: " << passos << "\n";
    arquivoSaida << "Astronautas resgatados:\n";

    for (const auto& astronauta : astronautasResgatados) {
        arquivoSaida << astronauta->toString() << "\n";  // Imprime os astronautas resgatados
    }

    // Lista de astronautas não resgatados
    arquivoSaida << "Astronautas não resgatados:\n";
    for (const auto& astronauta : estacao.getAstronautas()) {
        if (!astronauta->foiResgatado()) {  // Usando '->' ao invés de '.'
            arquivoSaida << astronauta->toString() << "\n";  // Usando '->' ao invés de '.'
        }
    }
}

int RoboDeResgate::getPassos() const {
    return passos;
}


void RoboDeResgate::imprimirEstadoAtual() const {
    std::cout << "Posição: (" << x << ", " << y << "), Passos: " << passos << std::endl;
}

void RoboDeResgate::buscarAstronautasComBFS() {
    // Define os movimentos permitidos: cima, baixo, esquerda e direita.
    const std::vector<std::pair<int, int>> moves = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    // Estrutura simples para armazenar uma célula e a distância a partir da posição atual do robô.
    struct Node {
        int x;
        int y;
        int dist; // Número de passos a partir da posição atual.
    };

    // Loop principal: enquanto houver um astronauta alcançável.
    while (true) {
        int L = estacao.getLinhas();
        int C = estacao.getColunas();

        // Cria uma matriz "visited" para marcar as células já visitadas.
        std::vector<std::vector<bool>> visited(L, std::vector<bool>(C, false));
        std::queue<Node> q;
        
        // Inicia o BFS a partir da posição atual do robô.
        Node start = { x, y, 0 };
        q.push(start);
        visited[x][y] = true;

        // Variáveis para armazenar o melhor candidato (astronauta não resgatado) encontrado.
        bool foundCandidate = false;
        Node candidate;
        candidate.dist = 0; // Inicializa a distância.

        // Executa o BFS.
        while (!q.empty()) {
            Node current = q.front();
            q.pop();

            // Se já encontramos um candidato e a distância atual for maior, não expandimos mais.
            if (foundCandidate && current.dist > candidate.dist)
                continue;

            // Verifica se a célula atual contém um astronauta não resgatado.
            std::shared_ptr<Modulo> mod = estacao.getMatriz()[current.x][current.y];
            ModuloComAstronauta* modAstro = dynamic_cast<ModuloComAstronauta*>(mod.get());
            if (modAstro != nullptr) {
                std::shared_ptr<Astronauta> astro = modAstro->getAstronauta();
                if (astro != nullptr && !astro->foiResgatado()) {
                    // Se for o primeiro candidato encontrado, ou se for melhor (menor distância ou desempate por posição),
                    // atualiza o candidato.
                    if (!foundCandidate) {
                        candidate = current;
                        foundCandidate = true;
                    } else {
                        if (current.dist < candidate.dist ||
                           (current.dist == candidate.dist && (current.x < candidate.x ||
                           (current.x == candidate.x && current.y < candidate.y)))) {
                            candidate = current;
                        }
                    }
                }
            }

            // Expande para os vizinhos (células adjacentes).
            for (size_t i = 0; i < moves.size(); i++) {
                int nx = current.x + moves[i].first;
                int ny = current.y + moves[i].second;
                // Verifica se a posição está dentro dos limites.
                if (nx < 0 || nx >= L || ny < 0 || ny >= C)
                    continue;
                if (visited[nx][ny])
                    continue;
                
                // Verifica se o módulo na célula (nx, ny) pode ser acessado (não é obstáculo, vazio ou com fogo).
                std::shared_ptr<Modulo> nextMod = estacao.getMatriz()[nx][ny];
                if (dynamic_cast<ModuloObstaculo*>(nextMod.get()) != nullptr)
                    continue;
                if (dynamic_cast<ModuloVazio*>(nextMod.get()) != nullptr)
                    continue;
                if (dynamic_cast<ModuloComFogo*>(nextMod.get()) != nullptr)
                    continue;
                
                visited[nx][ny] = true;
                Node next = { nx, ny, current.dist + 1 };
                q.push(next);
            }
        } // Fim do BFS

        // Se nenhum candidato for encontrado, encerra a busca.
        if (!foundCandidate)
            break;

        // Atualiza os passos acumulados e a posição do robô para a célula do candidato escolhido.
        passos += candidate.dist;
        x = candidate.x;
        y = candidate.y;

        // Resgata o astronauta na célula atual (marca como resgatado e adiciona à lista).
        std::shared_ptr<Modulo> modAtual = estacao.getMatriz()[x][y];
        ModuloComAstronauta* modAstroAtual = dynamic_cast<ModuloComAstronauta*>(modAtual.get());
        if (modAstroAtual != nullptr) {
            std::shared_ptr<Astronauta> astro = modAstroAtual->getAstronauta();
            if (astro != nullptr && !astro->foiResgatado()) {
                astro->marcarComoResgatado();
                astronautasResgatados.push_back(astro);
            }
        }
    } // Fim do loop principal de resgate

    // Após resgatar todos os astronautas possíveis, calcula o caminho de volta à zona S.
    int returnSteps = calcularCaminhoDeVolta();
    if (returnSteps >= 0) {
        passos += returnSteps;
        std::cout << "Caminho de volta à zona S: " << returnSteps << " passos." << std::endl;
    } else {
        std::cout << "Não foi possível retornar à zona S." << std::endl;
    }
}

int RoboDeResgate::calcularCaminhoDeVolta() {
    int L = estacao.getLinhas();
    int C = estacao.getColunas();
    const auto& matriz = estacao.getMatriz();
    
    // Matriz para marcar células visitadas e armazenar as distâncias
    std::vector<std::vector<bool>> visited(L, std::vector<bool>(C, false));
    std::vector<std::vector<int>> dist(L, std::vector<int>(C, -1));
    
    // Fila para o BFS; cada elemento é um par (x, y)
    std::queue<std::pair<int, int>> q;
    q.push({x, y});
    visited[x][y] = true;
    dist[x][y] = 0;
    
    // Movimentos permitidos: cima, baixo, esquerda, direita
    const std::vector<std::pair<int,int>> moves = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    
    while (!q.empty()) {
        auto current = q.front();
        q.pop();
        int cx = current.first;
        int cy = current.second;
        
        // Se o módulo atual for do tipo "segurança", retorna a distância (caminho de volta encontrado)
        if (dynamic_cast<ModuloSeguranca*>(matriz[cx][cy].get()) != nullptr) {
            return dist[cx][cy];
        }
        
        // Expande para os vizinhos
        for (auto& dir : moves) {
            int nx = cx + dir.first;
            int ny = cy + dir.second;
            if (nx < 0 || nx >= L || ny < 0 || ny >= C)
                continue;
            if (visited[nx][ny])
                continue;
            
            // Verifica se o módulo pode ser atravessado (não é obstáculo, vazio ou com fogo)
            auto nextMod = matriz[nx][ny];
            if (dynamic_cast<ModuloObstaculo*>(nextMod.get()) != nullptr)
                continue;
            if (dynamic_cast<ModuloVazio*>(nextMod.get()) != nullptr)
                continue;
            if (dynamic_cast<ModuloComFogo*>(nextMod.get()) != nullptr)
                continue;
            
            visited[nx][ny] = true;
            dist[nx][ny] = dist[cx][cy] + 1;
            q.push({nx, ny});
        }
    }
    
    // Se não encontrar caminho, retorna -1
    return -1;
}

