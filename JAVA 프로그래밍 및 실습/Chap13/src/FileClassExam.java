import java.io.File;

public class FileClassExam {
//File클래스를 활용한 파일관리
	
	public static void listDirectory(File dir) {
		
		System.out.println(dir.getPath()+ "의 서브리스트 입니다.");
		
		File[] subFiles =dir.listFiles(); //디렉터리 내의 파일과 서브 디렉터리 리스트를 File[]배열로 리턴.
		
		for(int i=0;i<subFiles.length;i++) {
			File f=subFiles[i];
			long t =f.lastModified(); //마지막 수정시간
			System.out.println(f.getName()); //파일명
			System.out.println(f.getPath());
			System.out.println(f.getParent()); //부모 디렉토리
			System.out.println(f.lastModified());
			System.out.println(f.length()); //파일 크기
			System.out.println("-------------------------------------");
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f1 =new File("c:\\windows\\system.ini");
		System.out.println(f1.getPath()+", "+f1.getParent()+" , "+f1.getName());
		
		String res = "";
		
		if(f1.isFile())
			res="파일";
		else if(f1.isDirectory())
			res="디렉터리";
		
		System.out.println("f1은 "+res +"입니다.");
		
		File f2=new File("c:\\Temp\\java_sample");
		
		if(f1.exists()) {
			f2.mkdir(); //f2생성.
		}
		
		listDirectory(new File("c:\\Temp")); //java_sample 생성후
		
		f2.renameTo(new File("c:\\Temp\\javasample"));
		
		listDirectory(new File("c:\\Temp")); //java_sample ->javasample 명칭 변경후
		
	}

}
