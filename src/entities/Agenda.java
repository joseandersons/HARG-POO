package entities;

import java.util.List;

public class Agenda {
    
    public static String agendaPorProcedimento(List<Appointment> list_consultas, int dia, int mes, int ano){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list_consultas.size(); i++){
            if(list_consultas.get(i).dia == dia && list_consultas.get(i).mes == mes && list_consultas.get(i).ano == ano){
                String aux = String.format("%d/%d/%d -> Procedimento: %s/n", dia, mes, ano, list_consultas.get(i).nomeServico);
                sb.append(aux);
            }
        }
        
        return sb.toString();
    }
    
    public static String agendaPorProfissional(List<Appointment> list_consultas, int dia, int mes, int ano){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list_consultas.size(); i++){
            if(list_consultas.get(i).dia == dia && list_consultas.get(i).mes == mes && list_consultas.get(i).ano == ano){
                String aux = String.format("%d/%d/%d - %d:%d -> Procedimento: %s/n", dia, mes, ano, list_consultas.get(i).nomeMedico, list_consultas.get(i).hora, list_consultas.get(i).minuto);
                sb.append(aux);
            }
        }

        return sb.toString();
    }
}
