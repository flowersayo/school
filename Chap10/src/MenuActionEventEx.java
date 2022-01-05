import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


//screen 메뉴에 4개의 메뉴 아이템을 만든다.
//Load를 선택하면 이미지를 보이지 않게하고, Hide는 이미지를 보이지 않게하며
//ReShow는 숨겨진 이미지를 다시 보이게하고, Exit를 선택하면 프로그램을 종료하도록 Action 리스너 작성.

public class MenuActionEventEx extends JFrame {
	
	
	JLabel imageLabel = new JLabel();
	
	public MenuActionEventEx() {
		
		setTitle("메뉴에 액션리스너 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createMenu();
		
		getContentPane().add(imageLabel,BorderLayout.CENTER); //이미지 라벨 붙이기
		setSize(250,200);
		setVisible(true);
		
	}

	//JMenuBar ->  JMenu -> JMenuItem
	void createMenu() {
		
		JMenuBar mb =new JMenuBar(); //메뉴바 생성
		JMenuItem [] menuItems = new JMenuItem[4];
		String [] itemTitles =  {"Load","Hide","ReShow","Exit"}; //메뉴아이템 리스트
		JMenu screenMenu = new JMenu ("Screen"); // 스크린 메뉴 생성
		
	
		
	
		// !주의! 스크린 메뉴에 action listener를 붙이는게 아니라 각각의 메뉴 아이템에 붙여야함
		//screenMenu.addActionListener(new MenuActionListener()); -> X
		
		//메뉴 액션 리스너 생성 (1회만해서 돌려쓰기) 
		MenuActionListener listener = new MenuActionListener();
		
		//메뉴 아이템 생성해서 이벤트 리스너 붙이기
		for(int i=0;i<itemTitles.length;i++) {
			
			 menuItems[i]=new JMenuItem(itemTitles[i]); //메뉴아이템 생성
			 menuItems[i].addActionListener(listener); // 메뉴액션리스너 붙이기.
			 screenMenu.add(menuItems[i]);
		}
		
		mb.add(screenMenu);
		setJMenuBar(mb); //메뉴바를 프레임에 부착.
		
	}
	
	class MenuActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String cmd =e.getActionCommand(); // 클릭한 메뉴 아이템 명칭 반환
			switch (cmd) {
			case "Load" :
				if(imageLabel.getIcon()!=null) //이미 라벨에 set 된 icon이 존재한다면
					return; //load이미 되어있으므로 리턴
				imageLabel.setIcon(new ImageIcon("images/apple.jpg"));
				break;
				
			case "Hide" :
				imageLabel.setVisible(false); //보이지 않게함.
				break;
			
			case "ReShow" : 
				imageLabel.setVisible(true); //보이게함.
				break;
				
			case "Exit" :
				System.exit(0); //종료
				break;
			
				
			}
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuActionEventEx();
	}

}
