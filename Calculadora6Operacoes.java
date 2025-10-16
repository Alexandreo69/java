import java.util.Scanner;

public class Calculadora6Operacoes {

    // Métodos para cada operação
    private static double soma(double a, double b) { return a + b; }
    private static double subtracao(double a, double b) { return a - b; }
    private static double multiplicacao(double a, double b) { return a * b; }
    private static double divisao(double a, double b) { return a / b; } // cuidado com divisão por zero tratado no código
    private static double modulo(double a, double b) { return a % b; }
    private static double potencia(double a, double b) { return Math.pow(a, b); }

    private static void mostrarMenu() {
        System.out.println("\n=== CALCULADORA: 6 OPERAÇÕES ===");
        System.out.println("1) Adição (a + b)");
        System.out.println("2) Subtração (a - b)");
        System.out.println("3) Multiplicação (a * b)");
        System.out.println("4) Divisão (a / b)");
        System.out.println("5) Resto / Módulo (a % b)");
        System.out.println("6) Potenciação (a ^ b)");
        System.out.println("0) Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        System.out.println("Calculadora simples — 6 operações");
        while (true) {
            mostrarMenu();
            // validação simples para entrada de opção
            if (!sc.hasNextInt()) {
                System.out.println("Entrada inválida. Digite o número da opção.");
                sc.nextLine(); // descarta entrada inválida
                continue;
            }
            opcao = sc.nextInt();
            if (opcao == 0) {
                System.out.println("Encerrando calculadora. Até logo!");
                break;
            }

            if (opcao < 0 || opcao > 6) {
                System.out.println("Opção desconhecida. Tente novamente.");
                continue;
            }

            // ler operandos
            System.out.print("Digite o valor de a: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Entrada inválida. Digite um número (use ponto para decimais).");
                sc.nextLine();
                System.out.print("Digite o valor de a: ");
            }
            double a = sc.nextDouble();

            System.out.print("Digite o valor de b: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Entrada inválida. Digite um número (use ponto para decimais).");
                sc.nextLine();
                System.out.print("Digite o valor de b: ");
            }
            double b = sc.nextDouble();

            // realiza operação escolhida
            double resultado;
            switch (opcao) {
                case 1:
                    resultado = soma(a, b);
                    System.out.printf("Resultado: %.10g\n", resultado);
                    break;
                case 2:
                    resultado = subtracao(a, b);
                    System.out.printf("Resultado: %.10g\n", resultado);
                    break;
                case 3:
                    resultado = multiplicacao(a, b);
                    System.out.printf("Resultado: %.10g\n", resultado);
                    break;
                case 4:
                    if (b == 0.0) {
                        System.out.println("Erro: divisão por zero não é permitida.");
                    } else {
                        resultado = divisao(a, b);
                        System.out.printf("Resultado: %.10g\n", resultado);
                    }
                    break;
                case 5:
                    if (b == 0.0) {
                        System.out.println("Erro: módulo por zero não é permitido.");
                    } else {
                        resultado = modulo(a, b);
                        System.out.printf("Resultado: %.10g\n", resultado);
                    }
                    break;
                case 6:
                    // potencia: a^b
                    resultado = potencia(a, b);
                    System.out.printf("Resultado: %.10g\n", resultado);
                    break;
                default:
                    System.out.println("Opção não implementada.");
            }

            // limpa eventual nova linha pendente
            sc.nextLine();
            System.out.println("\nPressione Enter para continuar...");
            sc.nextLine();
        }

        sc.close();
    }
}
