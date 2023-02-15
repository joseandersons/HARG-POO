package app;
import java.util.Scanner;

import entities.Clinical;
import entities.Prescricao;
import utilites.CPFValidator;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Clinical clinica = new Clinical();

        int option;
        
        while(true){
            System.out.println("Escolha uma das opções:");
            System.out.println("01 - Cadastro do paciente\n"
                             + "02 - Cadastro do médico\n"
                             + "03 - Cadastro de serviço\n"
                             + "04 - Agendar consulta\n"
                             + "05 - Exibir Prontuário\n"
                             + "06 - Exibir Agenda\n"
                             + "07 - Criar prescricao\n"
                             + "08 - Gerar orçamento\n"
                             + "09 - Abrir Caixa\n"
                             + "10 - Fechar Caixa\n"
                             + "11 - Sair\n");
            
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
                //ExibirAgenda
            }else if(option == 7){

                cadastrarPrescricao(clinica);

            }else if(option == 11){
                
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
            System.out.print("Procedimento não encontrado\n");
            //sc.close();
            return;
        }
        
        clinica.printService(nomeProcedimento);
        
        System.out.print("Digite o nome do medico: ");
        String nomeMedico = sc.nextLine();
        
        if(clinica.verProfissionalService(nomeMedico, nomeProcedimento)) {
            System.out.print("Medico nao encontrado!\n");
            //sc.close();
            return;
        }
        
        System.out.print("Dia: ");
        int dia = sc.nextInt();
        
        System.out.print("Mes: ");
        int mes = sc.nextInt();
        
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        
        System.out.print("Hora: ");
        int hora = sc.nextInt();
        
        System.out.print("Minuto: ");
        int minuto = sc.nextInt();

        String retorno = clinica.agendarConsulta(cpfPaciente, nomeMedico, nomeProcedimento,
                                                 dia, mes, ano, hora, minuto);

        System.out.println("Consulta agendada com sucesso!");
        System.out.println(retorno);
    }

    public static void criarFicha(Clinical clinica, int code) {
        Scanner sc = new Scanner(System.in);
        
        int idade;
        char sexo;
        String cpf;
        String name;
        String especializacao;
        
        System.out.print("Nome: ");
        name = sc.nextLine();

        System.out.print("Idade: ");
        idade = sc.nextInt();

        System.out.print("CPF: ");
        cpf = sc.nextLine();

        System.out.print("Sexo: ");
        sexo = sc.next().charAt(0);
        sc.nextLine();

        /*
        System.out.print("Registro Geral: ");
        rg = sc.nextInt();
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
        */

        if(code == 1){
            System.out.print("\nDigite a especializacao: ");
            especializacao = sc.nextLine();
            clinica.createDoctor(name, sexo, cpf, especializacao, idade);
        }else{
            clinica.createPatient(name, cpf, idade, sexo);
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

    public static void cadastrarPrescricao(Clinical clinica){
        Scanner sc = new Scanner(System.in);

        System.out.println("CPF: ");
        String cpf = sc.nextLine();

        if(!CPFValidator.verificar(cpf)){
            System.out.println("CPF Invalido!");
            return;
        }

        if(!clinica.verificarPessoa(cpf)){
            System.out.println("Cadastro nao encontrado!");
            return;
        }

        Prescricao prescricao = clinica.criarPrescricao(cpf);

        while(true){
            System.out.println("Medicamento: ");
            String nomeMedicamento = sc.nextLine();

            System.out.println("Intervalo: ");
            int intervalo = sc.nextInt();

            prescricao.addPrescricao(nomeMedicamento, intervalo);

            System.out.println("Deseja cadastrar outro? (s/n)");
            char op = sc.nextLine().charAt(0);
            if(op == 'n')
                break;
        }

        System.out.println("Prescricao cadastrada com sucesso!");
    }
}

