#ifndef __GERENTE_HPP
#define __GERENTE_HPP 

#include "Funcionario.hpp"

using namespace std;

class Gerente: virtual public Funcionario{

    protected:
        int numeroDeEquipes;

    public:

        Gerente (string nome, float salarioBase, int numeroDeEquipes);

        int getNumeroDeEquipes();

        void setNumeroDeEquipes(int numeroDeEquipes);
        float bonus();
        string descricao() override;
};
#endif