/**
 * @author Soumya
 */
import java.time.LocalDate;
import java.util.*;
public class BookingManager {
	
	FRSManager mgr;
	
	private String name;
	private int bookingId;
	private String origin;
	private LocalDate date;
	private int seatReq;
	private ComboFlight combo;
	/**
         * Constructs and initializes an object of 'FRSManager' class.
         * @param mgr An object of 'FRSManager' class.
         */
	public BookingManager(FRSManager mgr){
		this.mgr = mgr;
	}
	/**
         * Generates a random number between 0 and 100000000.
         * @return integer value in the range 0 to 100000000
        */
	private int getID(){
		Random r = new Random();
		return r.nextInt(100000000);
	}
	/**
         * Sets all the booking information in the booking manager.
         */
	public void book(){
		this.bookingId = this.getID();
		this.name = mgr.getName();
		this.origin = mgr.getSource();
		this.date = mgr.getDOJ();
		this.seatReq = mgr.getSeatRequired();
		this.combo = mgr.getCombo();
	}
	/**
         * 
         * @return Returns the booking ID for the booking being made.
         */
	public int getBookingId(){return this.bookingId;}
	/**
         * Returns the 'ComboFlight' object.
         * @return
         */
        public ComboFlight getCombo(){return this.combo;}
	/**
         * Converts all the booking details into a single line ready to be
         * written into a file.
         * @return the entire booking information in a string format with
         * different fields separated by a ','.
         */
	public String toString(){
		return this.bookingId + "," + this.name + "," + this.origin +","+this.combo.getSpiceJet().getFlightNo()+"-"+this.combo.getSilkAir().getFlightNo()+ "," + this.date.toString() + "," + this.seatReq;
	}
}
