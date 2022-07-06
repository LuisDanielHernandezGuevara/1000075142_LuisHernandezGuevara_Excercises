
public class StringsDecla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hello";
		
		String s2 = new String("Welcome");
		String s3 = new String ("Luis Daniel");
		
		String [] splitNewString = s3.split("Luis");
		System.out.print(splitNewString[0]);
		System.out.print(splitNewString[1]);
		
		//remove spaces from strings
		System.out.print(splitNewString[1].trim());
		for(int i = 0 ; i < s1.length(); i++) {
			System.out.print(s1.charAt(i));
		}
		
		PersonalInfo person1 = new PersonalInfo();
		person1.setName("Daniel");
		person1.setPhone_Number(3434252);

		System.out.print(person1.getName() + " " + person1.getPhone_Number());
		
		getData1();
	}
	
	public void getData() {
		System.out.print("Hello");
	}
	
	public static String getData1() {
		//static methods does not need an object to be called
		System.out.print("Returns data based in a static mthods");
		return " called static method";
	}

}
