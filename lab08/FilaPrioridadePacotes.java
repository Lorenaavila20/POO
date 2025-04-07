import java.util.PriorityQueue;

public class FilaPrioridadePacotes{
    private PriorityQueue<Pacote> filaPrioridade;
    
    public FilaPrioridadePacotes(){
        this.filaPrioridade = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.getPrioridade(), p2.getPrioridade()));
    }

    public void adicionarPacote(Pacote pacote){
        filaPrioridade.add(pacote);
    }

    public Pacote processarPacote(){
        return filaPrioridade.poll();
    }

    public void exibirPacotes(){
        for (Pacote pacote : filaPrioridade){
            System.out.println("Código: " + pacote.getCodigoPacote() + ", Descrição: " + pacote.getDescricao() + ", Cliente: " + pacote.getCpf());
        }
    }

    public boolean estaVazia(){
        return filaPrioridade.isEmpty();
    }
}
