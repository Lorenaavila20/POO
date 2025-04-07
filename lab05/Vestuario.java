public class Vestuario extends Produto{
    private String tamanho;

    public Vestuario(String nome, double preco, String tamanho){
        super(nome, preco);
        this.tamanho = tamanho;
    }

    public String getTamanho(){
        return tamanho;
    }

    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }

    @Override
    public String getDetalhe(){
        return super.getDetalhes() + ", Tamanho: " + tamanho;
    }
}