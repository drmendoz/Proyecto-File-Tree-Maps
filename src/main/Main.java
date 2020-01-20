/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import GUI.Interfaz;
import GUI.TreeMapRectangle;
import TreeMap.FileTreeMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author bolic
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileTreeMap tree=new FileTreeMap();
        //tree.llenarArbol("C:\\Users\\bolic\\Desktop\\pruebaProyecto");
        TreeMapRectangle view= new TreeMapRectangle(tree);
        //view.drawRectangle(tree,view.getRoot());
        Interfaz interfaz= new Interfaz(view,tree);
        interfaz.crearInterfaz();
        primaryStage.setScene(new Scene(interfaz.getRoot()));
        primaryStage.show();
    }
    
}
