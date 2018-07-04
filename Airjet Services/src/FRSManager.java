import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
/**
 * FRSManager links all the other manager classes i.e. DataManager,
 * SearchManager, BokingManager and DisplayManager. The manager 
 * classes communicates with each other via this class.
 * 
 * @author Sandeep Khan
 *
 */

public class FRSManager {
	
	public DataManager dataManager;
	public SearchManager searchManager;
	public DisplayManager dispMgr;
	public BookingManager bookingManager;
	
	private Flight[] spiceJet;
	private Flight[] silkAir;
	private int seatReq;
	private LocalDate dateOfJourney;
	private String source;
	private ComboFlight combo;
	private String registerName;
	
	/**
	 * Stores the name of the registrant
	 * @param name registrant name from the booking screen
	 */
	public void setRegisterName(String name){
		this.registerName  = name;
	}
	
	/**
	 * Stores source, date of journey and seats required by the user
	 * @param source source of journey entered by the user
	 * @param date date of journey entered by the user
	 * @param seat seats required by the user
	 */
	public void setInputScreenInformation(String source,String date,int seat){
		this.source = source;
		this.dateOfJourney = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yyyy"));
		this.seatReq = seat;
	}
	
	/**
	 * Stores the ComboFlight selected by the user
	 * @param combo ComboFlight selected by the user
	 */
	public void setCombo(ComboFlight combo){
		this.combo = combo;
	}
	
	/**
	 * Main function of the project
	 * @param args contains spicejet and silkair file name and may contain third argument to invoke Text Display
	 * @throws IOException
	 */
	public static void main(String[] args){
			if(args.length<2){
				System.out.println("File not found");
			}
			else{
				Scanner sc = new Scanner(System.in);
				FRSManager myMgr = new FRSManager();
			
				myMgr.dataManager = new DataManager(myMgr);
				myMgr.spiceJet = myMgr.dataManager.readSpiceJet(args[0].trim());
				if(myMgr.spiceJet[0]!=null){
				
					myMgr.silkAir = myMgr.dataManager.readSilkAir(args[1].trim());
			
					if(myMgr.silkAir[0]!=null){
						myMgr.searchManager = new SearchManager(myMgr);	
						myMgr.bookingManager = new BookingManager(myMgr);
			
						//mode=1 display GUI
						//mode=2 display Terminal
						int mode=1; 
						if(args.length == 3){
							if(args[2].equals("text"))
								mode = 2;
							else
								System.out.println("Display "+args[2]+" not implemented, defaulting to Swing Display");
						}
						if(mode==1){
							myMgr.dispMgr = new GDisplayManager(myMgr);
						}
						else{
							myMgr.dispMgr = new TDisplayManager(myMgr);
						}
						myMgr.dispMgr.createScreens();
						myMgr.dispMgr.showInputScreen();
                        
						sc.close();
					}
				}
			}
	}
	
	/**
	 * Returns all the spicejet flights in form of Flight array
	 * @return Flight array conatining all spicejet flights
	 */
	public Flight[] getSpiceJet(){return this.spiceJet;}
	
	/**
	 * Returns all the silkair flights in form of Flight array
	 * @return Flight array conatining all silkair flights
	 */
	public Flight[] getSilkAir(){return this.silkAir;}
	
	/**
	 * Returns the number of seats required by user
	 * @return seats required by the user
	 */
	public int getSeatRequired(){return this.seatReq;}
	
	/**
	 * Returns the source of journey entered by the user  
	 * @return source of journey
	 */
	public String getSource(){return this.source;}
	
	/**
	 * Returns the date of journey entered by the user
	 * @return date of journey
	 */
	public LocalDate getDOJ(){return this.dateOfJourney;}
	
	/**
	 * Returns the seats avalaible for all the spicejet and silkair flights as returned by the DataManager
	 * @return seats available for all flights
	 */
	public LinkedHashMap<Flight, ArrayList<Integer>> getSeats(){return this.dataManager.getSeats(this.spiceJet, this.silkAir);}
	
	/**
	 * Returns the name of the registrant
	 * @return name of the registrant
	 */
	public String getName(){return this.registerName;}
	
	/**
	 * Returns the ComboFlight selected by the user
	 * @return ComboFlight selected by the user
	 */
	public ComboFlight getCombo(){return this.combo;}
}
