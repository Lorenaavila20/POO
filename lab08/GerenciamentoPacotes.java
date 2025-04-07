import java.util.Scanner;

public class GerenciamentoPacotes{

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        ListaClientes listaClientes = new ListaClientes();
        FilaEntradaPacote filaEntrada = new FilaEntradaPacote();
        FilaPrioridadePacotes filaPrioridade = new FilaPrioridadePacotes();
        HistoricoPacotes historico = new HistoricoPacotes();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar um novo cliente à lista de clientes");
            System.out.println("2. Registrar um novo pacote");
            System.out.println("3. Processar o próximo pacote");
            System.out.println("4. Exibir os pacotes na fila de entrada");
            System.out.println("5. Exibir os pacotes na fila de prioridade");
            System.out.println("6. Exibir o histórico de pacotes entregues");
            System.out.println("7. Exibir a lista de clientes cadastrados");
            System.out.println("8. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao){
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente:");
                    String cpf = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);
                    listaClientes.adicionarCliente(cliente);
                    System.out.println("Cliente adicionado com sucesso.");
                    break;

                case 2:
                    
                    System.out.println("Digite o CPF do cliente:");
                    cpf = scanner.nextLine();
                    Cliente clienteBusca = listaClientes.buscarCliente(cpf);

                    if (clienteBusca == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    System.out.println("Digite a descrição do pacote:");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite a prioridade do pacote (1 = urgente, 2 = normal):");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine(); 

                    int codigoPacote = (int) (Math.random() * 1000); //gera um código aleatório
                    Pacote pacote = new Pacote(codigoPacote, descricao, prioridade, cpf);

                    if (prioridade == 1) {
                        filaPrioridade.adicionarPacote(pacote);
                    } else {
                        filaEntrada.adicionarPacote(pacote);
                    }

                    System.out.println("Pacote registrado com sucesso.");
                    break;

                    case 3:
                    Pacote pacoteProcessado = null;
                    if (!filaPrioridade.estaVazia()) {
                        pacoteProcessado = filaPrioridade.processarPacote();
                    } else if (!filaEntrada.estaVazia()) {
                        pacoteProcessado = filaEntrada.processarPacote();
                    }

                    if (pacoteProcessado != null) {
                        historico.adicionarAoHistorico(pacoteProcessado);
                        System.out.println("Pacote processado e adicionado ao histórico.");
                    } else {
                        System.out.println("Não há pacotes para processar.");
                    }
                    break;

                case 4:
                    filaEntrada.exibirPacotes();
                    break;

                case 5:
                    filaPrioridade.exibirPacotes();
                    break;

                case 6:
                    historico.exibirHistorico();
                    break;

                case 7:
                    listaClientes.exibirClientes();
                    break;

                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}