//package origem;
package com.example.metas;

public abstract class Estado 
{
    protected GGrafico gerenciador;
    protected Imagem fundo;
    protected Bloco capa;
    protected Lista lista_elem, lista_conj;
    protected Cores cores;

    Estado()
    {
        gerenciador = Principal.getGGrafico();
        lista_elem = Principal.getListaElementos();
        lista_conj = Principal.getListaConjuntos();
        cores = Principal.getCores();
    }

    public void inicializa_Elementos()
    {   
        fundo = new Imagem();
        fundo.setTamanho(gerenciador.getLargura(), gerenciador.getAltura());
        fundo.setPosicao(0, 0);
        fundo.setTextura(R.drawable.cinza);

        capa = new Bloco();
        capa.setCor(cores.getCor("Laranja"));
        capa.setAlpha(0.5f);
        capa.setTamanho(gerenciador.getLargura()*90/100,gerenciador.getAltura()*85/100);
        capa.setPosicao((gerenciador.getLargura()-capa.getLargura())/2,(gerenciador.getAltura()-capa.getAltura())/2);
        capa.setArred(gerenciador.getLargura()*5/100, gerenciador.getLargura()*5/100);
    }

    public void limpa_lista()
    {
        lista_elem.limpa_lista();
        lista_conj.limpa_lista();
    }

    public abstract void atualiza(); 
}
