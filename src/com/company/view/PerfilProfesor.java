package com.company.view;

import com.company.view.Interface.IngresarInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilProfesor extends JDialog {

    private JLabel lbIntroduccion;

    private JLabel lbUsuario;
    private JTextField edtUsuario;
    private JPanel pnlUsuario;

    private JLabel lbContrasenia;
    private JPasswordField pswContrasena;
    private JPanel pnlContrasena;
    private JButton btnIngresar;

    private JPanel pnLGeneral;

    private IngresarInterface listener;

    public PerfilProfesor(JFrame parent){
        super(parent, true);
        super.setSize(270,210);
        super.setDefaultCloseOperation(2);
        super.setLayout(new FlowLayout());


        lbIntroduccion = new JLabel("Ingrese con su cuenta de perfil: ");

        lbUsuario = new JLabel("Usuario: ");
        edtUsuario = new JTextField(5);
        pnlUsuario = new JPanel();
        pnlUsuario.add(lbUsuario);
        pnlUsuario.add(edtUsuario);
        pnlUsuario.setLayout(new GridLayout(2,1));

        lbContrasenia = new JLabel("Contraseña: ");
        pswContrasena = new JPasswordField(5);
        pnlContrasena = new JPanel();
        pnlContrasena.add(lbContrasenia);
        pnlContrasena.add(pswContrasena);
        pnlContrasena.setLayout(new GridLayout(2,1));

        pnLGeneral = new JPanel();
        pnLGeneral.add(lbIntroduccion);
        pnLGeneral.add(pnlUsuario);
        pnLGeneral.add(pnlContrasena);
        pnLGeneral.setLayout(new GridLayout(3,1));

        btnIngresar = new JButton("Ingresar");
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickIngresarProfesor();
            }
        });

        super.add(pnLGeneral);
        super.add(btnIngresar);
        super.setLocationRelativeTo(null);
        super.setVisible(false);
    }

    public char[] getPassword(){
        return pswContrasena.getPassword();
    }

    public String getPerfil(){
        return edtUsuario.getText();
    }

    public void setListener(IngresarInterface listener) {
        this.listener = listener;
    }
}
