/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeMap;

import java.io.File;
import java.util.LinkedList;


/**
 *
 * @author bolic
 */
public class Node {
    private File content;
    private LinkedList<FileTreeMap> childs;

    public Node(File content) {
        this.content = content;
        this.childs = new LinkedList<>();
    }
    
    

    public File getContent() {
        return content;
    }

    public void setContent(File content) {
        this.content = content;
    }

    public LinkedList<FileTreeMap> getChilds() {
        return childs;
    }

    public void setChilds(LinkedList<FileTreeMap> childs) {
        this.childs = childs;
    }
    
    
}
