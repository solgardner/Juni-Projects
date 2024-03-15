import java.awt.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends TicTacToe
{
    // instance variables - replace the example below with your own
    public String[][] BoardText;
    /**
     * Constructor for objects of class Board
     */
    public Board(String[][] bt)
    {
        BoardText = bt;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void draw(Graphics g)
    {
        //Draw Lines for board
        g.setColor(Color.white);
        g.drawLine(200,0,200,600);
        g.drawLine(400,0,400,600);
        g.drawLine(0,200,600,200);
        g.drawLine(0,400,600,400);
        
        //Draw chars in board
        g.setFont(new Font("ComicSans",Font.ITALIC, 50));
        for(int x = 0; x < BoardText.length; x++) {
            for (int y = 0; y < BoardText[x].length; y++) {
                    g.drawString(BoardText[x][y], x * 200 + 75, y * 200 + 125);
            }
        }
    }
}
