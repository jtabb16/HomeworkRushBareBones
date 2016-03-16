/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.management;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

/**
 *
 * @author jbt
 */
public class KeyboardControl implements KeyListener
{
    private static HashSet <Integer> activeKeys; //static because there is only one instance of keys
    public KeyboardControl()
    {
        System.out.println("New KeyboardControl Made");
        activeKeys = new HashSet<Integer>();
    }
    @Override
    public void keyTyped(KeyEvent e) 
    {
        //Do Nothing
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        activeKeys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        activeKeys.remove(e.getKeyCode());
    }
    
    public static HashSet<Integer> getActiveKeys()
    {
        return activeKeys;
    }
}
