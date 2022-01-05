import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintJPanelEx extends JFrame {

	
	public PaintJPanelEx() {
		setTitle("JPanel의 페인트 컴포넌트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel()); // 컨텐트팬을 가져와서 붙이는게 아니라 panel자체를 컨텐트팬으로 설정.
		setSize(250,200);
		setVisible(true);
		
	}
	 
	class MyPanel extends JPanel{
		
		//pa 까지만치고 ctrl-enter 누르면 자동완성
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.fillRect(10,10,50,50);
			g.fillRect(50,50,50,50);
			
			g.setColor(Color.MAGENTA);
			g.drawRect(90,90,50,50);
		}
		
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PaintJPanelEx();
	}

}
