/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.gameComponents;

/**
 *
 * @author jbt
 */
public class Obstacle extends Component
{
    private static final int OBSTACLE_WIDTH = 50;
    private static final int OBSTACLE_HEIGHT = 100;
    
    public Obstacle(String name, int x, int y)
    {
        super(name, x, y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
    }
    
    /*
    @Override
    void makeBoundary(int x, int y, int w, int h)
    {
        
    }
*/
}
