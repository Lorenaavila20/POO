import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Cliente[] clientes = new Cliente[100];
        int contadorClientes = 0;

         while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Adicionar Produto a um Cliente");
            System.out.println("3. Exibir Detalhes de um Cliente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao){

                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String CPF = scanner.nextLine();
                    clientes[contadorClientes++] = new Cliente(nome, CPF);
                    System.out.println("Cliente cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.print("Digite o CPF do cliente: ");
                    CPF = scanner.nextLine();
                    Cliente cliente = null;
                    for (int i = 0; i < contadorClientes; i++) {
                        if (clientes[i].getCPF().equals(CPF)) {
                            cliente = clientes[i];
                            break;
                        }
                    }
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.\n");
                        break;
                    }
                    System.out.println("Escolha o tipo de produto:");
                    System.out.println("1. Eletrônico");
                    System.out.println("2. Vestuário");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); 
                    if (tipo == 1) {
                        System.out.print("Digite o nome do produto: ");
                        String nomeProduto = scanner.nextLine();
                        System.out.print("Digite o preço do produto: ");
                        double preco = scanner.nextDouble();
                        System.out.print("Digite a garantia (em meses): ");
                        int garantia = scanner.nextInt();
                        scanner.nextLine();
                        cliente.adicionaCompra(new Eletronico(nomeProduto, preco, garantia));
                    }
                    else if (tipo == 2) {
                        System.out.print("Digite o nome do produto: ");
                        String nomeProduto = scanner.nextLine();
                        System.out.print("Digite o preço do produto: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Digite o tamanho: ");
                        String tamanho = scanner.nextLine();
                        cliente.adicionaCompra(new Vestuario(nomeProduto, preco, tamanho));
                    } else {
                        System.out.println("Tipo de produto inválido.\n");
                    }
                    System.out.println("Produto adicionado com sucesso!\n");
                    break; 

                case 3:
                    System.out.print("Digite o CPF do cliente: ");
                    CPF = scanner.nextLine();
                    cliente = null;
                    for (int i = 0; i < contadorClientes; i++) {
                        if (clientes[i].getCPF().equals(CPF)) {
                            cliente = clientes[i];
                            break;
                        }
                    }
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.\n");
                    } else {
                        System.out.println(cliente.getDetalhes() + "\n");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.\n");
            }
        }
    }
}