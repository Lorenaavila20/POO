import java.util.List;
import java.util.ArrayList;

public class HistoricoPacotes{
    private List<Pacote> historico;

    public HistoricoPacotes(){
        this.historico = new ArrayList<>();
    }

    public void adicionarAoHistorico(Pacote pacote){
        historico.add(pacote);
    }

    public void exibirHistorico(){
        for (Pacote pacote : historico){
            System.out.println("Código: " + pacote.getCodigoPacote() + ", Descrição: " + pacote.getDescricao() + ", Cliente: " + pacote.getCpf());
        }
    }
}
