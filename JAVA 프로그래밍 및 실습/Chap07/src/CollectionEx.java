import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionEx {

	
	static void printList (LinkedList<String> list) {
		
		Iterator <String> it = list.iterator();
		
		while (it.hasNext()) {
		String e =it.next();
		String separator;
		
		
		if (it.hasNext()) // 다음값이 있으면.
			separator = "->";
		else
			separator = "\n";
			
		System.out.print(e + separator);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList <String> myList = new LinkedList<String>();
		myList.add("트");
		myList.add("스");
		myList.add("매");
		myList.add(0,"터");
		myList.add(2,"아");
		
		Collections.sort(myList);
		printList(myList);
		Collections.reverse(myList);
		printList(myList);
		
		int idx = Collections.binarySearch(myList, "아")+1; //아 가 몇번째 요소인지
		System.out.println(idx+"번째 요소");
	}

}
