package origem;

public class Lista {
    private Elemento elemento;
    private Lista primeiro, proximo;

    Lista()
    {
        elemento = null;
        primeiro = proximo = null;
    }
    
    public void setElemento(Elemento elem)
    {
        elemento = elem;
    }

    public void setPrimeiro(Lista p)
    {
        primeiro = p;
    }

    public void setProximo(Lista p)
    {
        proximo = p;
    }

    public Elemento getElemento()
    {
        return elemento;
    }

    public Lista getPrimeiro()
    {
        return primeiro;
    }

    public Lista getProximo()
    {
        return proximo;
    }

    public void Insere_Elemento(Elemento e)
    {
        if(elemento == null)
        {
            setElemento(e);
            setPrimeiro(this);
        }
        else
        {
            Lista nova, atual;
            nova = new Lista();
            atual = this;
            while(atual.getProximo() != null)
                atual = atual.getProximo();
            atual.setProximo(nova);
            nova.setPrimeiro(this);
            nova.setElemento(e);
        }
    }
}
