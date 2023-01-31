package origem;

public class Cores 
{
    private Cor laranja, branco, preto; 

    Cores()
    {
        inicializa_Cores();
    }

    public void inicializa_Cores()
    {
        preto = new Cor();
        preto.setCor(0, 0, 0);

        laranja = new Cor();
        laranja.setCor(255, 138, 64);

        branco = new Cor();
        branco.setCor(255, 255, 255);
    }

    public Cor getCor(String c)
    {
        switch(c)
        {
            case "Branco":
                return branco;
            case "Preto":
                return preto;
            case "Laranja":
                return laranja;
        }
        return null;
    }
}
