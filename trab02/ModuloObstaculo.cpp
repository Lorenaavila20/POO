#include "ModuloObstaculo.hpp"

ModuloObstaculo::ModuloObstaculo() : Modulo('#') {}

bool ModuloObstaculo::podeAcessar() const {
    return false; 
}

std::string ModuloObstaculo::toString() const {
    return "Modulo com obstaculo!";
}