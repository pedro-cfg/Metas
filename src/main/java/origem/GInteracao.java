package origem;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GInteracao implements MouseListener
{   
    private GGrafico grafico;
    private Menu_Calendario menu_calendario;

    public GInteracao()
    {
        
    }

    public void Inicia(GGrafico g,Menu_Calendario m)
    {
        grafico = g;
        grafico.addMouseListener(this);
        menu_calendario = m;
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        //elem.setPosicao(e.getX()-elem.getLargura()/2, e.getY()-elem.getAltura()/2);
        if(Calendario.getMes()<12)
            menu_calendario.atualizaCalendario(Calendario.getMes()+1);
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
