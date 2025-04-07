public class Sobrevivente extends Pessoa{
    private String[] habilidades = new String[3];
    private String status;

//construtor
    public Sobrevivente (String nome, int idade, String id, String status){
        super(nome, idade, id);
        this.status = status;
    }
    
//getters e setters
    public String[] getHabilidades(){
        return habilidades;
    }

    public String getStatus(){
        return status;
    }

    public void setHabilidades(String[] habilidades){
        this.habilidades = habilidades;
    }

    public void setStatus(String status){
        this.status = status;
    }
    

}