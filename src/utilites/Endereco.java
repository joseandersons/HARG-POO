package utilites;

public class Endereco {
    public int cep;
    public String rua;
    public String cidade;
    public String bairro;
    public int numero;
    public String estado;
    
    public Endereco(int cep, String rua, String cidade, String bairro, int numero, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.bairro = bairro;
        this.estado = estado;
        this.numero = numero;
    }
    
    public String toString(){
        return "CEP: " + cep + "\n" + 
               "Rua: " + rua + "\n" + 
               "Cidade: " + cidade + "\n" + 
               "Bairro: " + bairro + "\n" + 
               "Estado: " + estado + "\n" + 
               "Número: " + numero + "\n";
    }
    
}
