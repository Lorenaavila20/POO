public class Pessoa{
    protected String nome;
    protected int idade;
    protected String id;

//construtor
    public Pessoa(String nome, int idade, String id){
        this.nome = nome;
        this.idade = idade;
        this.id = id;
    }
    
//getters e setters
    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getId(){
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setId(String id){
        this.id = id;
    }
}