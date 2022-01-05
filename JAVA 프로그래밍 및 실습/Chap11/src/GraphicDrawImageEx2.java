import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicDrawImageEx2 extends JFrame {

	public GraphicDrawImageEx2(){
		
		setTitle("패널의 크기에 맞춰 이미지 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		
		setSize(200,300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
	ImageIcon icon = new ImageIcon ("./images/image0.jpg"); //이미지 로딩
	Image img = icon.getImage(); //이미지 가져오기
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//패널의 크기에 맞춰서 그리기
		g.drawImage(img,0,0,getWidth(),getHeight(),this); //이미지, x좌표,y좌표,가로크기,세로크기, 이미지 그리기의 완료를 통보받는 객체
		
		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicDrawImageEx2 ();
	}

}
