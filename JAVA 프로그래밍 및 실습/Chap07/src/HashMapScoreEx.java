import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class HashMapScoreEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//이름이랑 점수를 저장할 해쉬맵 만들기
		
		HashMap <String,Integer> scoreMap = new HashMap <String,Integer>();
		
		//5개의 방 만들기
		
		scoreMap.put ("김성동",97);
		scoreMap.put ("황기태",88);
		scoreMap.put ("김남윤",98);
		scoreMap.put ("이재문",70);
		scoreMap.put ("한원선",99);
		
		
		System.out.println("해쉬맵의 요소 개수: " + scoreMap.size());
		
		
		Set<String> keys=scoreMap.keySet(); //Hashmap 키값 가져오기
		Iterator<String> it = keys.iterator(); 
		
		
		while(it.hasNext()) { //HashMap 순회
			
			System.out.println(it.next()); // 메모리상에 순서대로 저장되는 것이 아님. 
		}
	}

}
