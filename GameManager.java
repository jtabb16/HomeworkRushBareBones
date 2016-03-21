/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.management;

import org.jbt.gameComponents.Player;
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
    Player p;
    public GameManager(String levelName)
    {
        System.out.println("\nMaking New GameManager");
        
        levelMap = new TileMap(levelName);
        p = new Player(500, 500);
        renderer = new Renderer(levelMap, p);
        updater = new Updater(levelMap, p);
        input = new InputProcessor(levelMap);
        System.out.println("New GameManager Made");
    }
    
    public void startGame()
    {
        /*
        boolean runGame = true;
        System.out.println("Game Running");
        
        while (runGame)
        {
            input.performKeys();//Check the user input
            updater.update();
            renderer.render();
            
            //System.out.println("Game Running");
        }
        */
        
        /*
        The Game Loop:
        Help from: http://gameprogrammingpatterns.com/game-loop.html
        Fixed Timestep Update - so the game physics acts and feels the same way on all machines
        Variable Rendering Framerate - The game's graphics will run at the highest FPS possible
        */
        final double MS_PER_UPDATE = 8.33;//120 Hz = 8.33 mS per Cycle
        long previous = System.currentTimeMillis();
        long lag = 0l;
        while (true)
        {
          long current = System.currentTimeMillis();
          long elapsed = current - previous;
          previous = current;
          lag += elapsed;

          input.performKeys();

          while (lag >= MS_PER_UPDATE)//Update at 120 Hz
          {
            updater.update();
            lag -= MS_PER_UPDATE;
          }
        
          //Since the rendering and the updating are occurring at two different rates, the animation can look choppy
          //Need to see if we are, for example, halfway between frames and extrapolate by this value. Then render the extrapolation
          renderer.render(lag/MS_PER_UPDATE);//Render at Variable FPS
        }
    }
    
}
