import java.util.ArrayList;
import java.util.List;

 public class ListaClientes{
    private List<Cliente> clientes;

    public ListaClientes(){
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Cliente buscarCliente(String cpf){

        for (Cliente cliente : clientes){
            if (cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public void exibirClientes(){

        if (clientes.isEmpty()){
            System.out.println("Nenhum cliente cadastrado.");
        } else{ 
            for (Cliente cliente : clientes){
                System.out.println(cliente);
            }
        }
    }    
}

