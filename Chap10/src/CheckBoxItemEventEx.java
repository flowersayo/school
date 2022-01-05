import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxItemEventEx extends JFrame {

	JCheckBox [] fruits = new JCheckBox [3]; //체크박스 배열 레퍼런스 생성
	String [] names = {"사과","배","체리"};
	
	JLabel total; //계산 합이들어갈 변수.
	public CheckBoxItemEventEx() {
		
		setTitle("체크박스와 ItemEvent예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
		
		MyItemListener listener = new MyItemListener(); //아이템에 적용시킬 이벤트 리스너 생성

		for (int i=0;i<fruits.length;i++) {
			fruits[i]=new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);//외곽선 보이게 하기
			c.add(fruits[i]);
			fruits[i].addItemListener(listener); //리스너 붙이기 
		}
		
		total =new JLabel("현재 0원입니다.");
		c.add(total);
		
		setSize(250,150);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		
		int sum; //가격의 합

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			//아이템이 눌려지면 덧셈 작동
			
			if (e.getStateChange()==ItemEvent.SELECTED) {//아이템이눌려지면
				
				if(e.getItem() ==fruits[0]) 
					sum+=100;
				else if(e.getItem() ==fruits[1]) 
					sum+=500;
				else 
					sum+=20000;
					
			}
			else { //아이템이 해지되면
				
				if(e.getItem() ==fruits[0]) 
					sum-=100;
				else if(e.getItem() ==fruits[1]) 
					sum-=500;
				else 
					sum-=20000;
			}
			total.setText("현재 "+sum+"원입니다.");
				
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckBoxItemEventEx();
	}

}
