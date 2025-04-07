#ifndef CORRIDA_HPP
#define CORRIDA_HPP
#include <string>

using namespace std;
    
    class Corrida {
        private:
            string modeloCarro;
            string motorizacaoCarro;
            string fabricanteCarro;
            string nomeMotorista;
            double kmInicial;
            double kmFinal;

        public:
            //construtor: é chamado automaticamente quando um objeto da classe é criado
            Corrida(string modelo, string motorizacao, string fabricante, string motorista, double kmI, double kmF);

            //getters retornam o valor de um atributo específico sem alterá-lo
            string getModeloCarro () const; //const significa que é constante e nao pode ser mudado
            string getMotorizacao () const;
            string getFabricantevei () const;
            string getNomeMotorista () const;
            double getQuilometragemInicial () const;
            double getQuilometragemFinal () const;

            //setters modificam o valor de um atributo específico
            void setModeloCarro (string modelo);
            void setMotorizacao (string motorizacao);
            void setFabricante (string fabricante);
            void setNomeMotorista (string motorista);
            void setQuilometragemInicial (double kmI);
            void setQuilometragemFinal (double kmF);


            double calcularQuilometragemPercorrida() const;
            double valorFinal() const;
    };
#endif