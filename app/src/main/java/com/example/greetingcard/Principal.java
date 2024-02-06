//package origem;
package com.example.greetingcard;

import android.content.Context;
import android.util.AttributeSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal 
{
    private static GGrafico gerenciador;
    private static GInteracao interacao;
    private static Cores cores;
    private static Lista elementos, conjuntos;
    private static Menu_Calendario menu_calendario;
    private static Menu_Inicio menu_inicio;
    private static Salvamento salvamento;
    private static MainActivity main;
    private static int meta;
    private static File arquivo;

    Principal(MainActivity ma, int m)
    {
        main = ma;
        meta = m;
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
        arquivo = new File(c.getFilesDir(), "Meta.txt");
    }

    public void setMeta()
    {
        try {
            FileInputStream file = new FileInputStream(arquivo);
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));
            meta = reader.read();
            reader.close();
        }catch (IOException e)
        {
            main.troca();
            System.out.println(e.getMessage());
        }
        if(meta == 0)
            main.troca();
        menu_inicio.setMetas(meta);
    }

    public boolean getInicio()
    {
        return getGInteracao().getInicio();
    }

    public static void cria_Tudo()
    {
        conjuntos = new Lista();
        interacao = new GInteracao(main);
        cores = new Cores();
        menu_calendario = new Menu_Calendario();
        menu_inicio = new Menu_Inicio(meta);
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
