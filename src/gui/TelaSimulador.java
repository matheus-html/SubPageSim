package gui;
import algoritmos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class TelaSimulador extends JFrame {

    private JTextField campoPaginas;
    private JTextField campoFrames;
    private JButton botaoSimular;
    private JTextArea areaResultados;
    private PainelGrafico painelGrafico;

    private AlgSub fifo;
    private AlgSub lru;
    private AlgSub otimo;
    private AlgSub clock;

    public TelaSimulador() {
        setTitle("Simulador de Substituição de Páginas");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        this.fifo = new FIFO();
        this.lru = new LRU();
        this.otimo = new Otimo();
        this.clock = new SegundaChance();

        JPanel painelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        painelEntrada.add(new JLabel("Sequência de Páginas (com espaço):"));
        campoPaginas = new JTextField("7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1");
        painelEntrada.add(campoPaginas);

        painelEntrada.add(new JLabel("Número de Frames (Quadros):"));
        campoFrames = new JTextField("4");
        painelEntrada.add(campoFrames);

        painelEntrada.add(new JLabel());
        botaoSimular = new JButton("Simular");
        painelEntrada.add(botaoSimular);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(areaResultados);
        scrollPane.setPreferredSize(new Dimension(500, 150));

        painelGrafico = new PainelGrafico();

        add(painelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(painelGrafico, BorderLayout.SOUTH);

        botaoSimular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executarSimulacao();
            }
        });
    }

    private void executarSimulacao() {
        try {
            String linhaPaginas = campoPaginas.getText();
            int numQuadros = Integer.parseInt(campoFrames.getText());

            String[] paginasComoString = linhaPaginas.trim().split("\\s+");
            int[] paginas = new int[paginasComoString.length];
            for (int i = 0; i < paginasComoString.length; i++) {
                if (!paginasComoString[i].isEmpty()) {
                    paginas[i] = Integer.parseInt(paginasComoString[i]);
                }
            }

            int faltasFIFO = fifo.simular(paginas, numQuadros);
            int faltasLRU = lru.simular(paginas, numQuadros);
            int faltasOtimo = otimo.simular(paginas, numQuadros);
            int faltasClock = clock.simular(paginas, numQuadros);

            areaResultados.setText("");
            areaResultados.append("Simulação com " + numQuadros + " frames:\n");
            areaResultados.append("------------------------------------------\n");
            areaResultados.append(String.format("FIFO: \t\t%d faltas de página\n", faltasFIFO));
            areaResultados.append(String.format("LRU: \t\t%d faltas de página\n", faltasLRU));
            areaResultados.append(String.format("Ótimo: \t\t%d faltas de página\n", faltasOtimo));
            areaResultados.append(String.format("SegundaChance: \t%d faltas de página\n", faltasClock));

            Map<String, Integer> resultadosParaGrafico = new LinkedHashMap<>();
            resultadosParaGrafico.put("FIFO", faltasFIFO);
            resultadosParaGrafico.put("LRU", faltasLRU);
            resultadosParaGrafico.put("Ótimo", faltasOtimo);
            resultadosParaGrafico.put("Clock", faltasClock);

            painelGrafico.setResultados(resultadosParaGrafico);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro: Verifique os números digitados.\nA sequência deve ter números separados por espaço e o número de frames deve ser um número.",
                    "Erro de Formato",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaSimulador().setVisible(true);
            }
        });
    }
}