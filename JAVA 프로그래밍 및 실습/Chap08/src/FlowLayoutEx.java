import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutEx extends JFrame{

	public FlowLayoutEx() {
		
		setTitle("플로우 레이아웃 예시");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane=getContentPane();
		
		//새로운 배치관리자 설정.
		// Flowlayout : 왼쪽 -> 오른쪽 배치 . 정렬방법, 수평간격,수직간격 
		contentpane.setLayout(new FlowLayout(FlowLayout.CENTER,30,0)); //
		
		contentpane.add(new JButton("add"));
		contentpane.add(new JButton("sub"));
		contentpane.add(new JButton("div"));
		contentpane.add(new JButton("mul"));
		contentpane.add(new JButton("Calculate"));
		
		setSize(300,200); //contentpane의 크기
		setVisible(true); // 보이도록하기.
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new FlowLayoutEx();
	}

}
