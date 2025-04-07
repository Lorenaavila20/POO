#ifndef __PESSOA_HPP
#define __PESSOA_HPP 
#include<iostream>
#include <string>

using namespace std; 

class Pessoa{
    
    protected:
        string nome;
        string endereco;
    public:
        Pessoa();
        Pessoa(string nome, string endereco);

        string getNome();
        string getEndereco();

        void setNome(string nome);
        void setEndereco(string endereco);
        //void print();
        //void printNome();

};
#endif