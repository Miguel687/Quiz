package com.company.view;

import com.company.view.Interface.BorrarPreguntasInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrarPreguntasDialog extends JDialog {

    private JLabel lbID;
    private JTextField edtID;
    private JButton btnBorrar;
    private JButton btnCancelar;
    private JPanel pnlBorrar;

    private BorrarPreguntasInterface listener;

    public BorrarPreguntasDialog(JFrame parent){
        super(parent, true);
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(2);
        super.setSize(180,100);

        lbID = new JLabel("ID:");
        edtID = new JTextField(10);
        pnlBorrar = new JPanel();
        pnlBorrar.add(lbID);
        pnlBorrar.add(edtID);
        pnlBorrar.setLayout(new GridLayout(1,1, -70, 0));

        btnBorrar = new JButton("Borrar");
        btnCancelar = new JButton("Cancelar");

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickBorrar(edtID.getText());
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickCancelar();
            }
        });


        super.add(pnlBorrar);
        super.add(btnBorrar);
        super.add(btnCancelar);
        super.setLocationRelativeTo(null);
        super.setVisible(false);
    }

    public void setListener(BorrarPreguntasInterface listener) {
        this.listener = listener;
    }
}
