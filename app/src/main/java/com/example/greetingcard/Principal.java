//package origem;
package com.example.greetingcard;

import android.content.Context;
import android.util.AttributeSet;

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

    Principal()
    {

    }

    public void comeca()
    {
        cria_Tudo();
        inicia_Tudo();
        salvamento.le(menu_calendario.getCalendario().getDatas(),menu_inicio);
        menu_inicio.atualiza();
    }

    public void cria_Gerenciador(Context c, AttributeSet a)
    {
        elementos = new Lista();
        gerenciador = new GGrafico(elementos,c,a);
        salvamento = new Salvamento(c);
    }

    public static void cria_Tudo()
    {
        conjuntos = new Lista();
        interacao = new GInteracao();
        cores = new Cores();
        menu_calendario = new Menu_Calendario();
        menu_inicio = new Menu_Inicio();
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
