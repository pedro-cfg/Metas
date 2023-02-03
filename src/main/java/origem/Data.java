package origem;

public class Data 
{
    private int dia, mes, ano, linha, coluna;
    private int cumpriu_meta;
    private Dia_Calendario conjunto;

    Data()
    {
        cumpriu_meta = 0;
    }

    public void setData(int d, int m, int a)
    {
        dia = d;
        mes = m;
        ano = a;
    }

    public int getDia()
    {
        return dia;
    }

    public int getMes()
    {
        return mes;
    }

    public int getAno()
    {
        return ano;
    }

    public void setCumpriu(int b)
    {   
        cumpriu_meta = b;
    }

    public int getCumpriu()
    {
        return cumpriu_meta;
    }

    public void setPosicao(int i, int j)
    {
        linha = i;
        coluna = j;
    }

    public int getLinha()
    {
        return linha;
    }

    public int getColuna()
    {
        return coluna;
    }

    public Dia_Calendario getConjunto()
    {
        return conjunto;
    }

    public void cria_Conjunto()
    {
        conjunto = new Dia_Calendario(this);
    }

    public void colore()
    {
        if(cumpriu_meta == 2)
            conjunto.setCor(Principal.getCores().getCor("Verde"));
        else if(cumpriu_meta == 1)
            conjunto.setCor(Principal.getCores().getCor("Vermelho"));
        else if(cumpriu_meta == 3)
            conjunto.setCor(Principal.getCores().getCor("Cinza"));
        else 
            conjunto.setCor(Principal.getCores().getCor("Branco"));
    }
}
