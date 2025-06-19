import java.util.*;

public class Main {
    static List<Map<String, Object>> filmes = new ArrayList<>();

    public static void limparConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cls").inheritIO().start().waitFor();
            } else if (os.contains("Linux")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                System.out.println("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void adicionarFilme(Scanner sc) {
        System.out.println("Adicione um filme:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Ano: ");
        int ano = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        Map<String, Object> filme = new HashMap<>();
        filme.put("nome", nome);
        filme.put("ano", ano);

        filmes.add(filme);

        System.out.println("Filme adicionado com sucesso!");
    }

    public static void listarFilmes() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme encontrado!");
        }
        for (int i = 0; i < filmes.size(); i++) {
            Map<String, Object> filme = filmes.get(i);
            System.out.println("ID: " + i + " - Nome: " + filme.get("nome") + " - Ano: " + filme.get("ano"));
        }
    }

    public static void removerFilme(Scanner sc) {
        listarFilmes();

        System.out.println();
        System.out.println("Digite o ID do Filme que deseja remover: ");

        try {
            int id = sc.nextInt();
            sc.nextLine(); // Limpar Buffer

            Map<String, Object> filme = filmes.get(id);
            filmes.remove(id);
            System.out.println("Filme removido com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite apenas números.");
            sc.nextLine(); // Limpar buffer

            System.out.println("Pressione ENTER para continuar!");
            sc.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ID inválido! Nenhum filme na posição digitada.");

            System.out.println("Pressione ENTER para continuar!");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao remover filme!");

            System.out.println("Pressione ENTER para continuar!");
            sc.nextLine();
        }
    }

    public static void atualizarFilme(Scanner sc) {
        listarFilmes();

        System.out.println();
        System.out.println("Digite o ID do Filme que deseja atualizar: ");

        try {
            int id = sc.nextInt();
            sc.nextLine(); // Limpar Buffer

            Map<String, Object> filme = filmes.get(id);

            System.out.println("Nome: " + filme.get("nome") + " - Ano: " + filme.get("ano"));

            System.out.println("Digite as novas informações do filme (deixe vazio e pressione ENTER, caso não queira alterar)");
            System.out.println();

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Ano: ");
            String anoInput = sc.nextLine();

            if (!anoInput.isBlank()) {
                try {
                    int ano = Integer.parseInt(anoInput);
                    filme.put("ano", ano);
                } catch (NumberFormatException e) {
                    System.out.println("Ano inválido. O valor anterior será mantido");
                }
            }

            filme.put("nome", (!nome.isBlank()) ? nome : filme.get("nome"));
            filmes.set(id, filme);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite apenas números.");
            sc.nextLine(); // Limpar buffer
            System.out.println("Pressione ENTER para continuar!");
            sc.nextLine();

        } catch (IndexOutOfBoundsException e) {
            System.out.println("ID inválido! Nenhum filme na posição digitada.");
            System.out.println("Pressione ENTER para continuar!");
            sc.nextLine();

        } catch (Exception e) {
            System.out.println("Erro ao remover filme!");
            System.out.println("Pressione ENTER para continuar!");
            sc.nextLine();
        }
    }

    public static void exibirIntroducaoMenu() {
        System.out.println("----------------------");
        System.out.println("Esse é o Screen Match");
        System.out.println("----------------------");
        System.out.println("1. Adicionar Filme");
        System.out.println("2. Listar Filmes");
        System.out.println("3. Remover Filme");
        System.out.println("4. Atualizar Filme");
        System.out.println("5. Sair");
    }

    public static int capturarOpcao(Scanner sc) {
        try {
            int opcao;
            System.out.println("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer
            return opcao;
        } catch (Exception e) {
            System.out.println("Erro ao capturar opção");
            sc.nextLine(); // Limpa o buffer após o nextLine();
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            exibirIntroducaoMenu();
            int opcao = capturarOpcao(sc);

            switch (opcao) {
                case 1:
                    adicionarFilme(sc);
                    break;
                case 2:
                    listarFilmes();
                    System.out.println("Pressione ENTER para continuar");
                    sc.nextLine();
                    break;
                case 3:
                    removerFilme(sc);
                    break;
                case 4:
                    atualizarFilme(sc);
                    break;
                case 5:
                    System.exit(0);

            }
            limparConsole();
        }
    }
}