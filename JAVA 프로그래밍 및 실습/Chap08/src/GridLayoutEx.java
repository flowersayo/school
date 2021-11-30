import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutEx extends JFrame{

	public GridLayoutEx() {
		
		setTitle("BorderLayout 예시");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane=getContentPane();
		
		//새로운 배치관리자 설정.
		// GridLayout : 동일한 사각형(격자)로 분할하고 각 셀에 하나의 컴포넌트 배치
		// 컴포넌트가 Add되는 순서대로 상단왼쪽부터 차례대로 채워짐
		// GridLayout (행수,열수,수평간격,수직간격)
		contentpane.setLayout(new GridLayout(1,10)); // 1행 10열 
		
		for(int i=0;i<10;i++) {
			String text= Integer.toString(i);
			JButton jb =new JButton(text);
			contentpane.add(jb);
		}
		
		//초과할 경우 그냥 옆에 나열됨. 
		contentpane.add(new JButton("new"));
		setSize(500,100); //contentpane의 크기
		setVisible(true); // 보이도록하기.
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new GridLayoutEx();
	}

}
