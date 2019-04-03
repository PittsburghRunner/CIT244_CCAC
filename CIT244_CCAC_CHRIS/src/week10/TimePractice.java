/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week10;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author christopher.eckles
 */
public class TimePractice {
    
    public static void main(String[] args) {
            Random r = new Random();
    for(int i = 0 ; i < 200 ; i++){
    Math.pow(Math.cos(r.nextDouble()*r.nextDouble()),Math.PI);
    getTimestamp();
    }

}
 public static long getTimestamp(){
     long t = java.time.Instant.now().toEpochMilli();
     return t;
 }
    
}
