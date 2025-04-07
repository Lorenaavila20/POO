#include "Desenvolvedor.hpp"

using namespace std;

Desenvolvedor::Desenvolvedor(string nome, float salarioBase, string linguagemPrincipal): Funcionario(nome, salarioBase){
    this->linguagemPrincipal = linguagemPrincipal;
}

string Desenvolvedor::getLinguagemPrincipal(){
    return linguagemPrincipal;
}
void Desenvolvedor::setLinguagemPrincipal(string linguagemPrincipal){
    this->linguagemPrincipal = linguagemPrincipal;
}

string Desenvolvedor::projetosRealizados(){
    return "Projetos entregues na linguagem " + linguagemPrincipal;
}

string Desenvolvedor::descricao(){
    return Funcionario::descricao() + ", linguagem principal: " + linguagemPrincipal;
}