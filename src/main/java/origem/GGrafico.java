package origem;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GGrafico extends JPanel implements MouseListener
{
    private JFrame f = new JFrame();
    private Lista lista;
    private Graphics2D grafico;
    private int largura, altura;

    GGrafico(Lista l)
    {
        super();
        inicia();
        lista = l;
        addMouseListener(this);
    }

    public void inicia()
    {
        largura = 360;
        altura = 640;
        f.setSize(largura, altura);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setContentPane(this);
    }

    public void Redesenha()
    {
        repaint();
    }

    public void Desenha_Bloco(Bloco b)
    { 
        grafico.setColor(new Color(b.getCor().getVermelho(),b.getCor().getVerde(),b.getCor().getAzul()));
        grafico.fillRoundRect(b.getX(),b.getY(),b.getLargura(),b.getAltura(),b.getArredX(),b.getArredY());
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        grafico = g2;
        Elemento elem;
        Lista atual = lista.getPrimeiro();
        while(atual != null)
        {   
            elem = atual.getElemento();
            elem.Desenha();
            atual = atual.getProximo();
        }
    }

    public int getLargura()
    {
        return largura;
    }

    public int getAltura()
    {
        return altura;
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        //elem.setPosicao(e.getX()-elem.getLargura()/2, e.getY()-elem.getAltura()/2);
        Redesenha();
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