package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Appointment;
import entities.Cadastro;
import entities.Services;

public class Application {
	public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Cadastro> listaPaciente = new ArrayList<>();
		List<Cadastro> listaMedico = new ArrayList<>;
		List<Services> listaProcedimentos = new ArrayList<>();
		int option;
		
		System.out.println("Escolha uma das opções:");
		System.out.println("1- Cadastro do paciente\n2- Cadastro do médico\n3- Cadastro de serviço"
				+ "\n4- Agendar consulta\n5- Prontuário");
		
		option = sc.nextInt();
		if(option == 1) {
			
			
		} else if (option == 2) {
			
			
		} else if (option == 3) {
			
			
		} else if (option == 4) {
			agendarConsulta(listaPaciente, listaMedico, listaProcedimentos);
			
		} else {
			
		}
	}
	
	public Appointment agendarConsulta(List<Cadastro> listaPacientes,
									   List<Cadastro> listaMedicos,
									   List<Services> listaProcedimentos) {
		Scanner sc = new Scanner(System.in);
		Appointment consulta;
		Cadastro paciente;
		Cadastro medico;
		
		System.out.print("Digite o CPF do paciente(sem pontos e tracos): ");
		String cpfPaciente = sc.nextLine();
		
		if(!Cadastro.verificarCPF(cpfPaciente)) {
			System.out.print("CPF Inválido");
			return null;
		}
			
		paciente = Cadastro.buscarCPF(paciente, cpfPaciente);
		
		if(paciente == null) {
			System.out.print("Paciente não encontrado");
			return null;
		}
		
		System.out.print("Digite o nome do procedimento: ");
		String nomeProcedimento = sc.nextLine();
		
		Services procedimento = Services.buscarProcedimento(listaProcedimentos, nomeProcedimento);
		if(procedimento == null) {
			System.out.print("Procedimento não encontrado");
			return null;
		}
		
		procedimento.printService();
		
		System.out.print("Digite o nome do medico: ");
		String nomeMedico = sc.nextLine();
		
		if(procedimento.verificarProfissional(nomeMedico) == false) {
			System.out.print("Medico nao encontrado!");
			return null;
		}
		
		medico = Cadastro.buscarCadastroNome(listaMedicos, nomeMedico);
		
		System.out.print("Digite o dia: ");
		int dia = sc.nextInt();
		
		System.out.print("Digite o mes: ");
		int mes = sc.nextInt();
		
		System.out.print("Digite o ano: ");
		int ano = sc.nextInt();
		
		System.out.print("Digite a hora: ");
		int hora = sc.nextInt();
		
		System.out.print("Digite o minuto: ");
		int minuto = sc.nextInt();
		
		consulta = new Appointment(paciente, medico, procedimento,
									dia, mes, ano, hora, minuto);
		
		System.out.println("Consulta agendada com sucesso!");
		System.out.println(consulta);
		
		sc.close();
		return consulta;
	}
	
	public Cadastro criarFicha() {
		Scanner sc = new Scanner(System.in);
		
		String name;
		String email;
		int idade;
		int rg;
		char sexo;
		String especializacao;
		String cpf;
		int cartao_sus;
		int plano_de_saude;
		int telefone;
		int cep;
		String cidade;
		String estado;
		String rua;
		
		System.out.print("Nome: ");
		name = sc.nextLine();
		System.out.print("\nIdade: ");
		idade = sc.nextInt();
		System.out.print("\nRegistro Geral: ");
		rg = sc.nextInt();
		System.out.println("\nCPF: ");
		sc.nextLine();
		cpf = sc.nextLine();
		System.out.print("\nEspecialização: ");
		especializacao = sc.nextLine();
		System.out.print("\nSexo: ");
		email = sc.next();
		System.out.print("\nEmail: ");
		email = sc.nextLine();
		System.out.print("\nTelefone: ");
		telefone = sc.nextInt();
		System.out.print("\nCEP: ");
		cep = sc.nextInt();
		System.out.print("\nRua: ");
		sc.nextLine();
		rua = sc.nextLine();
		System.out.print("\nCidade: ");
		cidade = sc.nextLine();
		System.out.print("\nEstado: ");
		estado = sc.nextLine();
		System.out.print("\nCartão do SUS: ");
		cartao_sus = sc.nextInt();
		System.out.print("\nPlano de Saúde: ");
		plano_de_saude = sc.nextInt();
	}
}
