import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



//텍스트 파일 복사 (문자 스트림 FileReader,FileWriter 이용) 
public class TextCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File src = new File("c:\\windows\\system.ini");
		File dest = new File("c:\\Temp\\system.txt");
		
		int c; 
		
		
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw =new FileWriter(dest);
			
			while((c=fr.read())!=-1) { //문자 하나 읽고
				fw.write((char)c);  //문자 하나 쓰고 
				System.out.println("*");
			}
			
			fr.close();
			fw.close(); //스트림닫는거 잊지말기!!!!!
			System.out.println(src.getPath() +"->"+dest.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("입출력 오류");
		}
		
		
		
		
	}

}
