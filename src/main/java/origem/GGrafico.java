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
    AlphaComposite alcom;
    private int largura, altura;

    GGrafico(Lista l)
    {
        super();
        lista = l;
        inicia();
    }

    public void inicia()
    {
        largura = 360;
        altura = 720;
        f.setSize(largura, altura);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setContentPane(this);
        f.setVisible(true);
    }

    public void redesenha()
    {
        repaint();
    }

    public void Desenha(Bloco b)
    { 
        alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, b.getAlpha());
        grafico.setComposite(alcom);
        grafico.setColor(new Color(b.getCor().getVermelho(),b.getCor().getVerde(),b.getCor().getAzul()));
        grafico.fillRoundRect(b.getX(),b.getY(),b.getLargura(),b.getAltura(),b.getArredX(),b.getArredY());
    }

    public void Desenha(Imagem i)
    {
        alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, i.getAlpha());
        grafico.setComposite(alcom);
        grafico.drawImage(i.getTextura().getImagem(),i.getX(),i.getY(),i.getLargura(),i.getAltura(),null);
    }

    public void Desenha(Texto t)
    {
        alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, t.getAlpha());
        grafico.setComposite(alcom);
        grafico.setFont(new Font(t.getFonte(),t.getNegrito()?Font.BOLD:0,t.getTamanho()));
        grafico.setColor(new Color(t.getCor().getVermelho(),t.getCor().getVerde(),t.getCor().getAzul()));
        grafico.drawString(t.getTexto(),t.getX(),t.getY());
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        grafico = g2;
        alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.f);
        grafico.setComposite(alcom);
        Elemento elem;
        if(lista != null)
        {
            Lista atual = lista.getPrimeiro();
            while(atual != null)
            {   
                elem = atual.getElemento();
                elem.Desenha();
                atual = atual.getProximo();
            }
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

    public int getLarguraFonte(Texto t)
    {
        FontMetrics metrics = grafico.getFontMetrics(new Font(t.getFonte(),t.getNegrito()?Font.BOLD:0,t.getTamanho()));
        return metrics.stringWidth(t.getTexto());
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