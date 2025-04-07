#include "Funcionario.hpp"

using namespace std;

Funcionario::Funcionario(string nome, float salarioBase){
    this->nome = nome;
    this->salarioBase = salarioBase;
}

string Funcionario::getNome(){
    return nome;
}

float Funcionario::getSalarioBase(){
    return salarioBase;
}

void Funcionario::setNome(string nome){
    this->nome = nome;
}

void Funcionario::setSalario_Base(float salario_base){
    this->salarioBase = salarioBase;
}

string Funcionario::descricao(){
    return "Funcionário: " + nome + ", salário base: " + to_string(salarioBase);
}