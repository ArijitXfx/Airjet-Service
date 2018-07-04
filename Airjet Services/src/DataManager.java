import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
/**
 * 
 * @author Sayantan Dey
 *
 */
public class DataManager {
	
	
	FRSManager myMgr;
	
	/**
     * this is the constructor of DataManager class which will instantiate 
     * a FRSManager type object whenever an object is created
     * @param myMgr FRSManager object
     */
	public DataManager(FRSManager myMgr){
		this.myMgr = myMgr;
	}
    
	/**
     * this method will read the data from spicejet.csv and stuff it to the flight object
     * @param spicejetFile spicejet file name
     * @return spiceJet	Fligth array containing all spiceJet Flights 
     */
    public Flight[] readSpiceJet(String spicejetFile){
    	
    	String[] monthsArr = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    	ArrayList<String> Months = new ArrayList<String>(Arrays.asList(monthsArr));
    	
        Flight[] spiceJet = new Flight[57];
        BufferedReader br = null;
        
        try{
           br = new BufferedReader(new FileReader(spicejetFile));
            
            String line;
            int j=0;
            
            for(int k=1;k<=5;k++)
                line = br.readLine();
            
            while((line=br.readLine())!=null){
                
                StringTokenizer st = new StringTokenizer(line,"|");
                Flight flight = new Flight();
                
                flight.setOrigin(st.nextToken());
                flight.setDestination(st.nextToken());
                
                StringTokenizer freq  = new StringTokenizer(st.nextToken(),",");
                String[] days = new String[freq.countTokens()];
                for(int i=0; i<days.length;i++)
                    days[i] = freq.nextToken().trim();
                flight.setFrequency(days);
                
                flight.setFlightNo(st.nextToken());
                
                String departure = st.nextToken();
                String arrival  = st.nextToken();
                
                //Changing arrival and departure from 12hrs format to 24hrs format without ':' between hrs and mins.
                //Adding "+1" at the end of arrival if departure is in PM and arrival is in AM 
                flight.setDeparture(LocalTime.parse(departure, DateTimeFormatter.ofPattern("hh:mm a")).toString().replace(":", ""));
                if(departure.contains("PM") && arrival.contains("AM"))
                	flight.setArrival(LocalTime.parse(arrival, DateTimeFormatter.ofPattern("hh:mm a")).toString().replace(":", "")+"+1");
                else
                	flight.setArrival(LocalTime.parse(arrival, DateTimeFormatter.ofPattern("hh:mm a")).toString().replace(":", ""));
                
                
                
                
                flight.setVia(st.nextToken());
                
                String date[] = st.nextToken().split(" ");
                
                //Setting effectiveFrom and effectiveTill in d/M/yyyy format
                flight.setEffectiveFrom(date[0] + "/" + (Months.indexOf(date[1])+1) + "/20" +date[2]);
                date = st.nextToken().split(" ");
                flight.setEffectiveTill(date[0] + "/" + (Months.indexOf(date[1])+1) + "/20" +date[2]);
                
                flight.setRemarks(null);
                
                spiceJet[j++] = flight;
            }
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
         }catch(IOException e){
         	System.out.println(e.getMessage());
         }finally{
            try{
            	if(br!=null)
            		br.close();
            }catch(IOException e){
            	System.out.println(e.getMessage());
            }
        }
        return spiceJet;
    }
    
    /**
     * this method reads the flight data from silkair.csv file and stuff it to flight object
     * @param silkairFile silkair file name
     * @return silkAir	Fligth array containing all silkAir Flights 
     */
    public Flight[] readSilkAir(String silkairFile){
        Flight[] silkAir = new Flight[16];
        BufferedReader br = null;
        
        try{
           br = new BufferedReader(new FileReader(silkairFile));
            
            String line;
            int j=0;
            
            for(int k=1;k<=3;k++)
                line = br.readLine();
            
            while((line=br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line,"|");
                Flight flight = new Flight();
                flight.setVia("-");
                
                flight.setDestination("Singapore");
                flight.setOrigin(st.nextToken().split(" ")[0]);
                
                StringTokenizer freq  = new StringTokenizer(st.nextToken(),",");
                String[] days = new String[freq.countTokens()];
                for(int i=0; i<days.length;i++)
                    days[i] = freq.nextToken();
                flight.setFrequency(days);
                
                flight.setFlightNo(st.nextToken());
                
                String time = st.nextToken();
                flight.setDeparture(time.split("/")[0]);
                flight.setArrival(time.split("/")[1]);
                
                String last = st.nextToken();
                setEffective(last,flight);
                
                silkAir[j++] = flight;
            }
        }catch(FileNotFoundException e){
           System.out.println(e.getMessage());
        }catch(IOException e){
        	System.out.println(e.getMessage());
        }finally{
            try{
            	if(br!=null)
            		br.close();
            }catch(IOException e){
            	System.out.println(e.getMessage());
            }
        }
        return silkAir;
    }
    
