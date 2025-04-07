#include <iostream>
#include "Curso.hpp" 

using namespace std;

int main(){

    string nomeCurso;
    cout << "Digite o nome do curso: ";
    getline(cin, nomeCurso); 
    Curso curso(nomeCurso); 

    int numProfessores;
    cout << "Quantos professores deseja cadastrar? ";
    cin >> numProfessores;
    cin.ignore();
    
    for (int i = 0; i < numProfessores; ++i){
        string professor;
        cout << "Digite o nome do professor #" << i + 1 << ": ";
        getline(cin, professor);
        curso.cadastrarProfessor(professor);
    }


    int numAlunos;
    cout << "Quantos alunos deseja cadastrar? ";
    cin >> numAlunos;
    cin.ignore();  

    for (int i = 0; i < numAlunos; ++i){
        string aluno;
        cout << "Digite o nome do aluno #" << i + 1 << ": ";
        getline(cin, aluno);
        curso.cadastrarAluno(aluno);
    }


    int numDisciplinas;
    cout << "Quantas disciplinas deseja cadastrar? ";
    cin >> numDisciplinas;
    cin.ignore();

    for (int i = 0; i < numDisciplinas; ++i) {
        string disciplina;
        cout << "Digite o nome da disciplina #" << i + 1 << ": ";
        getline(cin, disciplina);
        curso.cadastrarDisciplina(disciplina);
    }


    cout << "\nLista de Professores: \n";
    curso.imprimirListaDeProfessores();

    cout << "\nLista de Alunos: \n";
    curso.imprimirListaDeAlunos();

    cout << "\nLista de Disciplinas: \n";
    curso.imprimirListaDeDisciplinas();

    return 0;
}
