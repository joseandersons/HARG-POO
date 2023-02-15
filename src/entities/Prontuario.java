package entities;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {
    public List<Appointment> consultas;
    public List<Prescricao> prescricoes;
    
    public Prontuario() {
        this.consultas = new ArrayList<>();
        this.prescricoes = new ArrayList<>();
    }
    
    public String toString(Clinical clinica, String cpfPaciente){
        StringBuilder sb = new StringBuilder();
        
        sb.append("================ PRONTUARIO ================\n");
        sb.append("Nome: " + clinica.pegarNomeCadastro(cpfPaciente) + "\n");
        sb.append("CPF: " + cpfPaciente + "\n");
        System.out.println("Idade: " + clinica.pegarIdadeCadastro(cpfPaciente) + "\n");
        
        for(Appointment consulta : this.consultas) {
            sb.append(consulta);
            sb.append("----------------------------------\n");
        }

        System.out.println("============================================");

        return sb.toString();
    }
}
