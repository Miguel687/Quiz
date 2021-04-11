package com.company.model;

import com.company.exception.RespuestaRepetidaException;

public class Respuesta {

    private String respuesta1, respuesta2, respuesta3, respuesta4;
    private boolean correcta;

    public Respuesta(String respuesta1, String respuesta2, String respuesta3, String respuesta4) throws RespuestaRepetidaException {
        this.setRespuesta1(respuesta1);
        this.setRespuesta2(respuesta2);
        this.setRespuesta3(respuesta3);
        this.setRespuesta4(respuesta4);
    }

    public void setRespuesta1(String respuesta1) throws RespuestaRepetidaException {
        if(!(respuesta1.equals(respuesta2)) && !(respuesta1.equals(respuesta3)) && !(respuesta1.equals(respuesta4))) {
            this.respuesta1 = respuesta1;
        }else {
            throw new RespuestaRepetidaException("No pueder la misma pregunta");
        }
    }

    public void setRespuesta2(String respuesta2) throws RespuestaRepetidaException {
        if(!(respuesta2.equals(respuesta1)) && !(respuesta2.equals(respuesta3)) && !(respuesta2.equals(respuesta4))) {
            this.respuesta2 = respuesta2;
        }else {
            throw new RespuestaRepetidaException("No pueder la misma pregunta");
        }
    }

    public void setRespuesta3(String respuesta3) throws RespuestaRepetidaException {
        if(!(respuesta3.equals(respuesta1)) && !(respuesta3.equals(respuesta2)) && !(respuesta3.equals(respuesta4))) {
            this.respuesta3 = respuesta3;
        }else {
            throw new RespuestaRepetidaException("No pueder la misma pregunta");
        }
    }

    public void setRespuesta4(String respuesta4) throws RespuestaRepetidaException {
        if(!(respuesta4.equals(respuesta1)) && !(respuesta4.equals(respuesta2)) && !(respuesta4.equals(respuesta3))) {
            this.respuesta4 = respuesta4;
        }else {
            throw new RespuestaRepetidaException("No pueder la misma pregunta");
        }
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
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


}
