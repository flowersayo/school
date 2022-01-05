

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//이름이랑 학점을 저장할 해쉬맵 만들기
		
		HashMap <String,Float> scoreMap = new HashMap <String,Float>();
		
		Scanner s= new Scanner(System.in);
		//5개의 방 만들기
		System.out.println("미래장학금관리시스템입니다.");
		for(int i=0;i<5;i++) {
			System.out.print("이름과 학점>>");
			String name=s.next();
			float score=s.nextFloat();
			scoreMap.put (name,score);
			
			
		}
		
		System.out.print("장학생 선발 학점 기준 입력 >>");
		
		float k =s.nextFloat(); //선발 기준
		
		// HashMap은 Iterator 지원 안하므로 keySet이용해야함.
		Set<String> keys=scoreMap.keySet(); //Hashmap 키값 가져오기
		Iterator<String> it = keys.iterator(); 
		
		
		System.out.print("장학생 명단 :");
		while(it.hasNext()) { //HashMap 순회
			
			String key = it.next();
			
			if (scoreMap.get(key)>=k) // 선발 기준을 통과한다면
			System.out.print(key+' '); // 메모리상에 순서대로 저장되는 것이 아님. 
		}
	}

}
