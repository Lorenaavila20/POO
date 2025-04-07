#ifndef __CURSO_HPP
#define __CURSO_HPP
#include <string>
#include <vector>

using namespace std;

class Curso{

    private: 
        string nome;
        vector <string> professores;
        vector <string> alunos;
        vector <string> disciplinas;
    
    public:
        Curso();
        Curso(string nome);

        string getNome();

        void setNome(string& nome);

        void cadastrarProfessor(string& professor);
        void cadastrarAluno(string& aluno);
        void cadastrarDisciplina(string& disciplina);

        void imprimirListaDeProfessores();
        void imprimirListaDeAlunos();
        void imprimirListaDeDisciplinas();
    
};
#endif