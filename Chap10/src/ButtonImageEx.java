import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonImageEx extends JFrame{

	
	public ButtonImageEx() {
		
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		//필요한 이미지 불러오기
		ImageIcon normalIcon =new ImageIcon("images/normalicon.gif");
		ImageIcon rolloverIcon =new ImageIcon("images/rollovericon.gif");
		ImageIcon pressedIcon =new ImageIcon("images/pressedicon.gif");
		
		JButton btn = new JButton("call...",normalIcon);
		btn.setPressedIcon(pressedIcon); //버튼 클릭시 이미지 설정
		btn.setRolloverIcon(rolloverIcon); //버튼에 마우스올렸을때 이미지

		c.add(btn);
		
		setSize(250,150);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonImageEx();
	}

}
