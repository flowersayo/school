
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboActionEx extends JFrame {

	String [] fruits = { "apple","banana","kiwi","mango","pear","peach","berry","strawberry","blackberry"};
		ImageIcon [] images = {new ImageIcon("images/apple.jpg"),	
				new ImageIcon("images/banana.jpg"),	
				new ImageIcon("images/kiwi.jpg"),	
				new ImageIcon("images/mango.jpg")};
	JLabel imageLabel= new JLabel(images[0]); // 이미지 라벨생성 - 초기이미지는 사과이미지로 
				
		//JList -> 하나이상의 아이템을 보여주고 아이템을 선택하도록 하는 리스트. 
		//JList<E>(Object [] listData)
	
	public ComboActionEx () {
		
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		var combo=new JComboBox<String>(fruits);
		c.add(combo);
		c.add(imageLabel);
		
		
		combo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //마우스눌리면 동작
				// TODO Auto-generated method stub
				JComboBox <String> cb= (JComboBox)e.getSource(); 
				int index = cb.getSelectedIndex(); //선택된 아이템의 인덱스 가져오기
				
				imageLabel.setIcon(images[index]); //imageLabel의그림 바꾸기.
				
			}
		});
	
		
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComboActionEx ();
	}

}
