/**
 * GDisplayManager class initiate Graphical interfaces 
 * @author Arijit
 *
 */
public class GDisplayManager implements  DisplayManager{
	
	public FRSManager frsObj;
	public GInputScreen inputScreen;
	public GBookingScreen bookingScreen;
	public GFlightAvailability flightScreen;
	public GConfirmationPage confirmationScreen;
	public October october;
	public November november;
	/**
	 * Constructs and initializes an object of 'FRSManager' class.
	 * @param myMgr FRSManager Object
	 */
	public GDisplayManager(FRSManager myMgr){
		this.frsObj = myMgr;
	}
	/**
	 * initializing all GUI screens instance
	 */
	public void createScreens(){
		inputScreen = new GInputScreen(this);
		bookingScreen = new GBookingScreen(this);
		flightScreen = new GFlightAvailability(this);
		confirmationScreen = new GConfirmationPage(this);
		october = new October(this);
		november = new November(this);
	}
	/**
	 * calls first screen i.e Input Screen
	 */
	public void showInputScreen(){ 
		if(flightScreen.initiate) flightScreen.frame.setVisible(false);
		if(confirmationScreen.initiate)confirmationScreen.frame.setVisible(false);
		inputScreen.inputScreen();
	}
	
	/**
	 * calls third screen i.e Booking Screen
	 */
	public void showBookingScreen(){
		if(flightScreen.initiate)flightScreen.frame.setVisible(false);
		flightScreen.frame.setVisible(false);
		bookingScreen.bookingScreen();
	}
	/**
	 * calls second screen i.e Flight Availability screen
	 */
	public void showFlightScreen(){
		if(bookingScreen.initiate)bookingScreen.frame.setVisible(false);
		inputScreen.frame.setVisible(false);
		flightScreen.flightScreen();
	}
	/**
	 * calls last screen i.e confirmation screen
	 */
	public void showConfirmationScreen(){
		bookingScreen.frame.setVisible(false);
		confirmationScreen.confirmationScreen();
	}
	/**
	 * calls October calendar screen
	 */
	public void showOctober(){
		october.showOctober();
	}
	/**
	 * calls November calendar screen
	 */
	public void showNovember(){
		november.showNovember();
	}
}
