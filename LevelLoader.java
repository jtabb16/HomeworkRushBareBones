/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jbt.fileIO;

import java.io.BufferedReader;
//import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.jbt.gameComponents.GenericTile;
import org.jbt.gameComponents.TransparentTile;
import org.jbt.gameComponents.Tile;

/**
 *
 * @author jbt
 */
public class LevelLoader 
{
    //File file;
    private final String nameOfFile;
    private Tile [][] tileMap;
    public LevelLoader(String fileName)
    {
        System.out.println("\nMaking New LevelLoader");
        nameOfFile = fileName;
        //primeFile(fileName);
        System.out.println("New LevelLoader Made");
    }
    
    /*
    private void primeFile(String fName)
    {
        //InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("com/me/myapp/myconfig.txt");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(fName);
        
        try
        {
            BufferedReader br = new BufferedReader (new InputStreamReader(is));
        }
        catch (NullPointerException e)
        {
            System.out.println("ERROR (NullPointerException) -- Unable to read file: " + fName);
        }
    }
    */
    
    //Load the tiles from a text file
    public void readFile()
    {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(nameOfFile);
        int numRowsOfTiles, numColsOfTiles;
        
        int x = 0;
        int y = 0;
        
        try
        {
            BufferedReader br = new BufferedReader (new InputStreamReader(is));
            numRowsOfTiles = Integer.parseInt(br.readLine());//Number of rows is on the first line
            numColsOfTiles = Integer.parseInt(br.readLine());//Number of columns is on the second line
            tileMap = new Tile[numRowsOfTiles][numColsOfTiles];
            
            System.out.println("TileMap will have " + tileMap.length + " Rows and " + tileMap[0].length + " Columns" );
            
            String delims = " ";//Using one space as a delimmiter in the level file
            for(int row = 0; row < numRowsOfTiles; row++) 
            {
                //System.out.println();
                //System.out.println("Row: " + row);
                String line = br.readLine();
                
                if (line == null){
                    System.out.println("ERROR: EMPTY TILE");
                    System.out.println("Make sure that the level-map file has specifies the correct dimensions");
                    System.out.println("Exiting with status 1 ( Good Luck Fixing The Error Jack :) )");
                    System.exit(1);
                }
                
                //System.out.println("d" + line + "p");
                String[] tokens = line.split(delims);
                for(int col = 0; col < numColsOfTiles; col++) 
                {
                    //System.out.println("Col: " + col);
                    String currentToken = tokens[col];
                    switch (currentToken)
                    {
                        case "GXXX":
                            tileMap[row][col] = new GenericTile(x,y);
                            //System.out.println("Generic Tile Made At: " + x + ", " + y);
                            break;
                        case "TRAN":
                            tileMap[row][col] = new TransparentTile(x,y);
                            //System.out.println("Null Tile Made At: " + x + ", " + y);
                            break;
                        default:
                            System.out.println("TOKEN FROM FILE NOT RECOGNIZED: " + tokens[col]);
                            break;
                    }
                    x+=Tile.getTileWidth();
                }
                x = 0;//Reset to the left side
                y +=Tile.getTileHeight();//The tile Height -- Shift down one tile each time
            }
        }
        catch (NullPointerException | IOException e)
        {
            if (e.equals("NullPointerException"))
                System.out.println("ERROR (NullPointerException) -- Unable to read file: " + nameOfFile);
            else if (e.equals("IOException"))
                System.out.println("ERROR (IOException) -- Unable to read line in file: " + nameOfFile);
        }
    }
    
    public Tile[][] getTiles(){ return tileMap; }
}
