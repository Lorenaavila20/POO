#ifndef ROBODERESGATE_HPP
#define ROBODERESGATE_HPP

#include <cstddef>
#include <queue>
#include <utility>
#include <vector>
#include <list>
#include <memory>
#include <fstream>
#include "EstacaoEspacial.hpp"
#include "Modulo.hpp"
#include "ModuloComAstronauta.hpp"
#include "Astronauta.hpp"

class RoboDeResgate {
private:
    int x, y;  // Posição atual do robô
    int safeX, safeY; 
    EstacaoEspacial& estacao;
    int passos;  // Contador de passos realizados
    std::vector<std::shared_ptr<Astronauta>> astronautasResgatados;  // Lista de astronautas resgatados

public:
    RoboDeResgate(EstacaoEspacial& estacao, int x_inicial, int y_inicial);

    void buscarAstronautasComBFS();  // Método para buscar astronautas usando BFS
    void gerarRelatorio(std::ofstream& arquivoSaida) const;  // Gera o relatório do resgate
    int getPassos() const;  // Retorna o número de passos
    int calcularCaminhoDeVolta();  // Método para calcular o caminho de volta
    void imprimirEstadoAtual() const;  // Imprime o estado atual (opcional para depuração)
};

#endif