import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class HashMapDicEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	HashMap<String,String> dic = new HashMap<String,String>();
	
	dic.put("baby", "아기");
	dic.put("love", "사랑");
	dic.put("apple", "사과");
	
	//dic에서 key값만 가져와서 iterator로 출력하기
	Set<String> keys=dic.keySet();
	
	var it =keys.iterator();
	while(it.hasNext()) {
		String key=it.next();
		String value = dic.get(key); //key값에 해당하는 value를 가져옴
		System.out.println(key + " " +value);
	}
	
	Scanner s=new Scanner (System.in);
	while(true){
		System.out.println("찾고싶은 단어는?");
		String eng=s.next();
		String kor =dic.get(eng);
		
		if(kor ==null)
			System.out.println(eng+ "는 없는 단어입니다");
		else
			System.out.println(kor);
	}
	
	
	}

}
