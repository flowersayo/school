
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListEx  extends JFrame {

	String [] fruits = { "apple","banana","kiwi","mango","pear","peach","berry","strawberry","blackberry"};
		ImageIcon [] images = {new ImageIcon("images/icon1.png"),	
				new ImageIcon("images/icon2.png"),	
				new ImageIcon("images/icon3.png"),	
				new ImageIcon("images/icon4.png")};
	
				
		//JList -> 하나이상의 아이템을 보여주고 아이템을 선택하도록 하는 리스트. 
		//JList<E>(Object [] listData)
	
	public ListEx () {
		
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c= getContentPane();
		c.setLayout(new FlowLayout());
		
		JList<String> strList = new JList<String>(fruits); // fruits string배열로 리스트 생성
		c.add(strList);
		
		JList<ImageIcon> imgList= new JList<ImageIcon>(images); //이미지 배열로 list생성
		c.add(imgList);
		
		
		JList<String> scrollList = new JList<String>(fruits); // fruits string배열로 리스트 생성
		c.add(scrollList);
		
		
		// 하나의 JList 가지고 돌려쓰면 안됨. 
		c.add(new JScrollPane(scrollList));
		
		
		
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListEx ();
	}

}

