import algoritmos.*;
import java.util.Scanner;

public class Simulador {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a sequência de páginas (separada por ESPAÇO):");
        String linhaPaginas = sc.nextLine();

        System.out.println("Digite o número de quadros de memória:");
        int numQuadros = sc.nextInt();

        String[] paginasComoString = linhaPaginas.trim().split("\\s+");

        int[] paginas = new int[paginasComoString.length];

        for (int i = 0; i < paginasComoString.length; i++) {
            paginas[i] = Integer.parseInt(paginasComoString[i]);
        }

        AlgSub fifo = new FIFO();
        AlgSub lru = new LRU();
        AlgSub otimo = new Otimo();
        AlgSub clock = new SegundaChance();

        System.out.println("Simulação com " + numQuadros + " quadros:");

        int faltasFIFO = fifo.simular(paginas, numQuadros);
        System.out.println("FIFO: " + faltasFIFO + " faltas de página");

        int faltasLRU = lru.simular(paginas, numQuadros);
        System.out.println("LRU: " + faltasLRU + " faltas de página");

        int faltasOtimo = otimo.simular(paginas, numQuadros);
        System.out.println("Ótimo: " + faltasOtimo + " faltas de página");

        int faltasClock = clock.simular(paginas, numQuadros);
        System.out.println("SegundaChance: " + faltasClock + " faltas de página");
    }
}
