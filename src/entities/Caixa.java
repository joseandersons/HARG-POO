package entities;

import java.util.List;

public class Caixa {
    double caixa;

    public Caixa() {
        this.caixa = 0;
    }

    public void addCaixa(Orcamento orcamento) {
        caixa += orcamento.valor;
    }

    public void clearList(List<Orcamento> listaOrcamento) {
        for(int i = 0; i < listaOrcamento.size(); i++)
            System.out.printf("Orçamento %d: Procedimento %s R$%.2lf\n", (i+1), listaOrcamento.get(i).procedimento, listaOrcamento.get(i).valor);

        System.out.printf("Total de dinheiro em caixa: %.2lf", caixa);
        listaOrcamento.clear();
    }
}