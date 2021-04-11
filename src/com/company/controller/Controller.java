package com.company.controller;
import com.company.exception.*;
import com.company.model.Pregunta;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Controller implements Serializable {

    private ArrayList<Pregunta> preguntas;
    private Double scoreFinal = 0.0;
    private Integer posicionPregunta;
    private Integer preguntaGuardada = 0;

    public Controller() throws FileNotFoundException, ArchivoInvalido {
        load();
    }

    public void load() throws FileNotFoundException, ArchivoInvalido {
        String ruta = "examen.dat";
        File file = new File(ruta);
        if (file.exists()){
            try {
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);
                preguntas = (ArrayList<Pregunta>)reader.readObject();

                reader.close();
                input.close();
            }catch (IOException e){
                throw new FileNotFoundException("Archivo no encontrado");
            }catch (ClassNotFoundException e) {
                throw new ArchivoInvalido("Archivo invalido");
            }
        }else {
            preguntas = new ArrayList<>();
        }
    }

    //public Pregunta siguientePregunta(){
    //    Pregunta p = preguntas.get(this.posicionPregunta);
    //    if(p != null){
    //        posicionPregunta++;
    //    }
    //    return p;
    //}

    public void save() throws GuardarArchivoException{
        String ruta = "examen.dat";
        try{
            File file = new File(ruta);
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);

            writer.writeObject(preguntas);

            writer.close();
            output.close();

            System.out.println("Se ha guardado correctamente...");

        } catch (Exception e){
            throw new GuardarArchivoException("No se pudo guardar correctamente el archivo");
        }
    }

    public boolean add(Pregunta pregunta) throws PreguntaNoValidaException {
        return preguntas.add(pregunta);
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }


    public Double getScoreFinal() {
        return scoreFinal ;
    }

    public void setScoreFinal() {
        scoreFinal++;
    }



    public void delete(String ID) throws PreguntaNotFoundException {
        try {
            if (!preguntas.isEmpty()){
                preguntas.removeIf(p -> p.getNoPregunta().equals(ID));

            }
        } catch (Exception e){
            throw new PreguntaNotFoundException("Pregunta no encontrada");
        }
    }

    public int cantidadPreguntas() {
        return preguntas.size();
    }

    public Integer cantidadPreguntasFiltradas(ArrayList<Pregunta> lista, Integer a){
        Integer cantidad = lista.stream().
                filter(x -> x.getTipoMater().equals(a)).collect(Collectors.toList()).size();

        return cantidad;
    }

    public Pregunta getPregunta(Integer x){
        return preguntas.get(x);
    }

    public ArrayList<Pregunta> filtrarMatarias(ArrayList<Pregunta> lista, Integer a)  {
        return (ArrayList<Pregunta>) lista.stream().
                filter(x -> x.getTipoMater().equals(a)).collect(Collectors.toList());

    }

    public boolean existePreguntasFiltradas(ArrayList<Pregunta> lista, Integer a){
        ArrayList<Pregunta> e = (ArrayList<Pregunta>) lista.stream().
                filter(x -> x.getTipoMater().equals(a)).collect(Collectors.toList());
        return true;
    }



}
