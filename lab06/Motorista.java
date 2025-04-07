public class Motorista{
    private String nome;
    private String cpf;
    private String habilitacao;

    public Motorista(String nome, String cpf, String habilitacao){
        this.nome = nome;
        this.cpf = cpf;
        this.habilitacao = habilitacao;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public String getHabilitacao(){
        return habilitacao;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public void setCpf (String cpf){
        this.cpf = cpf;
    }
    
    public void setHabilitacao (String habilitacao){
        this.habilitacao = habilitacao;
    }
    
    public String getDetalhe(){
        return "Nome: " + nome + "CPF: " + cpf + "Habilitação: " + habilitacao;
    }
}
