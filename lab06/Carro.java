public class Carro extends Veiculo{
    private int assentos;

    public Carro (String placa, String modelo, int assentos){
        super(placa, modelo);
        this.assentos = assentos;
    }

    public int getAssentos(){
        return assentos;
    }

    public void setAssentos(int assentos){
        this.assentos = assentos;
    }

    @Override
    public String getDetalhes() {
        return "Carro - Placa: " + placa + ", Modelo: " + modelo + ", Assentos: " + assentos;
    }

    @Override
    public double calcularCustoDistancia(double distancia){
        return distancia * 0.50;
    }
}