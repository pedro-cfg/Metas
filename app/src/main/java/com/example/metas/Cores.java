//package origem;
package com.example.metas;

public class Cores 
{
    private Cor laranja, branco, preto, cinza, vermelho, verde, bege; 

    Cores()
    {
        inicializa_Cores();
    }

    public void inicializa_Cores()
    {
        preto = new Cor();
        preto.setCor(0, 0, 0);

        laranja = new Cor();
        laranja.setCor(255, 138, 64);

        branco = new Cor();
        branco.setCor(255, 255, 255);

        cinza = new Cor();
        cinza.setCor(70, 70, 70);

        vermelho = new Cor();
        vermelho.setCor(255, 0, 0);

        verde = new Cor();
        verde.setCor(0, 255, 0);

        bege = new Cor();
        bege.setCor(208, 176, 132);
    }

    public Cor getCor(String c)
    {
        switch(c)
        {
            case "Branco":
                return branco;
            case "Preto":
                return preto;
            case "Laranja":
                return laranja;
            case "Cinza":
                return cinza;
            case "Vermelho":
                return vermelho;
            case "Verde":
                return verde;
            case "Bege":
                return bege;
        }
        return null;
    }
}

class Cor 
{
    private int vermelho,verde,azul;

    Cor()
    {
        vermelho = verde = azul = 0;
    }

    public void setCor(int r, int g, int b)
    {
        vermelho = r;
        verde = g;
        azul = b;
    }

    public int getVermelho()
    {
        return vermelho;
    }

    public int getVerde()
    {
        return verde;
    }

    public int getAzul()
    {
        return azul;
    }
}
