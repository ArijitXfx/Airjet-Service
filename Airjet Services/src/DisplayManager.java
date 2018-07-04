 /**
 * author: Arijit Basu
 * Interface of DisplayManager class
 */
public interface DisplayManager {
	/** 
	 * createScreen method will instantiate all the screens objects
	 */
	public void createScreens();
	/**
	 * showInputScreen method will show the first screen i.e Input Screen 
	 */
	public void showInputScreen();
	
	/**
	 * showFlightScreen method will show the second screen i.e Flight Screen
	 */
	public void showFlightScreen();
	
	/**
	 * showBookingScreen method will show the third screen i.e Booking Screen
	 */
	public void showBookingScreen();
	
	/**
	 * showConfirmationScreen method will show the forth screen i.e Confirmation Screen
	 */
	public void showConfirmationScreen();
}
