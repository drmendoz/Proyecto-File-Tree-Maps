/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.HashMap;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author bolic
 */
public class Colores {
    private HashMap<String,Paint> colorMap;

    public Colores() {
        colorMap=new HashMap<>();
    }
    
    public Paint buscarColor(String path){
        Paint retornar;
        String[] lista=path.split("\\.");
        String extension=" ";
        if(lista.length>1){
            extension=lista[1];
        }
        if(colorMap.containsKey(extension)){
            retornar=colorMap.get(extension);
        }
        else{
            retornar =  randomColor();
            colorMap.put(extension, retornar);
        }
        
        return retornar;
    }
    
    public Paint randomColor() {
        Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return Color.rgb(r, g, b);
    }
}
