#include <iostream>
#include "TechLead.hpp"

using namespace std;


TechLead::TechLead(int projetosEmAndamento, string linguagemPrincipal, int numeroDeEquipes, string nome, float salarioBase)
    : Funcionario(nome, salarioBase), Desenvolvedor(nome, salarioBase, linguagemPrincipal), Gerente(nome, salarioBase, numeroDeEquipes){
    this->projetosEmAndamento = projetosEmAndamento;
}

int TechLead::getProjetosEmAndamento(){
    return projetosEmAndamento;
}

void TechLead::setProjetosEmAndamento(int projetosEmAndamento){

    this-> projetosEmAndamento = projetosEmAndamento;
}

string TechLead::descricao(){
    return Gerente::descricao() + ", "+ Desenvolvedor::descricao() + ", projetos em andamento: " + to_string(projetosEmAndamento);
}