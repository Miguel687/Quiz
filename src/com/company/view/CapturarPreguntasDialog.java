package com.company.view;

import com.company.exception.PreguntaNoValidaException;
import com.company.exception.RespuestaRepetidaException;
import com.company.exception.RespuestaVaciaException;
import com.company.model.Pregunta;
import com.company.view.CapturarPreguntasInterface;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CapturarPreguntasDialog extends JDialog {

    private JLabel lbPregunta;
    private JTextField edtPregunta;
    private JPanel pnlPregunta;

    private JLabel lbrespuesta1;
    private JTextField edtRespuesta1;
    private JPanel pnlRespuesta1;

    private JLabel lbRespuesta2;
    private JTextField edtRespuesta2;
    private JPanel pnlRespuesta2;

    private JLabel lbRespuesta3;
    private JTextField edtRespuesta3;
    private JPanel pnlRespuesta3;

    private JLabel lbRespuesta4;
    private JTextField edtRespuesta4;
    private JPanel pnlRespuesta4;

    private JLabel lbRespuestaCorrecta;
    private JComboBox cbRespuesta;
    private JPanel pnlRespuestaCorrecta;

    private JLabel lbMateria;
    private JComboBox cbMateria;
    private JPanel pnlMateria;

    private JButton btnGenerar;
    private JButton btnCancelar;
    private JPanel pnlBotones;

    private CapturarPreguntasInterface listener;

    public CapturarPreguntasDialog(JFrame parent){
        super(parent, true);
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(2);
        super.setLocationRelativeTo(null);
        super.setSize(330, 270);

        lbPregunta = new JLabel("Pregunta:");
        edtPregunta = new JTextField(15);
        pnlPregunta = new JPanel();
        pnlPregunta.add(lbPregunta);
        pnlPregunta.add(edtPregunta);
        pnlPregunta.setLayout(new GridLayout(1,2,-35,0));

        lbrespuesta1 = new JLabel("Respuesta 1:");
        edtRespuesta1 = new JTextField(15);
        pnlRespuesta1 = new JPanel();
        pnlRespuesta1.add(lbrespuesta1);
        pnlRespuesta1.add(edtRespuesta1);
        pnlRespuesta1.setLayout(new GridLayout(1,2,-35,0));

        lbRespuesta2 = new JLabel("Respuesta 2:");
        edtRespuesta2 = new JTextField(15);
        pnlRespuesta2 = new JPanel();
        pnlRespuesta2.add(lbRespuesta2);
        pnlRespuesta2.add(edtRespuesta2);
        pnlRespuesta2.setLayout(new GridLayout(1,2,-35,0));

        lbRespuesta3 = new JLabel("Respuesta 3:");
        edtRespuesta3 = new JTextField(15);
        pnlRespuesta3 = new JPanel();
        pnlRespuesta3.add(lbRespuesta3);
        pnlRespuesta3.add(edtRespuesta3);
        pnlRespuesta3.setLayout(new GridLayout(1,2,-35,0));

        lbRespuesta4 = new JLabel("Respuesta 4:");
        edtRespuesta4 = new JTextField(15);
        pnlRespuesta4 = new JPanel();
        pnlRespuesta4.add(lbRespuesta4);
        pnlRespuesta4.add(edtRespuesta4);
        pnlRespuesta4.setLayout(new GridLayout(1,2,-35,0));

        lbRespuestaCorrecta = new JLabel("Respuesta correcta:");
        cbRespuesta = new JComboBox();
        cbRespuesta.addItem("Respuesta 1");
        cbRespuesta.addItem("Respuesta 2");
        cbRespuesta.addItem("Respuesta 3");
        cbRespuesta.addItem("Respuesta 4");
        pnlRespuestaCorrecta = new JPanel();
        pnlRespuestaCorrecta.add(lbRespuestaCorrecta);
        pnlRespuestaCorrecta.add(cbRespuesta);
        pnlRespuestaCorrecta.setLayout(new GridLayout(1,2,10,0));

        lbMateria = new JLabel("Materia:");
        cbMateria = new JComboBox();
        cbMateria.addItem("Matemáticas");
        cbMateria.addItem("POO");
        cbMateria.addItem("Inglés");
        cbMateria.addItem("Estadística");
        cbMateria.addItem("Circuitos");
        pnlMateria = new JPanel();
        pnlMateria.add(lbMateria);
        pnlMateria.add(cbMateria);
        pnlMateria.setLayout(new GridLayout(1,2,-35,0));

        btnGenerar = new JButton("Generar");
        btnCancelar = new JButton("Cancelar");
        pnlBotones = new JPanel();
        pnlBotones.add(btnGenerar);
        pnlBotones.add(btnCancelar);

        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    Pregunta pregunta = new Pregunta(
                            edtPregunta.getText(),
                            edtRespuesta1(),
                            edtRespuesta2(),
                            edtRespuesta3(),
                            edtRespuesta4(),
                            cbMateria.getSelectedIndex(),
                            cbRespuesta.getSelectedIndex()
                    );
                    listener.clickGenerar(pregunta);

                } catch (RespuestaRepetidaException | RespuestaVaciaException | PreguntaNoValidaException e) {
                    JOptionPane.showMessageDialog(CapturarPreguntasDialog.this, e.getMessage(), "Error", 0);
                }
                edtPregunta.setText(null);
                edtRespuesta1.setText(null);
                edtRespuesta2.setText(null);
                edtRespuesta3.setText(null);
                edtRespuesta4.setText(null);
                System.out.println("Se tuvo que limpiar el edt");
                cbMateria.setSelectedIndex(0);
                cbRespuesta.setSelectedIndex(0);

            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.clickCancelar();
            }
        });

        super.add(pnlPregunta);
        super.add(pnlRespuesta1);
        super.add(pnlRespuesta2);
        super.add(pnlRespuesta3);
        super.add(pnlRespuesta4);
        super.add(pnlRespuestaCorrecta);
        super.add(pnlMateria);
        super.add(pnlBotones);
        super.setLocationRelativeTo(null);
        super.setVisible(false);
    }

    public void setListener(CapturarPreguntasInterface listener) {
        this.listener = listener;
    }

    public String edtRespuesta1() throws RespuestaVaciaException {
        if(edtRespuesta1.getText().length() > 0){
            return edtRespuesta1.getText();
        }else {
            throw new RespuestaVaciaException("No puedes dejar una respuesta vacía krnal");
        }
    }

    public String edtRespuesta2() throws RespuestaVaciaException {
        if(edtRespuesta2.getText().length() > 0){
            return edtRespuesta2.getText();
        }else {
            throw new RespuestaVaciaException("No puedes dejar una respuesta vacía krnal");
        }
    }


    public String edtRespuesta3() throws RespuestaVaciaException {
        if(edtRespuesta3.getText().length() > 0){
            return edtRespuesta3.getText();
        }else {
            throw new RespuestaVaciaException("No puedes dejar una respuesta vacía krnal");
        }
    }


    public String edtRespuesta4() throws RespuestaVaciaException {
        if(edtRespuesta4.getText().length() > 0){
            return edtRespuesta4.getText();
        }else {
            throw new RespuestaVaciaException("No puedes dejar una respuesta vacía krnal");
        }
    }

    public void clearTextField(){
        edtPregunta.setText(null);
        edtRespuesta1.setText(null);
        edtRespuesta2.setText(null);
        edtRespuesta3.setText(null);
        edtRespuesta4.setText(null);

        cbMateria.setSelectedIndex(0);
        cbRespuesta.setSelectedIndex(0);
    }

}
