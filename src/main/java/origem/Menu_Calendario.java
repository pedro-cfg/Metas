package origem;

public class Menu_Calendario extends Estado
{
    private static Calendario[] calendario;

    Menu_Calendario(GGrafico g, Cores c)
    {
        super(g,c);
    }

    public void Inicia()
    {
        inicializa_Elementos();
        Calendario.setMes(Data.getMesAtual());
        Calendario.setAno(Data.getAnoAtual());
        calendario = new Calendario[49];
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                calendario[i*7+j] = new Calendario(gerenciador,cores);
                calendario[i*7+j].atualiza(i,j);
            }
        }
        Calendario.iniciaTextMes(gerenciador);
    }

    public void insere_Elementos_Calendario()
    {
        lista.Insere_Elemento(fundo);
        lista.Insere_Elemento(capa);
        for(int i=0;i<49;i++)
        {
            calendario[i].insereLista(lista);
        }
        lista.Insere_Elemento(Calendario.getTextMesTexto());
    }

    public void atualizaCalendario(int mes)
    {
        Calendario.setMes(mes);
        Calendario.atualizaTextMes(gerenciador);
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                calendario[i*7+j].atualiza(i,j);
            }
        }
    }
}
