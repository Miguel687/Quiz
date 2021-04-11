package com.company.view;

import com.company.view.Interface.SeleccionarPerfilInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionPerfilPanel extends JPanel {

    private JLabel lbIntroduccion;

    private JButton btnAlumno;
    private JButton btnProfesor;

    private JPanel pnlE;

    private SeleccionarPerfilInterface listener;

    public SeleccionPerfilPanel(){
        super.setLayout(new GridLayout(2,1));

        lbIntroduccion = new JLabel("¿Cón qué perfil deseas ingresar?");
        btnAlumno = new JButton("Alumno");
        btnProfesor = new JButton("Profesor");
        btnAlumno.setFont(new Font("Mono", Font.BOLD, 16));
        btnProfesor.setFont(new Font("Mono", Font.BOLD, 16));
        lbIntroduccion.setFont(new Font("cooper black", Font.PLAIN, 18));
        btnAlumno.setIcon(new ImageIcon("img/icono.png"));
        btnAlumno.setIconTextGap(2);
        btnAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAlumno.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        btnAlumno.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAlumno.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);





        pnlE = new JPanel();
        pnlE.setLayout(new GridLayout(2,1, 0, 20));

        btnProfesor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickProfesor();

            }
        });

        btnAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickAlumno();
            }
        });


        pnlE.add(btnProfesor);
        pnlE.add(btnAlumno);


        super.add(lbIntroduccion);
        super.add(pnlE);
    }

    public void setListener(SeleccionarPerfilInterface listener) {
        this.listener = listener;
    }
}
