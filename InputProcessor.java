/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.userInput;

import org.jbt.userInput.KeyboardControl;
import java.awt.event.KeyEvent;
import java.util.HashSet;
//import org.jbt.display.GameFrame;
import org.jbt.display.DisplayFrame;
import org.jbt.gameComponents.Tile;
import org.jbt.gameComponentsSynthesized.TileMap;

/**
 *
 * @author jbt
 */
public class InputProcessor 
{
    float platformYVel;
    int jumpCounter = 0, fallCounter = 0;
    TileMap tileMap;
    
    public InputProcessor(TileMap tMap)
    {
        System.out.println("\nMaking New InputProcessor");
        tileMap = tMap;
        System.out.println("New InputProcessor Made");
    }
    
    public void performKeys()
    {
        HashSet<Integer> currentKeys = KeyboardControl.getActiveKeys();
        Tile [][] tiles = tileMap.getTiles();
        
        //Control for up and down:
        if (currentKeys.contains(KeyEvent.VK_W))
        {
            System.out.println("W");
            if (jumpCounter <= 2)
                changeYVel(tiles, "jump");
            jumpCounter++;
        }
        else
        {
            jumpCounter = 0;//Only change this to zero if you touch the ground. Don't change to 0 here. This is just for testing until I have boundary detection
        }
        if (currentKeys.contains(KeyEvent.VK_S))
        {
            System.out.println("S");
            if (fallCounter < 2)
                changeYVel(tiles, "fall");
            fallCounter++;
        }
        else
        {
            fallCounter = 0;
        }
        //Control for right and left:
        if (currentKeys.contains(KeyEvent.VK_A))
        {
            System.out.println("A");
            changeXVel(tiles, "walkLeft");
        }
        else if (currentKeys.contains(KeyEvent.VK_D))
        {
            System.out.println("D");
            changeXVel(tiles, "walkRight");
        }
        else
        {
            for (Tile[] tile1 : tiles) {
                for (Tile tile : tile1) {
                    tile.setXVel(0);
                }
            }
        }
        
        //Control for exiting the game:
        if (currentKeys.contains(KeyEvent.VK_ESCAPE))
        {
            //Make this for accessing menu while in-game later on
            System.out.println("ESC");
            //dF.setRunningBool(false);
            System.exit(0);
        }
    }
    
    private void changeXVel(Tile[][]tiles, String action)
    {
        float speed = 0.0f;
        if (action.equals("walkRight"))
            speed = -1*tiles[0][0].getWalkSpeed();
        else if (action.equals("walkLeft"))
            speed = tiles[0][0].getWalkSpeed();
        
        for (Tile[] tile1 : tiles) {
                for (Tile tile : tile1) {
                    tile.setXVel(speed);
                }
            }
    }
    
    private void changeYVel(Tile[][] tiles, String action)
    {
        float speed = 0.0f;
        if (action.equals("jump"))
            speed = tiles[0][0].getJumpSpeed();
        else if (action.equals("fall"))
            speed = (-1*tiles[0][0].getJumpSpeed());
        
        for (Tile[] tile1 : tiles) {
                for (Tile tile : tile1) {
                    tile.setYVel(speed);
                }
            }
    }
}
