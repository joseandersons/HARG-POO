package entities;

import java.util.ArrayList;
import java.util.List;

public class Services {
    public String procedimento;
    public String especialidade;
    public List<String> profissionais = new ArrayList<>();
    public double valor;

    public Services() {
        this.profissionais = new ArrayList<>();
    }
    
    public Services(String procedimento, String especialidade, double valor) {
        this.procedimento = procedimento;
        this.especialidade = especialidade;
        this.valor = valor;
    }
    
    public void addProfissional(Cadastro profissional) {
        profissionais.add(profissional.nome);
    }
    
    
    public void printService() {
        System.out.println("Procedimento: " + procedimento);
        System.out.println("Profissionais: ");
        for (String nome : profissionais) {
            System.out.println(nome);
        } 
        System.out.println("Valor: R$" + valor);
    }

    public static Services buscarProcedimento(List<Services> allServices, String x) {
        for(Services search : allServices) {
            if (search.procedimento.equals(x)) {
                return search;
            }
        }
        return null;
    }
    
    public boolean verificarProfissional(String nomeMedico) {
        if (profissionais.contains(nomeMedico)) {
            return true;
        }else{
            return false;
        }
    }
}

