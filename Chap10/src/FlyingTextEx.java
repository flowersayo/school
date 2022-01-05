import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlyingTextEx extends JFrame {

	JLabel la = new JLabel("HELLO");
	
	public FlyingTextEx() {
		super("텍스트 날아라");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		la.setSize(50,50);
		la.setLocation(100,20);
		c.add(la);
		
		setSize(200,200);
		setVisible(true);
		
		// 이벤트를 c말고 la에 붙여도 되나? 가능! 대신 포커스를 la에 주어야함.
		la.addKeyListener(new MyKeyListener( ));
		
		la.setFocusable(true);
		la.requestFocus();
	}
	
	//Listener 는 extends 상속. Adapter는 implements 구현
	class MyKeyListener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			
			//getKeyCode는 String이 아니라 int! 
			int keycode = e.getKeyCode(); // 이벤트가 발생하면 키 코드값 가져옴. 
			
			switch (keycode) {
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(),la.getY()-10);
				break;
				
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(),la.getY()+10);
				break;
				
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX()-10,la.getY());
				break;
				
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX()+10,la.getY());
				break;
				

			}
			super.keyPressed(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlyingTextEx();
	}

}
