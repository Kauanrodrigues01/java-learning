import java.util.Scanner;

public class ControleFluxo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        // Loop principal do programa
        do {
            // Menu com switch-case para escolher uma opção
            System.out.println("Menu:");
            System.out.println("1 - Verificar maioridade");
            System.out.println("2 - Contar de 0 até 4 usando while");
            System.out.println("3 - Contar de 0 até 4 usando for com continue");
            System.out.println("4 - Escolher uma fruta");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite sua idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    // Uso do if, else if, else para classificar idade
                    if (idade < 18) {
                        System.out.println("Você é menor de idade.");
                    } else if (idade < 60) {
                        System.out.println("Você é adulto.");
                    } else {
                        System.out.println("Você é idoso.");
                    }
                    break;

                case 2:
                    // Exemplo de while com break
                    int contador = 0;
                    while (contador < 10) {
                        if (contador == 5) {
                            System.out.println("Contador chegou a 5, saindo do loop.");
                            break; // sai do loop quando contador é 5
                        }
                        System.out.println("While contador: " + contador);
                        contador++;
                    }
                    break;

                case 3:
                    // Exemplo de for com continue
                    for (int i = 0; i < 6; i++) {
                        if (i == 3) {
                            System.out.println("Pulando o número 3");
                            continue; // pula o número 3 e vai para próximo
                        }
                        System.out.println("For i: " + i);
                    }
                    break;

                case 4:
                    System.out.print("Escolha uma fruta (maçã, banana, laranja): ");
                    String fruta = sc.nextLine();

                    // switch com string para selecionar fruta
                    switch (fruta.toLowerCase()) {
                        case "maçã":
                            System.out.println("Você escolheu maçã.");
                            break;
                        case "banana":
                            System.out.println("Você escolheu banana.");
                            break;
                        case "laranja":
                            System.out.println("Você escolheu laranja.");
                            break;
                        default:
                            System.out.println("Fruta não reconhecida.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();

        } while (opcao != 5);

        sc.close();
    }
}
