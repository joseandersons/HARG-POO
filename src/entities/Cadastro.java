package entities;

import java.util.List;

public class Cadastro {
    public int rg, idade;
    public int telefone;
    public int plano_saude;
    public char sexo;
    public String cpf;
    public String nome, email;
    public String especializacao;
    public Prontuario prontuario;
    public Prioridade prioridade;
    
    public Cadastro(String nome, String cpf, int idade, char sexo, Prioridade prioridade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.plano_saude = 0;
        this.prioridade = prioridade;
    }

    public Cadastro(String nome, char sexo, String especializacao, String cpf, int idade, Prioridade prioridade) {
        this.nome = nome;
        this.sexo = sexo;
        this.especializacao = especializacao;
        this.cpf = cpf;
        this.idade = idade;
        this.plano_saude = 3;
        this.prioridade = prioridade;
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

    public static Cadastro buscarCadastroEsp(List<Cadastro> allCadastros, String nome) {
        for(Cadastro cadastro : allCadastros) {
            if (cadastro.especializacao.equals(nome)) {
                return cadastro;
            }
        }
        return null;
    }

    public void addPrescricao(Prescricao prescricao){
        this.prontuario.prescricoes.add(prescricao);
    }

    public String toString() {

        return "Paciente cadastrado com sucesso!\n\n" + 
               "Nome: " + nome + "\n" + 
               "Idade: " + idade + "\n" + 
               "Sexo: " + sexo + "\n" + 
               "CPF: " + cpf + "\n";
    }
    
}
