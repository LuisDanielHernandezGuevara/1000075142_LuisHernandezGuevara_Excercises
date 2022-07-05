
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
	}

}
