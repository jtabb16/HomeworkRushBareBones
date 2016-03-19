/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.management;

import org.jbt.gameComponentsSynthesized.TileMap;
import org.jbt.userInput.InputProcessor;

/*
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import org.jbt.display.GameFrame;
*/

/**
 *
 * @author jbt
 */
public class GameManager 
{
    Updater updater;
    Renderer renderer;
    TileMap levelMap;
    InputProcessor input;
    public GameManager(String levelName)
    {
        System.out.println("\nMaking New GameManager");
        levelMap = new TileMap(levelName);
        renderer = new Renderer(levelMap);
        updater = new Updater(levelMap);
        input = new InputProcessor(levelMap);
        System.out.println("New GameManager Made");
    }
    
    public void startGame()
    {
        boolean runGame = true;
        System.out.println("Game Running");
        
        while (runGame)
        {
            input.performKeys();//Check the user input
            updater.update();
            renderer.render();
            
            //System.out.println("Game Running");
        }
    }
    
}
