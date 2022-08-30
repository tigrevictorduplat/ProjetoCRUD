package JFrameAssets;

import javax.swing.*;

public class CalculaPosicao {
    
    public  int calculaCentroX(int larguraJanela){
        int posicaoX = (int) Math.round(larguraJanela*0.5);
        return posicaoX;
    }
    public  int calculaCentroX(int larguraJanela, double posicaoPorcentagem){
        int posicaoX = (int) Math.round(larguraJanela*posicaoPorcentagem);
        return posicaoX;
    }

    public  int calculaCentroY(int alturaJanela){
        int posicaoY = (int) Math.round(alturaJanela*0.5);
        return posicaoY;
    }

    public  int calculaCentroY(int alturaJanela, double posicaoPorcentagem){
        int posicaoY = (int) Math.round(alturaJanela*posicaoPorcentagem);
        return posicaoY;
    }

    public  int calculaTamanhoX(int larguraJanela, int divisaoPor){
        int tamanhoX = (int) Math.round((larguraJanela/divisaoPor));
        return tamanhoX; 
    }
    public  int calculaTamanhoY(int alturaJanela, int divisaoPor){
        int tamanhoY = (int) Math.round((alturaJanela/divisaoPor));
        return tamanhoY; 
    }

}
