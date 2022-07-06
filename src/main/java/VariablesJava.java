import java.util.ArrayList;

public class VariablesJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myNum =5;
		String website= "Luis Hernandez";
		char letter = 'l';
		double dec = 5.99;
		boolean card = true;
		
		System.out.print(myNum+ "is the value stored");
		System.out.print(website);
		
		//Arreglos
		int [] arr = new int [5];
		arr[0] = 1;
		arr[1] = 2;
		arr[3]=3;
		
		
		int []empty = {1,2,3,4,5};
		
		for (int i = 0 ; i< empty.length; i++) {
			System.out.print(empty[i]);
		}
		
		String [] name = {"Luis", "Hernandez"};
		
		for (int j = 0 ; j < name.length; j++) {
			System.out.print(name[j]);
		}
		
		//Another for loop
		for (String s: name) {
			System.out.println(s);
		}
		
		for(int i:empty) {
			System.out.println(i);
		}
		
		for(int k: empty) {
			if(k % 2 ==1) {
				System.out.println("Its not pair");
			}else {
				System.out.println("pair");
			}
		}
		
		//Accept any kind of data type
		ArrayList a = new ArrayList();
		//Accept only String data types
		ArrayList <String> a2 = new ArrayList();
		
		a.add("name 1");
		a.add("name 2");
		a.add(123);
		System.out.print(a.get(1));
		System.out.print(a);
		
		a2.add("Luis");
		a2.add("name2");
		System.out.println(a2);
		
	}

}
