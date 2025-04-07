#ifndef __DISCIPLINA_HPP
#define __DISCIPLINA_HPP
#include<iostream>
#include <string>
#include "Professor.hpp"

using namespace std;

class Disciplina{
    private:
        string nome;
        int cargaHoraria;
        Professor* professor;

    public:
        Disciplina();
        Disciplina(string nome, int cargaHoraria, Professor* professor);

        string getNome();
        int getCargaHoraria();
        
        void setNome(string& novoNome);
        void setCargaHoraria(int novaCargaHoraria);
        void setProfessor(Professor* novoProfessor);
     
};

#endif