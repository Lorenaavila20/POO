public class HistoricoPedidos{
    private NodoFila cabeca;
    
    public HistoricoPedidos(){
        this.cabeca = null;
    }

    public boolean estaVazia(){
        return cabeca == null;
    }

    public void adicionarPedido(Pedido pedido){
        NodoFila novoNodo = new NodoFila(pedido);
        novoNodo.setProximo(cabeca);
        cabeca = novoNodo;
    }

    public void exibirHistorico(){
        NodoFila temp = cabeca;
        while (temp != null){
            System.out.println(temp.getPedido());
            temp = temp.getProximo();
        }
    }
    
}
