package com.company.view;

import com.company.controller.Controller;
import com.company.exception.ArchivoInvalido;
import com.company.exception.ExamenNoEncontradoException;
import com.company.model.Pregunta;
import com.company.view.Interface.BotonesExamenInterface;
import com.company.view.Interface.ExamenSeleccionadoInterface;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MostrarExamenesFrame extends JFrame {

    private BotonesExamenPanel pnlBotones;
    private ExamenSeleccionado jfExamenSeleccionado;
    private Controller controller;

    public MostrarExamenesFrame() throws FileNotFoundException, ArchivoInvalido {
        super("Exámenes");
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(3);
        super.setSize(250,170);
        super.setIconImage(new ImageIcon(getClass().getResource("img/icono.png")).getImage());



        pnlBotones = new BotonesExamenPanel();
        pnlBotones.setListener(new BotonesExamenInterface() {
            @Override
            public void clickMatematicas() {
                try {
                    jfExamenSeleccionado = new ExamenSeleccionado(0);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ArchivoInvalido archivoInvalido) {
                    archivoInvalido.printStackTrace();
                } catch (ExamenNoEncontradoException e) {
                    JOptionPane.showMessageDialog(MostrarExamenesFrame.this, e.getMessage(), "Error", 0);
                }
                jfExamenSeleccionado.setVisible(true);
                MostrarExamenesFrame.super.setVisible(false);
            }

            @Override
            public void clickPOO() {
                try {
                    jfExamenSeleccionado = new ExamenSeleccionado(1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ArchivoInvalido archivoInvalido) {
                    archivoInvalido.printStackTrace();
                } catch (ExamenNoEncontradoException e) {
                    JOptionPane.showMessageDialog(MostrarExamenesFrame.this, e.getMessage(), "Error", 0);
                }
                jfExamenSeleccionado.setVisible(true);
                MostrarExamenesFrame.super.setVisible(false);

            }

            @Override
            public void clickCircuitos() {
                try {
                    jfExamenSeleccionado = new ExamenSeleccionado(2);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ArchivoInvalido archivoInvalido) {
                    archivoInvalido.printStackTrace();
                } catch (ExamenNoEncontradoException e) {
                    JOptionPane.showMessageDialog(MostrarExamenesFrame.this, e.getMessage(), "Error", 0);
                }
                jfExamenSeleccionado.setVisible(true);
                MostrarExamenesFrame.super.setVisible(false);
            }

            @Override
            public void clickEstadistica(){
                try {
                        jfExamenSeleccionado = new ExamenSeleccionado(3);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ArchivoInvalido archivoInvalido) {
                    archivoInvalido.printStackTrace();
                } catch (ExamenNoEncontradoException e) {
                    JOptionPane.showMessageDialog(MostrarExamenesFrame.this, e.getMessage(), "Error", 0);
                }
                jfExamenSeleccionado.setVisible(true);
                MostrarExamenesFrame.super.setVisible(false);
            }

            @Override
            public void clickIngles() {
                try {
                    jfExamenSeleccionado = new ExamenSeleccionado(4);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ArchivoInvalido archivoInvalido) {
                    archivoInvalido.printStackTrace();
                } catch (ExamenNoEncontradoException e) {
                    JOptionPane.showMessageDialog(MostrarExamenesFrame.this, e.getMessage(), "Error", 0);
                }
                jfExamenSeleccionado.setVisible(true);
                MostrarExamenesFrame.super.setVisible(false);
            }
        });



        super.add(pnlBotones);
        super.setLocationRelativeTo(null);
        super.setVisible(false);
    }

}
