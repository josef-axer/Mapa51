import java.util.Scanner;

public class Locatario {
    public String nome;
    public String cpf;
    public String telefone;
    public String anoNascimento;
    
    public Locatario(String nome, String cpf, String telefone, String anoNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.anoNascimento = anoNascimento;
    }
    
    public boolean verificarMaiorIdade() {
        int idade = 2023 - (Integer.parseInt(this.anoNascimento));
        return idade >= 18;
    }
    
    public static Locatario cadastrarLocatario() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o nome do locatário: ");
            String nome = scanner.hasNextLine() ? scanner.nextLine() : "";
   
            System.out.print("Digite o CPF do locatário: ");
            String cpf = scanner.hasNextLine() ? scanner.nextLine() : "";
   
            System.out.print("Digite o telefone do locatário: ");
            String telefone = scanner.hasNextLine() ? scanner.nextLine() : "";
   
            System.out.print("Digite o ano de nascimento do locatário: ");
            String anoNascimento = scanner.hasNextLine() ? scanner.nextLine() : "";
   
            return new Locatario(nome, cpf, telefone, anoNascimento);
        }
    }
    

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }
}
