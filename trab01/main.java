import java.util.Scanner;

public class main{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Vault vault = new Vault();

        while (true){
            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1: Cadastrar sobrevivente");
            System.out.println("2: Adicionar habilidade a um sobrevivente");
            System.out.println("3: Remover habilidade de um sobrevivente");
            System.out.println("4: Adicionar recurso ao Vault");
            System.out.println("5: Consumir recurso");
            System.out.println("6: Registrar missão");
            System.out.println("7: Adicionar sobrevivente a uma missão");
            System.out.println("8: Exibir sobreviventes do Vault");
            System.out.println("9: Exibir recursos do Vault");
            System.out.println("10: Exibir missões realizadas");
            System.out.println("11: Exibir sobreviventes cadastrados em uma missão");
            System.out.println("12: Sair");
            System.out.println();

            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao){
                case 1:
                    // cadastrar sobrevivente
                    System.out.print("Nome do sobrevivente: ");
                    String nome = scanner.nextLine();

                    System.out.print("Idade do sobrevivente: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Id do sobrevivente: ");
                    String id = scanner.nextLine();
                    
                    System.out.print("Status do sobrevivente (Ativo/Doente/Ferido/Morto): ");
                    String status = scanner.nextLine();

                    vault.cadastrarSobrevivente(new Sobrevivente(nome, idade, id, status));
                    break;

                case 2:
                    // adicionar habilidade de um sobrevivente
                    System.out.print("Id do sobrevivente: ");
                    String idHabilidade = scanner.nextLine();

                    System.out.print("Habilidade a ser adicionada (Engenharia/Medicina/Combate/Exploração/Culinária/Diplomacia/Hackeamento/Furtividade): ");
                    String habilidade = scanner.nextLine();

                    vault.adicionarHabilidadeSobrevivente(idHabilidade, habilidade);
                    break;

                case 3:
                    // remover habilidade de um sobrevivente
                    System.out.print("Id do sobrevivente: ");
                    String idRemoverHabilidade = scanner.nextLine();

                    System.out.print("Habilidade a ser removida: ");
                    String habilidadeRemover = scanner.nextLine();

                    vault.removerHabilidadeSobrevivente(idRemoverHabilidade, habilidadeRemover);
                    break;

                case 4:
                    // adicionar recurso ao Vault
                    System.out.print("Nome do recurso (Água/Comida/Munição/Remédios/Partes Mecânicas): ");
                    String nomeRecurso = scanner.nextLine();

                    System.out.print("Quantidade do recurso: ");
                    int quantidadeRecurso = scanner.nextInt();

                    vault.adicionarRecurso(new Recurso(nomeRecurso, quantidadeRecurso));
                    break;

                case 5:
                    // consumir recurso
                    System.out.print("Nome do recurso a ser consumido: ");
                    String nomeRecursoConsumir = scanner.nextLine();

                    System.out.print("Quantidade a ser consumida: ");
                    int quantidadeConsumir = scanner.nextInt();

                    vault.consumirRecurso(nomeRecursoConsumir, quantidadeConsumir);
                    break;

                case 6:
                    // registrar missão
                    System.out.print("Nome da missão: ");
                    String nomeMissao = scanner.nextLine();

                    System.out.print("Objetivo da missão: ");
                    String objetivoMissao = scanner.nextLine();

                    System.out.print("Local da missão: ");
                    String localMissao = scanner.nextLine();

                    System.out.print("Status da missão (Em andamento/Sucesso/Fracasso): ");
                    String statusMissao = scanner.nextLine();

                    Missao missao = new Missao(nomeMissao, objetivoMissao, localMissao, statusMissao);
                    
                    System.out.print("Deseja adicionar recursos à missão? (sim/não): ");
                    String respostaRecurso = scanner.nextLine();
                
                    while (respostaRecurso.equalsIgnoreCase("sim")){

                        System.out.print("Nome do recurso (Água/Comida/Remédios/Munição/Partes Mecânicas): ");
                        String nomeRecursoM = scanner.nextLine();
                
                        System.out.print("Quantidade do recurso: ");
                        int quantidadeRecursoM = scanner.nextInt();
                        scanner.nextLine();

                        Recurso recurso = new Recurso(nomeRecursoM, quantidadeRecursoM);

                        missao.adicionarRecursoMissao(recurso);
             
                        System.out.print("Deseja adicionar outro recurso? (sim/não): ");
                        respostaRecurso = scanner.nextLine();
                    }
                    vault.registrarMissao(missao); 

                    break;

                case 7:
                    // adicionar sobrevivente a uma missão
                    System.out.print("Nome da missão: ");
                    String nomeMissaoAdicionar = scanner.nextLine();

                    System.out.print("Identificador do sobrevivente: ");
                    String idSobreviventeAdicionar = scanner.nextLine();

                    Missao missaoAdicionar = null;

                    for (Missao m : vault.getMissoes()){
                        if (m != null && m.getNome().equals(nomeMissaoAdicionar)){
                            missaoAdicionar = m;
                            break;
                        }
                    }

                    if (missaoAdicionar != null){
                        missaoAdicionar.adicionarSobrevivente(idSobreviventeAdicionar); // Chama o método da missão
                    } else {
                        System.out.println("Missão não encontrada.");
                    }
                    break;
                    

                case 8:
                    // exibir sobreviventes do Vault
                    vault.exibirSobreviventes();
                    break;

                case 9:
                    // exibir recursos do Vault
                    vault.exibirRecursos();
                    break;

                case 10:
                    // exibir missões realizadas
                    vault.exibirMissoes();
                    break;

                case 11:
                    // exibir sobreviventes cadastrados em uma missão
                    System.out.print("Nome da missão: ");
                    String nomeMissaoExibir = scanner.nextLine();

                    vault.exibirSobreviventesMissao(nomeMissaoExibir);
                    break;

                case 12:
                    // sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;  // Encerra o programa

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
