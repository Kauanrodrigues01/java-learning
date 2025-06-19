import java.util.Scanner;

public class EntraSaidaDeDados {
    public static void main(String[] args) {
        // Criamos um objeto Scanner para ler dados do teclado (entrada padrão)
        Scanner sc = new Scanner(System.in);

        // Pedimos para o usuário digitar o nome
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        // nextLine() lê a linha inteira que o usuário digitar, incluindo espaços

        // Pedimos para o usuário digitar o email
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        // Pedimos para o usuário digitar a idade
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        /*
         * nextInt() lê apenas o número inteiro, mas não consome o caractere de nova linha '\n' que fica no buffer.
         * Isso significa que ao usar nextLine() logo depois, ele lê esse '\n' residual e retorna uma string vazia.
         * Por isso, precisamos chamar um nextLine() extra para limpar esse '\n' do buffer antes de usar nextLine() novamente.
         */
        sc.nextLine(); // Limpa o buffer para evitar problemas em futuras leituras de linha completa

        // Exemplo de saída formatada usando printf (melhor para mostrar dados formatados)
        System.out.printf("Cadastro concluído:\nNome: %s\nEmail: %s\nIdade: %d anos\n", nome, email, idade);

        sc.close();
    }
}
