//package origem;
package com.example.metas;

public class Botao_Meta extends Conjunto
{
    private Bloco bloco;

    Botao_Meta()
    {
        super();
    }

    public void inicia()
    {
        int larguraTela = gerenciador.getLargura();
        //int alturaTela = gerenciador.getAltura();

        bloco = new Bloco();
        bloco.setPosicao(x,y);
        bloco.setTamanho(largura, altura);
        bloco.setArred(larguraTela/36, larguraTela/36);
        bloco.setCor(cores.getCor("Laranja"));
        bloco.setAlpha(0.f);

    }



    public void insere_Elementos(Lista l)
    {
        l.insere_Elemento(bloco);
    }
    
    @Override
    public void toque()
    {
        interacao.interage(this);
    }
}
