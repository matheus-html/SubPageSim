package gui;

import javax.swing.JPanel;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class PainelGrafico extends JPanel {

    private Map<String, Integer> resultados = new LinkedHashMap<>();

    public PainelGrafico() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(500, 250));
    }

    public void setResultados(Map<String, Integer> novosResultados) {
        this.resultados = novosResultados;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (resultados.isEmpty()) {
            return;
        }

        int larguraPainel = getWidth();
        int alturaPainel = getHeight();
        int padding = 30;
        int larguraBarra = 40;
        int espacoEntreBarras = 60;

        int alturaGrafico = alturaPainel - 2 * padding;

        int maxFaltas = 0;
        for (int faltas : resultados.values()) {
            if (faltas > maxFaltas) {
                maxFaltas = faltas;
            }
        }

        if (maxFaltas == 0) maxFaltas = 1;

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 12));

        int x = padding + espacoEntreBarras;

        for (Map.Entry<String, Integer> entry : resultados.entrySet()) {
            String nomeAlgoritmo = entry.getKey();
            int faltas = entry.getValue();

            int alturaBarra = (int) (((double) faltas / maxFaltas) * alturaGrafico);
            int yBarra = alturaPainel - padding - alturaBarra;

            g.setColor(new Color(60, 120, 180));
            g.fillRect(x, yBarra, larguraBarra, alturaBarra);

            g.setColor(Color.BLACK);
            g.drawString(nomeAlgoritmo, x, alturaPainel - padding + 15);
            g.drawString(String.valueOf(faltas), x + larguraBarra / 2 - 8, yBarra - 5);

            x += larguraBarra + espacoEntreBarras;
        }
    }
}