package origem;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GInteracao implements MouseListener
{   
    private GGrafico grafico;
    private Menu_Calendario menu_calendario;
    private Menu_Inicio menu_inicio;
    private Lista conjuntos;

    public GInteracao()
    {
        
    }

    public void Inicia(Menu_Calendario m, Menu_Inicio m2)
    {
        grafico = Principal.getGGrafico();
        conjuntos = Principal.getListaConjuntos();
        grafico.addMouseListener(this);
        menu_calendario = m;
        menu_inicio = m2;
    }

    public void verifica_Toque(int x, int y)
    {
        Conjunto conj;
        if(conjuntos != null)
        {
            Lista atual = conjuntos.getPrimeiro();
            while(atual != null)
            {   
                conj = atual.geConjunto();
                if(x > conj.getX() && x < conj.getX()+conj.getLargura() && y > conj.getY() && y < conj.getY()+conj.getAltura())
                    conj.toque();
                atual = atual.getProximo();
            }
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

    public void interage(Botao_Selecao b)
    {
        int antes = menu_calendario.getCalendario().getSelecionado().getCumpriu();
        menu_calendario.getCalendario().getSelecionado().setCumpriu(b.getVerde()?2:1);
        menu_calendario.getCalendario().getSelecionado().colore();
        int depois = menu_calendario.getCalendario().getSelecionado().getCumpriu();
        if(antes != depois)
            menu_inicio.setNum(menu_inicio.getNum()+(b.getVerde()?1:(-1)));
        menu_calendario.atualiza();
    }

    public void interage(Botao_Inicio b)
    {
        if(b.getInicio())
            menu_calendario.atualiza();
        else
            menu_inicio.atualiza();
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        verifica_Toque(e.getX(),e.getY());
        grafico.redesenha();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {    

    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {   

    }
    
    @Override
    public void mouseExited(MouseEvent e) 
    {     

    }
    
    @Override
    public void mouseReleased(MouseEvent e) 
    {       

    }
}
