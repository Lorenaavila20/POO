public class Caminhao extends Veiculo{
    private double capacidadeCarga;

    public Carro (String placa, String modelo, double capacidadeCarga){
        super(placa, modelo);
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getCapacidadeCarga(){
        return capacidadeCarga;
    }

    public void setCapacidadeCarga (double capacidadeCarga){
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String getDetalhe(){
        return "Caminhão - Placa: " + placa + ", Modelo: " + modelo + ", Capacidade de Carga: " + capacidadeDeCarga + " toneladas";
    }

    @Override
    public double calcularCustoDistancia(double distancia){
        return distancia * 1.00;
    }
}