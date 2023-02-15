package app;
import java.util.Scanner;

import entities.Clinical;
import entities.Orcamento;
import entities.Prescricao;
import entities.Services;
import utilites.CPFValidator;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Clinical clinica = new Clinical();

        int option;

        System.out.println("\033[0m");
        System.out.printf("Bem Vindo!\nAbrindo Caixa do dia...\n\n");
        clinica.abrirCaixa();

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
                             + "09 - Fechar Caixa\n"
                             + "10 - Sair");
            
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

                exibirAgenda(clinica);

            }else if(option == 7){

                cadastrarPrescricao(clinica);
            }else if(option == 8){

                gerarOrcamento(clinica);

            }else if(option == 9){
                fecharCaixa(clinica);

            }else if(option == 10){

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

        if(!clinica.verificarPessoa(cpfPaciente)){
            System.out.println("Cadastro nao encontrado!\n");
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
        cpf = sc.nextLine();

        System.out.print("CPF: ");
        cpf = sc.nextLine();

        System.out.print("Sexo: ");
        sexo = sc.nextLine().charAt(0);

        boolean tabagismo, obesidade, hipertensao, gestante, diabetes;

        System.out.println("Fumante?(s/n)");
        char op = sc.nextLine().charAt(0);
        if(op == 's'){
            tabagismo = true;
        }else{
            tabagismo = false;
        }

        System.out.println("Obesidade?(s/n)");
        op = sc.nextLine().charAt(0);
        if(op == 's'){
            obesidade = true;
        }else{
            obesidade = false;
        }

        System.out.println("Hipertensao?(s/n)");
        op = sc.nextLine().charAt(0);
        if(op == 's'){
            hipertensao = true;
        }else{
            hipertensao = false;
        }

        System.out.println("Gestante?(s/n)");
        op = sc.nextLine().charAt(0);
        if(op == 's'){
            gestante = true;
        }else{
            gestante = false;
        }

        System.out.println("Diabetes?(s/n)");
        op = sc.nextLine().charAt(0);
        if(op == 's'){
            diabetes = true;
        }else{
            diabetes = false;
        }

        if(code == 1){
            System.out.print("\nDigite a especializacao: ");
            especializacao = sc.nextLine();

            clinica.createDoctor(name, sexo, especializacao, cpf, idade,
                                 tabagismo, obesidade, hipertensao, gestante,
                                 diabetes);
        }else{
            clinica.createPatient(name, cpf, idade, sexo, tabagismo,
                                  obesidade, hipertensao, gestante,
                                  diabetes);
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
            sc.nextLine();

            prescricao.addPrescricao(nomeMedicamento, intervalo);

            System.out.println("Deseja cadastrar outro? (s/n)");
            char op = sc.nextLine().charAt(0);
            if(op == 'n')
                break;
        }

        System.out.println("Prescricao cadastrada com sucesso!");
    }

    public static void exibirAgenda(Clinical clinica){
        Scanner sc = new Scanner(System.in);

        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();

        System.out.println("[1] Filtrar por profissional");
        System.out.println("[2] Filtrar por procedimento");
        int op = sc.nextInt();

        String agenda = clinica.exibirAgenda(dia, mes, ano, op);

        System.out.println(agenda);
    }

    public static void fecharCaixa(Clinical clinica){
       clinica.fecharCaixa();
       System.out.println("Caixa fechado com sucesso!\n");
    }

    public static void gerarOrcamento(Clinical clinica){
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

        Orcamento orcamento = clinica.criarOrcamento(cpf);

        while(true){
            System.out.println("Procedimento: ");
            String nomeProcedimento = sc.nextLine();

            if(!clinica.verificarProcedimento(nomeProcedimento)){
                System.out.println("Procedimento invalido!");
                return;
            }

            orcamento.addOrcamento(Services.buscarProcedimentoNome(clinica.listaProcedimentos, nomeProcedimento));

            System.out.println("Deseja cadastrar outro? (s/n)");
            char op = sc.nextLine().charAt(0);
            if(op == 'n')
                break;
        }

        clinica.attCaixa(orcamento);

        System.out.println("Orcamento gerado com sucesso!");
        System.out.println(orcamento.printOrcamento());
    }

}