    /**
     * this function sets the EffectiveFrom and EffectiveTill of silkAir flights
     * @param last remark section of silkair file
     * @param flight silkAir flight
     */
    private void setEffective(String last, Flight flight){
        StringTokenizer st = new StringTokenizer(last,",");
        if(st.countTokens()==0){
            flight.setEffectiveFrom("01/09/2016");
            flight.setEffectiveTill("13/11/2016");
            flight.setRemarks(null);
        }
        
        else{
            String line = st.nextToken();
            if(line.indexOf('-')!=-1){
            	//if line contains '-'
                flight.setEffectiveFrom(changeDateFormat(line.substring(0, line.indexOf('-') - 1)));
                flight.setEffectiveTill(changeDateFormat(line.substring(line.indexOf('-') + 2)));
                flight.setRemarks(null);
            }
            
            else if(line.contains("Eff.")){
                flight.setEffectiveFrom(changeDateFormat(line.substring(5)));
                flight.setEffectiveTill("13/11/2016");
                flight.setRemarks(null);
            }
            
            else if(line.contains("Disc.")){
                flight.setEffectiveFrom("01/09/2016");
                flight.setEffectiveTill(changeDateFormat(line.substring(6))); 
                
                if(st.hasMoreTokens()){
                    String[] remarks = new String[st.countTokens()];
                    for(int i=0;i<remarks.length;i++){
                        String exc = st.nextToken().trim();
                        if(exc.contains("Exc."))
                            remarks[i] = changeDateFormat(exc.split(" ")[1]);//i.e. separating the Exc. word from the date part 
                        else
                            remarks[i] = changeDateFormat(exc);
                    }
                    flight.setRemarks(remarks);
                }
                else
                    flight.setRemarks(null);
            }
            
        }
    }
    
    /**
     * this function formates the date to d/M/yyyy format
     * @param date date to be formatted
     * @return nDate date in d/M/yyyy format
     */
    private String changeDateFormat(String date){
    	
    	String[] monthsArr = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    	ArrayList<String> Months = new ArrayList<String>(Arrays.asList(monthsArr));
    	
        String nDate = date.substring(3)+"/"+(Months.indexOf(date.substring(0, 3))+1)+"/2016";
        return nDate;
    }
    
    /**
     * Returns LinkedHashMap containing all the flights of spiceJet and silkair along with there seat information 
     * given in the Seat.txt file. If the file is not present it creates a Seat.txt file.
     * @param spiceJet Flight array containing all spiceJet flights 
     * @param silkAir Flight array containing all silkAir flights
     * @return LinkedHashMap containing all the flights as key and there seat information as values
     */
    public LinkedHashMap<Flight, ArrayList<Integer>> getSeats(Flight[] spiceJet, Flight[] silkAir){
       
    	File file = new File("Seats.txt");
        
        if(!file.exists())
            createFile(spiceJet, silkAir);
        
        LinkedHashMap<Flight, ArrayList<Integer>>  seats= new LinkedHashMap<Flight, ArrayList<Integer>>();
        BufferedReader br = null;
        try{
           br = new BufferedReader(new FileReader("Seats.txt"));
            for(int i=1;i<=73;i++){
                
            	//storing all the integer values, separated by comma, present in a line in ArrayList<Integer> key
            	StringTokenizer line = new StringTokenizer(br.readLine(),",");
                ArrayList<Integer> key = new ArrayList<Integer>();
                
                while(line.hasMoreTokens())
                    key.add(Integer.parseInt(line.nextToken()));
                
                //first 57 lines contains the seat details of spiceJet flights
                //remaining contains the seat details of silkAir flights
                //Therefore for first 57 lines the keys for the hash map are spiceJet flights
                //and for remaining it's silkAir flights
                if(i>57)
                    seats.put(silkAir[i-58], key);
                else
                    seats.put(spiceJet[i-1], key);
            }
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }finally{
            try{
            	if(br!=null)
            		br.close();
            }catch(IOException e){
            	System.out.println(e.getMessage());
            }
        }
        return seats;
    }
    
