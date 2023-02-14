package app;
import java.util.Scanner;

import entities.Appointment;
import entities.Cadastro;
import entities.Clinical;
import entities.Services;
import utilites.CPFValidator;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Clinical clinica = new Clinical();

        int option;
        
        while(true){
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Cadastro do paciente\n"
                             + "2 - Cadastro do médico\n"
                             + "3 - Cadastro de serviço\n"
                             + "4 - Agendar consulta\n"
                             + "5 - Prontuário\n"
                             + "6 - Sair\n");
            
            option = sc.nextInt();
            if(option == 1) {
                criarFicha(clinica, 0);
            }else if(option == 2){
                criarFicha(clinica, 1);
            }else if(option == 3){
                cadastrarServico(clinica);
            }else if(option == 4){
                agendarConsulta(clinica);
            }else if(option == 5){
                verProntuario(clinica);
            }else if(option == 6){
                break;
            }else{
                System.out.println("Opcao invalida!");
            }
        }

        sc.close();
    }

    public static void agendarConsulta(Clinical clinica) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o CPF do paciente(sem pontos e tracos): ");
        String cpfPaciente = sc.nextLine();
        
        if(!CPFValidator.verificar(cpfPaciente)) {
            System.out.print("CPF Inválido!!");
            return;
        }
        
        System.out.print("Digite o nome do procedimento: ");
        String nomeProcedimento = sc.nextLine();
        
        if(clinica.verificarProcedimento(nomeProcedimento) == false) {
            System.out.print("Procedimento não encontrado");
            //sc.close();
            return;
        }
        
        clinica.printService(nomeProcedimento);
        
        System.out.print("Digite o nome do medico: ");
        String nomeMedico = sc.nextLine();
        
        if(clinica.verProfissionalService(nomeMedico, nomeProcedimento)) {
            System.out.print("Medico nao encontrado!");
            //sc.close();
            return;
        }
        
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

        String retorno = clinica.agendarConsulta(cpfPaciente, nomeMedico, nomeProcedimento,
                                                 dia, mes, ano, hora, minuto);

        System.out.println("Consulta agendada com sucesso!");
        System.out.println(retorno);
    }

    public static void criarFicha(Clinical clinica, int code) {
        Scanner sc = new Scanner(System.in);
        
        String cidade, estado, rua, bairro;
        String name, email;
        String cpf;
        String especializacao;
        int telefone, cep, numero;
        int idade, rg;
        char sexo;
        
        System.out.print("Nome: ");
        name = sc.nextLine();

        System.out.print("Idade: ");
        idade = sc.nextInt();

        System.out.print("Registro Geral: ");
        rg = sc.nextInt();
        sc.nextLine();

        System.out.print("CPF: ");
        cpf = sc.nextLine();

        System.out.print("Sexo: ");
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
        sc.nextLine();

        System.out.print("\nCidade: ");
        cidade = sc.nextLine();

        System.out.print("\nEstado: ");
        estado = sc.nextLine();

        if(code == 1){
            System.out.print("\nDigite a especializacao: ");
            especializacao = sc.nextLine();
            clinica.createDoctor(name, email, rg, sexo,
                                 especializacao, cpf,
                                 telefone, idade, cidade,
                                 bairro, estado, rua, cep, numero);
        }else{
            clinica.createPatient(cidade, bairro, estado, rua, name, 
                                  email, cpf, numero, telefone, cep, 
                                  idade, rg, sexo);
        }
        //sc.close();
    }

    public static void cadastrarServico(Clinical clinica){
        Scanner sc = new Scanner(System.in);

        String procedimento, especialidade;
        double valor;

        System.out.print("Nome do procedimento: ");
        procedimento = sc.nextLine();

        System.out.print("Nome da especialidade: ");
        especialidade = sc.nextLine();

        System.out.print("Valor do procedimento: ");
        valor = sc.nextDouble();
        System.out.println("TESTE");

        clinica.createService(procedimento, especialidade, valor);

        //sc.close();
    }

    public static void verProntuario(Clinical clinica){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o CPF do paciente: ");
        String cpf = sc.nextLine();

        if(!CPFValidator.verificar(cpf)){
            System.out.println("CPF Invalido!");
            return;
        }

        if(!clinica.verificarPessoa(cpf)){
            System.out.println("Cadastro nao encontrado!");
            return;
        }

        System.out.println(clinica.getMedicalRecord(cpf));
    }
}

