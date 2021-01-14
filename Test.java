package client;
import system.TicketBookingThread;
import system.TicketCounter;
import java.util.*;

class AgeException extends Exception {  
	 AgeException(String s) {  
		 super(s);  
	 }  
} 
public class Test {
	static void validate(int age) throws AgeException{  
	     if(age<5||age>60)  {
	    	 throw new AgeException("Welcome!!! Please take extra precautions during Journey!!!");
	     }
	     else {
	    	 System.out.println("Welcome!!! Please follow safety rules!!!");
	     }
	}  

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("*******************%%%%%   WELCOME TO BUS BOOKING PORTAL   %%%%%********************");
    	System.out.println("Enter your name: ");
    	String name=sc.next();
    	System.out.println("Enter the number of tickets to be booked: ");
    	int n=sc.nextInt();
    	ArrayList<String> arr_names=new ArrayList<String>();
    	ArrayList<Integer> arr_ages=new ArrayList<Integer>();
    	System.out.println("Enter the names of passenger: ");
    	for(int count=0;count<n;count++) {
    		arr_names.add(sc.next());
    	}
    	System.out.println("Enter the ages of passenger: ");
    	try {
	    	for(int count=0;count<n;count++) {
	    		int age=sc.nextInt();
	    		arr_ages.add(age);
	    	}
	    	for(int count=0;count<n;count++) {
	    		validate(arr_ages.get(count));
	    	}
	    	
    	} catch(Exception e) {
    		System.out.println("Exception occured: "+e);
    	}
    	
    	
        TicketCounter ticketCounter = new TicketCounter();
        TicketBookingThread t1 = new TicketBookingThread(ticketCounter,name,n);
        TicketBookingThread t2 = new TicketBookingThread(ticketCounter,"Martin",2);
        
        t1.start();
        t2.start();
      
    }
}
