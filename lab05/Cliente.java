public class Cliente{
    private String nome;
    private String cpf;
    private Produto[] compras;
    private int contadorCompras;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.compras = new Produto[100];
        this.contadorCompras = 0;
    }

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void adicionaCompra(Produto p){
        if(contadorCompras < compras.length){
            compras[contadorCompras++] = p;
        }else{
            System.out.println("Não é possível adicionar mais produtos");
        }
    }  

    public double calculaTotal(){
        double total = 0;
        
        for(int i = 0; i < contadorCompras; i++){
            total += compras[i].getPreco;
        }
        return total;
    }

    public String getDetalhe(){
        StringBuilder detalhe = new StringBuilder("Cliente: " + nome + ", CPF: " + CPF + "\nCompras:\n");
        for(int i = 0; i < contadorCompras; i++){
            detalhes.append(compras[i].getDetalhes()).append("\n");
        }
        detalhe.append("Total Gasto: R$").append(calculaTotal());
        return detalhes.toString();
    }

}