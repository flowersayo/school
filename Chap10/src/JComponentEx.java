import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentEx extends JFrame {

	
	public JComponentEx() {
		super("JComponent의 메소드 예제"); //타이틀 설정
		
		Container c=getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X버튼누를때 확실히 종료
		c.setLayout(new FlowLayout()); //배치관리
		
		JButton b1 =new JButton("Megenta/Yellow Button");
		JButton b2 =new JButton(" Disable Button");
		JButton b3 =new JButton("getX() ,get Y()");
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA); // 글자수
		b1.setFont(new Font("Arial",Font.ITALIC,20));
		b2.setEnabled(false);
		b3.addActionListener(new ActionListener() { //마우스나 <Enter>키로 버튼을 선택할경우.
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton b= (JButton)e.getSource(); // 액션이 발생한 소스를받아
				setTitle(b.getX()+","+getY()); // 좌표를 타이틀에 출력
			}
		});
		
		//버튼을 ContentPane에 붙임
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		
		setSize(260,200); // 스윙 컴포넌트의 공통 메소드
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new JComponentEx();
	}

}
