package origem;

public class Calendario {
    private Bloco bloco;
    private Texto texto;
    private GGrafico gerenciador;
    private static Cores cores;
    private Data data;
    private int linha, coluna;
    private static int mes, ano;
    private static Texto text_mes;

    Calendario(GGrafico g, Cores c)
    {
        gerenciador = g;
        bloco = new Bloco(g);
        texto = new Texto(g);
        cores = c;
        setCores(cores.getCor("Branco"),cores.getCor("Preto"));
    }

    public void atualiza(int i, int j)
    {
        linha = i;
        coluna = j;
        int larguraTela = gerenciador.getLargura();
        int alturaTela = gerenciador.getAltura();
        int ladoBloco = larguraTela*9/100;
        int dia = getDiaSemana(1,mes,ano)-1;
        if(dia<0)
            dia = 6;

        bloco.setPosicao(larguraTela/20+larguraTela*7/60+coluna*larguraTela/9-ladoBloco/2,alturaTela*3/20+alturaTela*8/60+linha*alturaTela/15-ladoBloco/2);
        bloco.setArred(larguraTela/36, larguraTela/36);

        texto.setTamanho(ladoBloco*7/10);

        if(linha == 0)
        {
            switch(coluna)
            {
                case 0:
                    texto.setTexto("D");
                    break;
                case 1:
                    texto.setTexto("S");
                    break;
                case 2:
                    texto.setTexto("T");
                    break;
                case 3:
                    texto.setTexto("Q");
                    break;
                case 4:
                    texto.setTexto("Q");
                    break;
                case 5:
                    texto.setTexto("S");
                    break;
                case 6:
                    texto.setTexto("S");
                    break;
            }
        }
        else
        {
            int num = (linha-1)*7+coluna+1-dia;
            int ultimo_dia;
            boolean bi = false;
                if(ano%4==0 && ano%100!=0 || ano%4==0 && ano%100==0 && ano%400==0)
            bi = true;
            if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)
                ultimo_dia = 31;
            else if(mes==4||mes==6||mes==9||mes==11)
                ultimo_dia = 30;
            else 
                ultimo_dia = bi?29:28;
            if(num > 0 && num <= ultimo_dia)
            {
                String s = new Integer(num).toString();
                texto.setTexto(s);
                // for(int k = 0;k<(bi?366:365);k++)
                // {
                //     if(datas[i].getMes() == mes)
                //     {
                //         if(datas[i].getDia() == num)
                //         {
                //             data = datas[i];
                //         }
                //     }
                // }
            }
            else
            {
                texto.setTexto(" ");
            }
            bloco.setTamanho(ladoBloco, ladoBloco);
        }
        if(texto != null)
            texto.setPosicao(bloco.getX()+(ladoBloco-gerenciador.getLarguraFonte(texto))/2, bloco.getY()+ladoBloco*4/5);
    }

    public void setCores(Cor bloc, Cor txt)
    {
        bloco.setCor(bloc);
        texto.setCor(txt);
    }

    public void insereLista(Lista l)
    {
        l.Insere_Elemento(bloco);
        l.Insere_Elemento(texto);
    }

    public Bloco getBloco()
    {
        return bloco;
    }

    public Texto getTexto()
    {
        return texto;
    }

    public Data getData()
    {
        return data;
    }

    public static void setMes(int m)
    {
        mes = m;
    }

    public static int getMes()
    {
        return mes;
    }

    public static void setAno(int a)
    {
        ano = a;
    }

    public static void iniciaTextMes(GGrafico g)
    {
        text_mes = new Texto(g);
        text_mes.setTexto(getStringMes(mes));
        text_mes.setCor(cores.getCor("Preto"));
        text_mes.setTamanho(g.getLargura()/10);
        int tamanho = g.getLarguraFonte(text_mes);
        text_mes.setPosicao((g.getLargura()-tamanho)/2, g.getAltura()*22/100);
    }

    public static void atualizaTextMes(GGrafico g)
    {
        text_mes.setTexto(getStringMes(mes));
        int tamanho = g.getLarguraFonte(text_mes);
        text_mes.setPosicao((g.getLargura()-tamanho)/2, g.getAltura()*22/100);
    }

    public static Texto getTextMesTexto()
    {
        return text_mes;
    }

    private static String getStringMes(int mes)
    {
        switch(mes)
        {
            case 1:
                return "Janeiro";
            case 2:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            case 7:
                return "Julho";
            case 8:
                return "Agosto";
            case 9:
                return "Setembro";
            case 10:
                return "Outubro";
            case 11:
                return "Novembro";
            case 12:
                return "Dezembro";
        }
        return "ERRO";
    }

public int getDiaSemana(int d, int m, int a)
    {
        int ancorasec = (((5*((a/100)%4))%7)+3)%7;
        int y = a%100;
        int ancora = ((((y/12)+(y%12)+((y%12)/4))%7)+ancorasec)%7;
        int diaancora = 0;
        boolean bi = false;
        if(a%4==0 && a%100!=0 || a%4==0 && a%100==0 && a%400==0)
            bi = true;
        if(m==4||m==6||m==8||m==10||m==12)
            diaancora = m;
        else if(m==1)
            diaancora = bi?4:3;
        else if(m==2)
            diaancora = bi?29:28;
        else if(m==3)
            diaancora = 14;
        else if(m==5)
            diaancora = 9;
        else if(m==7)
            diaancora = 11;
        else if(m==9)
            diaancora = 5;
        else if(m==11)
            diaancora = 7;
        int diasemana = (((d-diaancora)%7)+ancora)%7;
        if(diasemana<0)
            diasemana+=7;
        return diasemana;
    }
}
