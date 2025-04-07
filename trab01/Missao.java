public class Missao{
    private String nome;
    private String objetivo;
    private String local;
    private String[] sobreviventes = new String[5];
    private Recurso[] recursosColetados = new Recurso[10];
    private String status;

//construtor
    public Missao(String nome, String objetivo, String local, String status){
        this.nome = nome;
        this.objetivo = objetivo;
        this.local = local;
        this.status = status;
    }
    
//getters e setters
    public String getNome(){
        return nome;
    }

    public String getObjetivo(){
        return objetivo;
    }

    public String getLocal(){
        return local;
    }

    public String[] getSobreviventes() {
        return sobreviventes;
    }

    public Recurso[] getRecursosColetados() {
        return recursosColetados;
    }

    public String getStatus(){
        return status;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setObjetivo(String objetivo){
        this.objetivo = objetivo;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public void setRecursosColetados(Recurso[] recursosColetados) {
        this.recursosColetados = recursosColetados;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void adicionarSobrevivente(String id){
        for (int i = 0; i < sobreviventes.length; i++){
            if (sobreviventes[i] == null) {
                sobreviventes[i] = id;
                System.out.println();
                System.out.println("Sobrevivente " + id + " adicionado à missão.");
                return;
            }
        }
        System.out.println("A missão já possui 5 sobreviventes.");
    }

    public void listarSobreviventes(){
        System.out.println("Sobreviventes na missão:");
        for (String id : sobreviventes){
            if (id != null) {
                System.out.println("- " + id + " Nome" + nome);
            }
        }
    }
    
    public void adicionarRecursoMissao(Recurso recurso){
        for (int i = 0; i < recursosColetados.length; i++){
            if (recursosColetados[i] == null) {
                recursosColetados[i] = recurso;
                System.out.println();
                System.out.println("Recurso " + recurso.getNome() + " adicionado à missão.");
                return;
            }
        }
        System.out.println("O limite de recursos coletados foi atingido.");
    }
}