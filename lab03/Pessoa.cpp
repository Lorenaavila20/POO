#include <iostream>
#include "Pessoa.hpp"

using namespace std;

    Pessoa::Pessoa(){}

    Pessoa::Pessoa(string nome, string endereco){
        this->nome = nome;
        this->endereco = endereco;
    }

    string Pessoa::getNome(){
        return nome;
    }

    string Pessoa::getEndereco(){
        return endereco;
    }

    void Pessoa::setNome(string nome){
        this->nome = nome;
    }

    void Pessoa::setEndereco(string endereco){
        this->endereco = endereco;
    }