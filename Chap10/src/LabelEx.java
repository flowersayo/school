import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame {

	public LabelEx() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		//JLabel  : 문자열이나 이미지를 화면에 출력
		//JLabel (String txt ,Icon img , int hAlign)
		
		
		//1.문자열 라벨
		JLabel textLabel =new JLabel("제임스고슬링");
		
		//2.이미지 라벨
		ImageIcon img=new ImageIcon ("images/gosling.jpg"); // 1. 이미지로딩후
		JLabel imageLabel =new JLabel(img); //2.이미지를 레이블에 붙임.
		
		//3. 문자열+이미지라별
		ImageIcon icon=new ImageIcon("images/icon.gif");
		JLabel label =new JLabel("커피한잔 하실래예, 전화 주이소",icon,SwingConstants.CENTER);
		label.setBackground(Color.RED);
		c.add(textLabel);
		c.add(imageLabel);
		c.add(label);
		
		setSize(300,500);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LabelEx();
	}

}
