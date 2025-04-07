import java.util.LinkedList;
import java.util.Queue;

public class FilaPedido <T>{
    private Queue <T> fila;

    public FilaPedido(){
        this.fila = new LinkedList<>();
    }

    public void adicionarPedido(T pedido){
        if (pedido == null){
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        fila.add(pedido);
    }

    public T removerPedido(){
        if (!fila.isEmpty()){
            return fila.poll(); 
        } else{
            System.err.println("Não há pedidos na fila para remover.");
            return null;
        }
    }

    public void exibirUltimoPedido(){
        
        if (!fila.isEmpty()){
            T ultimoPedido = ((LinkedList<T>) fila).peekLast();
            System.out.println("Último pedido: " + ultimoPedido.toString());
        } else {
            System.err.println("A fila está vazia.");
        }
    }

    public boolean filaVazia(){
        return fila.isEmpty();
    }

    public int tamanhoFila(){
        return fila.size();   
    }

    public void exibirFila(){
        if (filaVazia()) {
            System.err.println("A fila está vazia.");
        } else {
            System.out.println("Fila de Pedidos:");
            for (T pedido : fila) {
                System.out.println(pedido.toString());
            }
        }
    }
}
