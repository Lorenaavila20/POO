#include <iostream>
#include "corrida.hpp"

using namespace std;

Corrida::Corrida(string modelo, string motorizacao, string fabricante, string motorista, double kmI, double kmF)
    : modeloCarro(modelo), motorizacaoCarro(motorizacao), fabricanteCarro(fabricante), nomeMotorista (motorista), kmInicial(kmI), kmFinal(kmF){}

string Corrida:: getModeloCarro() const {return modeloCarro;}
string Corrida:: getMotorizacao() const {return motorizacaoCarro;}
string Corrida:: getFabricantevei() const {return fabricanteCarro;}
string Corrida:: getNomeMotorista() const {return nomeMotorista;}
double Corrida:: getQuilometragemInicial() const {return kmInicial;}
double Corrida:: getQuilometragemFinal() const {return kmFinal;}

void Corrida:: setModeloCarro (string modelo) {modeloCarro = modelo;}
void Corrida:: setMotorizacao (string motorizacao) {motorizacaoCarro = motorizacao;}
void Corrida:: setFabricante (string fabricante) {fabricanteCarro = fabricante;}
void Corrida:: setNomeMotorista (string motorista) {nomeMotorista = motorista;}
void Corrida:: setQuilometragemInicial (double kmI) {kmInicial = kmI;}
void Corrida:: setQuilometragemFinal (double kmF) {kmFinal = kmF;}

double Corrida::calcularQuilometragemPercorrida () const{
    return kmFinal - kmInicial;
}

double Corrida::valorFinal() const{
    const double precoPorKm = 3.75;
    return calcularQuilometragemPercorrida () * precoPorKm;
}