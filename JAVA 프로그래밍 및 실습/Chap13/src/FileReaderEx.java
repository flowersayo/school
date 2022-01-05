
import java.io.FileReader;
import java.io.IOException;

//파일 읽기
public class FileReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader in =null;
		
		try {
			in =new FileReader("c:\\windows\\system.ini");
			int c;
			
			// 문자스트림은 2바이트의 유니코드 문자를 단위로 입출력하는 스트림.
			// byte는 1byte char은 2byte int는 4btye
			while((c=in.read())!=-1){//in.read() 는 1 byte를 읽어 int 타입으로 리턴한다.
				
				System.out.print((char)c); //!주의! int로 읽어들인거 char로 바꾸기
			}
			
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
				System.out.println("입출력 오류");
		}
		
	}

}
