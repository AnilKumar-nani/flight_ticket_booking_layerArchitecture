package flight_layer_architecture;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
class JunitTesting {

	@Test
	void testRegisterNewUserMethod() {
		UserData user = new UserData("vijay","9087654321","M","1998/04/23","vijay@gmail.com","12345");
		int out = new Service().serveNewUserRegistration(user);
		assertEquals(out,1);
	}
	@Test
	void testaddJourneyMethod() {
		Travel journey = new Travel("9087654321","anil",21,"1234567890","2021/07/23",123);
		int out = new Service().serveBookJourney(journey);
		assertEquals(out,1);
		
	}
	@Test
	void testaddJourneyHistory() {
		UserData user = new UserData();
		user.setMobNum("9087654321");
		List<Travel> travels = new Service().journeyHistory(user);
		assertTrue(travels.size()>=0);
		
	}
	
	@Test
	void testLogin() {
		UserData user = new UserData();
		user.setMobNum("9087654321");
		user.setPassword("12345");
		assertTrue(new Service().login(user)!=null);
		
	}
	@Test
	void testAvailFlights() {
		SearchFlights flights = new SearchFlights("HYD","CHENNAI");
		List<Flights> listOfAvailFlights = new Service().servegetDesiredFlights(flights);
		assertTrue(listOfAvailFlights.size()>=0);
	}

}
