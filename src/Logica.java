/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author jmchaparroa01
 */
public class Logica {
    
    private final static File FILE = new File("users.txt");
    
    public void escribirFichero(String nombre, String contrasenia){
        try{
            FileWriter fw = new FileWriter(FILE,true);
             
            fw.write("\n");
            fw.write(nombre+";"+contrasenia);
           
            
            fw.close();
            
            System.out.println("Usuario escrito");
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public boolean leerFichero(String nombre, String contrasenia){
        boolean bien = false;
        try{
            BufferedReader br = new BufferedReader(new FileReader(FILE));
            String linea;
            String[] palabras;
           
            while((linea = br.readLine()) != null){
                if(linea.contains(";")){
                    palabras = linea.split(";");
                    if(palabras[0].equals(nombre) && palabras[1].equals(contrasenia)){
                        bien = true;
                    }
                }
            }
                
            br.close();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return bien;
    }
}
