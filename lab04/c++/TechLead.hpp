#ifndef __TECHLEAD_HPP
#define __TECHLEAD_HPP 
#include <iostream>

#include "Desenvolvedor.hpp"
#include "Gerente.hpp"

using namespace std;

class TechLead: public Desenvolvedor, public Gerente{
    
    private:
        int projetosEmAndamento;
    
    public:

        TechLead(int projetosEmAndamento, string linguagemPrincipal, int numeroDeEquipes, string nome, float salarioBase);

        int getProjetosEmAndamento();
        
        void setProjetosEmAndamento(int projetosEmAndamento);

        string descricao() override; 
        
};

#endif
