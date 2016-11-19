package mandeep.hackerrank.thirtyDaysOfCode;

import java.util.Scanner;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}
class Student extends Person{
	private int[] testScores;
   
    Student(String firstName, String lastName, int identification, int[] testScores){
        super(firstName, lastName, identification);
        this.testScores = testScores;
    }
    public char calculate(){
        int sum = 0;
        
        for(int i = 0; i < testScores.length; i++){
            sum += testScores[i];    
        }
        
        sum /= testScores.length;
       
        if( sum >= 90 && sum <= 100)
            return 'O';
        else if(sum >= 80 && sum < 90)
            return 'E';
        else if(sum >= 70 && sum < 80)
            return 'A';
        else if(sum >= 55 && sum < 70)
            return 'P';
        else if(sum >= 40 && sum < 55)
            return 'D';
        else 
            return 'T';
    }
}
public class Inheritance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}
