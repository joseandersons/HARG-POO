package entities;

import java.util.ArrayList;
import java.util.List;

import utilites.Endereco;

public class Clinical {
    public List<Cadastro> listaMedico;
    public List<Cadastro> listaPaciente;
    public List<Services> listaProcedimentos;

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
    }

    public void createPatient(String name, String email, int rg, char sexo,
                              String especializacao, String cpf,
                              int telefone, int idade, String cidade,
                              String bairro, String estado, String rua, int cep, int numero){

        Endereco endereco = new Endereco(cep, rua, cidade, bairro, numero, estado);
        Cadastro paciente = new Cadastro(name, email, rg, sexo, especializacao, cpf, telefone, endereco, idade);

        listaMedico.add(paciente);
    }
}