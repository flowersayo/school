
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockBinaryCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File src=new File("c:\\Temp\\apple.jpg");
		File dest = new File("c:\\Temp\\back.jpg");
		
		int c; //읽어오기 변수
	
		
		try {
			
			FileInputStream fr = new FileInputStream(src);
			FileOutputStream fw = new FileOutputStream(dest);
			
			byte [] buf =new byte[1024 * 10]; //10KB 버퍼
			
			while(true) {
				int n=fr.read(buf); //버퍼 크기만큼 읽기. n은 실제 읽은 바이트
				fw.write(buf,0,n); //buf[0] 부터 n바이트 쓰기
				if(n<buf.length)
					break; //버퍼 크기보다 작게 읽혔기 때문에 파일끝에 도달한것. 복사 종료
			}
			fr.close();
			fw.close();
			System.out.println(src.getPath()+"->"+dest.getPath());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 복사 오류");
		}
	}

}
