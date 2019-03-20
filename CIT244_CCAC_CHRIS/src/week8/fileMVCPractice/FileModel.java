/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8.fileMVCPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edarsow
 */
public class FileModel {

    public void writeFile(String fileName) {
        PrintWriter fileWriter = null;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(fileName);

        try {
            java.io.File nameFile = new java.io.File(sb.toString());
            System.out.println("Writing to: " + nameFile.getAbsolutePath());
            // connect our writer object with the file to write to
            fileWriter = new PrintWriter(nameFile);
           // fileWriter.println("id,name,course");
            fileWriter.println("99, Mr.Eged, Fast Food Franchise R US");
            fileWriter.println("30, Mr Eckles, Something Else");
            fileWriter.println("48, Student 4, Music Class");


            
            fileWriter.flush();
            fileWriter.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    public List<Student> getStudentsFromFile(String fn) {
        List<Student> studList = new LinkedList<>();
        String fname = //"src/files/" + 
                fn;
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fname));
            fileScanner.useDelimiter("\n");
//        System.out.println("Delim: " + fileScanner.delimiter());
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

        while(fileScanner.hasNext()){
            Student stud = new Student();
            StringTokenizer tokenizer = new StringTokenizer(fileScanner.next(),",");
            stud.setId(Integer.parseInt(tokenizer.nextToken()));
            stud.setName(tokenizer.nextToken());
            stud.setCourse(tokenizer.nextToken());
            
            studList.add(stud);
        }
//        sb.append(fileScanner.next());
//        sb.append(fileScanner.next());
//        sb.append(fileScanner.next());
        System.out.println("File has studlist of " + studList.size());
        return studList;
    }

}
