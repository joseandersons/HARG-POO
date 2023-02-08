package entities;

import java.util.ArrayList;
import java.util.List;

public class Services {
	public String procedimento;
	public String especialidade;
	public List<String> profissionais = new ArrayList<>();
	public double valor;

	public Services() {
		
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
		System.out.println("Valor: " + valor);
	}

	public static Services buscarProcedimento(List<Services> allServices, String x) {
		for(int i = 0; i < allServices.size(); i++) {
			Services search = allServices.get(i);
			if(search.procedimento == x) {
				return search;
			}
		}
		return null;
	}
	
	public int verificarProfissional(String nomeMedico) {
		if (profissionais.contains(nomeMedico)) {
			return 1;
		}
		else return 0;
	}
}

