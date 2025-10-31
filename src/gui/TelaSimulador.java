package gui;
import algoritmos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSimulador extends JFrame{
    private JTextField campoPaginas;
    private JTextField campoFrames;
    private JButton botaoSimular;
    private JTextArea areaResultados;

    private AlgSub fifo;
    private AlgSub lru;
    private AlgSub otimo;
    private AlgSub clock;

    public TelaSimulador() {
        setTitle("Simulador de Substituição de Páginas");
        setSize(500, 400);
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

        add(painelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

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
                paginas[i] = Integer.parseInt(paginasComoString[i]);
            }

            int faltasFIFO = fifo.simular(paginas, numQuadros);
            int faltasLRU = lru.simular(paginas, numQuadros);
            int faltasOtimo = otimo.simular(paginas, numQuadros);
            int faltasClock = clock.simular(paginas, numQuadros);

            areaResultados.setText("");
            areaResultados.append("Simulação com " + numQuadros + " frames:\n");
            areaResultados.append("------------------------------------------\n");
            areaResultados.append("FIFO: " + faltasFIFO + " faltas de página\n");
            areaResultados.append("LRU: " + faltasLRU + " faltas de página\n");
            areaResultados.append("Ótimo: " + faltasOtimo + " faltas de página\n");
            areaResultados.append("SegundaChance: " + faltasClock + " faltas de página\n");

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
