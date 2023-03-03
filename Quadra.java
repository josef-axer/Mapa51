import java.util.Scanner;

public class Quadra {
    private String nome;
    private String tipo;
    private double valorMinuto;
    
    public Quadra(String nome, String tipo, double valorMinuto) {
        this.nome = nome;
        this.tipo = tipo;
        this.valorMinuto = valorMinuto;
    }
    
    public static Quadra cadastrarQuadra() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome da quadra: ");
        String nome = scanner.nextLine();
    
        System.out.print("Digite o tipo da quadra: ");
        String tipo = scanner.nextLine();
    
        double valorMinuto = 0.0;
        boolean inputValido = false;
        while (!inputValido) {
            System.out.print("Digite o valor por minuto da quadra: ");
            if (scanner.hasNextDouble()) {
                valorMinuto = scanner.nextDouble();
                inputValido = true;
            } else {
                scanner.next();
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
        
        scanner.close();
    
        return new Quadra(nome, tipo, valorMinuto);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorMinuto() {
        return valorMinuto;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }
}
