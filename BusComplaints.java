package system;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 

public class BusComplaints {
	public void complaint() {
	    try {
	      File myObj = new File("C:\\Users\\preethi.h.r\\Documents\\Bus_complaint.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
