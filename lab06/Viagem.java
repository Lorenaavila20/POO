public class Viagem{
    private Motorista motorista;
    private Veiculo veiculo;
    private double distancia;

    public Viagem (Motorista motorista, Veiculo veiculo, double distancia){
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.distancia = distancia;
    }

    public Motorista getMotorista(){
        return motorista;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }

    public double getDistancia(){
        return distancia;
    }

    public void setMotorista(Motorista motorista){
        this.motorista = motorista;
    }

    public void setVeiculo (Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public void setDistancia(double distancia){
        this.distancia = distancia;
    }

    public double calcularCustoTotal(){
        return veiculo.calcularCusto(distancia);
    }
    public String getDetalhes(){
        return "Viagem:\n" +
               "Motorista: " + (motorista != null ? motorista.getDetalhes() : "Nenhum motorista atribuído") + "\n" +
               "Veículo: " + (veiculo != null ? veiculo.getDetalhes() : "Nenhum veículo atribuído") + "\n" +
               "Distância: " + distancia + " km\n" +
               "Custo Total: R$ " + calcularCustoTotal();
    }
}