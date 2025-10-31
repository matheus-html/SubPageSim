import algoritmos.*;

public class Simulador {
    public static void main(String[] args) {
        int[] paginas = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        int numQuadros = 4;

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
