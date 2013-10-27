 //CS350, Project #2, 
 //Dave Nearing
 //Dominoes class (Domino board and actions) in a Domino game.

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JApplet;
import javax.swing.JFrame;

import java.util.Random;  //for drawing tiles

public class Dominoes extends JApplet
    implements KeyListener, MouseListener, MouseMotionListener
{
	
    private int player1Line;
    private int player2Line;
    private ArrayList top;
    private ArrayList bot;
    private ArrayList table;
    private int startX;
    private int startY;
    private CDomino target;
    boolean isInitialized;

    public Dominoes()
    {
        isInitialized = false;
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    private void setInitState()
    {
        int width = 40;
        int spacing = 20;
        int start_y = 20;
        int start_x = 10;
        player1Line = 100;
        player2Line = getSize().height - player1Line;
        ArrayList whole_set = new ArrayList();
        for(int i = 0; i <= 6; i++)
        {
            for(int j = i; j <= 6; j++)
                whole_set.add(new CDomino(0, 0, 30, i, j));

        }

        Random drawTiles = new Random();
        top = new ArrayList();
        for(int i = 0; i < 7; i++)
        {
            int index = drawTiles.nextInt(whole_set.size());
            CDomino p = (CDomino)whole_set.get(index);
            whole_set.remove(index);
            top.add(p);
            p.drag(start_x + i * (width + spacing), start_y);
        }

        bot = new ArrayList();
        for(int i = 0; i < 7; i++)
        {
            int index = drawTiles.nextInt(whole_set.size());
            CDomino p = (CDomino)whole_set.get(index);
            whole_set.remove(index);
            bot.add(p);
            p.drag(start_x + i * (width + spacing), player2Line + start_y);
        }

        table = new ArrayList();
        target = null;
    }

    public void paint(Graphics g)
    {
        if(!isInitialized)
        {
            isInitialized = true;
            setInitState();
        }
        Image backBuffer = createImage(getSize().width, getSize().height);
        Graphics gBackBuffer = backBuffer.getGraphics();
        gBackBuffer.setColor(Color.white);
        gBackBuffer.clearRect(0, 0, getSize().width, getSize().height);
        for(int i = 0; i < top.size(); i++)
            ((CDomino)top.get(i)).draw(gBackBuffer);

        for(int i = 0; i < bot.size(); i++)
            ((CDomino)bot.get(i)).draw(gBackBuffer);

        for(int i = 0; i < table.size(); i++)
            ((CDomino)table.get(i)).draw(gBackBuffer);

        gBackBuffer.setColor(Color.blue);
        gBackBuffer.drawLine(0, player1Line, getSize().width, player1Line);
        gBackBuffer.drawLine(0, player2Line, getSize().width, player2Line);
        g.drawImage(backBuffer, 0, 0, null);
    }

    public void keyPressed(KeyEvent keyevent)
    {
    }

    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == 82)
        {
            setInitState();
            repaint();
        }
    }

    public void keyTyped(KeyEvent keyevent)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
        if(!e.isMetaDown())
            return;
        for(int i = table.size() - 1; i >= 0; i--)
        {
            CDomino p = (CDomino)table.get(i);
            if(p.isInside(e.getX(), e.getY()))
            {
                p.rotate(p.getCenterTall(), p.getCenterLong());
                table.remove(i);
                table.add(p);
                repaint();
                return;
            }
        }

        for(int i = top.size() - 1; i >= 0; i--)
        {
            CDomino p = (CDomino)top.get(i);
            if(p.isInside(e.getX(), e.getY()))
            {
                top.remove(i);
                top.add(p);
                p.rotate(p.getCenterTall(), p.getCenterLong());
                repaint();
                return;
            }
        }

        for(int i = bot.size() - 1; i >= 0; i--)
        {
            CDomino p = (CDomino)bot.get(i);
            if(p.isInside(e.getX(), e.getY()))
            {
                bot.remove(i);
                bot.add(p);
                p.rotate(p.getCenterTall(), p.getCenterLong());
                repaint();
                return;
            }
        }

    }

    public void mousePressed(MouseEvent e)
    {
        if(e.isMetaDown())
            return;
        for(int i = table.size() - 1; i >= 0; i--)
        {
            CDomino p = (CDomino)table.get(i);
            if(p.isInside(e.getX(), e.getY()))
            {
            	startX = e.getX();
                startY = e.getY();
                table.remove(i);
                table.add(p);
                target = p;
                repaint();
                return;
            }
        }

        for(int i = top.size() - 1; i >= 0; i--)
        {
            CDomino p = (CDomino)top.get(i);
            if(p.isInside(e.getX(), e.getY()))
            {
            	startX = e.getX();
                startY = e.getY();
                top.remove(i);
                table.add(p);
                target = p;
                repaint();
                return;
            }
        }

        for(int i = bot.size() - 1; i >= 0; i--)
        {
            CDomino p = (CDomino)bot.get(i);
            if(p.isInside(e.getX(), e.getY()))
            {
                bot.remove(i);
                table.add(p);
                target = p;
                startX = e.getX();
                startY = e.getY();
                repaint();
                return;
            }
        }

    }

    public void mouseReleased(MouseEvent e)
    {
        target = null;
    }

    public void mouseEntered(MouseEvent mouseevent)
    {
    }

    public void mouseExited(MouseEvent mouseevent)
    {
    }

    public void mouseMoved(MouseEvent mouseevent)
    {
    }

    public void mouseDragged(MouseEvent e)
    {
        if(e.isMetaDown())
            return;
        if(target != null)
        {
            target.drag(e.getX() - startX, e.getY() - startY);
            startX = e.getX();
            startY = e.getY();
            repaint();
        }
    }

    public static void main(String args[])
    {
        JFrame application = new JFrame("Dominoes");
        Dominoes dominoesPanel = new Dominoes();
        application.add(dominoesPanel);
        application.setDefaultCloseOperation(3);
        application.setSize(1024, 7680);
        application.setVisible(true);
    }

}
