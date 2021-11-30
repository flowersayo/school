import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IndepClassListener extends JFrame {

	public IndepClassListener () {
		setTitle("독립 클래스로 이벤트 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn =new JButton("Action");
		c.add(btn);
		
		btn.addActionListener(new MyListener());
		setSize(250,120);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IndepClassListener();
	}

}

class MyListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton b=(JButton)e.getSource(); // 이벤트소스 가져오기.
		if(b.getText().equals("Action")) // 이벤트 소스의 글자가 Action이면
			b.setText("액션"); //버튼 텍스트 ㅏㅂ뀍
		else
			b.setText("Action");
				
	}
	
}