    /**
     * Creates the Seats.txt file with each Flight having either 15 or 0 seats based of frequency and date of availability
     * @param spiceJet Flight array containing all sppiceJet flights 
     * @param silkAir Flight array containing all silkAir flights 
     */
    private void createFile(Flight[] spiceJet, Flight[] silkAir){
        
        LocalDate startDate = LocalDate.parse("2016-10-01");
        LocalDate  endDate = LocalDate.parse("2016-11-14");
        FileWriter file=null;
        
        try{
            file = new FileWriter("Seats.txt");
            for(Flight flight: spiceJet){
                createLine(file , startDate, endDate, flight);
                //storing value 0 for 14Nov 2016 and 15Nov 2016 seperated by comma
                file.write("0,0,\r\n");
            }
            for(Flight flight:silkAir){
                createLine(file, startDate, endDate, flight);
                //storing value 0 for 14Nov 2016 and 15Nov 2016 seperated by comma
                file.write("0,0,\r\n");
            }
            
        }catch(Exception e){
        	System.out.println(e.getMessage());
        }finally{
            try{
            	if(file!=null)
            		file.close();
            }catch(Exception e){
            	System.out.println(e.getMessage());
            }
        }
        
    }
    
    /**
     * Create each line of Seats.txt file. Each line contains the number of seats available starting from Oct1 2016 to Nov15 2016 each value separated by a comma.
     * This functions only provide values from Oct1 to Nov13 which is one less than the endDate
     * @param file Seats.txt file
     * @param startDate	which is Oct1 2016
     * @param endDate which is Nov14 2016
     * @param flight Flight object. Can be spiceJet or silkAir
     */
    private void createLine(FileWriter file, LocalDate startDate, LocalDate endDate, Flight flight){
        try{
            while(!startDate.equals(endDate)){
            	//checking if startDate falls between flight's effectiveFrom and effectiveTill date
                if(startDate.compareTo(flight.getEffectiveFrom())>=0 && startDate.compareTo(flight.getEffectiveTill())<=0){
                    
                	if(flight.getRemarks()!=null){
                        if(Arrays.asList(flight.getRemarks()).contains(startDate)){
                        	//if startDate matches with any of Exc. date of that flight
                            file.write("0,");
                            startDate = startDate.plusDays(1);
                            continue;
                        }
                    }
                    boolean[] freq = flight.getFrequency();
                    //checking if the flight is available on the day of week of the startDate
                    if(freq[startDate.getDayOfWeek().getValue()-1])
                        file.write("15,");
                    else
                        file.write("0,");
            
                }
                else
                    file.write("0,");
                startDate = startDate.plusDays(1);
            }
        }catch(IOException e){
        	System.out.println(e.getMessage());
        }
    }
    
    /**
     * this function will write booking details of a passenger to a booking.txt file
     */
	public void writeBooking(){
		FileWriter file = null;
		
		try{
			file = new FileWriter("booking.txt",true);
			file.write(myMgr.bookingManager.toString());
			file.write("\r\n");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(file!=null)
					file.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
    
	/**
	 *this function will reduce the seats of spiceJet and silkAir flight, selected as the combo, by the value of seatReq
	 * @param combo the ComboFlight selected 
	 * @param seatReq seat required by the user
	 */
	public void upDateSeats(ComboFlight combo, int seatReq){
    	LinkedHashMap<Flight, ArrayList<Integer>> seats = myMgr.getSeats();
    	
    	//Calculating the index of the ArrayList<Inetegr> of the seats whose value needs to be decremented
    	int index = (int)LocalDate.parse("2016-10-01").until(combo.getSpiceDate(), ChronoUnit.DAYS);
    	Integer spiceSeat = seats.get(combo.getSpiceJet()).get(index);
    	spiceSeat -= seatReq;
    	seats.get(combo.getSpiceJet()).set(index, spiceSeat);
    	
    	//checking if the date of departure of both spiceJet and silkAir flight is not equal
    	if(!(combo.getSpiceDate().equals(combo.getSilkDate())))
    		index+=1;
    	
    	Integer silkSeat = seats.get(combo.getSilkAir()).get(index);
    	silkSeat -=seatReq;
    	seats.get(combo.getSilkAir()).set(index, silkSeat);
    	
    	FileWriter file = null;
    	try{
    		
    		file = new FileWriter("Seats.txt");
    		for(Map.Entry<Flight, ArrayList<Integer>> seat: seats.entrySet()){
    			for(Integer x: seat.getValue()){
    				//Writing integer values for a line in Seats.txt file followed by a comma 
    				file.write(x.toString()+",");
    			}
    			file.write("\r\n");
    		}
    		
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}finally{
    		try{
    			if(file!=null)
    				file.close();
    		}catch(Exception e){
    			System.out.println(e.getMessage());
    		}
    	}
    }
}

