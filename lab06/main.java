import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Motorista[] motoristas = new Motorista[10]; // Vetor para armazenar até 10 motoristas
        Veiculo[] veiculos = new Veiculo[10]; // Vetor para armazenar até 10 veículos
        Viagem[] viagens = new Viagem[10]; // Vetor para armazenar até 10 viagens

        int motoristaCount = 0; // Contador para motoristas cadastrados
        int veiculoCount = 0; // Contador para veículos cadastrados
        int viagemCount = 0; // Contador para viagens registradas

        int opcao;

        do {
            System.out.println("\nEscolha a opção:");
            System.out.println("1 - Cadastrar motorista");
            System.out.println("2 - Cadastrar veículo");
            System.out.println("3 - Registrar viagem");
            System.out.println("4 - Exibir detalhes de uma viagem");
            System.out.println("5 - Excluir motorista");
            System.out.println("6 - Excluir veiculo");
            System.out.println("7 - Sair");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (motoristaCount >= motoristas.length) {
                        System.out.println("Limite de motoristas atingido.");
                        break;
                    }

                    System.out.print("Digite o nome do motorista: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite a habilitação do motorista: ");
                    String habilitacao = scanner.nextLine();

                    motoristas[motoristaCount++] = new Motorista(nome, cpf, habilitacao);
                    System.out.println("Motorista cadastrado com sucesso!");
                    break;

                case 2:
                    if (veiculoCount >= veiculos.length) {
                        System.out.println("Limite de veículos atingido.");
                        break;
                    }

                    System.out.println("Escolha o tipo de veículo:");
                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.println("3 - Caminhão");
                    int tipoVeiculo = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Digite o modelo do veículo: ");
                    String modelo = scanner.nextLine();

                    switch (tipoVeiculo) {
                        case 1:
                            System.out.print("Digite o número de assentos: ");
                            int assentos = scanner.nextInt();
                            veiculos[veiculoCount++] = new Carro(placa, modelo, assentos);
                            System.out.println("Carro cadastrado com sucesso!");
                            break;

                        case 2:
                            System.out.print("Digite o número de cilindradas: ");
                            int cilindradas = scanner.nextInt();
                            veiculos[veiculoCount++] = new Moto(placa, modelo, cilindradas);
                            System.out.println("Moto cadastrada com sucesso!");
                            break;

                        case 3:
                            System.out.print("Digite a capacidade de carga (em toneladas): ");
                            double capacidadeDeCarga = scanner.nextDouble();
                            veiculos[veiculoCount++] = new Caminhao(placa, modelo, capacidadeDeCarga);
                            System.out.println("Caminhão cadastrado com sucesso!");
                            break;

                        default:
                            System.out.println("Opção inválida para tipo de veículo.");
                    }
                    break;

                case 3:
                    if (motoristaCount == 0 || veiculoCount == 0) {
                        System.out.println("É necessário cadastrar pelo menos um motorista e um veículo antes de registrar uma viagem.");
                        break;
                    }
                    if (viagemCount >= viagens.length) {
                        System.out.println("Limite de viagens atingido.");
                        break;
                    }

                    System.out.println("Escolha um motorista pelo índice:");
                    for (int i = 0; i < motoristaCount; i++) {
                        System.out.println(i + " - " + motoristas[i].getDetalhes());
                    }
                    int motoristaIndex = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Escolha um veículo pelo índice:");
                    for (int i = 0; i < veiculoCount; i++) {
                        System.out.println(i + " - " + veiculos[i].getDetalhes());
                    }
                    int veiculoIndex = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite a distância da viagem (em km): ");
                    double distancia = scanner.nextDouble();

                    Motorista motorista = motoristas[motoristaIndex];
                    Veiculo veiculo = veiculos[veiculoIndex];


                    if ((veiculo instanceof Moto && !motorista.getHabilitacao().equalsIgnoreCase("A")) ||
                        (veiculo instanceof Carro && !motorista.getHabilitacao().equalsIgnoreCase("B")) ||
                        (veiculo instanceof Caminhao && !motorista.getHabilitacao().matches("[CDE]"))) {
                        System.out.println("Habilitação incompatível com o tipo de veículo.");
                        break;
                    }

                    viagens[viagemCount++] = new Viagem(motorista, veiculo, distancia);
                    System.out.println("Viagem registrada com sucesso!");
                    break;

                case 4:
                    if (viagemCount == 0) {
                        System.out.println("Nenhuma viagem registrada.");
                        break;
                    }
                    System.out.println("Escolha uma viagem pelo índice:");
                    for (int i = 0; i < viagemCount; i++) {
                        System.out.println(i + " - " + viagens[i].getDetalhes());
                    }
                    int viagemIndex = scanner.nextInt();
                    System.out.println("Detalhes da viagem:");
                    System.out.println(viagens[viagemIndex].getDetalhes());
                    break;

                case 5:
                    System.out.print("Digite o índice do motorista para excluir: ");
                    int motoristaExcluir = scanner.nextInt();
                    if (motoristaExcluir >= 0 && motoristaExcluir < motoristaCount) {
                        motoristas[motoristaExcluir] = motoristas[--motoristaCount];
                        System.out.println("Motorista excluído com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 6:
                    System.out.print("Digite o índice do veículo para excluir: ");
                    int veiculoExcluir = scanner.nextInt();
                    if (veiculoExcluir >= 0 && veiculoExcluir < veiculoCount) {
                        veiculos[veiculoExcluir] = veiculos[--veiculoCount];
                        System.out.println("Veículo excluído com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 7);

        scanner.close();
    }
}
