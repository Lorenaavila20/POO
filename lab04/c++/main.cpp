#include <iostream>
#include <vector> 

#include "Gerente.hpp"
#include "Desenvolvedor.hpp"
#include "TechLead.hpp"

using namespace std;

int main(){
       
    vector <Funcionario*> funcionarios;
    int op;

    do {
        cout << "*** MENU ***\n";
        cout << "1. Adicionar Gerente\n";
        cout << "2. Adicionar Desenvolvedor\n";
        cout << "3. Adicionar TechLead\n";
        cout << "4. Mostrar Descrições\n";
        cout << "5. Sair\n";
        cin >> op;  

        switch (op){
            case 1:{
                string nome;
                float salario;
                int equipes;
                
                cout << "Digite o nome do gerente: ";
                cin.ignore();
                getline(cin, nome);

                cout << "Digite o salario base: ";
                cin >> salario;

                cout << "Digite o número de equipes sob supervisão: ";
                cin >> equipes;

                funcionarios.push_back(new Gerente(nome, salario, equipes));
                cout << "Gerente adicionado com sucesso!\n";
                break;
            }
            case 2:{
                string nome, linguagem; 
                float salario;

                cout << "Digite o nome do Desenvolvedor: ";
                cin.ignore();
                getline(cin, nome);

                cout << "Digite o salário base: ";
                cin >> salario;

                cout << "Digite a linguagem principal: ";
                cin.ignore();
                getline(cin, linguagem);
                
                funcionarios.push_back(new Desenvolvedor(nome, salario, linguagem));
                cout << "Desenvolvedor adicionado com sucesso!\n";
                break;
            }

            case 3:{

                string nome, linguagem;
                double salario;
                int equipes, projetos;

                cout << "Digite o nome do TechLead: ";
                cin.ignore();
                getline(cin, nome);

                cout << "Digite o salário base: ";
                cin >> salario;

                cout << "Digite o número de equipes sob supervisão: ";
                cin >> equipes;

                cout << "Digite a linguagem principal: ";
                cin.ignore();
                getline(cin, linguagem);

                cout << "Digite o número de projetos em andamento: ";
                cin >> projetos;

                funcionarios.push_back(new TechLead(projetos, linguagem, equipes, nome, salario));
                cout << "TechLead adicionado com sucesso!\n";
                break;
            }

            case 4:{
                cout << "\n***DESCRIÇÕES***\n";
                for(size_t i = 0; i < funcionarios.size(); i++){
                    cout << funcionarios [i] ->descricao() << endl;
                }
                break;
            }

            case 5:{
                cout << "Encerrando\n";
                break;
            }

            default:{
                cout << "Opção inválida\n";
                break;
            }
        }

    }while (op != 5);
        
        for (auto& func : funcionarios){
            delete func;
        }

    return 0;

}