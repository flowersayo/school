import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Ex4 extends JFrame {

	public Ex4() {
		
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
				
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addMouseListener(new LastMouseListener());

		c.addMouseMotionListener(new LastMouseListener());
		setSize(250,200);
		setVisible(true);
	}
	
	class LastMouseListener extends MouseAdapter{

		private int count = 0;
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mousePressed(e);
			count++;  System.out.println("press");
		}

		

		public void mouseReleased(MouseEvent e) { System.out.print(count); }

		public void mouseDragged(MouseEvent e) { count++; System.out.println("drag");} 
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex4();
	}

}