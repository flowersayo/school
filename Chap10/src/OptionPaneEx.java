import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class OptionPaneEx extends JFrame {

	public OptionPaneEx () {
		setTitle("옵션 팬 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c= getContentPane();
		
		
		// add하면서 붙이는 컴포넌트의 위치도 같이 설정하기.
		c.add(new MyPanel(),BorderLayout.NORTH);
		setSize(500,200);
		setVisible(true);
		
	}
	
	//class안에 class만들기 가능.
	class MyPanel extends Panel{
		
		// 패널에 들어갈 여러 요소들 생성
		JButton inputBtn =new JButton ("Input Name");
		 JTextField tf = new JTextField(10);
		 JButton confirmBtn =new JButton("Confirm");
		 JButton messageBtn =new JButton("Message");
		 
		 public MyPanel() {
			 
			 //패널에 붙임
			 setBackground(Color.LIGHT_GRAY);
			 add(inputBtn);
			 add(confirmBtn);
			 add(messageBtn);
			 add(tf);
			 
			 //인풋 버튼에 이벤트 리스너 추가
			 inputBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name =JOptionPane.showInputDialog("이름을 입력하세요");
					
					if( name!=null) {
						tf.setText(name);
					}
				}
			});
			 
			 confirmBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					// 화면 중앙정렬, 질문, 타이틀, 버튼구성
					int result= JOptionPane.showConfirmDialog(null,"계속할 것입니까?","Confirm",JOptionPane.YES_NO_OPTION);
					
					if(result==JOptionPane.CLOSED_OPTION) { //예,아니요 선택없이 다이얼로그 창을 닫은경우
						tf.setText("Just Closed Without Selection");
						
					}
					else if (result==JOptionPane.YES_OPTION) {
						tf.setText("YES");
					}
					else {
						tf.setText("NO");
					}
				}
			});
						
				messageBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, "조심하세요","Message",JOptionPane.ERROR_MESSAGE);
					}
				});
		 }
		 
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OptionPaneEx();
	}

}
