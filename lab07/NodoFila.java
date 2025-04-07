public class NodoFila{
    private Pedido pedido;
    private NodoFila proximo;

    public NodoFila(Pedido pedido){
        this.pedido = pedido;
        this.proximo = null;
    }

    public Pedido getPedido(){
        return pedido;
    }

    public NodoFila getProximo(){
        return proximo;
    }

    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }

    public void setProximo(NodoFila proximo){
        this.proximo = proximo;
    }
}