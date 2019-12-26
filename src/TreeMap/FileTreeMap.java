/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeMap;

import java.io.File;


/**
 *
 * @author bolic
 */
public class FileTreeMap  {
    private Node root;

    public FileTreeMap() {
        root=null;
    }

    
    public FileTreeMap(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        boolean val=false;
        if(root==null) val=true;
        return val;
    }
    
    public void addChild(File content){
        root.getChilds().add(new FileTreeMap(new Node(content)));
    }
    
    public void clear(){
        root=null;
    }
    public boolean isLeaf(){
        boolean val=false;
        if(root.getChilds().isEmpty()) val=true;
        return val;
    }
    public void llenarArbol(String path){
        File inicio=new File(path);
        root= new Node(inicio);
        for (File fileEntry : inicio.listFiles()){
            FileTreeMap tmp= new FileTreeMap(new Node(fileEntry));
            root.getChilds().add(tmp);
            System.out.println(fileEntry);
            if(fileEntry.isDirectory()){
                tmp.llenarArbol(fileEntry.getAbsolutePath());
            }
        }
    }
    
    public long calcularPeso(){
        long total=0;
        if(this.isLeaf()) total=root.getContent().length();
        else{
            for(FileTreeMap tmp:root.getChilds()){
                total+=tmp.calcularPeso();
                
            }
        }
        
        return total;
    }
  
}
