package entities;

import java.util.ArrayList;
import java.util.List;

public class Prescricao {
    public List<String> medicamentos;
    public List<Integer> intervalos;

    public Prescricao (){
        this.medicamentos = new ArrayList<>();
        this.intervalos = new ArrayList<>();
    }

    public void addPrescricao(String medicamento, int intervalo){
        medicamentos.add(medicamento);
        intervalos.add(intervalo);
    }

    public void printPrescricao(){
        for (int i = 0; i < medicamentos.size(); i++) {
            String medicamento = medicamentos.get(i);
            Integer intervalo = intervalos.get(i);
            System.out.println(medicamento + ": de " + intervalo + " em " + intervalo + " horas.");
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < medicamentos.size(); i++){
            String aux = String.format(medicamentos.get(i) + ": de " + intervalos.get(i) + " em " + intervalos.get(i) + " horas.");
            sb.append(aux);
        }
        return sb.toString();
    }

    public void clearPrescricao(){
        medicamentos.clear();
        intervalos.clear();
    }

}
