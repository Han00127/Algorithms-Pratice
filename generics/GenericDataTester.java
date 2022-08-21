package generics;

import java.util.ArrayList;

public class GenericDataTester {

	public static void main(String[] args) {
		GenericData<String> obj1 = new GenericData<>("Hello");
		System.out.println(obj1.getData());
		
		GenericData<Integer> obj2 = new GenericData<>(123);
		System.out.println(obj2.getData());
		
		ArrayList<GenericData> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);
		System.out.println(list);
		
		
	}
	
}
