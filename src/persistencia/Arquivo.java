/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author faculdade.ads
 */
public class Arquivo {
    
    public static void updateDataBase(Object obj, String caminho) {
      
        try {
            FileOutputStream arquivo = new FileOutputStream(caminho);
            ObjectOutputStream dado = new ObjectOutputStream(arquivo);
            dado.writeObject(obj);
            dado.close();
            
            
          } catch (Exception e) {
            e.printStackTrace();
        }
          
    }
    public static Object loadDataBase(String caminho){
    Object obj = null;
    Path path = Paths.get(caminho);
    if(Files.exists(path)){
        try {
            FileInputStream arquivo = new FileInputStream(caminho);
            ObjectInputStream dado = new ObjectInputStream(arquivo);
            obj = dado.readObject();
            dado.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
    
    }
    
    return obj;
    
    }
    
    
}
