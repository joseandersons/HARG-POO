package entities;

import java.util.List;

public class Caixa {
    double caixa;

    public Caixa() {
        this.caixa = 0;
    }

    public double addCaixa(List<Orcamento> listaOrcamento) {
        for(int i = 0; i < listaOrcamento.size(); i++)
            caixa += listaOrcamento.get(i).valor;
        
        return caixa;
    }

    public void clearList(List<Orcamento> listaOrcamento) {
        listaOrcamento.clear();
    }
}