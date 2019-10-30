/*Class:		CSE 1323L/W01
Date:			10/3/2019  
Name:			Terrence Smith
Assgnmt Name:	Client   
Assignment#:	Module 3B - Client
Resources: 		Introduction to Java Programming and Data Structures: Comp Version 11th e, 
 				Ch. 11. Also google, https://web.stanford.edu/class/archive/cs/cs108/cs108.1082/106a-java-handouts/HO49ArrayList.pdf,
 						https://stackoverflow.com/questions/31718178/how-to-remove-the-brackets-from-arraylisttostring*/

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	protected String compName;
	protected String compID;
	protected String billAddr;
	protected String billCity;
	protected String billState;
	
	public Client(String compName,String compID,String billAddr,String billCity,String billState) {
		this.compName = compName;
		this.compID = compID;
		this.billAddr = billAddr;
		this.billCity = billCity;
		this.billState = billState;
	}
	
	public String toString() {
		return "Company Name: "+compName+"\nCompany ID: "+compID+"\nBilling Address: "+
				billAddr+"\nBilling City: "+billCity+"\nBilling State: "+billState;
	}

}

class HourlyClient extends Client {
	double hourlyRate;
	double hoursBilled;
	
	public HourlyClient(String compName,String compID,String billAddr,String billCity,
						String billState,double hourlyRate,double hoursBilled) {
		super(compName,compID,billAddr,billCity,billState);
		this.hourlyRate = hourlyRate;
		this.hoursBilled = hoursBilled;
	}
	
	public double serviceCharge() {
		double svcCharge = hourlyRate * hoursBilled;
		return svcCharge;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nHourly rate: $"+hourlyRate+"\nHours worked: "+hoursBilled+
					"\nBilled amount: $"+serviceCharge();
	}
	
}

class TestClient {
	public static void main(String[] agrs) {
		String compName = "";
		String compID = "";
		String billAddr = "";
		String billCity = "";
		String billState = "";
		double hourlyRate = 0.0;
		double hoursBilled = 0.0;
		double total = 0;
		
		for(int i=1; i<6; i++) {
			Scanner input = new Scanner(System.in);
			System.out.println("Client "+i);
			System.out.println("Enter company name: ");
			compName = input.nextLine();
			System.out.println("Enter company id: ");
			compID = input.nextLine();
			System.out.println("Enter company billing address: ");
			billAddr = input.nextLine();
			System.out.println("Enter company city location: ");
			billCity = input.nextLine();
			System.out.println("Enter company state location: ");
			billState = input.nextLine();
			System.out.println("Enter hourly rate: ");
			hourlyRate = input.nextDouble();
			System.out.println("Enter hours worked: ");
			hoursBilled = input.nextDouble();
			System.out.println();
			
			ArrayList<HourlyClient> hourlyClient = new ArrayList<>();
			hourlyClient.add(new HourlyClient(compName,compID,billAddr,billCity,billState,hourlyRate,hoursBilled));
			
			System.out.println(hourlyClient.toString().replace("[","").replace("]",""));
			System.out.println();
			
			for(int x=0; x<hourlyClient.size(); x++) {
				total+=hourlyClient.get(x).serviceCharge();
			}

		}
		System.out.println("Total billed for all companies: "+ total);

	}
}
