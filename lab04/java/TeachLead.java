public class TechLead extends Funcionario implements Gerente, Desenvolvedor{
    private GerenteFun gerente;
    private DesenvolvedorFun desenvolvedor;
    private int numeroDeEquipes;
    private String linguagemPrincipal;
    private int projetosEmAndamento;

    public TechLead(String nome, double salarioBase, int numeroDeEquipes, String linguagemPrincipal, int projetosEmAndamento) {
        super(nome, salarioBase);
        this.gerente = new GerenteFun(nome, salarioBase, numeroDeEquipes); 
        this.desenvolvedor = new DesenvolvedorFun(nome, salarioBase, linguagemPrincipal);
        this.numeroDeEquipes = numeroDeEquipes;
        this.linguagemPrincipal = linguagemPrincipal;
        this.projetosEmAndamento = projetosEmAndamento;
    }

    @Override
    public int getNumeroDeEquipes(){
        return gerente.getNumeroDeEquipes();
    }

    @Override
    public float bonus(){
        return gerente.bonus();
    }

    @Override
    public String getLinguagemPrincipal(){
        return desenvolvedor.linguagemPrincipal();
    }

    @Override
    public String projetosRealizados(){
        return desenvolvedor.projetosRealizados;
    }

    @Override
    public String descricao(){
        return super.descricao() + ", Número de equipes: " + getNumeroDeEquipes() + ", Bônus: " + bonus() +
               ", Linguagem principal: " + getLinguaPrincipal() + ", Projetos em andamento: " + projetosEmAndamento;
    }
}