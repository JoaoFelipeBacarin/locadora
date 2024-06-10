package com.unialfa.view;

import com.unialfa.model.Diretor;
import com.unialfa.service.DiretorService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Locale;

import static java.lang.Integer.parseInt;

public class DiretorForm extends JFrame {
    private DiretorService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNomeDiretor;
    private JTextField campoNomeDiretor;
    private JLabel labelNacionalidadeDiretor;
    private JTextField campoNacionalidadeDiretor;
    private JLabel labelDataNascimentoDiretor;
    private JTextField campoDataNascimentoDiretor;
    private JLabel labelPremiacaoDiretor;
    private JTextField campoPremiacaoDiretor;
    private JLabel labelDataInicioCarreiraDiretor;
    private JTextField campoDataInicioCarreiraDiretor;
    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JButton botaoDeletar;
    private JTable tabelaDiretor;

    public DiretorForm() {
        service = new DiretorService();

        setTitle("Diretor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 550);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelId = new JLabel("ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(labelId, constraints);

        campoId = new JTextField(20);
        campoId.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelEntrada.add(campoId, constraints);

        labelNomeDiretor = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNomeDiretor, constraints);

        campoNomeDiretor = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNomeDiretor, constraints);

        labelNacionalidadeDiretor = new JLabel("Nacionalidade:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelNacionalidadeDiretor, constraints);

        campoNacionalidadeDiretor = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoNacionalidadeDiretor, constraints);

        labelDataNascimentoDiretor = new JLabel("Data de Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelDataNascimentoDiretor, constraints);

        campoDataNascimentoDiretor = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoDataNascimentoDiretor, constraints);

        labelPremiacaoDiretor = new JLabel("Quantidade de Premiações:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelPremiacaoDiretor, constraints);

        campoPremiacaoDiretor = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoPremiacaoDiretor, constraints);

        labelDataInicioCarreiraDiretor = new JLabel("Data do Início da Carreira:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelDataInicioCarreiraDiretor, constraints);

        campoDataInicioCarreiraDiretor = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoDataInicioCarreiraDiretor, constraints);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 0;
        constraints.gridy = 6;
        painelEntrada.add(botaoCancelar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> executarAcaoDoBotao());
        constraints.gridx = 1;
        constraints.gridy = 6;
        painelEntrada.add(botaoSalvar, constraints);

        botaoDeletar = new JButton("Deletar");
        botaoDeletar.addActionListener(e -> deletarDiretor());
        constraints.gridx = 2;
        constraints.gridy = 6;
        painelEntrada.add(botaoDeletar, constraints);

        JPanel painelSaida = new JPanel(new BorderLayout());

        tabelaDiretor = new JTable();
        tabelaDiretor.setModel(carregarDadosDiretores());
        tabelaDiretor.getSelectionModel().addListSelectionListener(e -> selecionarDiretor(e));
        tabelaDiretor.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tabelaDiretor);
        painelSaida.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private void selecionarDiretor(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaDiretor.getSelectedRow();
            if (selectedRow != -1) {
                var id = (Integer) tabelaDiretor.getValueAt(selectedRow, 0);
                campoId.setText(id.toString());
                var nome = (String) tabelaDiretor.getValueAt(selectedRow, 1);
                campoNomeDiretor.setText(nome);
                var nacionalidade = (String) tabelaDiretor.getValueAt(selectedRow, 2);
                campoNacionalidadeDiretor.setText(nacionalidade);
                var dataNascimento = (Date) tabelaDiretor.getValueAt(selectedRow, 3);
                campoDataNascimentoDiretor.setText(new SimpleDateFormat("dd/MM/yyyy").format(dataNascimento));
                var premiacao = (Integer) tabelaDiretor.getValueAt(selectedRow, 4);
                campoPremiacaoDiretor.setText(premiacao.toString());
                var dataInicioCarreira = (Date) tabelaDiretor.getValueAt(selectedRow, 5);
                campoDataInicioCarreiraDiretor.setText(new SimpleDateFormat("dd/MM/yyyy").format(dataInicioCarreira));
            }
        }
    }

    private void limparCampos() {
        campoId.setText("");
        campoNomeDiretor.setText("");
        campoNacionalidadeDiretor.setText("");
        campoDataNascimentoDiretor.setText("");
        campoPremiacaoDiretor.setText("");
        campoDataInicioCarreiraDiretor.setText("");
    }

    private void executarAcaoDoBotao() {
        try {
            service.salvar(construirDiretor());
            limparCampos();
            tabelaDiretor.setModel(carregarDadosDiretores());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DefaultTableModel carregarDadosDiretores() {
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Nacionalidade");
        model.addColumn("Data de Nascimento");
        model.addColumn("Premiação");
        model.addColumn("Data de Início da Carreira");

        service.listarDiretores().forEach(diretor ->
                model.addRow(new Object[]{
                        diretor.getId(),
                        diretor.getNome(),
                        diretor.getNacionalidade(),
                        diretor.getDataNascimento(),
                        diretor.getPremiacao(),
                        diretor.getDataInicioCarreira(),
                }));
        return model;
    }

    private Diretor construirDiretor() {
        try {
            return campoId.getText().isEmpty()
                    ? new Diretor(campoNomeDiretor.getText(), campoNacionalidadeDiretor.getText(),
                    converterData(campoDataNascimentoDiretor.getText()), Integer.parseInt(campoPremiacaoDiretor.getText()),
                    converterData(campoDataInicioCarreiraDiretor.getText()))
                    : new Diretor(
                    Integer.parseInt(campoId.getText()),
                    campoNomeDiretor.getText(), campoNacionalidadeDiretor.getText(),
                    converterData(campoDataNascimentoDiretor.getText()), Integer.parseInt(campoPremiacaoDiretor.getText()),
                    converterData(campoDataInicioCarreiraDiretor.getText()));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void deletarDiretor() {
        service.deletar(construirDiretor());
        limparCampos();
        tabelaDiretor.setModel(carregarDadosDiretores()); // Corrigido de carregarDadosLocadoras() para carregarDadosDiretores()
    }

    private Date converterData(String data) throws ParseException {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");
        return new Date(formatoSaida.parse(data).getTime()); // Retorna a data convertida
    }
