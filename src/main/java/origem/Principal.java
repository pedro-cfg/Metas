package origem;

import java.io.IOException;

public class Principal 
{
    private static GGrafico gerenciador;
    private static GInteracao interacao;
    private static Cores cores;
    private static Lista elementos, conjuntos;
    private static Menu_Calendario menu_calendario;
    private static Menu_Inicio menu_inicio;
    private static Salvamento salvamento;

    public static void main(String[] args) throws IOException
    {
        cria_Tudo();
        inicia_Tudo();   
        salvamento.le(menu_calendario.getCalendario().getDatas(),menu_inicio);
        menu_inicio.atualiza();
        gerenciador.redesenha();
    }

    public static void cria_Tudo()
    {
        elementos = new Lista();
        gerenciador = new GGrafico(elementos);
        conjuntos = new Lista();
        interacao = new GInteracao();
        cores = new Cores();
        menu_calendario = new Menu_Calendario();
        menu_inicio = new Menu_Inicio();
        salvamento = new Salvamento();
    }

    public static void inicia_Tudo()
    {
        menu_calendario.inicia();
        menu_inicio.inicia();
        interacao.Inicia(menu_calendario,menu_inicio,salvamento);
    }

    public static GGrafico getGGrafico()
    {
        return gerenciador;
    }

    public static GInteracao getGInteracao()
    {
        return interacao;
    }

    public static Cores getCores()
    {
        return cores;
    }

    public static Lista getListaElementos()
    {
        return elementos;
    }

    public static Lista getListaConjuntos()
    {
        return conjuntos;
    }
}
