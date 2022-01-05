import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

// screen 메뉴에 4개의 메뉴 아이템을 만든다.
// Load를 선택하면 이미지를 보이지 않게하고, Hide는 이미지를 보이지 않게하며
// ReShow는 숨겨진 이미지를 다시 보이게하고, Exit를 선택하면 프로그램을 종료하도록 Action 리스너 작성.

public class MenuEx extends JFrame {

	public MenuEx() {
		
		setTitle("메뉴에 Action 리스너 활용예제 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createMenu();
		setSize(250,200);
		setVisible(true);
		
	}
	
	//JMenuBar ->  JMenu -> JMenuItem
	void createMenu() {
		
		JMenuBar mb =new JMenuBar(); //메뉴바 생성
		JMenu screenMenu = new JMenu ("Screen"); // 스크린 메뉴 생성
		
		
		//메뉴 아이템 생성해서 붙이기
		screenMenu.add(new JMenuItem("Load"));
		screenMenu.add(new JMenuItem("Hide"));
		screenMenu.add(new JMenuItem("ReShow"));
		screenMenu.addSeparator(); //ReShow Exit 사이에 분리선추가
		screenMenu.add(new JMenuItem("Exit"));
	
		
		mb.add(screenMenu); // 스크린 메뉴를 메뉴바에 붙이기 
		mb.add(new JMenu("Edit")); 
		mb.add(new JMenu("Source")); 
		mb.add(new JMenu("Project")); 
		mb.add(new JMenu("Run")); 
		
		
		setJMenuBar(mb);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuEx();
	}

}
