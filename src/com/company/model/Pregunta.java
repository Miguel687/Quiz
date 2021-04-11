package com.company.model;

import com.company.exception.RespuestaRepetidaException;
import com.company.exception.RespuestaVaciaException;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Pregunta extends ArrayList<Pregunta> implements Serializable {

    private String pregunta;
    private String respuesta1, respuesta2, respuesta3, respuesta4;
    private boolean correcta;
    private Integer materia;
    private String noPregunta;
    private Integer inciso;
    public static int codigo = 1;

    public Pregunta(String pregunta,String respuesta1, String respuesta2, String respuesta3, String respuesta4, Integer materia, Integer inciso) throws RespuestaRepetidaException, RespuestaVaciaException {
        this.pregunta = pregunta;
        this.setRespuesta1(respuesta1);
        this.setRespuesta2(respuesta2);
        this.setRespuesta3(respuesta3);
        this.setRespuesta4(respuesta4);
        this.materia = materia;
        this.noPregunta = getIDPregunta();
        this.inciso = inciso;
    }

    public Integer getInciso() {
        return inciso;
    }

    public String getNoPregunta() {
        return noPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getMateria() {
        if(this.materia == 0){
            return "Matemáticas";
        }else if(this.materia == 1){
            return "POO";
        }else if(this.materia == 2){
            return "Circuitos";
        }else if(this.materia == 3){
            return "Estadística";
        }else if(this.materia == 4){
            return "Inglés";
        }else {
            return null;
        }
    }

    public Integer getTipoMater(){
        return materia;
    }

    public void setRespuesta1(String respuesta1) throws RespuestaRepetidaException, RespuestaVaciaException {
        if(!(respuesta1.equals(respuesta2)) && !(respuesta1.equals(respuesta3)) && !(respuesta1.equals(respuesta4))) {
            this.respuesta1 = respuesta1;
        }else {
            throw new RespuestaRepetidaException("No pueder la misma respuesta");
        }
    }

    public void setRespuesta2(String respuesta2) throws RespuestaRepetidaException, RespuestaVaciaException {
        if(!(respuesta2.equals(respuesta1)) && !(respuesta2.equals(respuesta3)) && !(respuesta2.equals(respuesta4))) {
            this.respuesta2 = respuesta2;
        }else {
            throw new RespuestaRepetidaException("No pueder la misma respuesta");
        }

    }

    public void setRespuesta3(String respuesta3) throws RespuestaRepetidaException, RespuestaVaciaException {
        if(!(respuesta3.equals(respuesta1)) && !(respuesta3.equals(respuesta2)) && !(respuesta3.equals(respuesta4))) {
            this.respuesta3 = respuesta3;
        }else {
            throw new RespuestaRepetidaException("No pueder la misma respuesta");
        }
    }

    public void setRespuesta4(String respuesta4) throws RespuestaRepetidaException {
        if(!(respuesta4.equals(respuesta1)) && !(respuesta4.equals(respuesta2)) && !(respuesta4.equals(respuesta3))) {
            this.respuesta4 = respuesta4;
        }else {
            throw new RespuestaRepetidaException("No pueder la misma respuesta");
        }

    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getIDPregunta() {
        Random random = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ID = "";
        int numero;
        int forma;

        forma = (int)(random.nextDouble()* letras.length()-1+0);
        numero=(int)(random.nextDouble() * 99+100);
        ID=ID+letras.charAt(forma)+numero;

        return ID;
    }

    public String getRespuesta2(){
        return respuesta2;
    }

    public String getRespuesta3() {
        return respuesta3;
    }

    public String getRespuesta4() {
        return respuesta4;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public boolean setCorrecta(Integer  correcta) {
        return true;
    }

    public Integer isSelect(Integer inciso) {
        return inciso;
    }



}
