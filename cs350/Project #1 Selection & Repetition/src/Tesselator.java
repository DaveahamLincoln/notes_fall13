// Fig. 5.26: Shapes.java
// Demonstrates drawing different shapes.
import java.awt.*;
import javax.swing.JPanel;

public class Tesselator extends JPanel  //Shapes inherits from Jpanel
{
   private int choice; // user's choice of which shape to draw
   private int pixels; //user's choice of pixels
   
   // constructor sets the user's choice
   public Tesselator ( int userPolyType, int userPixels )
   {
      choice = userPolyType;
      pixels = userPixels;
   } // end Tesselator constructor
   
   // draws a cascade of shapes starting from the top-left corner
   public void paintComponent( Graphics g )  //binds Graphics to g, sort of a reference thing.
   {
      super.paintComponent( g );
      
         // pick the shape based on the user's choice
      switch ( choice ){
      
            case 3: // draw triangles
            	int triangleHeight=(int) (Math.sqrt(3)*pixels);
                for ( int x = 0; x < 300; x=x+pixels ){
                	
                	for (int y = 0; y <300;y=y+triangleHeight) {
                		g.setColor(Color.red);
                		g.drawLine(x, y, 300, y);	//Horizontal
                		g.drawLine(x,y+triangleHeight/2,300,y+triangleHeight/2);	//RTL
                		g.drawLine(x, y, x+2*pixels,y+2*triangleHeight );	//LTR
                		g.drawLine(x+pixels, y, x, y+triangleHeight);
                		
                	}
            	}
            break;
            
            case 4: // draw rectangles
                for ( int x = 0; x < 300/pixels; x++ ){
                	
                	for (int y = 0; y <300/pixels;y++){
                		g.setColor(Color.blue);
                		g.drawRect( x*pixels, y*pixels, pixels, pixels ); //drawRect(x,y,w,h)
                	}
            	}
            break;

            case 6: // !!!draw hexagons!!!
            	g.setColor(Color.green);
            	int hexTriHeight=(int) (Math.sqrt(3)*pixels)/2;
                for (int y = 0; y <300;y=y+3*pixels) {
                		for ( int x = 0; x < 300; x=x+2*hexTriHeight ){
                			g.drawLine(x, y, x+hexTriHeight, y+pixels/2);	
                			g.drawLine(x+hexTriHeight,y+pixels/2,x+2*hexTriHeight,y);	
                			g.drawLine(x+hexTriHeight, y+pixels/2, x+hexTriHeight,y+pixels);
                			g.drawLine(x+hexTriHeight,y+pixels,x+hexTriHeight,y+pixels+pixels/2);
                			g.drawLine(x,y+pixels*2,x+hexTriHeight,y+pixels+pixels/2);//lower hex ne
                			g.drawLine(x+hexTriHeight,y+pixels+pixels/2, x+2*hexTriHeight, y+2*pixels);
                			g.drawLine(x, y+pixels*2, x, y+pixels*3);//Lower hex vert
                			g.drawLine(x, y+pixels*2, x-hexTriHeight, y+pixels+pixels/2);
                		}
                	}
                }
      		}
      
} // end method paintComponent
