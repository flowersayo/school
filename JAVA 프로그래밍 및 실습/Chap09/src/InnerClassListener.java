	import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

	public class InnerClassListener extends JFrame {

		public InnerClassListener () {
			setTitle("내부 클래스로 이벤트 만들기");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Container c=getContentPane();
			c.setLayout(new FlowLayout());
			JButton btn =new JButton("Action");
			c.add(btn);
			
			btn.addActionListener(new MyActionListener());
			setSize(250,120);
			setVisible(true);
		}

		// 메인 클래스 내부에 내부 클래스 작성
		class MyActionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JButton b=(JButton)e.getSource(); // 이벤트소스 가져오기.
				if(b.getText().equals("Action")) // 이벤트 소스의 글자가 Action이면
					b.setText("액션"); //버튼 텍스트 바꾸기
				else
					b.setText("Action");
				
				// 프레임 타이틀까지 변경해라
				// Q. InnerClassListener.this 가 의미하는바
				InnerClassListener.this.setTitle(b.getText());
			}
			
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new InnerClassListener();
		}
		


	}

	