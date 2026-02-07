import java.util.Scanner;

/**
 * Classe principal responsável por executar o programa.
 * O objetivo é calcular o número de maneiras distintas de subir uma escada
 * com N degraus, podendo subir 1 ou 2 degraus por vez.
 *
 * O cálculo é feito utilizando:
 * - Recursão
 * - Memoization (programação dinâmica)
 */
public class Main {

    /**
     * Método principal do programa.
     * Responsável por:
     * - Ler o valor de N informado pelo usuário
     * - Inicializar o vetor de memoization
     * - Chamar o método recursivo
     * - Exibir o resultado final
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor de N:");
        int n = scanner.nextInt();

        // Vetor utilizado para armazenar resultados já calculados (memoization)
        int[] vetor = new int[n + 1];

        // Chamada do método recursivo
        int resultado = subirEscadas(n, vetor);

        // Exibição do resultado final
        System.out.println("Número de maneiras de subir a escada: " + resultado);

        scanner.close();
    }

    /**
     * Método recursivo responsável por calcular o número de maneiras
     * de subir uma escada com n degraus.
     *
     * n     número de degraus restantes
     * vetor vetor de memoization para armazenar resultados já calculados
     * número de maneiras distintas de subir a escada
     */
    public static int subirEscadas(int n, int[] vetor) {

        // Caso base:
        // Se n for 0 ou 1, existe apenas uma forma de subir
        if (n == 0 || n == 1) {
            return 1;
        }

        // Se o valor já foi calculado anteriormente, retorna do vetor
        if (vetor[n] != 0) {
            return vetor[n];
        }

        // Relação de recorrência:
        // F(n) = F(n - 1) + F(n - 2)
        vetor[n] = subirEscadas(n - 1, vetor) + subirEscadas(n - 2, vetor);

        return vetor[n];
    }
}