import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha a opção:");
            System.out.println("1 - Criar Gerente");
            System.out.println("2 - Criar Desenvolvedor");
            System.out.println("3 - Criar TechLead");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do Gerente: ");
                    String nomeGerente = scanner.nextLine();
                    System.out.print("Digite o salário base do Gerente: ");
                    double salarioGerente = scanner.nextDouble();
                    System.out.print("Digite o número de equipes do Gerente: ");
                    int numeroDeEquipesGerente = scanner.nextInt();
                    GerenteFun gerente = new GerenteFun(nomeGerente, salarioGerente, numeroDeEquipesGerente);
                    System.out.println(gerente.descricao());
                    break;

                case 2:
                    System.out.print("Digite o nome do Desenvolvedor: ");
                    String nomeDesenvolvedor = scanner.nextLine();
                    System.out.print("Digite o salário base do Desenvolvedor: ");
                    double salarioDesenvolvedor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Digite a linguagem principal do Desenvolvedor: ");
                    String linguagemDesenvolvedor = scanner.nextLine();
                    DesenvolvedorFun desenvolvedor = new DesenvolvedorFun(nomeDesenvolvedor, salarioDesenvolvedor, linguagemDesenvolvedor);
                    System.out.println(desenvolvedor.descricao());
                    break;

                case 3:
                    System.out.print("Digite o nome do TechLead: ");
                    String nomeTechLead = scanner.nextLine();
                    System.out.print("Digite o salário base do TechLead: ");
                    double salarioTechLead = scanner.nextDouble();
                    System.out.print("Digite o número de equipes do TechLead: ");
                    int numeroDeEquipesTechLead = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a linguagem principal do TechLead: ");
                    String linguagemTechLead = scanner.nextLine();
                    System.out.print("Digite o número de projetos em andamento do TechLead: ");
                    int projetosEmAndamento = scanner.nextInt();
                    TechLead techLead = new TechLead(nomeTechLead, salarioTechLead, numeroDeEquipesTechLead, linguagemTechLead, projetosEmAndamento);
                    System.out.println(techLead.descricao());
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
