public class ListaClientes{
    private NodoLista cabeca;
    private NodoLista cauda;

    public ListaClientes(){
        this.cabeca = null;
        this.cauda = null;
    }

    public boolean estaVazia() {
        return cabeca == null;
    }

    public void inserirClienteFinal(Pessoa cliente){
        NodoLista novoNodo = new NodoLista(cliente);
        if (estaVazia()) {
            cabeca = novoNodo;
            cauda = novoNodo;
        } else {
            cauda.setProximo(novoNodo);
            cauda = novoNodo;
        }
    }

    public Pessoa buscarCliente(String cpf){
        NodoLista temp = cabeca;

        while (temp != null){
            if (temp.getCliente().getCpf().equals(cpf)){
                return temp.getCliente();
            }
            temp = temp.getProximo();
        }
        return null; 
    }

    public void exibirClientes(){
        NodoLista temp = cabeca;
        while(temp != null){
            System.out.println(temp.getCliente());
            temp = temp.getProximo();
        }
    }
}