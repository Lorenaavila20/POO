public class Pedido{
    private int codigoPedido;
    private String descricaoPedido;
    private int tempoEstimado;
    private String cpf;

    public Pedido(int codigoPedido, String descricaoPedido, int tempoEstimado, String cpf){
        this.codigoPedido = codigoPedido;
        this.descricaoPedido = descricaoPedido;
        this.tempoEstimado = tempoEstimado;
        this.cpf = cpf;
    }
    
    public int getCodigoPedido(){
        return codigoPedido;
    }

    public String getDescricaoPedido(){
        return descricaoPedido;
    }

    public String getTempoEstimado(){
        return descricaoPedido;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCodigoPedido(int codigoPedido){
        this.codigoPedido = codigoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido){
        this.descricaoPedido = descricaoPedido;
    }

    public void setTempoEstimado(int tempoEstimado){
        this.tempoEstimado = tempoEstimado;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pedido #" + codigoPedido + " - " + descricaoPedido + " (Tempo estimado: " + tempoEstimado + " min, CPF: " + cpf + ")";
    }
}