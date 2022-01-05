import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicDrawImageEx extends JFrame {

	public GraphicDrawImageEx(){
		
		setTitle("원본 이미지로 원하는 위치에 이미지 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		
		setSize(300,400);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
	ImageIcon icon = new ImageIcon ("./images/image0.jpg"); //이미지 로딩
	Image img = icon.getImage(); //이미지 가져오기
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(img,20,20,this); //이미지, x좌표,y좌표, 이미지 그리기의 완료를 통보받는 객체
		
		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicDrawImageEx ();
	}

}
