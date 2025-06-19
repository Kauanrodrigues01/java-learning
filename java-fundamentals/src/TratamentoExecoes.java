import java.util.InputMismatchException;
import java.util.Scanner;

public class TratamentoExecoes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int idade = 0;
        boolean idadeValida = false;

        while (!idadeValida) {
            System.out.print("Digite sua idade: ");
            try {
                // Tenta ler um inteiro
                idade = sc.nextInt();
                idadeValida = true;  // se chegou aqui, a idade é válida

                if (idade < 0) {
                    // Se idade for negativa, lança uma exceção manualmente para tratar
                    throw new IllegalArgumentException("Idade não pode ser negativa.");
                }

            } catch (InputMismatchException e) {
                // Captura erro quando não é um número inteiro
                System.out.println("Erro: Por favor, digite um número válido.");
                sc.nextLine(); // limpar o buffer do scanner para tentar ler de novo
            } catch (IllegalArgumentException e) {
                // Captura erro da idade negativa
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine(); // limpar buffer
            }
        }

        // Agora que a idade é válida, segue o programa normal
        boolean podeVotar = idade >= 16;
        boolean votoObrigatorio = idade >= 18 && idade <= 70;

        String mensagem = podeVotar ?
                (votoObrigatorio ? "Voto obrigatório." : "Voto facultativo.")
                : "Não pode votar.";

        System.out.println(mensagem);

        sc.close();
    }
}
