import java.io.FileInputStream;
import java.io.IOException;

//저장된 바이너리 파일(.out)읽어오기 
public class FileInputStreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte b[] =new byte[6];
		
		try {

			FileInputStream fin = new FileInputStream("c:\\Temp\\test.out");
			int n=0,c;
			
			while((c=fin.read())!=-1) { //read는 바이트 단위로 읽어서 int 정수형으로 변환. 
				b[n]= (byte)c; //형변환필수! 
						n++;
			}
			
			System.out.println("읽은 배열 출력하기");
			
			for(int i=0;i<b.length;i++)
				System.out.println(b[i]);//+ ' '쓰면 공백이 더해져서 출력됨 아오 ㅋㅋ
			
			System.out.println();
			
			fin.close(); //꼭 닫기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("입출력오류");
		}
	}

}
