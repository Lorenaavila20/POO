import java.util.ArrayList;
import java.util.List;

public class ListaProduto<T>{
    private List <T> produtos;

    public ListaProduto(){
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(T produto){
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo.");
        }
        produtos.add(produto);
    }

    public T buscarProduto(String nome){
        for (T produto : produtos){
            if (produto instanceof Produto){  
                Produto p = (Produto) produto;
                if (p.getDescricao().equalsIgnoreCase(nome)){
                    return produto;
                }
            }
        }
        System.err.println("Produto '" + nome + "' não encontrado.");
        return null;
    }

    public void exibirProdutos(){
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("Lista de Produtos:");
        for (T produto : produtos){
            System.out.println(produto);
        }
    }
}
