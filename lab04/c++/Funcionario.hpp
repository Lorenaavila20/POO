#ifndef __FUNCIONARIO_HPP
#define __FUNCIONARIO_HPP 
#include <iostream>
#include <string>

using namespace std;

class Funcionario{

    protected:
        string nome;
        float salarioBase;

    public:

        Funcionario (string nome, float salarioBase);

        string getNome();
        float getSalarioBase();

        void setNome(string nome);
        void setSalario_Base(float salarioBase);

        virtual string descricao();
        virtual ~Funcionario(){}
};
#endif