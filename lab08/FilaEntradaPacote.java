import java.util.LinkedList;
import java.util.Queue;

public class FilaEntradaPacote{
    private Queue<Pacote> fila;

    public FilaEntradaPacote(){
        this.fila = new LinkedList<>();
    }

    public void adicionarPacote(Pacote pacote){
        fila.add(pacote);
    }

    public Pacote processarPacote(){
        return fila.poll();
    }

    public void exibirPacotes(){
        for (Pacote pacote : fila) {
            System.out.println("Código: " + pacote.getCodigoPacote() + ", Descrição: " + pacote.getDescricao() + ", Cliente: " + pacote.getCpf());
        }
    }

    public boolean estaVazia(){
        return fila.isEmpty();
    }
}
