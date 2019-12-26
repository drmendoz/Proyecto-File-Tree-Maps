/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import TreeMap.FileTreeMap;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author bolic
 */
public class TreeMapRectangle {
    private FileTreeMap tree;
    private HBox root;
    private final Colores colores;

    public TreeMapRectangle(FileTreeMap tree) {
        this.tree = tree;
        this.root = new HBox();
        root.setPrefHeight(800);
        root.setPrefWidth(1000);
        this.colores=new Colores();
    }

    public FileTreeMap getTree() {
        return tree;
    }

    public void setTree(FileTreeMap tree) {
        this.tree = tree;
    }

    public HBox getRoot() {
        return root;
    }

    public void setRoot(HBox root) {
        this.root = root;
    }
    
    
    
    public void drawRectangle(FileTreeMap map,Pane container){
        long tamMap=map.calcularPeso();
        double containerWidth= container.getPrefWidth();
        double containerHeigth=container.getPrefHeight();
        for(FileTreeMap tmp:map.getRoot().getChilds()){
            long tamTmp=tmp.calcularPeso();
            if(tmp.isLeaf()){
                Rectangle r=new Rectangle();
                r.setFill(colores.buscarColor(tmp.getRoot().getContent().getAbsolutePath()));
                if(container instanceof HBox){
                    r.setHeight(containerHeigth);
                    r.setWidth(containerWidth*tamTmp/tamMap);
                    
                    
                }else{
                    r.setHeight(containerHeigth*tamTmp/tamMap);
                    r.setWidth(containerWidth);
                }
                container.getChildren().add(r);
            }
            else{
                if(container instanceof HBox){
                    VBox vbox= new VBox();
                    vbox.setPrefHeight(containerHeigth);
                    vbox.setPrefWidth(containerWidth*tamTmp/tamMap);
                    drawRectangle(tmp, vbox);
                    container.getChildren().add(vbox);
                }else{
                    HBox hbox=new HBox();
                    hbox.setPrefHeight(containerHeigth*tamTmp/tamMap);
                    hbox.setPrefWidth(containerWidth);
                    drawRectangle(tmp, hbox);
                    container.getChildren().add(hbox);
                }
            }
        }
    }
    
    
}
