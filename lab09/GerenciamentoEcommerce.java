import java.util.Scanner;

public class GerenciamentoEcommerce{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ListaProduto<Produto> listaProdutos = new ListaProduto<>();
        FilaPedido<Pedido> filaPedidos = new FilaPedido<>();
        HistoricoPedidos<Pedido> historicoPedidos = new HistoricoPedidos<>();
    

    while (true){
        System.out.println("\n*** Menu ***");
        System.out.println("1. Cadastrar um novo produto");
        System.out.println("2. Registrar um novo pedido");
        System.out.println("3. Processar o próximo pedido");
        System.out.println("4. Exibir produtos cadastrados");
        System.out.println("5. Exibir pedidos pendentes");
        System.out.println("6. Exibir histórico de pedidos concluídos");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                System.out.print("Digite o código do produto: ");
                int codigo = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o preço do produto: ");
                double preco = scanner.nextDouble();
                System.out.print("Digite o estoque do produto: ");
                int estoque = scanner.nextInt();

                Produto produto = new Produto(codigo, nome, preco, estoque);
                listaProdutos.adicionarProduto(produto);
                System.out.println("Produto cadastrado com sucesso!");
                break;

            case 2:
                System.out.print("Digite o código do pedido: ");
                int codigoPedido = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Digite o nome do cliente: ");
                String clienteNome = scanner.nextLine();

                Pedido pedido = new Pedido(codigoPedido, clienteNome);

                while (true) {
                    System.out.print("Digite o nome do produto a ser adicionado (ou 'fim' para finalizar): ");
                    String nomeProduto = scanner.nextLine();
                    if (nomeProduto.equalsIgnoreCase("fim")) {
                        break;
                    }

                    Produto produtop = listaProdutos.buscarProduto(nomeProduto);

                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); 

                    try {
                        pedido.adicionarProduto(produtop, quantidade);
                        System.out.println("Produto adicionado ao pedido.");
                    } catch (IllegalArgumentException | IllegalStateException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                if (!pedido.getItens().isEmpty()){
                    filaPedidos.adicionarPedido(pedido);
                    System.out.println("Pedido registrado com sucesso!");
                } else{
                    System.out.println("Pedido não pode ser criado sem itens.");
                }
                break;

            case 3:
                Pedido pedidor = filaPedidos.removerPedido();
                historicoPedidos.adicionarAoHistorico(pedidor);
                System.out.println("Pedido processado e movido para o histórico.");
                break;

            case 4:
                listaProdutos.exibirProdutos();
                break;
                
            case 5:
                filaPedidos.exibirFila();
                break;
            case 6:
                historicoPedidos.exibirHistorico();
                break;
            case 7:
                System.out.println("Saindo...");
                scanner.close();
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
}
