/**
 * @author Soumya
 */
import java.util.*;
public class SearchManager {
	FRSManager myMgr;
        /**
         * Constructs and initializes an object of 'FRSManager' class.
         * @param myMgr An object of 'FRSManager' class.
         */
	public SearchManager(FRSManager myMgr){
		this.myMgr = myMgr;
	}
        /**
         * Searches through flight routes and constructs a list of valid flight combinations.
         * @return Returns a list of valid flight combination.
         */
	public ArrayList<ComboFlight> search(){
		
		ArrayList<Flight> spiceJetList = filterSpiceJet(myMgr.getSpiceJet(), myMgr.getSource());
		ArrayList<Flight> silkAirList = new ArrayList<Flight>(Arrays.asList(myMgr.getSilkAir()));
		
		ArrayList<ComboFlight> comboList = new ArrayList<ComboFlight>();
		for(Flight spice: spiceJetList){
			for(Flight silk: silkAirList){
				if(spice.getDestination().equalsIgnoreCase(silk.getOrigin())){
					ComboFlight combo = new ComboFlight();
					if(combo.isValidCombo(spice, silk, myMgr.getDOJ(), myMgr.getSeatRequired(), myMgr.getSeats())){
						comboList.add(combo);
					}
				}
				
			}
		}
                /**
                 * This sorts the list of valid flight combinations in ascending order of transit time.
                 */
		if(!comboList.isEmpty())
			Collections.sort(comboList);
		
		return comboList;
	}
	/**
         * Filters SpiceJet flights on the basis on the city they are departing from.
         * @param flights All flights.
         * @param origin The city of origin.
         * @return The list of flights that are departing from the city of origin of journey.
         */
	private ArrayList<Flight> filterSpiceJet(Flight [] flights, String origin){
		ArrayList<Flight> spiceJetFil = new ArrayList<Flight>();
		for(Flight flight: flights ){
			if(flight.getOrigin().equalsIgnoreCase(origin))
				spiceJetFil.add(flight);
		}
		return spiceJetFil;
	}

}
