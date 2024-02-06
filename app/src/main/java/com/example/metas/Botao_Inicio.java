//package origem;
package com.example.metas;

public class Botao_Inicio extends Conjunto
{
    private Bloco bloco;
    private Quadrado quadrado;
    private Texto texto;
    private String s;
    private boolean inicio;

    Botao_Inicio(boolean i)
    {
        super();
        inicio = i;
    }

    public void inicia()
    {
        int larguraTela = gerenciador.getLargura();
        //int alturaTela = gerenciador.getAltura();
        
        texto = new Texto();
        texto.setCor(cores.getCor("Preto"));
        texto.setTamanho(largura*16/100);
        texto.setTamanhoBloco(largura,altura);
        texto.setTexto(s);
        texto.setPosicao(x+largura/2, y+altura*85/100);

        bloco = new Bloco();
        bloco.setPosicao(x,y);
        bloco.setTamanho(largura, altura);
        bloco.setArred(larguraTela/36, larguraTela/36);
        bloco.setCor(cores.getCor("Laranja"));
        bloco.setAlpha(0.7f);

        quadrado = new Quadrado();
        quadrado.setPosicao(x,y);
        quadrado.setTamanho(largura, altura);
        quadrado.setArred(larguraTela/36, larguraTela/36);
        quadrado.setGrossura(10);
        quadrado.setCor(cores.getCor("Preto"));
    }

    public void setTexto(String t)
    {
        s = t;
    }

    public boolean getInicio()
    {
        return inicio;
    }

    public void insere_Elementos(Lista l)
    {
        l.insere_Elemento(bloco);
        l.insere_Elemento(texto);
        l.insere_Elemento(quadrado);
    }
    
    @Override
    public void toque()
    {
        interacao.interage(this);
    }
}
