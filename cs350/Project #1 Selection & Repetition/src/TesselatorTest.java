// Fig. 5.27: ShapesTest.java
// Test application that displays class Shapes.
import java.io.*;	// added by Zhang
import java.util.*;	// added by Zhang
import javax.swing.JFrame;
//import javax.swing.JOptionPane;

public class TesselatorTest
{
   public static void main( String[] args )
   {
      // obtain user's choice
//      String input = JOptionPane.showInputDialog(
//         "Enter 1 to draw rectangles\n" +
//         "Enter 2 to draw ovals" );
//      
//      int choice = Integer.parseInt( input ); // convert input to int

	  // added by Zhang
	  int choice=1;
	  int choice2=2;
	  Scanner input;
	  
	  //exception handling. try/catch block
	  try {
		  input=new Scanner(new File("tesselate.txt"));
		  choice=input.nextInt(); //
		  choice2=input.nextInt();
		  input.close();
	  }
	  catch (IOException e) {
		   System.err.println(e);
		   System.exit(1);
	  }
	  // end of addition by Zhang
	   
      // create the panel with the user's input
      // Shapes panel = new Shapes( choice );
      Tesselator panel = new Tesselator( choice, choice2 );
      
      JFrame application = new JFrame("Tesselation"); // creates a new JFrame

      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.add( panel ); // add the panel to the frame
      application.setSize( 300, 300 ); // set the desired size
      application.setVisible( true ); // show the frame
   } // end main
} // end class ShapesTest
