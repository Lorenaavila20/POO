public class Produto{
    private int codigo;
    private String descricao;
    private double preco;
    private int estoque;

    public Produto(int codigo, String descricao, double preco, int estoque){
        if (preco < 0){
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        if (estoque < 0){
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = 10.0;
        this.estoque = 5;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getDescricao(){
        return descricao;
    }

    public double getPreco(){
        return preco;
    }

    public int getEstoque(){
        return estoque;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setPreco(double preco){
        if (preco < 0){
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public void setEstoque(int estoque){
        if (estoque < 0){
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
        this.estoque = estoque;
    }

    public void reduzirEstoque(int qtd){
        if (qtd <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        if (estoque >= qtd){
            estoque -= qtd;
            System.out.println("Estoque reduzido com sucesso!");
        } else{
            throw new IllegalStateException("Estoque insuficiente.");
        }
    }

    public void aumentarEstoque(int qtd){
        if (qtd <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        estoque += qtd;
        System.out.println("Estoque aumentado com sucesso!");
    }


    @Override
    public String toString(){
        return String.format("Código: %d | Descrição: %s | Preço: R$ %.2f | Estoque: %d", codigo, descricao, preco, estoque);
    }
}
