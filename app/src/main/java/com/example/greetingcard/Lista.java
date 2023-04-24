//package origem;
package com.example.greetingcard;

public class Lista {
    private Elemento elemento;
    private Conjunto conjunto;
    private Lista primeiro, proximo;

    Lista()
    {
        conjunto = null;
        elemento = null;
        primeiro = proximo = null;
    }
    
    public void setElemento(Elemento elem)
    {
        elemento = elem;
    }

    public void setConjunto(Conjunto conj)
    {
        conjunto = conj;
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

    public Conjunto geConjunto()
    {
        return conjunto;
    }

    public Lista getPrimeiro()
    {
        return primeiro;
    }

    public Lista getProximo()
    {
        return proximo;
    }

    public void insere_Elemento(Elemento e)
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

    public void insere_Conjunto(Conjunto c)
    {
        if(conjunto == null)
        {
            setConjunto(c);
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
            nova.setConjunto(c);
        }
    }

    public void limpa_lista()
    {
        Lista nova, atual;
        nova = new Lista();
        atual = this;
        while(atual.getProximo() != null)
        {
            nova = atual;
            atual = atual.getProximo();
            nova.setConjunto(null);
            nova.setElemento(null);
            nova.setPrimeiro(null);
            nova.setProximo(null);
        }
    }
}
