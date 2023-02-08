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
		List<Services> listaProcedimentos = new ArrayList<>();
		
		agendarConsulta(listaPaciente, listaProcedimentos)
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
}
