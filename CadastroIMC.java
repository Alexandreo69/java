import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    private String nome;
    private double peso;
    private double altura;
    private double imc;

    // Construtor
    public Pessoa(String nome, double peso, double altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.imc = calcularIMC();
    }

    // Cálculo do IMC
    private double calcularIMC() {
        return peso / (altura * altura);
    }

    // Getters
    public String getNome() {
        return nome;
    }
    public double getPeso() {
        return peso;
    }
    public double getAltura() {
        return altura;
    }
    public double getIMC() {
        return imc;
    }
    public void exibirDados() {
        System.out.printf("Nome: %-10s | Peso: %.2f kg | Altura: %.2f m | IMC: %.2f%n", nome, peso, altura, imc);
    }
}

// Classe principal
public class CadastroIMC {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== MENU CADASTRO DE IMC ===");
            System.out.println("1 - Cadastrar nova pessoa");
            System.out.println("2 - Mostrar todos os cadastrados");
            System.out.println("3 - Consultar pessoa por nome");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leia.nextInt();
            leia.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CADASTRAR PESSOA ---");
                    System.out.print("Nome: ");
                    String nome = leia.nextLine();

                    System.out.print("Peso (kg): ");
                    double peso = leia.nextDouble();

                    System.out.print("Altura (m): ");
                    double altura = leia.nextDouble();
                    leia.nextLine();

                    pessoas.add(new Pessoa(nome, peso, altura));
                    System.out.println(" Pessoa cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.println("\n=== LISTA DE PESSOAS CADASTRADAS ===");
                    if (pessoas.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada ainda.");
                    } else {
                        for (Pessoa p : pessoas) {
                            p.exibirDados();
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nDigite o nome da pessoa que deseja consultar: ");
                    String nomeBuscado = leia.nextLine();

                    boolean encontrado = false;
                    for (Pessoa p : pessoas) {
                        if (p.getNome().equalsIgnoreCase(nomeBuscado)) {
                            System.out.println("\n--- Dados encontrados ---");
                            System.out.printf("Nome: %s%nPeso: %.2f kg%nAltura: %.2f m%nIMC: %.2f%n", p.getNome(), p.getPeso(), p.getAltura(), p.getIMC());
                            encontrado = true;
//                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println(" Nome não encontrado na lista.");
                    }
                    break;

                case 4:
                    System.out.println("\nEncerrando o programa... ");
                    break;

                default:
                    System.out.println("\n Opção inválida. Tente novamente!");
            }
        } while (opcao != 4);

        leia.close();
    }
}
