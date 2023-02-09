package entities;

public class Prontuario {
    public Cadastro paciente;
    public Cadastro medico;
    public Appointment consulta;
    
    public Prontuario() {
        
    }
    
    public void prontPrinter() {
        System.out.print("Paciente: " + paciente.nome + "\ntIdade: " + paciente.idade + "\tCPF: " + paciente.cpf +
                "\nSexo: " + paciente.sexo + "\tTelefone: " + paciente.telefone + "\tEmail: " + paciente.email +
                "\tConvênio: " paciente.convenio + "\nEndereço: " + paciente.endereço + "\tCidade: " + paciente.cidade +
                "\tCEP: " + paciente.cep + "\tUF: " + paciente.uf + "\n");
        System.out.print("Especialista: " + medico.nome + "\n");
        System.out.print("Data: " + consulta.dia + "/" + consulta.mes + "/" + consulta.ano + "/tProcedimento: " consulta.servico);
    }
}
