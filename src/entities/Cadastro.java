package entities;

import java.util.List;

import utilites.Endereco;

public class Cadastro {
    public int rg, idade;
    public int telefone;
    public int plano_saude;
    public char sexo;
    public String cpf;
    public String nome, email;
    public String especializacao;
    public Endereco endereco;
    public Prontuario prontuario;
    
    public Cadastro(String nome, String email, int rg, String cpf, int telefone, Endereco endereco, int idade, char sexo) {
        this.nome = nome;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idade = idade;
        this.sexo = sexo;
        this.plano_saude = 0;
    }

    public Cadastro(String nome, String email, int rg, char sexo, String especializacao, String cpf,
                    int telefone, Endereco endereco, int idade) {
        this.nome = nome;
        this.email = email;
        this.rg = rg;
        this.sexo = sexo;
        this.especializacao = especializacao;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idade = idade;
        this.plano_saude = 3;
    }
    
    public static Cadastro buscarDoctor(List<Cadastro> list_medicos, String name_medico) {
        for(int i = 0; i < list_medicos.size(); i++) {
            if(list_medicos.get(i).nome == name_medico) {
                return list_medicos.get(i);
            }
        }
        return null;
    }

    public static Cadastro buscarCadastroCPF(List<Cadastro> allCadastros, String cpf) {
        for(Cadastro cadastro : allCadastros) {
            if (cadastro.cpf.equals(cpf)) {
                return cadastro;
            }
        }
        return null;
    }

    public static Cadastro buscarCadastroNome(List<Cadastro> allCadastros, String nome) {
        for(Cadastro cadastro : allCadastros) {
            if (cadastro.nome.equals(nome)) {
                return cadastro;
            }
        }
        return null;
    }

    public String toString() {

        return "Paciente cadastrado com sucesso!\n\n" + 
               "Nome: " + nome + "\n" + 
               "Idade: " + idade + "\n" + 
               "Sexo: " + sexo + "\n" + 
               "RG: " + rg + "\n" + 
               "CPF: " + cpf + "\n" + 
               "Endereço:\n" + endereco + "\n";

    }
    
}
