#include <iostream>
#include <string>
#include "corrida.hpp"

using namespace std;

int main(){
    
    string modelo, fabricante, motorizacao, motorista;
    double kmI, kmF;

    cout << "Insira o modelo do carro: ";
    getline (cin, modelo);

    cout << "Insira a motorização do carro: ";
    getline (cin, motorizacao);

    cout << "Insira o fabricante do veículo: ";
    getline (cin, fabricante);

    cout << "Insira o nome do motorista: ";
    getline (cin, motorista);

    cout << "Insira a quilometragem inicial: ";
    cin >> kmI;

    cout << "Insira a quilometragem final: ";
    cin >> kmF;

    Corrida corrida (modelo, motorizacao, fabricante, motorista, kmI, kmF);

    cout << "\nDados da corrida\n";
    cout << "modelo do carro:\t" << corrida.getModeloCarro() << endl;
    cout << "motorização do carro:\t" << corrida.getMotorizacao() << endl;
    cout << "fabricante do carro\t: " << corrida.getFabricantevei() << endl; 
    cout << "nome do motorista\t: " << corrida.getNomeMotorista() << endl;
    cout << "quilometragem inicial:\t" << corrida.getQuilometragemInicial() << endl;
    cout << "quilometragem final:\t" << corrida.getQuilometragemFinal() << endl;
    cout << "quilometragem percorrida:\t" << corrida.calcularQuilometragemPercorrida() << "km" << endl;
    cout << "valor total R$\t" << corrida.valorFinal() << endl; 
    
    return 0;
}