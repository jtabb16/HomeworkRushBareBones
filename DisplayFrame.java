package org.jbt.display;

/**
 * @author jbt
 * Purpose: To provide the main drawing surface for the entire game
 * Date: 3/15/16
 * 
 * Notes:
 * I am actively rendering (not relying on paint() or paintComponent()).
 * This means that I need to make my own double buffer
 */

/*
Code heavily modified from:
http://www.gamedev.net/page/resources/_/technical/general-programming/java-games-active-rendering-r2418
*/

//The main point of this class is to set up a JFrame to hold graphical components:
import javax.swing.JFrame;

//For visual stuff:
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

//For setting up the frame and buffer
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.GraphicsConfiguration;

//Enables use of double-buffer
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

//Custom-MadeImports:
    //For enabling custom control over handling keyboard input:
import org.jbt.userInput.KeyboardControl;


public class DisplayFrame 
{
    //Boolean to say whether the window should be open
    private boolean running = true;
    
    //Dimensions of Window -- Set to full screen in constructor
    private int width =0; //1000;
    private int height = 0;//800;
  
    //Variables for counting frames per second
    private int fps = 0;
    private int frames = 0;
    private long totalTime = 0;
    private long curTime = System.currentTimeMillis();
    private long lastTime = curTime;
  
    //Variables for using double-buffering
    private BufferStrategy buffer;
    private BufferedImage bi;
    
    // Objects needed for rendering...
    private Graphics g = null;
    private Graphics2D g2 = null;
    
    /*
    Construct the main drawing mechanism
    */
    public DisplayFrame()
    {
        System.out.println("\nMaking New DisplayFrame");
        // Create game window...
        JFrame frame = new JFrame();
        frame.setIgnoreRepaint( true );
        frame.setUndecorated( true );
        
        // Get graphics configuration...
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();

        //Set the size of the game window...
        gd.setFullScreenWindow( frame );
        width = gc.getBounds().width;
        height = gc.getBounds().height;
            //frame.setSize(width,height);
        frame.setVisible(true);

        // Create BackBuffer...
        frame.createBufferStrategy( 2 );
        buffer = frame.getBufferStrategy();

        // Create off-screen drawing surface
        bi = gc.createCompatibleImage( width, height );
        
        //Add custom modules:
            //Listen to Key Input:
            frame.addKeyListener(new KeyboardControl());
        System.out.println("New DisplayFrame Made");
    }
    
    /*
    Prepare to draw
    Called Before an object is drawn
    Example:
    DisplayFrame dFrame = new DisplayFrame();
    dFrame.prepareDraw();
    Graphics2D gfx = dFrame.getG();
    gfx.fillRect();
    dFrame.drawRectangles();
    dFrame.draw();
    */
    public void prepareDraw()
    {
        g2 = null;
        try 
        {
            // count Frames per second...
            countFPS();
            //Clear the buffer...
            g2 = bi.createGraphics();
            clearBackBuffer(g2);
        } finally {}
    }
    
    /*
    Draw all the graphics
    Called after an object is drawn
    */
    public void draw()
    {
        g = null;
        try
        {
            drawFPS(g2);
            //flip the buffer image...
            g = buffer.getDrawGraphics();
            g.drawImage( bi, 0, 0, null );
            if( !buffer.contentsLost() )
                buffer.show();
        }
        finally
        {
            // release resources...
            if( g != null ) 
                g.dispose();
            if( g2 != null ) 
                g2.dispose();
        }
    }
  
    /*
    Get the graphics object to draw with
    */
    public Graphics2D getG(){ return g2; }
    
    /*
    Get the state of the game (if it's running or not)
    */
    public boolean getRunningBool(){ return running; }
    
    /*
    Set the game's running boolean
    */
    //public void setRunningBool(boolean b){ running = b; }
    
    /*
    Get the width of the frame
    */
    public int getWidth(){ return width; }
    
    /*
    Get the height of the frame
    */
    public int getHeight(){ return height; }
    
    
    /*
    Helper methods for above methods:
    (Basically re-organized code that could have been in the above code, but this just makes it easier to read)
    */
    
    /*
    Clear the back buffer -- what we draw to before actually displaying
    */
    private void clearBackBuffer(Graphics2D g2)
    {
        // clear back buffer...
        g2.setColor( Color.BLACK );
        g2.fillRect( 0, 0, width, height );
    }
    
    /*
    Count the FPS
    */
    private void countFPS()
    {
        lastTime = curTime;
        curTime = System.currentTimeMillis();
        totalTime += curTime - lastTime;
        if( totalTime > 1000 ) 
        {
            totalTime -= 1000;
            fps = frames;
            frames = 0;
        } 
        ++frames;
    }
    
    /*
    Display the FPS
    */
    private void drawFPS(Graphics2D g2)
    {
        // display frames per second...
        g2.setFont( new Font( "Courier New", Font.PLAIN, 12 ) );
        g2.setColor( Color.GREEN );
        g2.drawString( String.format( "FPS: %s", fps ), 20, 20 );
    }
}
