/**
 * @author Soumya
 */
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
public class ComboFlight implements Comparable<ComboFlight>{
		
		private long transit;
		private long total;
		private Flight spiceJet;
		private Flight silkAir;
		private LocalDate spiceDate;
		private LocalDate silkDate;
                /**
                 * Checks if any valid combination of flights exist for the entered details of journey.
                 * @param spiceJet An object of 'Flight' class.
                 * @param silkAir An object of 'Flight' class.
                 * @param date A 'LocalDate' object.
                 * @param seatReq An integer variable representing the number of seats requested in a booking.
                 * @param seats A LinkedHashMap with keys of 'Flight' type. This represents the number of seats that are vacant.
                 * @return Returns true if valid, false otherwise.
                 */
		public boolean isValidCombo(Flight spiceJet, Flight silkAir, LocalDate date, int seatReq, LinkedHashMap<Flight, ArrayList<Integer>> seats){
			
			this.spiceJet = spiceJet;
			this.silkAir = silkAir;
			spiceDate = date;
			LocalDateTime spiceDep=null, spiceArr=null;
			
			DateTimeFormatter spiceTimeFormat = DateTimeFormatter.ofPattern("HHmm");
			
			if(dateAndSeatChecker(spiceJet,date,seatReq,seats)){
				spiceDep = LocalDateTime.of(date, LocalTime.parse(spiceJet.getDeparture(),spiceTimeFormat));
				spiceArr = LocalDateTime.of(date, LocalTime.parse(spiceJet.getArrival().substring(0,4), spiceTimeFormat));
				
				//if(spiceJet.getDeparture().contains("PM") && spiceJet.getArrival().contains("AM"))
				if(spiceJet.getArrival().contains("+"))
					spiceArr = spiceArr.plusDays(1);
				
				if(checkTransit(spiceDep, spiceArr,spiceArr.toLocalDate(), seatReq, seats))
					return true;
				
				if(checkTransit(spiceDep, spiceArr, spiceArr.toLocalDate().plusDays(1), seatReq, seats))
					return true;
			}
			return false;
		}
		/**
                 * Checks if the requested date and number of seats can be considered as possible options for a booking.
                 * @param flight An object of 'Flight' class.
                 * @param date A 'LocalDate' object.
                 * @param seatReq An integer variable representing the number of seats requested in a booking.
                 * @param seats A LinkedHashMap with keys of 'Flight' type. This represents the number of seats that are vacant.
                 * @return Returns true if requested date and seats are possible, false otherwise.
                 */	
                private boolean dateAndSeatChecker(Flight flight, LocalDate date, int seatReq, LinkedHashMap<Flight, ArrayList<Integer>> seats){
			int index = (int)LocalDate.parse("2016-10-01").until(date, ChronoUnit.DAYS);
			if(seats.get(flight).get(index)>=seatReq)
				return true;
			return false;
		}
		/**
                 * Checks if the transit time between the two connecting flights
                 * is valid for a booking to be made.
                 * @param spiceDep A 'LocalDateTime' object.
                 * @param spiceArr A 'LocalDateTime' object.
                 * @param date A 'LocalDate' object representing the date of journey.
                 * @param seatReq An integer variable representing the number of seats requested in a booking.
                 * @param seats A LinkedHashMap with keys of 'Flight' type. This represents the number of seats that are vacant.
                 * @return Returns true if the transit time is valid as per the project guidelines, false otherwise.
                 */
		private boolean checkTransit(LocalDateTime spiceDep, LocalDateTime spiceArr , LocalDate date , int seatReq, LinkedHashMap<Flight, ArrayList<Integer>> seats){
			silkDate = date;
		    DateTimeFormatter silkTimeFormat = DateTimeFormatter.ofPattern("HHmm");
			if(dateAndSeatChecker(silkAir, date, seatReq,seats)){
				
				LocalDateTime silkDep = LocalDateTime.of(date, LocalTime.parse(silkAir.getDeparture(), silkTimeFormat));
				LocalDateTime silkArr = LocalDateTime.of(date, LocalTime.parse(silkAir.getArrival().substring(0,4), silkTimeFormat));
				
				if(silkAir.getArrival().contains("+"))
					silkArr = silkArr.plusDays(1);
				
				transit = spiceArr.until(silkDep, ChronoUnit.MINUTES);
				if(transit>=120 && transit<=360){
					total = spiceDep.until(spiceArr, ChronoUnit.MINUTES) + transit + silkDep.until(silkArr, ChronoUnit.MINUTES) - 150;
					return true;
				}
				
			}
			
			return false;
		}
		/**
                 * Compares valid flight combinations based on their transit time.
                 * @param obj The other flight combination that this one is being compared to. 
                 */
		@Override
		public int compareTo(ComboFlight obj){
			if(this.getTotal()>obj.getTotal())
				return 1;
			else if(this.getTotal()<obj.getTotal())
				return -1;
			else
				return 0;
		}
		/**
                 * Returns the time between a SpiceJet and a SilkAir flight.
                 */
		public long getTransit(){return transit;}
		/**
                 * Returns the transit time between a SpiceJet and a SilkAir flight for a valid combo. 
                 */
                public long getTotal(){return total;}
                /**
                 * Returns spiceJet of 'Flight' class.
                 */
                public Flight getSpiceJet(){return spiceJet;}
                /**
                 * Returns silkAir of 'Flight' class.
                 */
                public Flight getSilkAir(){return silkAir;}
                /**
                 * Returns spiceDate of 'LocalDate' class.
                 */
                public LocalDate getSpiceDate(){return spiceDate;}
                /**
                 * Returns silkDate of 'LocalDate' class.
                 */
                public LocalDate getSilkDate(){return silkDate;}
}
