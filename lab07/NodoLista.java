public class NodoLista{
    private Pessoa cliente;
    private NodoLista proximo;

    public NodoLista(Pessoa cliente){
        this.cliente = cliente;
        this.proximo = null;
    }

    public Pessoa getCliente(){
        return cliente;
    }

    public NodoLista getProximo(){
        return proximo;
    }

    public void setCliente(Pessoa cliente){
        this.cliente = cliente;
    }

    public void setProximo(NodoLista proximo){
        this.proximo = proximo;
    }
    
}