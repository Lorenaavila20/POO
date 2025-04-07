public class Pacote{
    private int codigoPacote;
    private String descricao;
    private int prioridade;
    private String cpf;

    public Pacote(int codigoPacote, String descricao, int prioridade, String cpf){
        this.codigoPacote = codigoPacote;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.cpf = cpf;
    }

    public int getCodigoPacote(){
        return codigoPacote;
    }

    public String getDescricao(){
        return descricao;
    }

    public int getPrioridade(){
        return prioridade;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCodigoPacote(int codigoPacote){
        this.codigoPacote = codigoPacote;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pacote{" + "codigoPacote=" + codigoPacote + ", descricao='" + descricao + '\'' + ", prioridade=" + prioridade + ", cpf='" + cpf + '\'' + '}';
    }    
}