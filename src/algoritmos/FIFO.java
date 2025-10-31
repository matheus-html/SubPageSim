package algoritmos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FIFO implements AlgSub {
    @Override
    public int simular(int[] paginasReferencia, int numQuadros) {
        int pageFaults = 0;
        Queue<Integer> fila = new LinkedList<>();
        Set<Integer> memoria = new HashSet<>();

        for (int pagina : paginasReferencia) {
            if (!memoria.contains(pagina)) {
                pageFaults++;

                if (memoria.size() == numQuadros) {
                    int paginaRemovida = fila.poll();
                    memoria.remove(paginaRemovida);
                }

                fila.offer(pagina);
                memoria.add(pagina);
            }
        }
        return pageFaults;
    }
}
