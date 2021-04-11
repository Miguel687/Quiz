package com.company.view;

import com.company.controller.Controller;
import com.company.exception.ArchivoInvalido;
import com.company.exception.ExamenNoEncontradoException;
import com.company.model.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExamenSeleccionado extends JFrame {


    private Controller controller;
    private ArrayList<Pregunta> preguntas;
    private Integer cantidadPreguntasFiltradas;

    private JLabel lbPregunta;
    private JLabel lbTitulo;

    private JRadioButton rbRespuesta1;
    private JRadioButton rbRespuesta2;
    private JRadioButton rbRespuesta3;
    private JRadioButton rbRespuesta4;

    private JPanel pnlTitulo;
    private JPanel pnlPregunta;
    private JPanel pnlBotones;

    private ButtonGroup group;
    private JButton btnSiguiente;
    private JButton btnTerminar;

    int position = 0;
    int seleccion = -1;

    public ExamenSeleccionado(Integer a) throws FileNotFoundException, ArchivoInvalido, ExamenNoEncontradoException {
        super.setSize(560, 500);
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        eventoCerrarVentana(0);
        super.setIconImage(new ImageIcon(getClass().getResource("img/icono.png")).getImage());


        controller = new Controller();
        this.preguntas = controller.filtrarMatarias(controller.getPreguntas(), a);
        if(this.preguntas.isEmpty()){
            ExamenSeleccionado.super.setVisible(false);
            JOptionPane.showMessageDialog(ExamenSeleccionado.this, "Aún no se realiza este examen", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
        this.cantidadPreguntasFiltradas = controller.cantidadPreguntasFiltradas(controller.getPreguntas(), 0);

        System.out.println("Número de preguntas:" + cantidadPreguntasFiltradas);

        lbTitulo = new JLabel();
        lbPregunta = new JLabel((position+ 1)+". "+preguntas.get(0).getPregunta());
        rbRespuesta1 = new JRadioButton(preguntas.get(0).getRespuesta1());
        rbRespuesta2 = new JRadioButton(preguntas.get(0).getRespuesta2());
        rbRespuesta3 = new JRadioButton(preguntas.get(0).getRespuesta3());
        rbRespuesta4 = new JRadioButton(preguntas.get(0).getRespuesta4());

        pnlTitulo = new JPanel();
        pnlPregunta = new JPanel();
        pnlBotones = new JPanel();

        //Agregar tipografía y tamaño
        lbTitulo.setFont(new Font("Serif", Font.CENTER_BASELINE, 22));
        lbPregunta.setFont(new Font("Arial", Font.ITALIC, 18));
        rbRespuesta1.setFont(new Font("Arial", Font.PLAIN, 16));
        rbRespuesta1.setBackground(new Color(144, 164, 174));
        rbRespuesta2.setFont(new Font("Arial", Font.PLAIN, 16));
        rbRespuesta2.setBackground(new Color(253, 254, 254));
        rbRespuesta3.setFont(new Font("Arial", Font.PLAIN, 16));
        rbRespuesta3.setBackground(new Color(144, 164, 174));
        rbRespuesta4.setFont(new Font("Arial", Font.PLAIN, 16));
        rbRespuesta4.setBackground(new Color(253, 254, 254));

        rbRespuesta1.setSize(400,20);

        switch (a){
            case 0:
                lbTitulo.setText("Examen de Matemáticas");
                break;
            case 1:
                lbTitulo.setText("Examen de POO");
                break;
            case 2:
                lbTitulo.setText("Examen de Circuitos");
                break;
            case 3:
                lbTitulo.setText("Examen de Estadística");
                break;
            case 4:
                lbTitulo.setText("Examen de Inglés");
                break;
        }

        btnTerminar = new JButton("Terminar examen");
        btnTerminar.setVisible(false);

        group = new ButtonGroup();
        group.add(rbRespuesta1);
        group.add(rbRespuesta2);
        group.add(rbRespuesta3);
        group.add(rbRespuesta4);
        btnSiguiente = new JButton("Siguiente >");

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                position++;
                seleccion++;
                int puntaje = 0;
                Integer cantidadPreguntas = controller.cantidadPreguntasFiltradas(controller.getPreguntas(), 0);
                if (position < cantidadPreguntas) {
                    lbPregunta.setText((position+ 1)+". "+preguntas.get(position).getPregunta());
                    rbRespuesta1.setText(preguntas.get(position).getRespuesta1());
                    rbRespuesta2.setText(preguntas.get(position).getRespuesta2());
                    rbRespuesta3.setText(preguntas.get(position).getRespuesta3());
                    rbRespuesta4.setText(preguntas.get(position).getRespuesta4());
                    System.out.println("La respuesta de esta pregunta es : "+ preguntas.get(position).getInciso());
                    System.out.println("Posición: "+position+" " + "Número de preguntas: "+ cantidadPreguntas);

                    if (rbRespuesta1.isSelected()){
                        if (preguntas.get(seleccion).getInciso() == 0){
                            controller.setScoreFinal();
                            System.out.println("Correcto");
                        }else {
                            puntaje+=0;
                            System.out.println("Incorrecto");
                        }
                    }else if(rbRespuesta2.isSelected()){
                        System.out.println("Selecciono 2");
                        if (preguntas.get(seleccion).getInciso() == 1){
                            controller.setScoreFinal();
                            System.out.println("Correcto");
                        }else {
                            puntaje+=0;
                            System.out.println("Incorrecto");
                        }
                    }else if(rbRespuesta3.isSelected()){
                        System.out.println("Selecciono 3");
                        if(preguntas.get(seleccion).getInciso() == 2){
                            controller.setScoreFinal();
                            System.out.println("Correcto");
                        }else {
                            puntaje+=0;
                            System.out.println("Incorrecto");
                        }
                    }else if(rbRespuesta4.isSelected()){
                        System.out.println("Selecciono 3");
                        if (preguntas.get(seleccion).getInciso() == 3){
                            controller.setScoreFinal();
                            System.out.println("Correcto");
                        }else {
                            puntaje+=0;
                            System.out.println("Incorrecto");
                        }
                    }

                    group.clearSelection();
                    System.out.println("Puntaje acumulado: "+ controller.getScoreFinal());
                }else{


                    if (rbRespuesta1.isSelected()){
                        if (preguntas.get(seleccion).getInciso() == 0){
                            controller.setScoreFinal();
                            System.out.println("Correcto");
                        }else {
                            puntaje+=0;
                            System.out.println("Incorrecto");
                        }
                    }else if(rbRespuesta2.isSelected()){
                        System.out.println("Selecciono 2");
                        if (preguntas.get(seleccion).getInciso() == 1){
                            controller.setScoreFinal();
                            System.out.println("Correcto");
                        }else {
                            puntaje+=0;
                            System.out.println("Incorrecto");
                        }
                    }else if(rbRespuesta3.isSelected()){
                        System.out.println("Selecciono 3");
                        if(preguntas.get(seleccion).getInciso() == 2){
                            controller.setScoreFinal();
                            System.out.println("Correcto");
                        }else {
                            puntaje+=0;
                            System.out.println("Incorrecto");
                        }
                    }else if(rbRespuesta4.isSelected()){
                        System.out.println("Selecciono 3");
                        if (preguntas.get(seleccion).getInciso() == 3){
                            controller.setScoreFinal();
                            System.out.println("Correcto");
                        }else {
                            puntaje+=0;
                            System.out.println("Incorrecto");
                        }
                    }

                    System.out.println("Puntaje final: " + controller.getScoreFinal());

                    btnSiguiente.setVisible(false);
                    btnTerminar.setVisible(true);


                    System.out.println("Te rifaste : "+(controller.getScoreFinal()/cantidadPreguntasFiltradas)*10);
                    btnTerminar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            JOptionPane.showMessageDialog(ExamenSeleccionado.this,
                                    "Tu calificación final es: " + ((controller.getScoreFinal()/cantidadPreguntasFiltradas)*10),
                                    "Calficación",
                                    JOptionPane.INFORMATION_MESSAGE);
                            eventoCerrarVentana(1);
                        }
                    });
                }
            }
        });


        pnlPregunta.add(lbPregunta);
        pnlPregunta.add(rbRespuesta1);
        pnlPregunta.add(rbRespuesta2);
        pnlPregunta.add(rbRespuesta3);
        pnlPregunta.add(rbRespuesta4);
        pnlPregunta.setLayout(new GridLayout(5,1,0,10));

        pnlBotones.add(btnSiguiente);
        pnlBotones.add(btnTerminar);
        pnlBotones.setLayout(new FlowLayout());

        pnlTitulo.add(lbTitulo);
        pnlTitulo.add(pnlPregunta);
        pnlTitulo.add(pnlBotones);
        pnlTitulo.setLayout(new GridLayout(3,1,0,10));
        //pnlTitulo.setBounds(20,20,520, 400);


        super.add(pnlTitulo);
        super.setLocationRelativeTo(null);
        super.setVisible(false);
    }

    private void cerrarVentana() {
        String botones[] ={"Confirmar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this,"¿Está seguro que desea salir del examen?",
                "Confirmación",
                0,0,
                null,
                botones,
                botones[0]);
        if (eleccion == JOptionPane.YES_OPTION){
            System.exit(0);
        }else if(eleccion == JOptionPane.NO_OPTION){
            System.out.println("Se canceló el cierre");
        }
    }

    public void eventoCerrarVentana(Integer finalizo){
        if (finalizo > 0){
            System.exit(0);
        }else {
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    cerrarVentana();
                }
            });
        }

    }
}
