#ifndef __ALUNO_HPP
#define __ALUNO_HPP
#include<iostream>
#include "Pessoa.hpp"
#include <string>

using namespace std;

class Aluno : public Pessoa{
    private:
        int matricula;

    public:
        Aluno();
        Aluno(int matricula, string nome, string endereco);

        int getMatricula();

        void setMatricula(int mat);
        //void print();
};

#endif