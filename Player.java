/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.gameComponents;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author jbt
 */
public class Player extends Entity
{
    public Player(int x, int y)
    {
        super("PXXX", x, y);
        System.out.println("\nMaking New Player");
        
        System.out.println ("New Player Made");
    }
    
    public void drawPlayer(Graphics2D g2, double extrapolationValue)
    {
        //Extrapolate where the image should be...
        float newXVel = super.getXVel()*(float)extrapolationValue;
        float newX = super.getXCoord() + newXVel;
        float newYVel = super.getYVel()*(float)extrapolationValue;
        float newY = super.getYCoord() + newYVel;
        
        
        g2.setColor(Color.RED);
        g2.fillRect(Math.round(newX), Math.round(newY), Math.round(Entity.getEntityWidth()), Math.round(Entity.getEntityHeight()));
        
        
        //Draw the image... NOT WORKING FOR SOME REASON !! ?? !!
        //super.drawImage(g2, newX, newY);
        //System.out.println("Drawing Player");
    }
}
