package entities;

public class Appointment {
	public Cadastro paciente;
	public Cadastro medico;
	public Services servico;
	public int dia, mes, ano, hora, minuto;
	
	public Appointment(Cadastro paciente, Cadastro medico, Services servico,
							int dia, int mes, int ano, int hora, int minuto){
		this.paciente = paciente;
		this.medico = medico;
		this.servico = servico;
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.hora = hora;
		this.minuto = minuto;
	}
	
	public String toString() {
		return "Paciente: " + paciente + "\n"
			 + "Procedimento: " + servico.procedimento + "\n"
			 + "Especialidade: " + servico.especialidade + "\n"
			 + "Medico: " + medico.nome + "\n"
			 + "Valor: $ " + String.format("%.2f", servico.valor)
			 + "Data: " + dia + "/" + mes + "/" + ano + " " + hora + ":" + "minuto";
	} 
}
