import java.util.Scanner;

public class Operadores {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();

        // Operadores Aritméticos
        // + : soma
        // - : subtração
        // * : multiplicação
        // / : divisão (inteira aqui)
        // % : resto da divisão (módulo)
        int exemploSoma = idade + 5; // adiciona 5 à idade
        int exemploResto = idade % 2; // resto da divisão da idade por 2 (0 se par, 1 se ímpar)

        // Operadores de Atribuição
        // = : atribui valor
        // += : soma e atribui (idade += 1 é idade = idade + 1)
        int contador = 1;
        contador += 1; // agora contador vale 2

        // Operadores de Comparação
        // == : igual a
        // != : diferente de
        // <  : menor que
        // >  : maior que
        // <= : menor ou igual
        // >= : maior ou igual
        boolean podeVotar = idade >= 16; // pessoa pode votar se idade >= 16

        // Operadores Lógicos
        // && : E lógico (AND) - true se ambos verdadeiros
        // || : OU lógico (OR) - true se pelo menos um verdadeiro
        // !  : negação lógica (NOT)
        boolean votoObrigatorio = idade >= 18 && idade <= 70;

        // Operador ternário
        // condição ? valor_se_verdadeiro : valor_se_falso
        String mensagem = podeVotar ?
                (votoObrigatorio ? "Voto obrigatório." : "Voto facultativo.")
                : "Não pode votar.";

        System.out.println(mensagem);

        sc.close();
    }
}
