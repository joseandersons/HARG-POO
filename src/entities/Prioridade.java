package entities;

public class Prioridade {
    int fator;
    int idade;
    boolean tabagismo, obesidade, hipertensao, gestante, diabetes;

    public Prioridade(int idade, boolean tabagismo, boolean obesidade, boolean hipertensao, boolean gestante, boolean diabetes){
        this.fator = 0;
        this.idade = idade;
        this.tabagismo = tabagismo;
        this.obesidade = obesidade;
        this.hipertensao = hipertensao;
        this.gestante = gestante;
        this.diabetes = diabetes;
    }

    public void setPrioridade(){
        if(idade >= 60){
            fator += 1;
        }

        if(tabagismo){
            fator += 1;
        }

        if(obesidade){
            fator += 1;
        }

        if(hipertensao){
            fator += 1;
        }
        
        if(gestante){
            fator += 1;
        }

        if(diabetes){
            fator += 1;
        }
    }

    public int getFator(){
        return fator;
    }
    
}
