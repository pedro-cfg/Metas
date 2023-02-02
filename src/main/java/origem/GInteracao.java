package origem;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GInteracao implements MouseListener
{   
    private GGrafico grafico;
    private Menu_Calendario menu_calendario;
    private Lista conjuntos;

    public GInteracao()
    {
        
    }

    public void Inicia(Menu_Calendario m)
    {
        grafico = Principal.getGGrafico();
        conjuntos = Principal.getListaConjuntos();
        grafico.addMouseListener(this);
        menu_calendario = m;
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
        menu_calendario.getCalendario().getSelecionado().setCumpriu(b.getVerde()?2:1);
        menu_calendario.getCalendario().getSelecionado().colore();
        menu_calendario.atualiza();
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
