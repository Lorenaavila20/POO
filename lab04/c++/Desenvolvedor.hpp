#ifndef __DESENVOLVEDOR_HPP
#define __DESENVOLVEDOR_HPP 

#include "Funcionario.hpp"

using namespace std;

class Desenvolvedor: virtual public Funcionario{
    protected: 
        string linguagemPrincipal;

    public:
        
        Desenvolvedor(string nome, float salarioBase, string linguagemPrincipal);

        string getLinguagemPrincipal();

        void setLinguagemPrincipal(string linguagemPrincipal);

        string projetosRealizados();
        string descricao() override;
};

#endif
