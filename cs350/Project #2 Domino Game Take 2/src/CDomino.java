 //CS350, Project #2, 
 //Dave Nearing
 //CDomino class for individual Dominos in a Domino game.

import java.awt.Color;
import java.awt.Graphics;

public class CDomino
{
    private int cornerX;
    private int cornerY;
    private int xWide;
    private int yWide;
    private int offset;
    private int dots;
    private double[] Xs;
    private double[] Ys;
	private int rotIndex;

    public CDomino(int x, int y, int w, int numSpots1, int numSpots2)
    {
        int spotMatrix[][][] = {
            {new int[3], new int[3], new int[3]}, //blank 
            {new int[3], {0, 1, 0},  new int[3]}, //1
            {{1, 0, 0},  new int[3], {0, 0, 1} }, //2
            {{1, 0, 0},  {0, 1, 0},  {0, 0, 1} }, //3
            {{1, 0, 1},  new int[3], {1, 0, 1} }, //4
            {{1, 0, 1},  {0, 1, 0},  {1, 0, 1} }, //5
            {{1, 0, 1},  {1, 0, 1},  {1, 0, 1} }  //6
        };
        offset = 3;
        
        cornerX = x;
        cornerY= y;
        xWide = x + w;
        yWide = y + 2 * w;
        dots = numSpots1 + numSpots2;
        Xs = new double[dots];
        Ys = new double[dots];
        rotIndex=0;

        int index = 0;  //keeps track of which (X,Y) dot slot you're filling in.
        int border = 4; //size of the border around the dots
        int change = (w - 2 * border) / 2;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                if(spotMatrix[numSpots1][i][j] == 1)
                {
                    Xs[index] = x + border + j * change;
                    Ys[index] = y + border + i * change;
                    index++;
                }

        }

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
                if(spotMatrix[numSpots2][i][j] == 1)
                {
                    Xs[index] = x + border + j * change;
                    Ys[index] = y + w + border + i * change;
                    index++;
                }

        }

    }

    public int getCenterTall()
    {
        return (cornerX + xWide) / 2;
    }

    public int getCenterLong()
    {
        return (cornerY + yWide) / 2;
    }

    public boolean isInside(int x, int y)
    {
        return x >= cornerX && x < xWide && y >= cornerY && y < yWide;
    }

    public void drag(int dx, int dy)
    {
        cornerX += dx;
        cornerY += dy;
        xWide += dx;
        yWide += dy;
        for(int i = 0; i < (int)dots; i++)
        {
            Xs[i] += dx;
            Ys[i] += dy;
        }

    }

    public void rotate(int newX, int newY)
    {
        double swap = newX + (cornerY - newY);
        cornerY = newY - (cornerX - newX);
        cornerX = (int) swap;
        double swapWide = newX + (yWide - newY);
        yWide = newY - (xWide - newX);
        xWide = (int) swapWide;
        switch(rotIndex%2){
        //I don't know why this doesn't work.
        	case(0):
        		int vs1 = cornerY;
        		cornerY = yWide;
        		yWide = vs1;
        		rotIndex++;
        		break;
        	case(1):
        		rotIndex++;
        		break;
        		}
        
        for(int i = 0; i < dots; i++)
        {
            swapWide = newX + (Ys[i] - newY);
            Ys[i] = newY - (Xs[i] - newX);
            Xs[i] = swapWide;
        }

    }


    public void draw(Graphics g)
    {
        g.setColor(Color.gray);
        g.fillRect(cornerX, cornerY, xWide - cornerX, yWide - cornerY);
        g.setColor(Color.red);
        for(int i = 0; i < dots; i++)
            g.fillOval((int)Xs[i] - offset, (int)Ys[i] - offset, 5, 5);

        if(yWide - cornerY > xWide - cornerX)
            g.drawLine(cornerX, (cornerY + yWide)/2, xWide, (cornerY + yWide)/2); //middle line tall
        else
            g.drawLine((cornerX + xWide) / 2, cornerY, (cornerX + xWide) / 2, yWide); //middle line wide
        g.setColor(Color.blue);
        g.drawRect(cornerX, cornerY, xWide - cornerX, yWide - cornerY);
    }

}
