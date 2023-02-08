package utilites;

import java.util.List;

public class Cadastro {
	public int id;
	public String nome;
	public String email;
	public int rg;
	public char sexo;
	public String especializacao;
	public String cpf;
	public int cartao_sus;
	public int plano_saude = 0;
	public int telefone;
	public Endereco endereco;
	public int idade;
	
	
	public Cadastro(int id, String nome, String email, int rg, String especializacao, String cpf, int cartao_sus,
			int plano_saude, int telefone, Endereco endereco, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.rg = rg;
		this.especializacao = especializacao;
		this.cpf = cpf;
		this.cartao_sus = cartao_sus;
		this.plano_saude = plano_saude;
		this.telefone = telefone;
		this.endereco = endereco;
		this.idade = idade;
	}

	public Cadastro(int id, String nome, String email, int rg, char sexo, String especializacao, String cpf,
			int telefone, Endereco endereco, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.rg = rg;
		this.sexo = sexo;
		this.especializacao = especializacao;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.idade = idade;
	}
	
	public static Cadastro is_this_doctor(List<Cadastro> list_medicos, String name_medico) {
		for(int i = 0; i < list_medicos.size(); i++) {
			if(list_medicos.get(i).nome == name_medico) {
				return list_medicos.get(i);
			}
		}
		return null;
	}
	
}
