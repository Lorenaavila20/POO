#include "Gerente.hpp"

using namespace std;

Gerente::Gerente(string nome, float salarioBase, int numeroDeEquipes): Funcionario(nome, salarioBase){
    this->numeroDeEquipes = numeroDeEquipes;
}

int Gerente::getNumeroDeEquipes(){
    return numeroDeEquipes;
}

void Gerente::setNumeroDeEquipes(int numeroDeEquipes){
    this->numeroDeEquipes = numeroDeEquipes;
}

float Gerente::bonus(){
    return numeroDeEquipes * 500;
}

string Gerente::descricao(){
    return Funcionario::descricao() + ", número de equipes: " + to_string (numeroDeEquipes) + ", bônus: " + to_string(bonus());
}