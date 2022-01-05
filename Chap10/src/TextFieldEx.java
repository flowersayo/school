import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldEx extends JFrame {

	
	//JTextField(String txt, int cols) : 초기화문자열, 입력창의 열개수
	JTextField tf = new JTextField(20); 
	
	//JTextArea (width,height)
	JTextArea ta = new JTextArea(7, 20); // 한줄에 20문자가 입력 가능하며 7줄로 구성. (행,열)
	
	public TextFieldEx() {
		
		setTitle("텍스트 영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
			/*
		c.add(new JLabel("이름  "));
		c.add(new JTextField(20)); 
		
		c.add(new JLabel("학과  "));
		c.add(new JTextField(20)); 
		
		c.add(new JLabel("주소  "));
		c.add(new JTextField(20)); 
		*/
		
		//텍스트 필드에 문자열을 입력한 후<Enter>키를 입력하면 텍스트 영역창에 문자열을 추가하고, 텍스트필드 입력창은 치우는 프로그램. 
		
		c.add(new JLabel("입력후 엔터키를 입력하세요"));
		c.add(tf);
		
		tf.addActionListener(new ActionListener() { //마우스 클릭 or enter키 눌렸을때
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField t=(JTextField)e.getSource(); //액션이 perform된 소스 가져오기
				ta.append(t.getText()+'\n'); // text area에 내용 추가하기
				t.setText(""); // 스트링초기화
			}
		});
		c.add(new JScrollPane(ta)); // text area에 스크롤뷰 추가
	
		
		setSize(300,250);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextFieldEx();
	}

}