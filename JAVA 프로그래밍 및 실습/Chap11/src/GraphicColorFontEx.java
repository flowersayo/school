import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicColorFontEx extends JFrame{

	public GraphicColorFontEx() {
		setTitle("문자열, 컬러, 폰트 사용예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(300,300);
		setVisible(true);
	}
	class MyPanel extends JPanel{ //그냥 Panel아님에 주의
		
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawString("자바가 정말 재밌네", 30, 30);
			
			g.setColor(new Color(255,0,0)); //red
			g.setFont(new Font ("Arial",Font.ITALIC,30)); //폰트명,글자스타일,크기
			// 그냥 바로 인자를 주어 세팅하는것이 아니라, 먼저 Font 객체를 생성하고 그것을 인자로 주어야함에 유의
	
			g.drawString("How much?", 30, 70);
			
			g.setColor(new Color(0X00ff00ff)); //컬러헥사코드 +투명값까지 표현해서 8자리 자주색
			
			// draw하기전에 color,font를 한번씩 설정해도됨
			for(int i=1;i<=4;i++) {
				g.setFont(new Font("Jokerman",Font.ITALIC,i*10)); 
				g.drawString("This much!!", 30, 60+i*40);
				
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicColorFontEx();
	}

}
