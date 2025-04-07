import java.util.ArrayList;
import java.util.List;

public class HistoricoPedidos<T>{
    private List <T> historico;

    public HistoricoPedidos(){
        this.historico = new ArrayList<>();
    }

    public void adicionarAoHistorico(T pedido){
        if (pedido == null){
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        historico.add(pedido);
    }

    public void exibirHistorico(){
        if (historico.isEmpty()){
            System.out.println("O histórico de pedidos está vazio.");

        }else{
            System.out.println("Histórico de Pedidos:");
            for (int i = 0; i < historico.size(); i++){
                System.out.println((i + 1) + ". " + historico.get(i).toString());
            }
        }
    }
}
