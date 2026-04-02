package jogo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PedraPapelTesoura extends JFrame {

    private final String[] opcoes = {"Pedra", "Papel", "Tesoura"};
    private final JLabel resultadoLabel = new JLabel("Escolha sua jogada!");
    private final Random random = new Random();

    public PedraPapelTesoura() {
        setTitle("Jogo Pedra, Papel e Tesoura");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de botões
        JPanel botoesPanel = new JPanel();
        for (String opcao : opcoes) {
            JButton botao = new JButton(opcao);
            botao.addActionListener(e -> jogar(opcao));
            botoesPanel.add(botao);
        }

        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("Arial", Font.BOLD, 16));

        add(resultadoLabel, BorderLayout.CENTER);
        add(botoesPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // centraliza
        setVisible(true);
    }

    private void jogar(String jogadorEscolha) {
        String computadorEscolha = opcoes[random.nextInt(3)];
        String resultado;

        if (jogadorEscolha.equals(computadorEscolha)) {
            resultado = "Empate! Ambos escolheram " + jogadorEscolha + ".";
        } else if (
            (jogadorEscolha.equals("Pedra") && computadorEscolha.equals("Tesoura")) ||
            (jogadorEscolha.equals("Papel") && computadorEscolha.equals("Pedra")) ||
            (jogadorEscolha.equals("Tesoura") && computadorEscolha.equals("Papel"))
        ) {
            resultado = "Você venceu! " + jogadorEscolha + " vence " + computadorEscolha + ".";
        } else {
            resultado = "Você perdeu! " + computadorEscolha + " vence " + jogadorEscolha + ".";
        }

        resultadoLabel.setText(resultado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PedraPapelTesoura::new);
    }
}
