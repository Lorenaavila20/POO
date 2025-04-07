public class GerenteFun extends Funcionario implements Gerente{
    private int numeroDeEquipes;

    public GerenteFun(String nome, float salarioBase, int numeroDeEquipes){
        super(nome, salarioBase);
        this.numeroDeEquipes = numeroDeEquipes;
    }

    @Override
    public int getNumeroDeEquipes(){
        return numeroDeEquipes;
    }

    @Override
    public float bonus(){
        return numeroDeEquipes * 500;
    }

    @Override
    public String descricao(){
        return super.descricao() + ", Número de equipes: " + numeroDeEquipes + ", Bônus: " + bonus();
    }
}