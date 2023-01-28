package origem;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GInteracao implements MouseListener
{   
    private GGrafico grafico;
    private Imagem elem;

    public GInteracao(GGrafico g)
    {
        grafico = g;
        grafico.addMouseListener(this);
    }

    public void setElemento(Imagem e)
    {
        elem = e;
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        elem.setPosicao(e.getX()-elem.getLargura()/2, e.getY()-elem.getAltura()/2);
        grafico.Redesenha();
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
