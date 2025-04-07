#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <list>
#include <memory>
#include "EstacaoEspacial.hpp"
#include "RoboDeResgate.hpp"
#include "Modulo.hpp"
#include "ModuloComAstronauta.hpp"
#include "ModuloComFogo.hpp"
#include "ModuloObstaculo.hpp"
#include "ModuloSeguranca.hpp"
#include "ModuloVazio.hpp"
#include "ModuloNormal.hpp"
#include "Astronauta.hpp"

using namespace std;

void processarArquivo(const string& nomeArquivoEntrada, const string& nomeArquivoSaida);

int main() {
    // Processa os arquivos de entrada1.txt a entrada10.txt
    for (int i = 1; i <= 10; i++) {
        string nomeArquivoEntrada = "entrada" + to_string(i) + ".txt";
        string nomeArquivoSaida = "saida" + to_string(i) + ".txt";

        // Verifica se o arquivo de entrada existe
        ifstream arquivoEntrada(nomeArquivoEntrada);
        if (!arquivoEntrada.is_open()) {
            cout << "Arquivo " << nomeArquivoEntrada << " não encontrado. Pulando...\n";
            continue;
        }
        arquivoEntrada.close();

        // Processa o arquivo e gera o relatório
        processarArquivo(nomeArquivoEntrada, nomeArquivoSaida);
    }

    return 0;
}

void processarArquivo(const string& nomeArquivoEntrada, const string& nomeArquivoSaida) {
    ifstream arquivoEntrada(nomeArquivoEntrada);
    ofstream arquivoSaida(nomeArquivoSaida);

    if (!arquivoEntrada.is_open()) {
        cerr << "Erro ao abrir o arquivo de entrada: " << nomeArquivoEntrada << endl;
        return;
    }

    if (!arquivoSaida.is_open()) {
        cerr << "Erro ao criar o arquivo de saída: " << nomeArquivoSaida << endl;
        return;
    }

    // Leitura das dimensões da matriz
    int linhas, colunas;
    if (!(arquivoEntrada >> linhas >> colunas)) {
        cerr << "Dimensões da matriz inválidas.\n";
        return;
    }

    // Criação da estação espacial
    EstacaoEspacial estacao(linhas, colunas);
    int x_inicial = 0, y_inicial = 0;
    vector<pair<int, int>> posicoesAstronauta;  // Armazena as posições (i, j) onde o caractere é 'A'

    // Leitura da matriz
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            char tipoModulo;
            if (!(arquivoEntrada >> tipoModulo)) {
                cerr << "Tipo de módulo inválido na posição: (" << i << ", " << j << ")\n";
                continue;
            }
            estacao.adicionarModulo(i, j, tipoModulo);
            if (tipoModulo == 'S') {
                x_inicial = i;
                y_inicial = j;
            }
            if (tipoModulo == 'A') {
                posicoesAstronauta.push_back({i, j});
            }
        }
    }

    // Descarta a linha residual após a leitura da matriz
    string linhaResidual;
    getline(arquivoEntrada, linhaResidual);

    // Ignora a linha "Astronautas:"
    string linha;
    getline(arquivoEntrada, linha);

    // Leitura dos astronautas (os dados não contêm coordenadas)
    int idx = 0;
    while (getline(arquivoEntrada, linha)) {
        if (linha.empty())
            continue;  // Ignora linhas vazias

        stringstream ss(linha);
        string nome;
        int nivelSaude;
        int atendimentoUrgente;  // Usado como inteiro (0 ou 1)

        // Usa vírgulas como delimitador
        getline(ss, nome, ',');  // Nome do astronauta
        ss >> nivelSaude;        // Nível de saúde
        ss.ignore(1, ',');       // Ignora a vírgula
        ss >> atendimentoUrgente; // Urgência (0 ou 1)

        // Se houver uma posição de módulo 'A' para este astronauta, usa-a
        int x = 0, y = 0;
        if (idx < posicoesAstronauta.size()) {
            x = posicoesAstronauta[idx].first;
            y = posicoesAstronauta[idx].second;
        }
        idx++;

        // Exibe os dados lidos para depuração
        cout << "Nome: " << nome << ", Saúde: " << nivelSaude 
             << ", Urgente: " << (atendimentoUrgente ? "Sim" : "Não") 
             << ", Posição atribuída: (" << x << ", " << y << ")" << endl;

        // Cria o astronauta com a posição definida a partir da matriz e adiciona à estação
        Astronauta astronauta(nome, nivelSaude, atendimentoUrgente, x, y);
        estacao.adicionarAstronauta(make_shared<Astronauta>(astronauta));
    }

    // Posição inicial do robô (definida pelo módulo de segurança)
    RoboDeResgate robo(estacao, x_inicial, y_inicial);

    // Inicia o resgate usando BFS
    robo.buscarAstronautasComBFS();

    // Gera o relatório no arquivo de saída
    robo.gerarRelatorio(arquivoSaida);

    arquivoEntrada.close();
    arquivoSaida.close();
}
