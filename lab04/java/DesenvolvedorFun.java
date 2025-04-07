public class DesenvolvedorFun extends Funcionario implements Desenvolvedor{
    private String linguagemPrincipal;

    public Desenvolvedor(String nome, float salarioBase, String linguagemPrincipal){
        super(nome, salarioBase);
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public int getLinguagemPrincipal(){
        return linguagemPrincipal;
    }

    @Override
    public String projetosRealizados(){
        return "Projetos entregues na linguagem " + linguagemPrincipal;
    }

    @Override
    public String descricao(){
         return super.descricao() + ", Linguagem principal: " + linguagemPrincipal + ", " + projetosRealizados();
    }
}