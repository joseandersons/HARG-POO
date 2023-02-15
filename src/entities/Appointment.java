package entities;

import java.util.Random;

public class Appointment {
    public int id;
    public int dia, mes, ano, hora, minuto;
    public String cpfPaciente;
    public String nomeMedico;
    public String nomeServico;
    
    public Appointment(String cpfPaciente, String nomeMedico, String nomeServico,
                       int dia, int mes, int ano, int hora, int minuto){
        Random random = new Random();

        this.id = random.nextInt(999999999);
        this.cpfPaciente = cpfPaciente;
        this.nomeMedico = nomeMedico;
        this.nomeServico = nomeServico;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minuto = minuto;
    }

    public String toString(Clinical clinica, String cpfPaciente){
        StringBuilder sb = new StringBuilder();

        sb.append("ID da consulta: " + id + "\n");
        sb.append("Nome do paciente: " + clinica.pegarNomeCadastro(cpfPaciente) + "\n");
        sb.append("Nome do médico: " + nomeMedico + "\n");
        sb.append("Procedimento: " + nomeServico + "\n");
        sb.append("Data da consulta: " + dia + "/" + mes + "/" + ano + "\n");
        sb.append("Horário: " + hora + ":" + minuto + "\n");

        return sb.toString();
    }

}
