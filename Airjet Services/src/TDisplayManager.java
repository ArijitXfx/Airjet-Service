import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Text based Display Manager
 * to show input or output text based
 * @author Arijit
 *
 */
public class TDisplayManager implements DisplayManager{
	public FRSManager frsObj;
	ArrayList<ComboFlight> comboList;
	private ComboFlight comboFlight;
	public Scanner sc;
	public String date;
	public String source;
	public int seat;
	
	/**
	 * Constructs and initializes an object of 'FRSManager' class.
	 * @param mgr FRSManager object
	 */
	public TDisplayManager(FRSManager mgr){
		this.frsObj = mgr;
	}

	public void createScreens(){
		//Do Nothing
	}
	/**
	 * Takes source, date and seats from user
	 */
	public void showInputScreen(){
		 sc = new Scanner(System.in);
	        System.out.println("---------Welcome to AirJet Flight Booking Service---------");
	        while(true){
	        	try {
	        		//date input
	            	while(true){
	            		System.out.println("Enter date of travel in dd/mm/yyyy between 01/10/2016 to 13/11/2016");
	                    this.date = sc.next();
	                    try{
	                    	Date initialDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2016");
	            			Date finalDate = new SimpleDateFormat("dd/MM/yyyy").parse("13/11/2016");
	            			Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
	            			int month = Integer.parseInt(""+date.charAt(4));
	            			int day = Integer.parseInt(""+date.charAt(0)+date.charAt(1));
	            			//date is in between 01/10/2016 or after 13/11/2016 and also date validator
	            			if(currentDate.compareTo(initialDate)<0 || currentDate.compareTo(finalDate)>0||(month==0&&day>31)){
	            				System.out.println("Invlid date");
	            			}else{
	            				break;
	            			}
	                    }catch(Exception ex){
	                    	System.out.println("Invalid date");
	                    }
	                    
	            	}
	            	//Source input
	        		while(true){
	        			System.out.println("Enter source of journey (Delhi, Pune, Mumbai)");
	                    this.source = sc.next();
	                    String lower = source.toLowerCase();
	                    if(!lower.equals("delhi") && !lower.equals("pune") && !lower.equals("mumbai")){
	                    	System.out.println("Invalid input");
	                    }else{
	                    	break;
	                    }
	        		}
	        		//No of passenger input
	        		while(true){
	        			 System.out.println("Enter number of seats (1 to 10)");
	        			 try{
	    	    	         this.seat = Integer.parseInt(sc.next());
	    	    	         if(seat<1){
	    	    	        	System.out.println("Requested seat should be a possetive number");
	    	    			}else if(seat>10){
	    	    				System.out.println("Can not book more than 10 seats");
	    	    			}else{
	    	    				break;
	    	    			}
	        			 }catch(Exception ex){
	    	    	    	 System.out.println("Invalid input");
	    	    	     }
	        		}
	    			this.frsObj.setInputScreenInformation(source, date, seat);
	    		    this.showFlightScreen();
	    		} catch (Exception ex) {
	    			// TODO Auto-generated catch block
	    			System.out.println("Invalid Input");
	    		}			
	        }
	}
	/**
	 * takes passenger name
	 */
	public void showBookingScreen(){
		System.out.println("\n---------Booking Screen---------");
		sc = new Scanner(System.in);
        while(true){
        	System.out.print("Enter Register Name: "); 
            String regName = sc.nextLine();
            //checks if passenger name contain any number or special character except '-'
        	if(regName.matches("[a-zA-Z- ]+")){
        		this.frsObj.setRegisterName(regName);
                this.frsObj.bookingManager.book();
                this.showConfirmationScreen();
				this.showConfirmationScreen();
			}else{
				System.out.println("Invalid Input");
			}
        }
    }  
	/**
	 * show all available flights
	 */
	public void showFlightScreen(){
		System.out.println("\n---------Flights List---------");
		sc = new Scanner(System.in);
    	comboList = this.frsObj.searchManager.search();
    	
    	//print flight details
		if(!comboList.isEmpty()){
			int i = 1;
			for(ComboFlight combo: comboList){
				String silkVia = " (Via "+combo.getSilkAir().getVia()+")";
		    	String spiceVia = " (Via "+combo.getSpiceJet().getVia()+")";
		    	if(silkVia.equals(" (Via -)")){
					silkVia = "";
				}
				if(spiceVia.equals(" (Via -)")){
					spiceVia = "";
				}
				System.out.println(i++ +" "+ combo.getSpiceJet().toString()+ spiceVia+"\n" +"  "+ combo.getSilkAir().toString()+silkVia);
				System.out.println("  Total Time: "+combo.getTotal()/60+"hrs "+combo.getTotal()%60+"min\n");
			}
			int index = 0;
			//user select a combo flight
			while(true){
				try{
					System.out.print("Select a combo:");
					index = sc.nextInt();
					if(index<1 || index>comboList.size()){
						System.out.println("Invalid Input");
					}else{
						break;
					}
				}catch(Exception ex){
					System.out.println("Invalid Input");
					sc.next();
				}
			}
			String ch = "";
			//user confirm to book
			while(true){
				System.out.println("Book it y/n");
				ch =sc.next();
				if(ch.equals("y") || ch.equals("n")||ch.equals("Y") || ch.equals("N")){
					break;
				}else{
					System.out.println("Invalid Input");
				}
			}
			
			if(ch.equals("y")){
				this.frsObj.setCombo(comboList.get(index-1));
				this.showBookingScreen();
			}else{
                this.showFlightScreen();
            }
		}else{
			System.out.println("No Flight is available");
			this.showInputScreen();
		}
		sc.close();
	}
	/**
	 * show booking number, Flight and passenger details
	 */
	public void showConfirmationScreen(){
		System.out.println("\n---------"+this.frsObj.getName()+"'s Ticket---------");
		sc = new Scanner(System.in);
    	comboFlight = this.frsObj.getCombo();
    	System.out.println();
    	System.out.println("----------------------------------------------------");
    	String silkVia = "  Via "+comboFlight.getSilkAir().getVia();
    	String spiceVia = "  Via "+comboFlight.getSpiceJet().getVia();
    	
    	//if via is null then it will not show anything
    	if(silkVia.equals("  Via -")){
			silkVia = "";
		}
		if(spiceVia.equals("  Via -")){
			spiceVia = "";
		}
		//Attaching all the information into flightDetails variable
		String flightDetails = "Booking Id: "+ this.frsObj.bookingManager.getBookingId()+"\n";
		flightDetails +=comboFlight.getSpiceJet().getFlightNo()+ " ---> " +comboFlight.getSpiceJet().getOrigin()+" - "+comboFlight.getSpiceJet().getDestination()+spiceVia;
		flightDetails +="\nTime: "+comboFlight.getSpiceJet().getDeparture()+" - "+comboFlight.getSpiceJet().getArrival();
		
		flightDetails+= "\n"+comboFlight.getSilkAir().getFlightNo()+" ---> " + comboFlight.getSilkAir().getOrigin()+" - "+comboFlight.getSilkAir().getDestination()+silkVia;
		flightDetails += "\nTime: "+comboFlight.getSilkAir().getDeparture()+" - "+comboFlight.getSilkAir().getArrival();
		
		flightDetails += "\nTotal Time: "+comboFlight.getTotal()/60+"hrs "+comboFlight.getTotal()%60+"min";
		System.out.println(flightDetails);
		System.out.println();
		String passengerDetail = "Passenger Name: "+ this.frsObj.getName();
		passengerDetail += "\nSeats: "+this.frsObj.getSeatRequired();
		passengerDetail += "\nDate: " + this.frsObj.getDOJ().toString();
		
		System.out.println(passengerDetail);
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		//user checks if the ticket is right or not
		while(true){
			System.out.print("Do you want to proceed?\n1.Yes\n2.No\nSelect:");
			String ch = sc.next();
			if(ch.equals("1")){
				
				//Code goes here
				this.frsObj.dataManager.writeBooking();
				this.frsObj.dataManager.upDateSeats(this.frsObj.bookingManager.getCombo(),this.frsObj.getSeatRequired());
				
				break;
			}else if(ch.equals("2")){
				break;
			}else{
				System.out.println("Invalid Choice");
			}
		}
		
		while(true){
			//user decide whether he make another reservation or not
			System.out.print("\nDo you want to make another reservation?\n1.Yes\n2.No\nSelect:");
			
			String choice = sc.next();
			if(choice.equals("1")){
				System.out.println("---------------------------------");
				this.showInputScreen();
			}else if(choice.equals("2")){
				System.out.println("Thank you for using AirJet Flight Booking Service. Have to good day!");
				System.exit(0);
			}else{
				System.out.println("Invalid Choice");
			}
		}
	}
	
}
