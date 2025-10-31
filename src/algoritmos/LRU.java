package algoritmos;

import java.util.LinkedList;
import java.util.List;

public class LRU implements AlgSub {
    @Override
    public int simular(int[] paginasReferencia, int numQuadros) {
        int pageFaults = 0;
        List<Integer> memoria = new LinkedList<>();

        for (int pagina : paginasReferencia) {
            if (memoria.contains(pagina)) {
                memoria.remove((Integer) pagina);
                memoria.add(pagina);
            } else {
                pageFaults++;

                if (memoria.size() == numQuadros) {
                    memoria.remove(0);
                }

                memoria.add(pagina);
            }
        }
        return pageFaults;
    }
}
