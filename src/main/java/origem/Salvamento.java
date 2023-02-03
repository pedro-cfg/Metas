package origem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Salvamento
{
    private String arquivo;

    Salvamento()
    {
        arquivo = "src/main/java/dados/dados.txt";
    }

    public void escreve(Data[] d) throws IOException
    {
        OutputStream os = new FileOutputStream(arquivo);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        int cont = 0;
        while(d[cont].getCumpriu()!=3)
        {
            bw.write(d[cont].getCumpriu());
            //bw.newLine();
            cont++;
        }

        bw.close();
    }

    public void le(Data[] d,Menu_Inicio m) throws IOException
    {
        InputStream is = new FileInputStream(arquivo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        int cont = 0;
        while(d[cont].getCumpriu()!=3)
        {
            int cumpriu = br.read();
            if(cumpriu == 1 || cumpriu == 2)
            {
                d[cont].setCumpriu(cumpriu);
                d[cont].colore();
                if(cumpriu == 2)
                    m.setNum(m.getNum()+1);
            }
            cont++;
        }

        br.close();
    }
}
