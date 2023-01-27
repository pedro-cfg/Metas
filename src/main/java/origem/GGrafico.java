package origem;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GGrafico extends JPanel
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
    }

    public void inicia()
    {
        largura = 360;
        altura = 720;
        f.setSize(largura, altura);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);
        f.setContentPane(this);
    }

    public void Redesenha()
    {
        repaint();
    }

    public void Desenha(Bloco b)
    { 
        grafico.setColor(new Color(b.getCor().getVermelho(),b.getCor().getVerde(),b.getCor().getAzul()));
        grafico.fillRoundRect(b.getX(),b.getY(),b.getLargura(),b.getAltura(),b.getArredX(),b.getArredY());
    }

    public void Desenha(Imagem i)
    {
        grafico.drawImage(i.getTextura().getImagem(),i.getX(),i.getY(),i.getLargura(),i.getAltura(),null);
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
}

class Textura
{
    private Image imagem;

    Textura()
    {

    }

    public void setImagem(String origem)
    {
        imagem = new ImageIcon(origem).getImage();
    }

    public Image getImagem()
    {
        return imagem;
    }
}