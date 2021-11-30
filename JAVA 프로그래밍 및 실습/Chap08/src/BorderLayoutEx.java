import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx extends JFrame{

	public BorderLayoutEx() {
		
		setTitle("BorderLayout 예시");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane=getContentPane();
		
		//새로운 배치관리자 설정.
		// BorderLayout : 컨테이너의 공간을 5구역으로 분할 배치
		// add( 컴포넌트, 위치 )
		contentpane.setLayout(new BorderLayout()); //
		
		contentpane.add(new JButton("add"),BorderLayout.NORTH);
		contentpane.add(new JButton("sub"),BorderLayout.SOUTH);
		contentpane.add(new JButton("div"),BorderLayout.WEST);
		contentpane.add(new JButton("mul"),BorderLayout.EAST);
		contentpane.add(new JButton("Calculate"),BorderLayout.CENTER);
		
		
		setSize(300,200); //contentpane의 크기
		setVisible(true); // 보이도록하기.
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new BorderLayoutEx();
	}

}
