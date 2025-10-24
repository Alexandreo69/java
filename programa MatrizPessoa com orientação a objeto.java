// programa MatrizPessoa com orientação a objeto

import java.util.Scanner;

// Classe que representa uma pessoa (modelo de objeto)
class Pessoa {
    private String nome;
    private int idade;
    private String telefone;

    // Construtor para inicializar os atributos da pessoa
    public Pessoa(String nome, int idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    // Métodos getters (para acessar os dados privados)
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    // Método para exibir os dados da pessoa
    public void exibirDados() {
        System.out.println("Nome: " + nome + " | Idade: " + idade + " | Telefone: " + telefone);
    }
}

// Classe principal
public class MatrizPessoasOO {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        // Criamos um vetor de objetos Pessoa (em vez de uma matriz 3x5 de Strings)
        Pessoa[] pessoas = new Pessoa[5];

        // Preenchendo o vetor com objetos Pessoa já definidos (como antes)
        pessoas[0] = new Pessoa("Ana", 25, "9999-1111");
        pessoas[1] = new Pessoa("Bruno", 30, "9888-2222");
        pessoas[2] = new Pessoa("Carlos", 22, "9777-3333");
        pessoas[3] = new Pessoa("Daniela", 28, "9666-4444");
        pessoas[4] = new Pessoa("Eduardo", 35, "9555-5555");

        // Exibir todos os dados (agora chamando o método da classe Pessoa)
        System.out.println("=== LISTA DE PESSOAS ===");
        for (Pessoa p : pessoas) {
            p.exibirDados();
        }

        // Solicitar nome para busca
        System.out.print("\nDigite o nome da pessoa que deseja consultar: ");
        String nomeBuscado = leia.nextLine();

        boolean encontrado = false;

        // Procurar o nome entre os objetos Pessoa
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nomeBuscado)) {
                System.out.println("\n--- Dados encontrados ---");
                System.out.println("Nome: " + p.getNome());
                System.out.println("Idade: " + p.getIdade());
                System.out.println("Telefone: " + p.getTelefone());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\nNome não encontrado na lista.");
        }

        leia.close();
    }
}
