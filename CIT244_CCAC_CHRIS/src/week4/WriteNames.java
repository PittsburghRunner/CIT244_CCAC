/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author christopher.eckles
 */
public class WriteNames {
    public static void main(String[] args) {
        try{
        File nameFile = new File("namesInClass.txt");
        PrintWriter fileWriter = new PrintWriter(nameFile);
        fileWriter.print("Test File Content");
        fileWriter.flush();
        fileWriter.close();
        fileWriter.close();
        }
        catch (FileNotFoundException ex){
            
        } finally {
           

        }
    }
}
