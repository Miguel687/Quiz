package com.company.view;

import com.company.view.Interface.MenuInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBarProfesor extends JPanel {

    private JMenuBar mbMenu;

    private JMenu jmInicio;
    private JMenu jmAyuda;

    private JMenuItem itNuevo;
    private JMenuItem itBorrar;
    private JMenuItem itGuardar;
    private JMenuItem itAcerca;

    private MenuInterface listener;

    public  MenuBarProfesor(){
        mbMenu = new JMenuBar();

        jmInicio = new JMenu("Inicio");
        jmAyuda = new JMenu("Ayuda");

        itNuevo = new JMenuItem("Nuevo");
        itBorrar = new JMenuItem("Borrar");
        itGuardar = new JMenuItem("Guardar");
        itAcerca = new JMenuItem("Acerca de..");

        jmInicio.add(itNuevo);
        jmInicio.add(itBorrar);
        jmInicio.add(new JSeparator());
        jmInicio.add(itGuardar);
        itNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        itGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));


        itNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickNuevo();
            }
        });

        itGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickGuardar();
            }
        });

        itBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.cilckBorrar();
            }
        });

        itAcerca.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clicAbout();
            }
        });

        jmAyuda.add(itAcerca);

        mbMenu.add(jmInicio);
        mbMenu.add(jmAyuda);

        super.add(mbMenu);
    }

    public JMenuBar getMbBar() {
        return mbMenu;
    }

    public void setListener(MenuInterface listener) {
        this.listener = listener;
    }
}
