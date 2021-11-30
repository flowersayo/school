import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame () { //생성자
		setTitle ("첫 스윙프로그램");
		setSize(300,300);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyFrame frame = new MyFrame(); // 프레임 실행
	}

}
