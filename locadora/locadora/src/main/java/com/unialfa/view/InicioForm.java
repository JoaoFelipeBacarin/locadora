package com.unialfa.view;

import javax.swing.*;
import java.awt.*;

public class InicioForm extends JFrame{
    private JButton botaoFilmes;
    private JButton botaoDiretores;

    public InicioForm() {
        setTitle("Início");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        botaoDiretores = new JButton("Diretores");
        botaoDiretores.addActionListener(e -> {
            try {
                new DiretorForm().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(botaoDiretores, constraints);

        botaoFilmes = new JButton("Filmes");
        botaoFilmes.addActionListener(e -> {
            try {
                new FilmeForm().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelEntrada.add(botaoFilmes, constraints);

        add(painelEntrada, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var form = new InicioForm();
            form.setVisible(true);
        });
    }
}
