package entities;

import java.util.ArrayList;
import java.util.List;


public class Orcamento {
    public List<Services> procedimento;
    public Cadastro paciente;
    double valor;

    public Orcamento(Cadastro paciente) {
        procedimento = new ArrayList<>();
        this.paciente = paciente;
    }

    public void addOrcamento(Services procedimento) {     
        this.procedimento.add(procedimento);
        
        if(paciente.plano_saude == 0){
            this.valor += procedimento.valor;
        }
        else if(paciente.plano_saude == 1){
            this.valor += procedimento.valor * 0.95;
        }
        else if(paciente.plano_saude == 2){
            this.valor += procedimento.valor * 0.9;
        }
        else{
            this.valor += procedimento.valor * 0.85;
        }
    }

    public void removeOrcamento(Services procedimento){
        if(paciente.plano_saude == 0){
            this.valor -= procedimento.valor;
        }
        else if(paciente.plano_saude == 1){
            this.valor -= procedimento.valor * 0.95;
        }
        else if(paciente.plano_saude == 2){
            this.valor -= procedimento.valor * 0.9;
        }
        else{
            this.valor -= procedimento.valor * 0.85;
        }
    }

    public void zerarOrcamento(){
        this.valor = 0;
    }
    
    public String printOrcamento(){
        return "Valor total: R$ " + this.valor + "\n";
    }
}
