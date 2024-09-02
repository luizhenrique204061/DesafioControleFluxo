import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        boolean entradaValida = false;
        int parametroUm = 0;
        int parametroDois = 0;

        do {
            System.out.println("Digite o primeiro parâmetro");

            if (terminal.hasNextInt()) {
                parametroUm = terminal.nextInt();
                entradaValida = true; // A entrada é válida, podemos sair do loop
            } else {
                System.out.println("Digite um valor válido");
                terminal.next(); // Avançar para o próximo token para evitar loop infinito
            }
        } while (!entradaValida);

        entradaValida = false; // Reiniciar para a próxima entrada

        do {
            System.out.println("Digite o segundo parâmetro");

            if (terminal.hasNextInt()) {
                parametroDois = terminal.nextInt();
                entradaValida = true; // A entrada é válida, podemos sair do loop
            } else {
                System.out.println("Digite um valor válido");
                terminal.next(); // Avançar para o próximo token para evitar loop infinito
            }
        } while (!entradaValida);

        try {
            // Chamando o método contendo a lógica de contagem
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException exception) {
            // Imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println(exception.getMessage());
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        int contagem = parametroDois - parametroUm;
        // Realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
