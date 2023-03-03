import java.util.Scanner;

public class Locacao {
    private Locatario locatario;
    private Quadra quadra;
    private int tempoMinuto;
    private boolean necessitaEquipamento;

    public Locacao(Locatario locatario, Quadra quadra, int tempoMinuto, boolean necessitaEquipamento) {
        this.locatario = locatario;
        this.quadra = quadra;
        this.tempoMinuto = tempoMinuto;
        this.necessitaEquipamento = necessitaEquipamento;
    }

    public Locacao() {
    }

    public double calcularLocacao() {
        double valorTotal = 0;
        double valorMinuto = quadra.getValorMinuto();

        if (tempoMinuto <= 120) {
            valorTotal = valorMinuto * tempoMinuto;
        } else {
            double valorHoraNormal = valorMinuto * 60;
            double valorHoraDesconto = valorHoraNormal * 0.9;
            int horasNormais = 2;
            int horasExtras = (tempoMinuto - 120) / 60;
            int minutosExtras = (tempoMinuto - 120) % 60;
            valorTotal = (horasNormais * valorHoraNormal) + (horasExtras * valorHoraDesconto)
                    + (minutosExtras * valorMinuto);
        }

        if (necessitaEquipamento) {
            valorTotal += 50;
        }

        return valorTotal;
    }

    public void mostrarResumoLocacao() {
        System.out.println("Resumo da Locação:");
        System.out.println("Locatário: " + locatario.getNome() + " (" + locatario.getCpf() + ")");
        System.out.println("Quadra: " + quadra.getNome() + " (" + quadra.getTipo() + ")");
        System.out.println("Tempo (minutos): " + tempoMinuto);
        System.out.println("Necessita equipamento: " + (necessitaEquipamento ? "Sim" : "Não"));
        System.out.println("Valor total da locação: R$" + calcularLocacao());
    }

    public void cadastrarLocacao() {
        Locatario locatario = Locatario.cadastrarLocatario();
        Quadra quadra = Quadra.cadastrarQuadra();
        if (!locatario.verificarMaiorIdade()) {
            System.out.println("O locatário é menor de idade. A locação não pode ser realizada.");
            return;
        }
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o tempo (em minutos) da locação: ");
            int tempoMinuto = 0;
            boolean inputValido = false;
            while (!inputValido) {
                if (scanner.hasNextInt()) {
                    tempoMinuto = scanner.nextInt();
                    inputValido = true;
                } else {
                    scanner.next(); // descarta o valor inválido
                    System.out.println("Valor inválido. Tente novamente.");
                }
            }
            System.out.print("Necessita de equipamento? (S/N): ");
            String resposta = "";
            inputValido = false;
            while (!inputValido) {
                if (scanner.hasNext()) {
                    resposta = scanner.next();
                    if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("N")) {
                        inputValido = true;
                    } else {
                        System.out.println("Resposta inválida. Tente novamente.");
                    }
                } else {
                    scanner.next(); // descarta o valor inválido
                    System.out.println("Resposta inválida. Tente novamente.");
                }
            }
            boolean necessitaEquipamento = resposta.equalsIgnoreCase("S");
            Locacao locacao = new Locacao(locatario, quadra, tempoMinuto, necessitaEquipamento);
            locacao.mostrarResumoLocacao();
        }
        }
        

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Quadra getQuadra() {
        return quadra;
    }

    public void setQuadra(Quadra quadra) {
        this.quadra = quadra;
    }

    public int getTempoMinuto() {
        return tempoMinuto;
    }

    public void setTempoMinuto(int tempoMinuto) {
        this.tempoMinuto = tempoMinuto;
    }

    public boolean isNecessitaEquipamento() {
        return necessitaEquipamento;
    }

    public void setNecessitaEquipamento(boolean necessitaEquipamento) {
        this.necessitaEquipamento = necessitaEquipamento;
    }
}
