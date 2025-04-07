#include <iostream>
#include "Curso.hpp"

using namespace std;

Curso::Curso(string nome){
    nome = nome;
}

string Curso::getNome(){
    return nome;
}

void Curso::setNome(string& novoNome){
    nome = novoNome;
}

void Curso::cadastrarProfessor(string& professor){
    professores.push_back(professor);
}

void Curso::cadastrarAluno(string& aluno){
    alunos.push_back(aluno);
}

void Curso::cadastrarDisciplina(string& disciplina){
    disciplinas.push_back(disciplina);
}

void Curso::imprimirListaDeProfessores(){
    cout << "Professores do curso"<< nome << ":" << endl;
    for(auto& professor : professores){
        cout <<"- " << professor << endl;
    }
}

void Curso::imprimirListaDeAlunos(){
    cout << "Alunos do curso"<< nome << ":" << endl;
    for(auto& aluno : alunos){
        cout <<"- " << aluno << endl;
    }
}

void Curso::imprimirListaDeDisciplinas(){
    cout << "Disciplinas do curso"<< nome << ":" << endl;
    for(auto& disciplina : disciplinas){
        cout <<"- " << disciplina << endl;
    }
}