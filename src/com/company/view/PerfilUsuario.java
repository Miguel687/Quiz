package com.company.view;

import com.company.view.Interface.IngresarAlumnoInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilUsuario extends JDialog {

    private JLabel lbIntroduccion;

    private JLabel lbUsuario;
    private JTextField edtUsuario;
    private JPanel pnlUsuario;

    private JLabel lbContrasenia;
    private JPasswordField pswContrasena;
    private JPanel pnlContrasena;
    private JButton btnIngresar;

    private JPanel pnLGeneral;

    private IngresarAlumnoInterface listener;


    public PerfilUsuario(JFrame parent){
        super(parent, true);
        super.setSize(270,210);
        super.setDefaultCloseOperation(2);
        super.setLayout(new FlowLayout());

        lbIntroduccion = new JLabel("Ingrese con su cuenta de perfil: ");

        lbUsuario = new JLabel("Matrícula:");
        edtUsuario = new JTextField(5);
        pnlUsuario = new JPanel();
        pnlUsuario.add(lbUsuario);
        pnlUsuario.add(edtUsuario);
        pnlUsuario.setLayout(new GridLayout(2,1));

        lbContrasenia = new JLabel("Contraseña:");
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
                listener.clickIngresar();
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

    public void setListener(IngresarAlumnoInterface listener) {
        this.listener = listener;
    }
}
