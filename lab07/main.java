import java.util.Scanner;

public class main {
    private static ListaClientes listaClientes = new ListaClientes();
    private static HistoricoPedidos historicoPedidos = new HistoricoPedidos();
    private static FilaPedidos filaPedidos = new FilaPedidos(historicoPedidos);  // Passando histórico para fila
    private static int codigoPedido = 1;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando){
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar cliente");
            System.out.println("2. Adicionar pedido");
            System.out.println("3. Preparar próximo pedido");
            System.out.println("4. Exibir pedidos em espera");
            System.out.println("5. Exibir histórico de pedidos");
            System.out.println("6. Exibir lista de clientes");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    Pessoa cliente = new Pessoa(nome, cpf);
                    listaClientes.inserirClienteFinal(cliente);

                    System.out.println("Cliente adicionado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o CPF do cliente: ");
                    cpf = scanner.nextLine();
                    cliente = listaClientes.buscarCliente(cpf);

                    if (cliente != null){
                        System.out.print("Digite a descrição do pedido: ");
                        String descricao = scanner.nextLine();

                        System.out.print("Digite o tempo estimado de preparo (em minutos): ");
                        int tempoEstimado = scanner.nextInt();
                        scanner.nextLine(); 
                        
                        Pedido pedido = new Pedido(codigoPedido++, descricao, tempoEstimado, cpf);
                        filaPedidos.enfileirar(pedido);
                        System.out.println("Pedido adicionado com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 3:
                    filaPedidos.desenfileirar(); 
                    break;
                case 4:
                    System.out.println("\nPedidos em espera:");
                    filaPedidos.exibirFila(listaClientes);
                    break;
                case 5:
                    System.out.println("\nHistórico de pedidos:");
                    historicoPedidos.exibirHistorico();
                    break;
                case 6:
                    System.out.println("\nLista de clientes cadastrados:");
                    listaClientes.exibirClientes();
                    break;
                case 7:
                    rodando = false;
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
