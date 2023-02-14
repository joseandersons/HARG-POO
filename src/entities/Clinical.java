package entities;

import java.util.ArrayList;
import java.util.List;

import utilites.Endereco;

public class Clinical {
    public List<Cadastro> listaMedico;
    public List<Cadastro> listaPaciente;
    public List<Services> listaProcedimentos;
    public List<Orcamento> listaOrcamentos;
    public List<Appointment> listaConsultas;

    public Clinical(){
        this.listaMedico = new ArrayList<>();
        this.listaPaciente = new ArrayList<>();
        this.listaProcedimentos = new ArrayList<>();
    }

    public void createPatient(String cidade, String bairro, String estado, String rua,
                              String name, String email, String cpf, int numero,
                              int telefone, int cep, int idade, int rg, char sexo){
        Endereco endereco = new Endereco(cep, rua, cidade, bairro, numero, estado);
        Cadastro paciente = new Cadastro(name, email, rg, cpf, telefone, endereco, idade, sexo);

        listaPaciente.add(paciente);
        System.out.println(paciente);
    }

    public void createDoctor(String name, String email, int rg, char sexo,
                             String especializacao, String cpf,
                             int telefone, int idade, String cidade,
                             String bairro, String estado, String rua, int cep, int numero){

        Endereco endereco = new Endereco(cep, rua, cidade, bairro, numero, estado);
        Cadastro doctor = new Cadastro(name, email, rg, sexo, especializacao, cpf, telefone, endereco, idade);

        listaMedico.add(doctor);
    }

    public void createService(String procedimento, String especialidade, double valor){
        Services service = new Services(procedimento, especialidade, valor);

        listaProcedimentos.add(service);
        System.out.println("Procedimento criado com sucesso!!\n");
        service.printService();
    }

    public String pegarNomeProcedimento(String nome){
        Services procedimento = Services.buscarProcedimento(this.listaProcedimentos, nome);
        if(procedimento == null){
            return null;
        }

        return procedimento.procedimento;
    }

    public String pegarNomeCadastro(String cpf){
        Cadastro pessoa = Cadastro.buscarCadastroCPF(this.listaPaciente, cpf);
        if(pessoa == null){
            return null;
        }

        return pessoa.nome;
    }

    public boolean verificarPessoa(String cpf){
        Cadastro pessoa = Cadastro.buscarCadastroCPF(this.listaPaciente, cpf);
        if(pessoa == null){
            return false;
        }

        return true;
    }

    public boolean verificarProcedimento(String nome){
        Services procedimento = Services.buscarProcedimento(this.listaProcedimentos, nome);

        if(procedimento != null){
            return true;
        }else{
            return false;
        }
    }

    public void printService(String nome){
        Services procedimento = Services.buscarProcedimento(this.listaProcedimentos, nome);

        procedimento.printService();
    }

    public boolean verProfissionalService(String nomeMedico, String nomeProcedimento){
        Services procedimento = Services.buscarProcedimento(this.listaProcedimentos, nomeProcedimento);

        if(procedimento.verificarProfissional(nomeMedico)){
            return true;
        }else{
            return false;
        }
    }

    public String pegarIdadeCadastro(String cpf){
        Cadastro pessoa = Cadastro.buscarCadastroCPF(this.listaPaciente, cpf);
        if(pessoa == null){
            return null;
        }

        return Integer.toString(pessoa.idade);
    }

    public String agendarConsulta(String cpfPaciente, String nomeMedico, String nomeProcedimento,
                                int dia, int mes, int ano, int hora, int minuto){
        Appointment consulta = new Appointment(cpfPaciente, nomeMedico, nomeProcedimento,
                                               dia, mes, ano, hora, minuto);

        Cadastro pessoa = Cadastro.buscarCadastroCPF(this.listaPaciente, cpfPaciente);

        pessoa.prontuario.consultas.add(consulta);
        this.listaConsultas.add(consulta);

        return consulta.toString(this, cpfPaciente);
    }

    public String getMedicalRecord(String cpf){
        Cadastro pessoa = Cadastro.buscarCadastroCPF(this.listaPaciente, cpf);

        return pessoa.prontuario.toString(this, cpf);
    }
}
