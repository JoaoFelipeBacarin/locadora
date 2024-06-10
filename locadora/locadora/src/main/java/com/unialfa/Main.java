package com.unialfa;

import com.unialfa.dao.DiretorDao;
import com.unialfa.dao.FilmeDao;
import com.unialfa.view.DiretorForm;
import com.unialfa.view.FilmeForm;
import com.unialfa.view.InicioForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var formFilme = new FilmeForm();
            formFilme.setVisible(true);
            var formDiretor = new DiretorForm();
            formDiretor.setVisible(true);
        });
    }
}