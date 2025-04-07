#include "ModuloNormal.hpp"

ModuloNormal::ModuloNormal() : Modulo('.') {}  

bool ModuloNormal::podeAcessar() const {
    return true;  
}

std::string ModuloNormal::toString() const {
    return "Modulo normal!";
}