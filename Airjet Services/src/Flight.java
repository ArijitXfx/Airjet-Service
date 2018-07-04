import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Sayantan Dey
 *
 */
public class Flight {
	private String origin;
	private String destination;
	private boolean[] frequency = {false,false,false,false,false,false,false};
	private String flightNo;
	private String depart;
	private String arrv;
	private LocalDate startDate;
	private LocalDate endDate;
	private String via;
	private LocalDate[] remarks;
	
	/**
	 * Stores the source city of the Flight
	 * @param origin source city of the Flight
	 */
	public void setOrigin(String origin){
		this.origin = origin.toUpperCase().trim();
	}
	
	/**
	 * Stores the destination city of the Flight
	 * @param destination destination city of the Flight
	 */
	public void setDestination(String destination){
		this.destination = destination.toUpperCase();
	}
	
	/**
	 * Stores the frequency of the Flight
	 * @param days days of week on which the Flight fly 
	 */
	public void setFrequency(String[] days){
		
		String[] DaysArr ={"MONDAY","TUESDAY", "WEDNESDAY","THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY", "Mon", "Tue", "Wed","Thu", "Fri", "Sat", "Sun"};
        ArrayList<String> Days = new ArrayList<String>(Arrays.asList(DaysArr));
        
		for(String day: days){
			if(day.equalsIgnoreCase("Daily")) {Arrays.fill(frequency, true);}
			
			else{
				frequency[Days.indexOf(day) % 7] = true;
			}
		}
	}
	
	/**
	 * Stores the flight number of the Flight 
	 * @param number flight number of the Flight
	 */
	public void setFlightNo(String number){
		flightNo = number.trim();
	}
	
	/**
	 * Store the departure time of the Flight
	 * @param dept departure time of the Flight
	 */
	public void setDeparture(String dept){
		depart = dept.trim();
	}
	
	/**
	 * Store the arrival time of the Flight
	 * @param arrival arrival time of the Flight
	 */
	public void setArrival(String arrival){
		arrv = arrival.trim();
	}
	
	/**
	 * Store the date from which the Flight is effective
	 * @param date effectiveFrom date
	 */
	public void setEffectiveFrom(String date){
		startDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
	}
	
	/**
	 * Store the date till which the Flight is effective
	 * @param date effectiveTill date
	 */
	public void setEffectiveTill(String date){
		endDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
	}
	
	/**
	 * Store the via city of the Flight
	 * @param via city via which the Flight travel 
	 */
	public void setVia(String via){
		this.via = via;
	}
	
	/**
	 * Store the Exc. dates on which the Flight doesn't fly. If no such date
	 * is present it stores null
	 * @param remarks array of Exc. dates
	 */
	public void setRemarks(String[] remarks){
		if(remarks==null)
			this.remarks = null;
		else{
			LocalDate[] excDate = new LocalDate[remarks.length];
			for(int i=0;i<remarks.length;i++){
				excDate[i] = LocalDate.parse(remarks[i], DateTimeFormatter.ofPattern("d/M/yyyy")); 
			}
			this.remarks = excDate;
		}
	}
	
	/**
	 * Returns the origin city of the Flight
	 * @return origin city of the Flight
	 */
	public String getOrigin(){return origin;}
	
	/**
	 * Returns frequency of the Flight
	 * @return frequency of Flight
	 */
	public boolean[] getFrequency(){return frequency;}
	
	/**
	 * Returns destination city of the Flight
	 * @return destination city of the Flight
	 */
	public String getDestination(){return destination;}
	
	/**
	 * Return flight number of the Flight
	 * @return flight number of the Flight
	 */
	public String getFlightNo(){return flightNo;}
	
	/**
	 * Returns the departure time of the Flight
	 * @return departure time of the Flight
	 */
	public String getDeparture(){return depart;}
	
	/**
	 * Returns the arrival time of the Flight
	 * @return arrival time of the Flight
	 */
	public String getArrival(){return arrv;}
	
	/**
	 * Returns the date from which the Flight is effective
	 * @return effectiveFrom date of the Flight
	 */
	public LocalDate getEffectiveFrom(){return startDate;}
	
	/**
	 * Returns the date till which the Flight is effective
	 * @return effectiveTill date of the Flight
	 */
	public LocalDate getEffectiveTill(){return endDate;}
	
	/**
	 * Returns array of Exc. date/dates of the Flight
	 * @return Exc. date/dates of the Flight
	 */
	public LocalDate[] getRemarks(){return remarks;}
	
	/**
	 * Returns the city via which the Flight travels
	 * @return city name via which the Flight travels
	 */
	public String getVia(){return via;}
	
	/**
	 * @return flight number, Flight's origin city, Flight's destination city, Flight's departure time and Flight's arrival time all separated by a space 
	 */
	public String toString(){
		return this.flightNo+" "+this.origin+" "+this.destination+" "+this.depart+" "+this.arrv;
	}

}
