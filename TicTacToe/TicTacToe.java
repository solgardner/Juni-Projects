
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
public class TicTacToe extends Applet implements MouseListener
{
    public int X;
    public int Y;
    public int winCondition = -1;
    public String[][] BoardChar = {{"-","-","-"},
                                   {"-","-","-"},
                                   {"-","-","-"}};
    public boolean isPlayerX = true;
                                   
    public void init()
    {
        addMouseListener(this);
        setBackground(Color.black);
    }
    
    public void mousePressed (MouseEvent e)
    {
        X = (int)(e.getX() / 200);
        Y = (int)(e.getY() / 200);
        if(isPlayerX)
        {
        BoardChar[X][Y] = "X";
        } else
        {
            BoardChar[X][Y] = "O";
        }
        winCondition = checkWins(isPlayerX);
        isPlayerX = !isPlayerX;
        repaint();
    }
    
    public void mouseClicked (MouseEvent e) {}
    public void mouseEntered (MouseEvent e) {}
    public void mouseExited (MouseEvent e) {}
    public void mouseReleased (MouseEvent e) {}
    
    public void resetBoard() {
        try{TimeUnit.SECONDS.sleep(2);}
        catch(Exception e){};
        BoardChar[0][0] = "-";
        BoardChar[0][1] = "-";
        BoardChar[0][2] = "-";
        BoardChar[1][0] = "-";
        BoardChar[1][1] = "-";
        BoardChar[1][2] = "-";
        BoardChar[2][0] = "-";
        BoardChar[2][1] = "-";
        BoardChar[2][2] = "-";
        winCondition = -1;
        isPlayerX = true;
        repaint();
    }
    
    public void paint(Graphics g)
    {
        Board b = new Board(BoardChar);
        b.draw(g);
        g.setFont(new Font("default",Font.BOLD, 50));
        if(winCondition != -1) {
            if(winCondition == 0){
                g.drawString("X Wins!", 200,200);
                resetBoard();
            }
            if(winCondition == 1){
                g.drawString("O Wins!", 200,200);
                resetBoard();
            }
            if(winCondition == 2){
                g.drawString("It's a tie!", 200,200);
                resetBoard();
            }
        }
    }
    
    
    //Returns 0 if X wins, 1 if O wins, 2 if a tie, and -1 if the game is not over
    public int checkWins(boolean X)
    {
        String current;
        int r;
        if(X) {
            current = "X";
            r = 0;
        } else {
            current = "O";
            r = 1;
        }
        
        //Win conditions for X
        if(BoardChar[0][0] == current && BoardChar[0][1] == current && BoardChar[0][2] == current) {
            return r;
        }
        if(BoardChar[1][0] == current  && BoardChar[1][1] == current && BoardChar[1][2] == current) {
            return r;
        }
        if(BoardChar[2][0] == current  && BoardChar[2][1] == current && BoardChar[2][2] == current) {
            return r;
        }
        if(BoardChar[0][0] == current  && BoardChar[1][0] == current && BoardChar[2][0] == current) {
            return r;
        }
        if(BoardChar[0][1] == current  && BoardChar[1][1] == current && BoardChar[2][1] == current) {
            return r;
        }
        if(BoardChar[0][2] == current  && BoardChar[1][2] == current && BoardChar[2][2] == current) {
            return r;
        }
        if(BoardChar[0][0] == current  && BoardChar[1][1] == current && BoardChar[2][2] == current) {
            return r;
        }
        if(BoardChar[0][2] == current  && BoardChar[1][1] == current && BoardChar[2][0] == current) {
            return r;
        }
        for (int x = 0; x < BoardChar.length; x++)
        {
            for(int y = 0; y < BoardChar[x].length; y++) {
                
                if(BoardChar[x][y] == "-") {
                    return -1;
                }
            }
        }
        return 2;
    }
}
