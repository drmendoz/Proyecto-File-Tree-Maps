/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import TreeMap.FileTreeMap;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author bolic
 */
public class Interfaz {

    private TreeMapRectangle treemap;
    private VBox root;
    private final FileTreeMap fileTree;

    public Interfaz(TreeMapRectangle treemap, FileTreeMap ftm) {
        this.treemap = treemap;
        this.root = new VBox();
        this.fileTree = ftm;
    }

    public TreeMapRectangle getTreemap() {
        return treemap;
    }

    public void setTreemap(TreeMapRectangle treemap) {
        this.treemap = treemap;
    }

    public VBox getRoot() {
        return root;
    }

    public void setRoot(VBox root) {
        this.root = root;
    }

    public void crearInterfaz() {
        root.getChildren().clear();
        
        root.getChildren().add(treemap.getRoot());
        HBox bottomContent = new HBox();
        TextField urlField = new TextField();
        Button boton = new Button("Crear");
        bottomContent.getChildren().addAll(urlField, boton);
        root.getChildren().add(bottomContent);
        boton.setOnAction(e -> {
            root.getChildren().clear();
            treemap.borrarMatriz();
            fileTree.llenarArbol(urlField.getText());
            
            treemap.drawRectangle(fileTree, treemap.getRoot());
            root.getChildren().addAll(treemap.getRoot(),bottomContent);
            
        });
    }

}
