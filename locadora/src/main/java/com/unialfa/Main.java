package com.unialfa;

import com.unialfa.view.DiretorForm;
import com.unialfa.view.FilmeForm;
import com.unialfa.view.InicioForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //var form = new FilmeForm();
            var form = new DiretorForm();
            //var form = new InicioForm();
            form.setVisible(true);
        });
    }
}