// Fig. 14.34: PaintFrame.java
// Using class MouseMotionAdapter.
// import java.awt.Point;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

class CMyPoint {
	public CMyPoint(int x, int y) {
		X=x;
		Y=y;
	}
	
	public int getX() { return X; }
	public void setX(int x) { X=x; }
	public int getY() { return Y; }
	public void setY(int y) { X=y; }

	public double distanceTo(int x, int y) {
		return Math.sqrt((x-X)*(x-X)+(y-Y)*(y-Y));
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
        g.fillOval( X, Y, 4, 4 );
	}
	
	private int X;
	private int Y;
}

public class PaintPanel extends JPanel  
	implements MouseListener, MouseMotionListener
{

	private ArrayList<CMyPoint> points;  

	// init and register mouse event handler
    public PaintPanel()
    {
        points=new ArrayList<CMyPoint>();

	    // handle frame mouse and mouse motion events
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    } // end PaintFrame constructor

    // draw ovals in a 4-by-4 bounding box at specified locations on window
    public void paintComponent( Graphics g )
    {
    	boolean bUseDoubleBuffering=false;
    	
    	if (bUseDoubleBuffering) {
	        // super.paintComponent( g ); // clears drawing area
	
	    	Image backBuffer=createImage(getSize().width, getSize().height);
	    	Graphics gBackBuffer=backBuffer.getGraphics();
	    	
	        // draw all points in array
	        for ( int i = 0; i < points.size(); i++ ) {
	        	 points.get(i).draw(gBackBuffer);
	        }
	        
	        g.drawImage(backBuffer, 0, 0, null);
    	}
    	else {
	        super.paintComponent( g ); // clears drawing area
    		
	        // draw all points in array
	        for ( int i = 0; i < points.size(); i++ ) {
	        	 points.get(i).draw(g);
	        }
    	}
    } // end method paintComponent
    
    // MouseListener event handlers
    public void mouseClicked( MouseEvent e )
    {
        if (e.isMetaDown()) {	// right button
            for ( int i = points.size()-1; i >= 0; i-- ) {
            	if (points.get(i).distanceTo(e.getPoint().x, e.getPoint().y)<50) {
            		points.remove(i);
            	}
            }
            repaint();        	
        }
    }

    public void mousePressed( MouseEvent e )
    {
    	if (e.isMetaDown()) return;	// ignore right button
        
    	points.add(new CMyPoint(e.getPoint().x, e.getPoint().y)); // add point
        repaint();
    }

    public void mouseReleased( MouseEvent e )
    {
    }

    public void mouseEntered( MouseEvent e )
    {
    }

    public void mouseExited( MouseEvent e )
    {
    }

    public void mouseMoved( MouseEvent e )
    {
    }
    
    public void mouseDragged( MouseEvent e )
    {
        if (e.isMetaDown()) return;	// ignore right button
    	
        points.add(new CMyPoint(e.getPoint().x, e.getPoint().y)); // add point
        repaint();
    } // end method mouseDragged
} // end class PaintPanel


/**************************************************************************
 * (C) Copyright 1992-2010 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/