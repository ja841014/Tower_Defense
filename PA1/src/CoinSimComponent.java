// it is same function as CarComponent
/*
 * Extends JComponent. 
 * Constructor initializes any necessary data and runs the simulation. 
 * Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. 
 * This class uses the CoinTossSimulator and Bar class.
 * */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   This component draws two car shapes.
*/
public class CoinSimComponent extends JComponent
{  
	private int TwoHeads;
	private int TwoTails;
	private int HeadTail;
	private int Total_Trials;
	// Bar fixed feature 
	public final static int BAR_WIDTH = 30;
	public final int VERTICAL_BUFFER = 30;
	
	
	public CoinSimComponent(int TwoHeads, int TwoTails, int HeadTail, int Total_Trials) {
		this.TwoHeads = TwoHeads;
		this.TwoTails= TwoTails;
		this.HeadTail = HeadTail;
		this.Total_Trials = Total_Trials;
	}
	
//	public static int getBarWidth() {
//		return BAR_WIDTH;
//	}

	
   public void paintComponent(Graphics g)
   {  

      Graphics2D g2 = (Graphics2D) g;
      int tallestBar = getHeight() - 2 * VERTICAL_BUFFER;
      int bottom = getHeight() - VERTICAL_BUFFER;
      
      // scale set up
      double scale_bar1 = ((double)TwoHeads/(double)Total_Trials);
      double scale_bar2 = ((double)HeadTail/(double)Total_Trials);
      double scale_bar3 = ((double)TwoTails/(double)Total_Trials);
      
      // bar height set up
      int bar_height1 = (int) Math.round(tallestBar * scale_bar1);
      int bar_height2 = (int) Math.round(tallestBar * scale_bar2);
      int bar_height3 = (int) Math.round(tallestBar * scale_bar3);
      
      // color set up
      Color color1 = Color.RED;
      Color color2 = Color.GREEN;
      Color color3 = Color.BLUE;
      
      // label set up
      String str1 = "Two Heads: " + TwoHeads + "(" + (int)(Math.round(scale_bar1 * 100)) + "%)";
      String str2 = "A Head and a tail: " + HeadTail + "(" + (int)(Math.round(scale_bar2 * 100)) + "%)";
      String str3 = "Two Tails: " + TwoTails + "(" + (int)(Math.round(scale_bar3 * 100)) + "%)";
      
      // Bar constructor
      Bar bar1 = new Bar(bottom, getWidth() / 4 - BAR_WIDTH / 2, BAR_WIDTH , bar_height1, scale_bar1, color1, str1);
      Bar bar2 = new Bar(bottom, getWidth() / 2 - BAR_WIDTH / 2, BAR_WIDTH, bar_height2, scale_bar2, color2, str2);
      Bar bar3 = new Bar(bottom, (int)(getWidth() * 0.75) - BAR_WIDTH / 2, BAR_WIDTH, bar_height3, scale_bar3, color3, str3);
      
      // Draw
      bar1.draw(g2);
      bar2.draw(g2);
      bar3.draw(g2);
       
   }


}
