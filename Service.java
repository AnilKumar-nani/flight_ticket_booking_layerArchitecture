package flight_layer_architecture;

import java.util.List;

public class Service {
	
	private DataBaseConnection getObjectOfDbLayer() {
		return new DataBaseConnection();
	}
	
	public int serveNewUserRegistration(UserData user) {
		return getObjectOfDbLayer().newUserRegistration(user);
	}
	public int serveBookJourney(Travel journey) {
		return getObjectOfDbLayer().bookJourney(journey);
	}
	public List<Flights> servegetDesiredFlights(SearchFlights filterFlights) {
		return getObjectOfDbLayer().getDesiredFlights(filterFlights);
	}
	public UserData login(UserData user) {
		return getObjectOfDbLayer().verifyLogin(user);
	}
	public List<Travel> journeyHistory(UserData user) {
		return getObjectOfDbLayer().travelHistory(user);
	}
	
}
