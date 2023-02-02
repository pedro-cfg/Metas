package origem;

import java.util.Calendar;

public class Calendario 
{
    private int dia, mes, ano;
    private Data[] datas;
    private Calendar c;
    private boolean bi;
    private Data selecionado;

    Calendario()
    {
        atualizaData();
        bi = false;
    }

    public void atualizaData()
    {
        c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH)+1;
        ano = c.get(Calendar.YEAR);
    }

    public void geraDatas()
    {
        int cont = 0;
        if(ano%4==0 && ano%100!=0 || ano%4==0 && ano%100==0 && ano%400==0)
            bi = true;
        datas = new Data[bi?366:365];
        for(int m = 1;m <= 12; m++)
        {
            int col = getDiaSemana(1, m, ano)-1;
            int lin = 0;
            int ult_dia = 31;
            if(m==4||m==6||m==9||m==11)
                ult_dia = 30;
            else if(m==2)
                ult_dia = (bi?29:28);
            for(int d=1;d<=ult_dia;d++)
            {
                datas[cont] = new Data();
                datas[cont].setData(d, m, ano);
                col++;
                if(col == 7)
                {
                    col = 0;
                    lin++;
                }
                datas[cont].setPosicao(lin, col);
                datas[cont].cria_Conjunto();
                if(m < mes || (m == mes && d < dia))
                    datas[cont].setCumpriu(1);
                else if(m==mes && d == dia)
                {
                    datas[cont].setCumpriu(0);
                    selecionado = datas[cont];
                }
                else
                    datas[cont].setCumpriu(3);
                datas[cont].colore();
                cont++;
            }
        }
    }

    public int getDiaSemana(int d, int m, int a)
    {
        int ancorasec = (((5*((a/100)%4))%7)+3)%7;
        int y = a%100;
        int ancora = ((((y/12)+(y%12)+((y%12)/4))%7)+ancorasec)%7;
        int diaancora = 0;
        boolean bi = false;
        if(a%4==0 && a%100!=0 || a%4==0 && a%100==0 && a%400==0)
            bi = true;
        if(m==4||m==6||m==8||m==10||m==12)
            diaancora = m;
        else if(m==1)
            diaancora = bi?4:3;
        else if(m==2)
            diaancora = bi?29:28;
        else if(m==3)
            diaancora = 14;
        else if(m==5)
            diaancora = 9;
        else if(m==7)
            diaancora = 11;
        else if(m==9)
            diaancora = 5;
        else if(m==11)
            diaancora = 7;
        int diasemana = (((d-diaancora)%7)+ancora)%7;
        if(diasemana<=0)
            diasemana+=7;
        return diasemana-1;
    }

    public void setMes(int m)
    {
        mes = m;
    }

    public int getMes()
    {
        return mes;
    }

    public void insere_elementos_lista(Lista l)
    {
        for(int i=0;i<(bi?366:365);i++)
        {
            if(datas[i].getMes() == mes)
                datas[i].getConjunto().insere_Elementos(l);
        }
        if(mes == selecionado.getMes())
            l.insere_Elemento(selecionado.getConjunto().getQuadrado());
    }

    public void insere_conjuntos_lista(Lista l)
    {
        for(int i=0;i<(bi?366:365);i++)
        {
            if(datas[i].getMes() == mes)
                l.insere_Conjunto(datas[i].getConjunto());
        }
    }

    public void setSelecionado(Data b)
    {   
        if(b.getCumpriu() != 3)
            selecionado = b;
    }

    public Data getSelecionado()
    {
        return selecionado;
    }
}
