import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyCharEx extends JFrame {

	JLabel la=new JLabel("엔터키로 배경색이 바뀝니다.");
			
	public KeyCharEx(){
		super("키보드 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(la);
		c.addKeyListener(new MyKeyListner());
		// 창이 여러개 떠있을때 포커스 잡기
		
		
		//키보드만 사용하는 경우 붙여줄것.
		c.setFocusable(true);
		c.requestFocus();

		setSize(250,150);
		setVisible(true);
	}
	class MyKeyListner extends KeyAdapter{
		
		//엔터키가 눌리면 랜덤 색상으로 배경색 변경하기.
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
			int r =(int)(Math.random()*256);
			int g=(int)(Math.random()*256);
			int b= (int)(Math.random()*256);
			
			// 1. KeyEvent.getKeyChar() : 키의 문자코드(유니코드) 알아내기 
			// 2. KeyEvent.getKeyCode() : 입력된 키의 가상 키 값 알아내기
			// 3. keyEvent.getKeyText(keyCode) : keyCode의 코드 값에 해당하는 키의 이름 문자열 리턴 ex) F1,SHIFT
			
			System.out.println(e.getKeyText(10));
			switch (e.getKeyChar()) {
			

			case '\n': 
				la.setText("r= " +r+","+"g = "+g+","+"b = "+b);
				
				getContentPane().setBackground(new Color(r,g,b));
				break;
			case 'q' : 
				System.exit(0); // 시스템 완전 종료
			}

		
			//super.keyPressed(e);
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new KeyCharEx();
	}

}
