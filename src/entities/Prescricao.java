package entities;

import java.util.ArrayList;
import java.util.List;

public class Prescricao {
    int flag;
    public List<String> medicamentos;
    public List<Integer> intervalos;

    public Prescricao (){
        this.medicamentos = new ArrayList<>();
        this.intervalos = new ArrayList<>();
    }

    public void addPrescricao(String medicamento, int intervalo){
        flag = 1;
        medicamentos.add(medicamento);
        intervalos.add(intervalo);
    }

    public void printPrescricao(){
        for (int i = 0; i < medicamentos.size(); i++) {
            String medicamento = medicamentos.get(i);
            Integer intervalo = intervalos.get(i);
            System.out.println(medicamento + " - " + intervalo + "x ao dia.");
        }
    }

    public void clearPrescricao(){
        flag = 0;
        medicamentos.clear();
        intervalos.clear();
    }

}
