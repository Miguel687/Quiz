package com.company.view;

import com.company.exception.ArchivoInvalido;
import com.company.view.Interface.IngresarAlumnoInterface;
import com.company.view.Interface.IngresarInterface;
import com.company.view.Interface.SeleccionarPerfilInterface;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

import static java.lang.ClassLoader.getSystemResource;

public class PrincipalFrame extends JFrame {

    private SeleccionPerfilPanel pnlSeleccion;
    private PerfilProfesor jfPerfilProfesor;
    private PerfilUsuario jfPerfilUsuario;
    private MostrarPreguntasFrame pnlGenerador;
    private MostrarExamenesFrame jfMostrarExamenes;


    public PrincipalFrame() throws FileNotFoundException, ArchivoInvalido {
        super("QUIZ");
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(3);
        super.setSize(400, 260);
        super.setIconImage(new ImageIcon(getClass().getResource("img/icono.png")).getImage());

        pnlSeleccion = new SeleccionPerfilPanel();
        jfPerfilProfesor = new PerfilProfesor(this); //Login Profesor
        jfPerfilUsuario = new PerfilUsuario(this); //Login estudiante
        pnlGenerador = new MostrarPreguntasFrame();
        jfMostrarExamenes = new MostrarExamenesFrame();

        //Panel de selección de viewtipo de usuario
        pnlSeleccion.setListener(new SeleccionarPerfilInterface() {
            @Override
            public void clickAlumno() {
                jfPerfilUsuario.setVisible(true);
            }

            @Override
            public void clickProfesor(){
                jfPerfilProfesor.setVisible(true);
            }
        });

        //Login de profesor
        jfPerfilProfesor.setListener(new IngresarInterface() {
            @Override
            public void clickIngresarProfesor() {
                String contrasenia = new String(jfPerfilProfesor.getPassword());
                if((contrasenia.equals("12345")) && (jfPerfilProfesor.getPerfil().equals("Administrador"))){
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Bienvenido "+ jfPerfilProfesor.getPerfil());
                    pnlGenerador.setVisible(true);
                    jfPerfilProfesor.setVisible(false);
                    PrincipalFrame.super.setVisible(false);
                }else if(!(contrasenia.equals("12345"))){
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Contraseña inválida","Error",JOptionPane.ERROR_MESSAGE);
                }else if (!(jfPerfilProfesor.getPerfil().equals("Administrador"))){
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Usuario no valido","Error",JOptionPane.ERROR_MESSAGE);
                } else if (!(contrasenia.equals("12345")) && !(jfPerfilProfesor.getPerfil().equals("Administrador"))) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Usuario y contraseña incorrectos","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jfPerfilUsuario.setListener(new IngresarAlumnoInterface() {
            @Override
            public void clickIngresar() {
                String contrasenia = new String(jfPerfilUsuario.getPassword());
                if((contrasenia.equals("12345")) && (jfPerfilUsuario.getPerfil().equals("A001"))){
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Bienvenido!");
                    jfMostrarExamenes.setVisible(true);
                    jfPerfilUsuario.setVisible(false);
                    PrincipalFrame.super.setVisible(false);
                }else if(!(contrasenia.equals("12345"))){
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Error en contraseña","Error",JOptionPane.ERROR_MESSAGE);
                }else if (!(jfPerfilUsuario.getPerfil().equals("A001"))){
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Usuario no enocntrado","Error",JOptionPane.ERROR_MESSAGE);
                } else if (!(contrasenia.equals("12345")) && !(jfPerfilProfesor.getPerfil().equals("A001"))) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this,"Usuario y contraseña incorrectos","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });



        super.add(pnlSeleccion);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException, ArchivoInvalido {
        new PrincipalFrame();
    }


}
