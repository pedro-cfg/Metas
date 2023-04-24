//package origem;
package com.example.greetingcard;


import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Salvamento
{
    private File arquivo;

    Salvamento(Context c)
    {
        arquivo = new File(c.getFilesDir(), "Dados.txt");;
    }

    public void escreve(Data[] d)
    {
        try{
            FileOutputStream file = new FileOutputStream(arquivo);
            OutputStreamWriter bw = new OutputStreamWriter(file);

            int cont = 0;
            while (d[cont].getCumpriu() != 3) {
                bw.write(d[cont].getCumpriu());
                cont++;
            }

            bw.flush();
            bw.close();
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void le(Data[] d,Menu_Inicio m)
    {
        try {
            FileInputStream file = new FileInputStream(arquivo);
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));

            int cont = 0;
            while (d[cont].getCumpriu() != 3) {
                int cumpriu = reader.read();
                if (cumpriu == 1 || cumpriu == 2) {
                    d[cont].setCumpriu(cumpriu);
                    d[cont].colore();
                    if (cumpriu == 2)
                        m.setNum(m.getNum() + 1);
                }
                cont++;
            }
            reader.close();
        }catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
