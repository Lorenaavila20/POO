#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int main(){
    
    ifstream arquivoEntrada("entrada.txt");
    ofstream arquivoSaida("saida.txt");
    string linha;

    if(!arquivoEntrada || !arquivoSaida){
        cerr << "Não foi possivel abrir o arquivo de entrada ou o de saída: "<< endl;
        return -1;
    }

    
    while (getline(arquivoEntrada, linha)){
        bool italico = false;
        bool negrito = false;

        for (char caracter : linha) {

            if (caracter == '_') {

                arquivoSaida << (italico ? "</i>" : "<i>");
                italico = !italico;

            } else if (caracter == '*') {

                arquivoSaida << (negrito ? "</b>" : "<b>");
                negrito = !negrito;

            } else {

                arquivoSaida << caracter;
            }
        }

            arquivoSaida << endl;
    }

        arquivoEntrada.close();
        arquivoSaida.close();

        return 0;
}