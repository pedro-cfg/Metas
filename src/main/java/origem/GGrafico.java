package origem;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GGrafico extends JPanel implements MouseListener
{
    private JFrame f = new JFrame();
    private boolean desenha = false;
    private Elemento elem;
    private Lista lista;

    GGrafico(Lista l)
    {
        super();
        inicia();
        lista = l;
        addMouseListener(this);
    }

    public void inicia()
    {
        f.setSize(360, 640);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setContentPane(this);
    }

    public void Atualiza_Elemento(Elemento e)
    {
        elem = e;
    }

    public void Desenha()
    {
        desenha = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(desenha)
        {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Lista atual = lista.getPrimeiro();
            while(atual != null)
            {   
                elem = atual.getElemento();
                g2.setColor(new Color(elem.getCor().getVermelho(),elem.getCor().getVerde(),elem.getCor().getAzul()));
                //g2.fillRect(elem.getX(),elem.getY(),elem.getLargura(),elem.getAltura());
                g2.fillRoundRect(elem.getX(),elem.getY(),elem.getLargura(),elem.getAltura(),50,50);
                atual = atual.getProximo();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        elem.setPosicao(e.getX()-elem.getLargura()/2, e.getY()-elem.getAltura()/2);
        Desenha();
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