package com.company.view;

import javax.swing.table.AbstractTableModel;
import com.company.controller.Controller;
import com.company.exception.SinPreguntasException;
import com.company.model.Pregunta;

public class PreguntasModelTable extends AbstractTableModel {

    private Controller controller;

    public PreguntasModelTable(Controller controller) {
        this.controller = controller;
    }


    @Override
    public int getRowCount() {
         return controller.cantidadPreguntas();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pregunta pregunta = controller.getPregunta(rowIndex);
        switch (columnIndex){
            case 0:
                return pregunta.getNoPregunta();
            case 1:
                return pregunta.getPregunta();
            case 2:
                return pregunta.getRespuesta1();
            case 3:
                return pregunta.getRespuesta2();
            case 4:
                return pregunta.getRespuesta3();
            case 5:
                return pregunta.getRespuesta4();
            case 6:
                return pregunta.getMateria();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int columna){
        switch (columna){
            case 0:
                return "ID";
            case 1:
                return "Pregunta";
            case 2:
                return "Respuesta 1";
            case 3:
                return "Respuesta 2";
            case 4:
                return "Respuesta 3";
            case 5:
                return "Respuesta 4";
            case 6:
                return "Materia";
            default:
                throw new AssertionError();
        }
    }

}
