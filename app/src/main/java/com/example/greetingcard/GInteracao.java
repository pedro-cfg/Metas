//package origem;
package com.example.greetingcard;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;

public class GInteracao implements View.OnTouchListener
{   
    private GGrafico grafico;
    private Menu_Calendario menu_calendario;
    private Menu_Inicio menu_inicio;
    private Lista conjuntos;
    private Salvamento salvamento;
    private MainActivity main;
    private boolean inicio;
    public GInteracao(MainActivity ma)
    {
        main = ma;
        inicio = true;
    }

    public void Inicia(Menu_Calendario m, Menu_Inicio m2, Salvamento s)
    {
        grafico = Principal.getGGrafico();
        conjuntos = Principal.getListaConjuntos();
        menu_calendario = m;
        menu_inicio = m2;
        salvamento = s;
    }

    public void verifica_Toque(int x, int y)
    {
        Conjunto conj;
        if(conjuntos != null)
        {
            Lista atual = conjuntos.getPrimeiro();
            boolean acionou = false;
            while(atual != null && !acionou)
            {
                conj = atual.geConjunto();
                if(x > conj.getX() && x < conj.getX()+conj.getLargura() && y > conj.getY() && y < conj.getY()+conj.getAltura())
                {
                    conj.toque();
                    acionou = true;
                }
                atual = atual.getProximo();
            }
            if(acionou)
                grafico.redesenha();
        }
    }

    public void interage(Seta s)
    {
        menu_calendario.atualizaCalendario(s.getEsquerda()?(-1):1);
        menu_calendario.atualiza();
    }

    public void interage(Dia_Calendario d)
    {
        menu_calendario.getCalendario().setSelecionado(d.getData());
        menu_calendario.atualiza();
    }

    public void interage(Botao_Selecao b) throws IOException
    {
        if(menu_calendario.getCalendario().getMes() == menu_calendario.getCalendario().getSelecionado().getMes())
        {
            int antes = menu_calendario.getCalendario().getSelecionado().getCumpriu();
            menu_calendario.getCalendario().getSelecionado().setCumpriu(b.getVerde()?2:1);
            menu_calendario.getCalendario().getSelecionado().colore();
            int depois = menu_calendario.getCalendario().getSelecionado().getCumpriu();
            if(antes != depois && !(antes == 0 && depois ==1))
                menu_inicio.setNum(menu_inicio.getNum()+(b.getVerde()?1:(-1)));
            menu_calendario.atualiza();
            salvamento.escreve(menu_calendario.getCalendario().getDatas());
        }
    }

    public void interage(Botao_Meta b)
    {
        main.troca();
    }

    public void interage(Botao_Inicio b)
    {
        if(b.getInicio())
        {
            menu_calendario.atualiza();
            inicio = false;
        }
        else
        {
            menu_inicio.atualiza();
            inicio = true;
        }
    }

    public boolean getInicio()
    {
        return inicio;
    }

    public void volta()
    {
        menu_inicio.atualiza();
        inicio = true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent e) {

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                verifica_Toque((int)e.getX(),(int)e.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return false;
    }

}
