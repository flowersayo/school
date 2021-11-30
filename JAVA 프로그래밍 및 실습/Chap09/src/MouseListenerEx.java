	import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

	public class MouseListenerEx extends JFrame {

		JLabel la=new JLabel("Hello");
		
		public MouseListenerEx () {
			setTitle("마우스 이벤트 예제");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Container c=getContentPane();
			c.setLayout(null);
			la.setSize(50,20);
			//setLocale아님! 
			la.setLocation(30,30);
			c.add(la);
			
			//label이 아닌 contentpane에 이벤트 리스터 붙임.
			c.addMouseListener(new MyMouseListener());
			//Frame 크기 설정
			setSize(200,200);
			setVisible(true);
			
			
		}
		
		// 1. MouseAdapter이용 
		class MyMouseListener extends MouseAdapter{
			
			//mousePressed만 구현하면 됨.
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int x=e.getX(); // x좌표
				int y=e.getY(); // y좌표
				la.setLocation(x,y); // 마우스가 움직인 곳으로 라벨의 좌표 변경
				super.mousePressed(e);
			}
		}
		
		// 1.MouseListener이용 : interface이기때문에 추상메소드 구현 필요
		
		/*
	
		class MyMouseListener implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x=e.getX(); // x좌표
				int y=e.getY(); // y좌표
				la.setLocation(x,y); // 마우스가 움직인 곳으로 라벨의 좌표 변경
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		*/
			
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new MouseListenerEx();
		}

	}
