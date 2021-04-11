package com.company.view;

import com.company.exception.PreguntaNoValidaException;
import com.company.model.Pregunta;

public interface CapturarPreguntasInterface {
    public void clickGenerar(Pregunta pregunta) throws PreguntaNoValidaException;
    public void clickCancelar();
}
