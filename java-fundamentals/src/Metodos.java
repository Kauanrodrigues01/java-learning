import java.util.Scanner;

public class Metodos {

    /*
     * public: torna o método ou classe visível em qualquer parte do programa.
     * static: o método pertence à classe, e não precisa de um objeto para ser chamado.
     * void: significa que o método que não retorna valor nenhum.
     * main: é o metódo principal que incia a execução do programa
     * String[] args: parâmetro usado para receber argumentos pela linha de comando.
     */

    // 🔹 Método principal (ponto de entrada do programa)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite sua altura (em metros): ");
        double altura = sc.nextDouble();

        System.out.print("Digite seu peso (em kg): ");
        double peso = sc.nextDouble();

        double imc = calcularIMC(peso, altura);

        String classificacao = classificarIMC(imc);

        exibirResultado(nome, imc, classificacao);
    }

    // Método que calcula e retorna o IMC
    // Fórmula: peso / (altura * altura)
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    // Método que classifica o IMC com base no valor
    public static String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau 1";
        } else if (imc < 40) {
            return "Obesidade grau 2";
        } else {
            return "Obesidade grau 3 (mórbida)";
        }
    }

    // Método void (sem retorno) apenas exibe o resultado formatado
    public static void exibirResultado(String nome, double imc, String classificacao) {
        System.out.println("\n🔹 Resultado:");
        System.out.println("Nome: " + nome);
        System.out.printf("IMC: %.2f\n", imc);
        System.out.println("Classificação: " + classificacao);
    }
}
