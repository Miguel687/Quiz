package com.company.view;

import com.company.controller.Controller;
import com.company.view.Interface.BotonesExamenInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonesExamenPanel extends JPanel {
    private JButton btnPoo;
    private JButton btnEstadistica;
    private JButton btnMatematicas;
    private JButton btnCircuitos;
    private JButton btnIngles;

    private JPanel pnlBotones;

    private BotonesExamenInterface listener;

    private Controller controller;

    public BotonesExamenPanel(){
        super.setLayout(new FlowLayout());

        btnPoo = new JButton("POO");
        btnCircuitos = new JButton("Circuitos");
        btnMatematicas = new JButton("Matemáticas");
        btnIngles = new JButton("Inglés");
        btnEstadistica = new JButton("Estadística");

        pnlBotones = new JPanel();
        pnlBotones.add(btnPoo);
        pnlBotones.add(btnCircuitos);
        pnlBotones.add(btnMatematicas);
        pnlBotones.add(btnIngles);
        pnlBotones.add(btnEstadistica);
        pnlBotones.setLayout(new GridLayout(3,2,5,10));


        btnMatematicas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickMatematicas();
            }
        });

        btnEstadistica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickEstadistica();
            }
        });

        btnIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickIngles();
            }
        });

        btnCircuitos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickCircuitos();
            }
        });

        btnPoo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickPOO();
            }
        });

        super.add(pnlBotones);
        super.setVisible(true);
    }

    public void setListener(BotonesExamenInterface listener) {
        this.listener = listener;
    }
}
