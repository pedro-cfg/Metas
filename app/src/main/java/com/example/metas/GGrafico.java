//package origem;
package com.example.metas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;


public class GGrafico extends View
{

    private Lista lista;
    private int largura, altura;
    private Paint pincel;
    private Canvas canvas;

    GGrafico(Lista l, Context c, AttributeSet a)
    {
        super(c,a);
        lista = l;
    }

    public void inicia(int a, int l)
    {
        largura = l;
        altura = a;
        Bitmap bitmap = Bitmap.createBitmap(largura, altura, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        setupPaint();
    }

    private void setupPaint() {
        pincel = new Paint();
        pincel.setAntiAlias(true);
    }

    public void redesenha()
    {
        invalidate();
        this.draw(canvas);
    }

    public void Desenha(Bloco b)
    {
        pincel.setStyle(Paint.Style.FILL);
        pincel.setColor(Color.argb((int)(b.getAlpha()*255),b.getCor().getVermelho(),b.getCor().getVerde(),b.getCor().getAzul()));
        canvas.drawRoundRect(b.getX(),b.getY(),b.getX()+b.getLargura(),b.getY()+b.getAltura(),b.getArredX(),b.getArredY(),pincel);
    }

    public void Desenha(Quadrado b)
    {
        pincel.setColor(Color.argb((int)(b.getAlpha()*255),b.getCor().getVermelho(),b.getCor().getVerde(),b.getCor().getAzul()));
        pincel.setStyle(Paint.Style.STROKE);
        pincel.setStrokeWidth(b.getGrossura());
        canvas.drawRoundRect(b.getX(),b.getY(),b.getX()+b.getLargura(),b.getY()+b.getAltura(),b.getArredX(),b.getArredY(),pincel);
    }

    public void Desenha(Imagem i)
    {
        pincel.setAlpha((int)(i.getAlpha()*255));
        Drawable d = getResources().getDrawable(i.getTextura(), null);
        d.setBounds(i.getX(),i.getY(),i.getX()+i.getLargura(),i.getY()+i.getAltura());
        d.draw(canvas);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), i.getTextura());
//        canvas.drawBitmap(bitmap, i.getX(), i.getY(), pincel);
//        bitmap = null;
    }

    public void Desenha(Linha i)
    {
        pincel.setColor(Color.argb((int)(i.getAlpha()*255),i.getCor().getVermelho(),i.getCor().getVerde(),i.getCor().getAzul()));
        pincel.setStyle(Paint.Style.STROKE);
        pincel.setStrokeWidth(i.getGrossura());
        canvas.drawLine(i.getX(),i.getY(),i.getX2(),i.getY2(),pincel);
    }

    public void Desenha(Texto t)
    {
        pincel.setColor(Color.argb((int)(t.getAlpha()*255),t.getCor().getVermelho(),t.getCor().getVerde(),t.getCor().getAzul()));
        pincel.setStyle(Paint.Style.FILL);
        pincel.setTextSize(t.getTamanho());
        pincel.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(t.getTexto(),t.getX(),t.getY(),pincel);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
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

    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
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
