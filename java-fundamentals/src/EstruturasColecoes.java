import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstruturasColecoes {
    public static void main(String[] args) {

        // 1️ARRAYS

        // ➕ Vantagens:
        // - Mais rápido e leve
        // - Pode armazenar tipos primitivos diretamente (int, double, etc)
        // ➖ Desvantagens:
        // - Tamanho fixo
        // - Pouca flexibilidade

        int[] numeros = new int[3]; // array de tamanho fixo com 3 posições
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;

        System.out.println("🔹 Array:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posição " + i + ": " + numeros[i]);
        }

        // 2️⃣ LISTAS (ArrayList)

        // ➕ Vantagens:
        // - Tamanho dinâmico (adiciona e remove facilmente)
        // - Métodos úteis: add(), remove(), contains(), size(), etc.
        // ➖ Desvantagens:
        // - Não suporta tipos primitivos diretamente (usa wrappers como Integer)
        // - Um pouco mais lenta que array em casos simples

        List<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(10);
        listaNumeros.add(20);
        listaNumeros.add(30);
        listaNumeros.add(40);

        listaNumeros.remove(1); // remove o valor da posição 1 (20)

        System.out.println("\n🔹 Lista:");
        for (int i = 0; i < listaNumeros.size(); i++) {
            System.out.println("Índice " + i + ": " + listaNumeros.get(i));
        }

        System.out.println("Contém o número 10? " + listaNumeros.contains(10));
        System.out.println("Tamanho da lista: " + listaNumeros.size());
        System.out.println("Está vazia? " + listaNumeros.isEmpty());

        // Pegar o primeiro e último item da lista
        if (!listaNumeros.isEmpty()) {
            System.out.println("Primeiro: " + listaNumeros.get(0));
            System.out.println("Último: " + listaNumeros.get(listaNumeros.size() - 1));
        }

        // 3️⃣ MAPAS (HashMap)

        // ➕ Vantagens:
        // - Armazena pares "chave → valor"
        // - Busca rápida por chave
        // - Ideal para representar objetos como "nome → idade", "produto → preço"
        // ➖ Desvantagens:
        // - Não mantém ordem
        // - Não pode ter chaves duplicadas

        Map<String, Integer> estoque = new HashMap<>();
        estoque.put("Arroz", 10);
        estoque.put("Feijão", 5);
        estoque.put("Macarrão", 8);

        estoque.put("Feijão", 7); // atualiza valor do Feijão

        System.out.println("\n🔹 Mapa:");
        for (String produto : estoque.keySet()) {
            System.out.println(produto + " → " + estoque.get(produto) + " unidades");
        }

        System.out.println("Tem arroz? " + estoque.containsKey("Arroz"));
        System.out.println("Quantidade de feijão: " + estoque.get("Feijão"));
        System.out.println("Mapa está vazio? " + estoque.isEmpty());
    }
}
