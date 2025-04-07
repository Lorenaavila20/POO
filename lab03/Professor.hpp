#ifndef __PROFESSOR_HPP
#define __PROFESSOR_HPP
#include<iostream>
#include <string>
#include "Pessoa.hpp"

using namespace std;

class Professor : public Pessoa{
    private:
        string titulacao;
        string curso;

    public:
        Professor();
        Professor(string nome, string endereco, string titulacao, string curso);

        string getTitulacao();
        string getCurso();
        
        void setTitulacao(string& novoTitulacao);
        void setCurso(string& novoCurso);
   
};

#endif