#include "Disciplina.hpp"
#include <iostream>

using namespace std;

Disciplina::Disciplina(string nome, int cargaHoraria, Professor* Professor){
    nome = nome;
    cargaHoraria = cargaHoraria;
    professor = professor;
}

string Disciplina::getNome(){
    return nome;
}

int Disciplina::getCargaHoraria(){
    return cargaHoraria;
}

void Disciplina::setNome(string& novoNome){
    nome = novoNome;
}

void Disciplina::setCargaHoraria(int novaCargaHoraria){
    cargaHoraria = novaCargaHoraria;
}

void Disciplina::setProfessor(Professor* novoProfessor){
    professor = novoProfessor;
}