package flight_layer_architecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public boolean registerNewUser() {
		UserData userN = new UserData();
		try {
			System.out.println("Your Name");
			userN.setName(br.readLine());
			System.out.println("Your MobileNumber");
			userN.setMobNum(br.readLine());
			System.out.println("Your Date Of Birth");
			userN.setDob(br.readLine());
			System.out.println("Enter Gender");
			userN.setGender(br.readLine().substring(0,1));
			System.out.println("Enter Password");
			String passw = br.readLine();
			
			
				userN.setPassword(passw);
				System.out.println("Enter Your email");
				userN.setEmail(br.readLine());
				
				int act = new Service().serveNewUserRegistration(userN);
				if(act==1) {
					System.out.println(" User Successfully Registered");
					return true;
				}
				else if(act==0) {
					System.out.println("User already exist");
					return false;
				}
			
			
		} catch (IOException e) {
			System.out.println(" 404 Error");
		}
		return false;
		
	}
	UserData loginUser() {
		UserData user = new UserData();
		try {
			System.out.println("Your MobileNumber");
			user.setMobNum(br.readLine());
			System.out.println("Your Password");
			user.setPassword(br.readLine());
			user = new Service().login(user);
			return user;
		} catch (IOException e) {
			return null;
		}
	}
	
	Travel findJourney(UserData user) {
		SearchFlights flights = new SearchFlights();
		Travel journey=null;
		try {
			System.out.println("From");
			flights.setFrom(br.readLine());
			System.out.println("To");
			flights.setTo(br.readLine());
			List<Flights> availFlights = new Service().servegetDesiredFlights(flights);
			int flightInd=0;
			if(availFlights!=null) {
				for(Flights eachAvailFlights:availFlights) {
					System.out.println("Choice:"+ ++flightInd +"-->"+eachAvailFlights);
				}
				System.out.println("Select Flight");
				int choiceOfFlight=Integer.parseInt(br.readLine());
				if(choiceOfFlight>0 && choiceOfFlight<=availFlights.size()) {
					journey = new Travel();
					journey.setFlightNumber(availFlights.get(choiceOfFlight-1).getFlightNumber());
					journey.setUserMobile(user.getMobNum());
					System.out.println("Enter Name");
					journey.setCustomerName(br.readLine());
					System.out.println("Enter Age");
					journey.setCustomerAge(Integer.parseInt(br.readLine()));
					System.out.println("Enter Mobile Number");
					journey.setCustomerMobilenum(br.readLine());
					System.out.println("journey Date");
					journey.setJourneyDate(br.readLine());
				}
				
				
			}
			else {
				System.out.println("No Flights Available");
			}
			
		} catch (IOException | NumberFormatException e) {
			System.out.println("Invalid Choice..Try again");
			return null;
		}
		return journey;
	}
	
	boolean addJourneyToUser(Travel journey) {
		int act = new Service().serveBookJourney(journey);
		if(act==1) {
			System.out.println("Ticekt booked...Wish you a happy journey");
			return true;
		}
		
		System.out.println("Your Ticket cancelled");
		return false;
	
	}
	boolean journeyHistory(UserData user) {
		List<Travel> userJourneys = new Service().journeyHistory(user);
		if(userJourneys!=null) {
			for(Travel journey:userJourneys) {
				System.out.println(journey);
			}
			return true;
		}
		System.out.println("Travel list not found");
		return false;
	}
	
	public static void main(String[] args) {
		int choice1 = 0;
		do {
			System.out.println("1.Register\n2.Login\n3.Exit");
			try {
				choice1 = Integer.parseInt(br.readLine());
			} catch (IOException | NumberFormatException e) {
				System.out.println("Wrong Details Entered please try again");
				continue;
			}
			switch(choice1) {
			case 1: new Main().registerNewUser();
				break;
			case 2:	{
				UserData user = new Main().loginUser();
				if(user!=null) {
					int choice2=0;
					do {
						System.out.println("1.Book Ticket\n2.History\n3.Exit");
						try {
							choice2 = Integer.parseInt(br.readLine());
						} catch (IOException | NumberFormatException e) {
							System.out.println("Wrong details entered please try again");
							continue;
						} 
						switch(choice2) {
						case 1: Travel journey = new Main().findJourney(user);
								if(journey!=null) {
									new Main().addJourneyToUser(journey);
								}
							break;
						case 2: new Main().journeyHistory(user);
							break;
						case 3: System.out.println("Exiting");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("User succesfully log out");
							break;
							default:System.out.println("Wrong details entered please try again");
							break;
						}
					} while(choice2!=3);
				}
			}
				break;
			case 3: System.out.println("Exiting ");
				break;
				default:System.out.println("Wrong details entered please try again");
			}
		} while(choice1!=3);
	}
}
