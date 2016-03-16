/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.main;

//import org.jbt.display.GameFrame2;
import org.jbt.management.GameManager;

/**
 *
 * @author jbt
 * @version 0.1
 */
public class MainClass 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("Hello Jack. Let's get started. :)");
        
        int levelNum = 0;
        
       // GameFrame2 gf = new GameFrame2();
        //gf.runGameFrame();
        GameManager gM = new GameManager(levelNum);
        gM.startGame();
    }
}
