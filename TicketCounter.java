package system;

import java.util.*;

interface Questions{
	public void SurveyQuesions();
}
enum Survey implements Questions{	
	YES {
		public String getFeedback() {
			System.out.println("Please proceed to give the Feedback!!!");
			Scanner sc=new Scanner(System.in);
			System.out.println("\nHow do you rate the Booking system?");
			System.out.println("Please select a number from (1-5)");
			int num=sc.nextInt();
			System.out.println("Thank you for your time!!!");
			return "YES";
		}
	},
	NO {
		public String getFeedback() {
			System.out.println("Thank you!!!");
			return "NO";
		}
	},
	LATER {
		public String getFeedback() {
			System.out.println("Please give the feedback as soon as possible!!!");
			return "LATER";
		}
	};
	public void SurveyQuesions() {
		System.out.println("How do you rate the Bus booking system?");
		
	}
	public abstract String getFeedback();
}

public class TicketCounter {

	private int availableSeats = 3;
	public synchronized void feedbackFunction(String pname) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nHi "+pname+", Would you like to give the Feedback? (YES/ NO/ LATER)");
    	String sur=sc.next();
    	Survey survey=Survey.valueOf(sur);
    	switch(survey) {
    	case YES:
    		survey.getFeedback();
    		break;
    	case NO:
    		survey.getFeedback();
    		break;
    	case LATER:
    		survey.getFeedback();
    		break;
    	default:
    		System.out.println("Please select (YES/ NO/ LATER");
    	}
	}
	
	public synchronized void launchComplaint(String pname) {
		System.out.println("\nHi "+pname+", Here is the Contact Details for any Query......!!!");
    	BusComplaints bc=new BusComplaints();
    	bc.complaint();
	}

	public synchronized void bookTicket(String pname, int numberOfSeats) {
		TicketCounter ticketCounter = new TicketCounter();
		if ((availableSeats >= numberOfSeats) && (numberOfSeats > 0)) {
			System.out.println("*************************************************************************************");
			System.out.println("\n\nHi," + pname + " : " + numberOfSeats+ " Seats booked Successfully..");
			availableSeats = availableSeats- numberOfSeats;
			ticketCounter.feedbackFunction(pname);
			ticketCounter.launchComplaint(pname);
		} else {
			System.out.println("*************************************************************************************");
			System.out.println("\n\nHi," + pname + " : Seats Not Available");
			ticketCounter.feedbackFunction(pname);
			ticketCounter.launchComplaint(pname);
		}
	}
}
