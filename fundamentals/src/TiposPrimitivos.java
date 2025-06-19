import java.sql.SQLOutput;
import java.util.Scanner;

public class TiposPrimitivos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine(); // Limpar buffer

        System.out.println("Altura: ");
        float altura = sc.nextFloat();
        sc.nextLine(); // Limpar buffer

        System.out.println("Salário: ");
        double salario = sc.nextDouble();
        sc.nextLine(); // Limpar buffer

        System.out.println("Gênero (M/F): ");
        char genero = sc.next().charAt(0);
        sc.nextLine(); // Limpar buffer

        System.out.println("Trabalha? (True or False): ");
        boolean trabalha = sc.nextBoolean();

        long idadeLong = idade; // conversão implícita (java faz automaticamente)
        int salarioInt = (int) salario; // conversão explícita (cast)
        double alturaDouble = altura; // conversão implicita
    }
}
