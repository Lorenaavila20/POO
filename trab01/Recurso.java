public class Recurso{
    private String nome;
    private int quantidade;

    //construtor
    public Recurso(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }
    
//getters e setters
    public String getNome(){
        return nome;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}