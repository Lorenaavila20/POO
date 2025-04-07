#ifndef MODULOSEGURANCA_HPP
#define MODULOSEGURANCA_HPP

#include "Modulo.hpp"

class ModuloSeguranca : public Modulo {
public:
    ModuloSeguranca();

    bool podeAcessar() const override;
    std::string toString() const override;
};

#endif