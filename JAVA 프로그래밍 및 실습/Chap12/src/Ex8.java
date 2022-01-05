import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;



//텍스트 파일 복사 (문자 스트림 FileReader,FileWriter 이용) 
public class Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InputStreamReader rd = new  InputStreamReader (System.in);

		
		int c; 
		Scanner s=new Scanner(System.in);
		
		try {
	
			FileWriter fout = new FileWriter("c:\\Temp\\test.txt");
			while(true) { //문자 하나 읽고
				System.out.println("학점 입력 프로그램입니다.");

				System.out.print("이름 학점>>");
				String line =
			
			
				fw.write((char)c);  //문자 하나 쓰고 
				System.out.println("*");
			}
			
			rd.close();
			fw.close(); //스트림닫는거 잊지말기!!!!!
			System.out.println(src.getPath() +"->"+dest.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("입출력 오류");
		}
		
		

}

