public class Moto extends Veiculo{
    private int cilindradas;

    public Moto (String placa, String modelo, int cilindradas){
        super(placa, modelo);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas(){
        return cilindradas;
    }

    public void setCilindradas (int cilindradas){
        this.cilindradas = cilindradas;
    }

    @Override
    public String getDetalhe(){
        return "Moto - Placa: " + placa + ", Modelo: " + modelo + ", Cilindradas: " + cilindradas;
    }

    @Override
    public double calcularCustoDistancia(double distancia){
        return distancia * 0.20;
    }
}