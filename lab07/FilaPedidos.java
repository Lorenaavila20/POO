public class FilaPedidos{
    private NodoFila cabeca;
    private NodoFila cauda;
    private HistoricoPedidos historicoPedidos;

    public FilaPedidos(HistoricoPedidos historicoPedidos){
        this.cabeca = null;
        this.cauda = null;
        this.historicoPedidos = historicoPedidos;
    }

    public boolean estaVazia(){
        return cabeca == null;
    }

    public void enfileirar(Pedido pedido){
        NodoFila novoNodo = new NodoFila(pedido);
        if (estaVazia()){
            cabeca = novoNodo;
            cauda = novoNodo;
        }else{
            cauda.setProximo(novoNodo);
            cauda = novoNodo;
        }
    }


    public void desenfileirar(){
        if (estaVazia()){
            System.out.println("A fila está vazia. Nenhum pedido para remover.");
            return; 
        }

        Pedido pedidoRemovido = cabeca.getPedido();
        cabeca = cabeca.getProximo();

        if (cabeca == null){ 
            cauda = null;
        }
        historicoPedidos.adicionarPedido(pedidoRemovido);
        System.out.println("Pedido preparado e movido para o histórico: " + pedidoRemovido);
    }

    public void exibirFila(ListaClientes listaClientes){
        if (estaVazia()){
            System.out.println("A fila está vazia.");
            return;
        }

        NodoFila temp = cabeca;
        while (temp != null){
            Pedido pedido = temp.getPedido();
            Pessoa cliente = listaClientes.buscarCliente(pedido.getCpf());
            if (cliente != null){
                System.out.println("Pedido: " + pedido.getDescricaoPedido() + ", Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
            } else {
                System.out.println("Pedido: " + pedido.getDescricaoPedido() + ", Cliente não encontrado.");
            }
            temp = temp.getProximo();
        }
    }
}