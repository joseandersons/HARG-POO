package entities;

import java.util.List;

public class ExibirAgenda {
    
    public static void agenda_por_procedimento(List<Appointment> list_consultas, int dia, int mes, int ano){
        for(int i = 0; i < list_consultas.size(); i++){
            if(list_consultas.get(i).dia == dia && list_consultas.get(i).mes == mes && list_consultas.get(i).ano == ano)
                System.out.printf("%d/%d/%d -> Procedimento: %s/n", dia, mes, ano, list_consultas.get(i).nomeServico);
            
        }

    }
    
    public static void agenda_por_profissional(List<Appointment> list_consultas, int dia, int mes, int ano){
        for(int i = 0; i < list_consultas.size(); i++){
            if(list_consultas.get(i).dia == dia && list_consultas.get(i).mes == mes && list_consultas.get(i).ano == ano)
                System.out.printf("%d/%d/%d - %d:%d -> Procedimento: %s/n", dia, mes, ano, list_consultas.get(i).nomeMedico, list_consultas.get(i).hora, list_consultas.get(i).minuto);
            
        }
    }
}
