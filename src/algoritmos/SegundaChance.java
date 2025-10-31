package algoritmos;

import java.util.HashMap;
import java.util.Map;

public class SegundaChance implements AlgSub {
    @Override
    public int simular(int[] paginasReferencia, int numQuadros) {
        int pageFaults = 0;
        int ponteiro = 0;

        Integer[] quadros = new Integer[numQuadros];
        boolean[] bitR = new boolean[numQuadros];
        Map<Integer, Integer> paginaParaIndice = new HashMap<>();

        for (int pagina : paginasReferencia) {
            if (paginaParaIndice.containsKey(pagina)) {
                bitR[paginaParaIndice.get(pagina)] = true;
            } else {
                pageFaults++;

                while (true) {
                    if (quadros[ponteiro] == null) {
                        quadros[ponteiro] = pagina;
                        bitR[ponteiro] = true;
                        paginaParaIndice.put(pagina, ponteiro);
                        ponteiro = (ponteiro + 1) % numQuadros;
                        break;
                    }

                    if (!bitR[ponteiro]) {
                        paginaParaIndice.remove(quadros[ponteiro]);

                        quadros[ponteiro] = pagina;
                        bitR[ponteiro] = true;
                        paginaParaIndice.put(pagina, ponteiro);

                        ponteiro = (ponteiro + 1) % numQuadros;
                        break;
                    } else {
                        bitR[ponteiro] = false;
                        ponteiro = (ponteiro + 1) % numQuadros;
                    }
                }
            }
        }
        return pageFaults;
    }
}
