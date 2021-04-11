package com.company.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;


import  com.company.controller.Controller;
import com.company.exception.ArchivoInvalido;
import com.company.exception.GuardarArchivoException;
import com.company.exception.PreguntaNoValidaException;
import com.company.exception.PreguntaNotFoundException;
import com.company.model.Pregunta;
import com.company.view.Interface.BorrarPreguntasInterface;
import com.company.view.Interface.MenuInterface;
import com.company.view.CapturarPreguntasInterface;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class MostrarPreguntasFrame extends JFrame {

    private MenuBarProfesor pnlMenu;
    private CapturarPreguntasDialog jfCapturar;
    private Controller controller;
    private PreguntasModelTable modelTablePreguntas;
    private JTable tbAlumnos;
    private  BorrarPreguntasDialog borrarDialog;


    public MostrarPreguntasFrame() {
        super("Tabla de preguntas");
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        eventoCerrarVentana();
        super.setIconImage(new ImageIcon(getClass().getResource("img/icono.png")).getImage());


        super.setSize(1000, 400);

        pnlMenu = new MenuBarProfesor();
        jfCapturar = new CapturarPreguntasDialog(this);
        try {
            controller = new Controller();
        }catch (FileNotFoundException e){

        }catch (ArchivoInvalido e){

        }

        modelTablePreguntas = new PreguntasModelTable(controller);

        tbAlumnos = new JTable(modelTablePreguntas);
        tbAlumnos.setSize(1000,400);
        //tbAlumnos.setPreferredScrollableViewportSize(tbAlumnos.getPreferredSize());
        tbAlumnos.setFillsViewportHeight(true);



        pnlMenu.setListener(new MenuInterface() {
            @Override
            public void clickNuevo() {
                jfCapturar.setVisible(true);
                modelTablePreguntas.fireTableDataChanged();
            }

            @Override
            public void cilckBorrar() {
                borrarDialog.setVisible(true);
            }


            @Override
            public void clickGuardar() {

                try {
                    controller.save();
                } catch (GuardarArchivoException e){
                    JOptionPane.showMessageDialog(MostrarPreguntasFrame.this, e.getMessage(), "Error", 0);
                }

            }

            @Override
            public void clicAbout() {
                JOptionPane.showMessageDialog(MostrarPreguntasFrame.this,
                        "Versión 1.1",
                        "Información",
                        1);
            }
        });

        jfCapturar.setListener(new CapturarPreguntasInterface() {
            @Override
            public void clickGenerar(Pregunta pregunta) throws PreguntaNoValidaException {
                controller.add(pregunta);
                System.out.println(pregunta.getPregunta());
                jfCapturar.setVisible(false);
                System.out.println("Nueva pregunta");
                modelTablePreguntas.fireTableDataChanged();
            }

            @Override
            public void clickCancelar() {
                jfCapturar.setVisible(false);
            }
        });

        borrarDialog = new BorrarPreguntasDialog(this);
        borrarDialog.setListener(new BorrarPreguntasInterface() {
            @Override
            public void clickBorrar(String id) {
                try {
                    controller.delete(id);
                    modelTablePreguntas.fireTableDataChanged();
                    borrarDialog.setVisible(false);
                } catch (PreguntaNotFoundException e) {
                    JOptionPane.showMessageDialog(MostrarPreguntasFrame.this, e.getMessage(), "Error", 0);
                }
            }

            @Override
            public void clickCancelar() {
                borrarDialog.setVisible(false);
            }
        });


        super.setJMenuBar(pnlMenu.getMbBar());
        super.add(new JScrollPane(tbAlumnos), BorderLayout.CENTER);
        super.setLocationRelativeTo(null);
        super.setVisible(false);
    }

    private void cerrarVentana() throws GuardarArchivoException {
        String botones[] ={"Confirmar", "Salir"};
        int eleccion = JOptionPane.showOptionDialog(null,"¿Desea guardar todos los cambios realizados en esta sesión?",
                "Confirmación",
                0,0,
                null,
                botones,
                botones[0]);
        if ((eleccion == JOptionPane.YES_OPTION)){
            controller.save();
            JOptionPane.showMessageDialog(this, "Se han guardado los cambios correctamente",
                    "Guardado exitoso", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }else if((eleccion == JOptionPane.NO_OPTION)){
            System.exit(0);
        }
    }

    public void eventoCerrarVentana(){

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    cerrarVentana();
                } catch (GuardarArchivoException guardarArchivoException) {
                    guardarArchivoException.printStackTrace();
                }
            }
        });

    }



}
