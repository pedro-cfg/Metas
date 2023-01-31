package origem;

public class Principal 
{
    private static GGrafico gerenciador;
    private static GInteracao interacao;
    private static Cores cores;
    private static Menu_Calendario menu_calendario;
    private static Data[] d;

    public static void main(String[] args)
    {
        while(gerenciador == null)
        {
            gerenciador = new GGrafico();
            interacao = new GInteracao();
            cores = new Cores();
            inicializa_Datas();
            menu_calendario = new Menu_Calendario(gerenciador,cores);
            menu_calendario.Inicia();
            menu_calendario.insere_Elementos_Calendario();
            interacao.Inicia(gerenciador, menu_calendario);
        }
        gerenciador.redesenha();
    }

    public static void inicializa_Datas()
    {
        Data.atualiza();
        int ano = Data.getAnoAtual();
        int cont = 0;
        boolean bi = false;
        if(ano%4==0 && ano%100!=0 || ano%4==0 && ano%100==0 && ano%400==0)
            bi = true;
        d = new Data[bi?366:365];
        for(int i = 1;i <= 12; i++)
        {
            if(i==1||i==3||i==5||i==7||i==8||i==10||i==12)
            {
                for(int j=1;j<=31;j++)
                {
                    d[cont] = new Data();
                    d[cont].setData(j, i, ano);
                    cont++;
                }
            }
            else if(i==4||i==6||i==9||i==11)
            {
                for(int j=1;j<=30;j++)
                {
                    d[cont] = new Data();
                    d[cont].setData(j, i, ano);
                    cont++;
                }
            }
            else
            {
                for(int j=1;j<=(bi?29:28);j++)
                {
                    d[cont] = new Data();
                    d[cont].setData(j, i, ano);
                    cont++;
                }
            }
        }
    }
}
