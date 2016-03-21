/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.main;

import org.jbt.fileIO.LevelLoader;
import org.jbt.management.GameManager;

/**
 *
 * @author jbt
 * @version 1.1.0
 * Date: 3/16/16
 */
public class Main 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Hello Jack. Let's get started. :)");
        //String levelName = "0";
        String levelName = "a";
        
        //LevelLoader l = new LevelLoader ("org/jbt/resources/levels/0.level");
        //l.readFile();
        
        
        
        GameManager gM = new GameManager(levelName);
        gM.startGame();
        
    }
}
