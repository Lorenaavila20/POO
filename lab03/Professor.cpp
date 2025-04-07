#include "Professor.hpp"
#include <iostream>

using namespace std;

Professor::Professor() : titulacao(""), curso("") {}

Professor::Professor(string nome, string endereco, string titulacao, string curso){
    nome = nome;
    endereco = endereco;
    titulacao = titulacao;
    curso = curso;
}

string Professor::getTitulacao(){
    return titulacao;
}

string Professor::getCurso(){
    return curso;
}

void Professor::setTitulacao(string& novoTitulacao){
    this->titulacao = novoTitulacao;
}

void Professor::setCurso(string& novoCurso){
    this-> curso = novoCurso;
}