import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// ctrl +shift + o 로 자동 import문 작성
//ctrl +space 로 자동완성후보

public class ContentPaneEx extends JFrame {

	public ContentPaneEx() {
		
		setTitle("버튼 3개 실행");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 프로그램(스윙)도 종료
		Container contentpane = getContentPane();
		
		contentpane.setBackground(Color.ORANGE);
		
		contentpane.setLayout(new FlowLayout()); //일렬 배치
		
		contentpane.add(new JButton("OK"));
		contentpane.add(new JButton("Cancel"));
		contentpane.add(new JButton("Ignore"));
		
		
		setSize(300,150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//ContentPaneEx content=new ContentPaneEx();
		new ContentPaneEx(); // 이름 생략 가능. 
	}

}
