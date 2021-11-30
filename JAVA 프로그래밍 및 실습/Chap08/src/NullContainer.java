import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

	public class NullContainer extends JFrame{

		public NullContainer() {
			
		
			setTitle("자유롭게 배치하는 ,배치관리자가 없는 NullContainer");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container contentpane=getContentPane();
			
			contentpane.setLayout(null);// 배치관리자 해제
			
			// NullContainer는 컴포넌트의 절대적 크기,위치를 지정해주어야함.
			// 지정해주지 않을시 화면에 출력 X
			
			var la = new JLabel("Hello Press Button!");
			la.setLocation(130,50); // 버튼 위치 지정
			la.setSize(200,20); //버튼 크기 지정
			contentpane.add(la);
			
			for(int i=1;i<=9;i++) {
				JButton b=new JButton(Integer.toString(i));
				b.setLocation(i*15,i*15);
				b.setSize(50,20);
				contentpane.add(b);
			}
			
			
			setSize(300,200); //contentpane의 크기
			setVisible(true); // 보이도록하기.
			
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
		new NullContainer();
		}

	}
