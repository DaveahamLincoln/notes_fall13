import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;

import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Dominos extends JApplet  
// public class Dominos extends JPanel  
	implements KeyListener, MouseListener, MouseMotionListener
{
	// state representation
	private ArrayList<CDomino> blocks;  

	private boolean isShiftDown;
	private boolean isCtrlDown;

	private CDomino BlockToBeMoved;
	private int m_nOldX;
	private int m_nOldY;
	
    public Dominos()	// constructor
    {
		// Initial State    	
    	
		blocks = new ArrayList<CDomino>();
		//blocks.add(new CPiece(400, 300, 300, 200, 300, 400));
		//blocks.add(new CPiece(400, 300, 450, 350, 500, 300, 450, 250));
    	blocks.add(new CDomino(50, 130, 100, 130, 100, 30, 50, 30, 2,6));
    	blocks.add(new CDomino(110, 130, 160, 130, 160, 30, 110, 30, 2,6));	
    	blocks.add(new CDomino(170, 130, 220, 130, 220, 30, 170, 30, 2,6));
    	blocks.add(new CDomino(230, 130, 280, 130, 280, 30, 230, 30, 2,6));
    	blocks.add(new CDomino(290, 130, 340, 130, 340, 30, 290, 30, 2,6));	
    	blocks.add(new CDomino(350, 130, 400, 130, 400, 30, 350, 30, 2,6));
    	blocks.add(new CDomino(410, 130, 460, 130, 460, 30, 410, 30, 2,6));
    	
    	blocks.add(new CDomino(50, 700, 100, 700, 100, 600, 50, 600, 2,6));
    	blocks.add(new CDomino(110, 700, 160, 700, 160, 600, 110, 600, 2,6));	
    	blocks.add(new CDomino(170, 700, 220, 700, 220, 600, 170, 600, 2,6));
    	blocks.add(new CDomino(230, 700, 280, 700, 280, 600, 230, 600, 2,6));
    	blocks.add(new CDomino(290, 700, 340, 700, 340, 600, 290, 600, 2,6));	
    	blocks.add(new CDomino(350, 700, 400, 700, 400, 600, 350, 600, 2,6));
    	blocks.add(new CDomino(410, 700, 460, 700, 460, 600, 410, 600, 2,6));
    	//?? ?? top right ??
    	
		isShiftDown=false;
		isCtrlDown=false;

		BlockToBeMoved=null; // no shape selected 
		
        // handle key, mouse and mouse motion events
		this.setFocusable(true);
		this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    // State Presentation
    public void paint( Graphics g )
    {
		// State Presentation, using double buffers
    	// create the back buffer
    	Image backBuffer=createImage(getSize().width, getSize().height);
    	Graphics gBackBuffer=backBuffer.getGraphics();
		// clear the back buffer
		gBackBuffer.setColor(Color.white);
		gBackBuffer.clearRect(0, 0, getSize().width, getSize().height);
		// draw the pieces to back buffer
		for (int i=0; i<blocks.size(); i++) {
			blocks.get(i).draw(gBackBuffer);
		}
		// copy from back buffer to front
		g.drawImage(backBuffer, 0, 0, null);
    } // end method paintComponent
    
    // KeyListener event handlers
    public void keyPressed( KeyEvent e )
    {
		if (e.getKeyCode()==KeyEvent.VK_SHIFT) isShiftDown=true;
		if (e.getKeyCode()==KeyEvent.VK_CONTROL) isCtrlDown=true;   	
    }
    
    public void keyReleased( KeyEvent e )
    {
		if (e.getKeyCode()==KeyEvent.VK_SHIFT) isShiftDown=false;
		if (e.getKeyCode()==KeyEvent.VK_CONTROL) isCtrlDown=false;   	    	
    }

    public void keyTyped( KeyEvent e )
    {    	
    }

    // MouseListener event handlers
    public void mouseClicked( MouseEvent e )
    {
		if (!isShiftDown && !isCtrlDown) return;
    	if (e.isMetaDown()) return;	// ignore right button

    	for (int i=blocks.size()-1; i>=0; i--) {
    		CDomino p=blocks.get(i);
			if (p.isInside(e.getX(), e.getY())) {
				p.rotate(isShiftDown?90:-90);	// note difference btw coordinate systems 
				blocks.remove(i);
				blocks.add(p);	// move to the end, i.e. the top
				repaint();
				break;
			}
		}
    }

    public void mousePressed( MouseEvent e )
    {
		if (isShiftDown || isCtrlDown) return;
    	if (e.isMetaDown()) return;	// ignore right button
        
		// search from top down (i.e. back to front)
		for (int i=blocks.size()-1; i>=0; i--) {
			CDomino p=blocks.get(i);
			if (p.isInside(e.getX(), e.getY())) {
				blocks.remove(i);
				blocks.add(p);	// move to the end, i.e. the top
				BlockToBeMoved=p;
				m_nOldX=e.getX();
				m_nOldY=e.getY();
				repaint();
				break;
			}
		}
    }

    public void mouseReleased( MouseEvent e )
    {
		BlockToBeMoved=null; // no shape selected
   }

    public void mouseEntered( MouseEvent e )
    {
    }

    public void mouseExited( MouseEvent e )
    {
    }

    // MouseMotionListener event handlers
    public void mouseMoved( MouseEvent e )
    {
    }
    
    public void mouseDragged( MouseEvent e )
    {
        if (e.isMetaDown()) return;	// ignore right button
    	
		if (BlockToBeMoved!=null) {
			BlockToBeMoved.translate(e.getX()-m_nOldX, e.getY()-m_nOldY);
			m_nOldX=e.getX();
			m_nOldY=e.getY();
			repaint();
		}

    }

    // The main function for the application
	public static void main(String[] args) {
		JFrame application = new JFrame( "Tangram" );
	      
		Dominos tangramPanel = new Dominos();
		application.add(tangramPanel);
	  
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		application.setSize( 1024, 768 ); // set frame size
		application.setVisible( true ); // display frame
	}
}
