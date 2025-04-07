#include <iostream>
#include "Aluno.hpp"

using namespace std;

Aluno::Aluno(int matricula, string nome, string endereco){
    nome = nome;
    matricula = matricula;
}

int Aluno::getMatricula(){
    return matricula;
}

void Aluno::setMatricula (int mat){
    this->matricula = matricula;
}