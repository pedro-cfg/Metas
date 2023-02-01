package origem;

import java.util.Calendar;

public class Data {
    private int dia, mes, ano;
    private boolean cumpriu_meta;
    private static Calendar c;

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

    public static void atualiza()
    {
        c = Calendar.getInstance();
    }

    public static int getDiaAtual()
    {
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMesAtual()
    {
        return c.get(Calendar.MONTH)+1;
    }

    public static int getAnoAtual()
    {
        return c.get(Calendar.YEAR);
    }
}
