import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("J.K. Rowling");

        Livro harryPotter = new Livro("Harry Potter e a Pedra Filosofal", autor, 2000, true);
        Livro harryPotter2 = new Livro("Harry Potter e a Câmara Secreta", autor, 2001, true);

        Usuario user1 = new Usuario("Kauan Rodrigues", "12345678909");
        Usuario user2 = new Usuario("Maria Silva", "98765432100");

        Funcionario funcionario = new Funcionario("João Souza", "11122233344");

        System.out.println("\n📚 Estado inicial dos livros:");
        System.out.println(harryPotter);
        System.out.println(harryPotter2);

        System.out.println("\n👤 Tentativa de empréstimo do usuário:");
        user1.emprestarLivro(harryPotter);  // Deve emprestar com sucesso
        user1.exibirDados();

        System.out.println("\n👤 Tentativa de outro usuário pegar o mesmo livro:");
        user2.emprestarLivro(harryPotter);  // Deve falhar
        user2.exibirDados();

        System.out.println("\n👔 Funcionário pegando outro livro:");
        funcionario.emprestarLivro(harryPotter2);  // Deve emprestar com sucesso
        funcionario.exibirDados();

        System.out.println("\n✅ Devolução do livro pelo usuário:");
        user1.devolverLivro(harryPotter);  // Devolve o livro
        user1.exibirDados();

        System.out.println("\n📚 Estado final dos livros:");
        System.out.println(harryPotter);
        System.out.println(harryPotter2);
    }
}


class Livro {
    private String titulo;
    private Autor autor;
    private int anoDePublicacao;
    private boolean disponivel = true;

    public Livro(String titulo, Autor autor, int anoDePublicacao, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoDePublicacao = anoDePublicacao;
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor.getNome() +
                ", ano=" + anoDePublicacao +
                ", disponivel=" + disponivel +
                '}';
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado!");
        } else {
            System.out.println("Livro não está disponível");
        }
    }

    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Livro devolvido!");
        } else {
            System.out.println("Livro já foi devolvido!");
        }
    }

    public void exibirInformacoes() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor.getNome());
        System.out.println("Ano de publicação: " + anoDePublicacao);
        System.out.println("Disponível: " + disponivel);
    }

    public boolean getDisponivel() {
        return disponivel;
    }
}

class Autor {
    private String nome;

    public Autor(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Autor{" + "nome='" + nome + '\'' + '}';
    }


    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
    }

    public String getNome() {
        return nome;
    }
}

abstract class Pessoa {
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    public abstract void exibirDados();

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

class Usuario extends Pessoa {
    private Livro livroEmprestado;

    public Usuario(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", livroEmprestado=" + (livroEmprestado != null ? livroEmprestado.toString() : "Nenhum") +
                '}';
    }

    public void emprestarLivro(Livro livro) {
        if (!livro.getDisponivel()) {
            System.out.println("Este livro não está disponível!");
            return;
        }
        if (livroEmprestado == null) {
            System.out.println("Você já está com um livro emprestado!");
            return;
        }
        livroEmprestado = livro;
        livro.emprestar();
    }

    public void devolverLivro(Livro livro) {
        if (livroEmprestado == livro) {
            livroEmprestado = null;
            livro.devolver();
        } else {
            System.out.println("Este não é o livro que você pegou emprestado!");
        }
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + super.getNome());
        System.out.println("CPF: " + super.getCpf());
        System.out.println("Livro emprestado:");
        if (livroEmprestado != null) {
            livroEmprestado.exibirInformacoes();
        } else {
            System.out.println("Nenhum livro emprestado!");
        }
    }
}

class Funcionario extends Pessoa {
    private List<Livro> livrosEmprestados = new ArrayList<>();

    public Funcionario(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", livrosEmprestados=" + livrosEmprestados +
                '}';
    }

    public void emprestarLivro(Livro livro) {
        if (!livro.getDisponivel()) {
            System.out.println("Este livro não está disponível!");
            return;
        }
        if (livrosEmprestados.size() >= 10) {
            System.out.println("Atingiu o limite máximo de livros.");
            return;
        }
        livrosEmprestados.add(livro);
        livro.emprestar();
    }

    public void devolverLivro(Livro livro) {
        if (livrosEmprestados.contains(livro)) {
            livrosEmprestados.remove(livro);
            livro.devolver();
        } else {
            System.out.println("Este livro já foi devolvido!");
        }
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + super.getNome());
        System.out.println("CPF: " + super.getCpf());
        System.out.println("Livros emprestados:");

        if (!livrosEmprestados.isEmpty()) {
            for (Livro livro : livrosEmprestados) {
                System.out.println();
                livro.exibirInformacoes();
                System.out.println();
            }
        } else {
            System.out.println("Nenhum livro emprestado!");
        }
    }
}