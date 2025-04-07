public class Funcionario{

    protected String nome;
    protected float salarioBase;

    public Funcionario(String nome, float salarioBase){
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String descricao(){
        return "Funcionário: " + nome + ", salário base: " + salarioBase;
    }
}