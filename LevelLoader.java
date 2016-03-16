package org.jbt.synthesizedGameComponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.jbt.gameComponents.GenericTile;
import org.jbt.gameComponents.NullTile;
import org.jbt.gameComponents.Tile;

/**
 *
 * @author jbt
 */
public class LevelLoader 
{
    Tile [][] tileMap;
    int levelNum;
    public LevelLoader(int levelNum)
    {
        this.levelNum = levelNum;
        System.out.println("New LevelLoader Made");
    }
    
    /**
     *
     */
    protected void loadLevelMap()
    {
        //Load the tiles for levelNum from a text file
        int numRowsOfTiles, numColsOfTiles;
        try {
            String s = "/"  + levelNum + ".level";
            //InputStream in = getClass().getResourceAsStream(s);
            //String locationOfS = "/resources/levels/"+String.valueOf(levelNum)+".level";
            
            URL location = LevelLoader.class.getProtectionDomain().getCodeSource().getLocation();
            URL url = new URL (location + "levels/" + s);
            
           // InputStream in = ((new URL (getClass().getResourceAsStream("s"))).openStream());
            //InputStream in = getClass().getResourceAsStream(locationOfS);
            InputStream in = url.openStream();
            
            //if (url == null)
                //System.out.println("File For Level " + levelNum + " NOT FOUND: " + "'" + url + "'");
                
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            //BufferedReader br = new BufferedReader (new InputStreamReader (getClass().getResourceAsStream("../resources" + s)));
            numRowsOfTiles = Integer.parseInt(br.readLine());//Number of rows is on the first line
            numColsOfTiles = Integer.parseInt(br.readLine());//Number of columns is on the second line
            tileMap = new Tile[numRowsOfTiles][numColsOfTiles];
            
            System.out.println("TileMap will have " + tileMap.length + " Rows and " + tileMap[0].length + " Columns" );
            //width = numCols * tileSize;
            //height = numRows * tileSize;

            //xmin = GamePanel.WIDTH - width;
            //xmax = 0;
            //ymin = GamePanel.HEIGHT - height;
            //ymax = 0;

            int x = 0;
            int y = 0;
            
            
            String delims = " ";
            for(int row = 0; row < numRowsOfTiles; row++) 
            {
                System.out.println("Row: " + row);
                String line = br.readLine();
                System.out.println(line);
                String[] tokens = line.split(delims);
                System.out.println();
                for(int col = 0; col < numColsOfTiles; col++) 
                {
                    System.out.println("Col: " + col);
                    if (tokens[col].equals("GXXX"))
                    {
                        tileMap[row][col] = new GenericTile(x,y);
                        System.out.println(x + ", " + y);
                    }
                    else if (tokens[col].equals("TRAN"))
                    {
                        //tileMap[numTilesWide][numTilesHigh] = new Tile(tokens[col]);
                        //tileMap[row][col] = null;
                        tileMap[row][col] = new NullTile(x,y);
                        System.out.println("Null Tile Made");
                    }
                    else
                    {
                        System.out.println("TOKEN FROM LEVELMAP " + levelNum + " NOT RECOGNIZED: " + tokens[col]);
                    }
                    x += Tile.getTileWidth();//The tile width
                }
                x = 0;
                y +=Tile.getTileHeight();//The tile Height
            }
            
        }
        catch(IOException | NumberFormatException e) 
        {
            e.printStackTrace();
        }
    }
    
    protected Tile[][] getTiles()
    {
        //int mapWidth=0, mapHeight=0;
        //Tile[][] tileMap = new Tile [mapWidth][mapHeight];
        
        return tileMap;
    }
}
