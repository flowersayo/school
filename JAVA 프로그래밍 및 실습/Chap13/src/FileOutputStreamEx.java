import java.io.FileOutputStream;
import java.io.IOException;

//바이너리파일 출력
public class FileOutputStreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//byte의 표현 범위 -128  ~ 127   
		byte b[] = {65,66,67,68,69,70}; //int 로 바뀌어도 상관없음 .
		
		try {
			FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
			

			for(int i=0;i<b.length;i++) 
				fout.write(b[i]);
			
			// A B C D E F 저장
			fout.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("오류");
		}
		
		System.out.println("저장했습니다."); 
	}

}
