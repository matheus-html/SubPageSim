package algoritmos;

import java.util.HashSet;
import java.util.Set;

public class Otimo implements AlgSub {
    @Override
    public int simular(int[] paginasReferencia, int numQuadros) {
        int pageFaults = 0;
        Set<Integer> memoria = new HashSet<>();

        for (int i = 0; i < paginasReferencia.length; i++) {
            int pagina = paginasReferencia[i];

            if (!memoria.contains(pagina)) {
                pageFaults++;

                if (memoria.size() == numQuadros) {
                    int paginaParaRemover = -1;
                    int maiorDistancia = -1;

                    for (int paginaNaMemoria : memoria) {
                        int distancia = Integer.MAX_VALUE;
                        for (int j = i + 1; j < paginasReferencia.length; j++) {
                            if (paginasReferencia[j] == paginaNaMemoria) {
                                distancia = j;
                                break;
                            }
                        }

                        if (distancia > maiorDistancia) {
                            maiorDistancia = distancia;
                            paginaParaRemover = paginaNaMemoria;
                        }
                    }
                    memoria.remove(paginaParaRemover);
                }
                memoria.add(pagina);
            }
        }
        return pageFaults;
    }
}
