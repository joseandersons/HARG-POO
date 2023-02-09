package app;
import java.util.Scanner;

import entities.Clinical;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Clinical clinica = new Clinical();

        int option;
        
        System.out.println("Escolha uma das opções:");
        System.out.println("1 - Cadastro do paciente\n"
                         + "2 - Cadastro do médico\n"
                         + "3 - Cadastro de serviço\n"
                         + "4 - Agendar consulta\n"
                         + "5 - Prontuário\n");
        
        option = sc.nextInt();
        if(option == 1) {
            cadastrarPaciente(clinica);
        }else if(option == 2){
            cadastrarMedico(clinica);
            
        }else if(option == 3){
            cadastrarServico(clinica);
            
        }else if(option == 4){
            //agendarConsulta(clinica);
        }else{
            System.out.println("Opcao invalida!");
        }

        sc.close();
    }
    /* 
    public Appointment agendarConsulta(Clinical clinica) {
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
     */
    public static void cadastrarPaciente(Clinical clinica) {
        Scanner sc = new Scanner(System.in);
        
        String cidade, estado, rua, bairro;
        String name, email;
        String cpf;
        int telefone, cep, numero;
        int idade, rg;
        char sexo;
        
        System.out.print("Nome: ");
        name = sc.nextLine();

        System.out.print("\nIdade: ");
        idade = sc.nextInt();
        sc.nextLine();

        System.out.print("\nRegistro Geral: ");
        rg = sc.nextInt();
        sc.nextLine();

        System.out.println("\nCPF: ");
        cpf = sc.nextLine();

        System.out.print("\nSexo: ");
        sexo = sc.next().charAt(0);
        sc.nextLine();

        System.out.print("\nEmail: ");
        email = sc.nextLine();

        System.out.print("\nTelefone: ");
        telefone = sc.nextInt();
        sc.nextLine();

        System.out.print("\nCEP: ");
        cep = sc.nextInt();
        sc.nextLine();

        System.out.print("\nRua: ");
        rua = sc.nextLine();

        System.out.print("\nBairro: ");
        bairro = sc.nextLine();

        System.out.print("\nNumero: ");
        numero = sc.nextInt();
        cpf = sc.nextLine();

        System.out.print("\nCidade: ");
        cidade = sc.nextLine();

        System.out.print("\nEstado: ");
        estado = sc.nextLine();

        clinica.createPatient(cidade, bairro, estado, rua, name, 
                              email, cpf, numero, telefone, cep, 
                              idade, rg, sexo);
        sc.close();
    }

    public static void cadastrarMedico(Clinical clinica){

    }

    public static void cadastrarServico(Clinical clinica){

    }
}
