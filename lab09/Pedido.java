import java.util.ArrayList;
import java.util.List;

public class Pedido{
    private int codigoPedido;
    private String clienteNome;
    private List <Produto> itens;
    private double total;

    public Pedido(int codigoPedido, String clienteNome){
        if (clienteNome == null || clienteNome.trim().isEmpty())
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio.");
        this.codigoPedido = codigoPedido;
        this.clienteNome = clienteNome;
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public int getCodigoPedido(){
        return codigoPedido;
    }

    public String getClienteNome(){
        return clienteNome;
    }

    public List<Produto> getItens(){
        return itens;
    }

    public double getTotal(){
        return total;
    }

    public void setCodigoPedido(int codigoPedido){
        this.codigoPedido = codigoPedido;
    }

    public void setClienteNome(String clienteNome){
        if (clienteNome == null || clienteNome.trim().isEmpty())
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou vazio.");
        this.clienteNome = clienteNome;
    }

    
    public void setItens(List<Produto> itens){
        this.itens = itens;
    }

    public void adicionarProduto(Produto produto, int quantidade){
        if (produto == null){
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        if (quantidade <= 0){
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        produto.reduzirEstoque(quantidade);
        this.itens.add(produto);
        this.total += produto.getPreco() * quantidade;
    }

    @Override
    public String toString(){
        return "Pedido #" + codigoPedido + " | Cliente: " + clienteNome + " | Total: R$ " + total;
    }

}