import java.util.Scanner;

class Usuario {
    private String login;
    private String senha;
    private int nivelAcesso;
    // Construtor
    public Usuario(String login, String senha, int nivelAcesso) {
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }
    // Getters (encapsulamento)
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }
    public int getNivelAcesso() {
        return nivelAcesso;
    }
}

// Classe principal que faz o controle de login
public class SistemaLogin {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Criação de usuários cadastrados
        Usuario u1 = new Usuario("admin", "1234", 1);
        Usuario u2 = new Usuario("joao", "abcd", 2);
        Usuario u3 = new Usuario("visitante", "0000", 3);

        // Vetor de usuários
        Usuario[] usuarios = {u1, u2, u3};

        System.out.println("=== SISTEMA DE LOGIN ===");
        System.out.print("Login: ");
        String login = entrada.nextLine();

        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        boolean acessoPermitido = false;

        // Verifica se o login e senha conferem com algum usuário
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                acessoPermitido = true;
                System.out.println("\n>>> Acesso permitido!");

                // Verifica o nível de acesso
                switch (u.getNivelAcesso()) {
                    case 1:
                        System.out.println("Bem-vindo, Administrador! Você tem acesso total ao sistema.");
                        break;
                    case 2:
                        System.out.println("Bem-vindo, Usuário Comum! Você tem acesso às funções básicas.");
                        break;
                    case 3:
                        System.out.println("Bem-vindo, Visitante! Seu acesso é limitado.");
                        break;
                }
                break;
            }
        }

        if (!acessoPermitido) {
            System.out.println("\n>>> Acesso negado! Login ou senha incorretos.");
        }

        entrada.close();
    }
}
