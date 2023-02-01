package origem;

public class Data 
{
    private int dia, mes, ano, linha, coluna;
    private boolean cumpriu_meta;
    private Dia_Calendario conjunto;

    Data()
    {

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

    public void setCumpriu(boolean b)
    {   
        cumpriu_meta = b;
    }

    public boolean getCumpriu()
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
}
