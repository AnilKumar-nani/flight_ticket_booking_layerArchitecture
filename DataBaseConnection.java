package flight_layer_architecture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConnection {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private void establishConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight_book","root","12345");
	
	}
	private void prepareTheStatement(String query) throws SQLException {
		
		preparedStatement = connection.prepareStatement(query);
		
	}
	private void closeConnections() {
		try {
			if(connection != null) connection.close();
			if(preparedStatement != null) preparedStatement.close();
			if(resultSet != null) resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private int signUpNewUser(UserData user) {
		String query = "insert into user_data values(?,?,?,?,?,?);";
		
		try {
			establishConnection();
			prepareTheStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getMobNum());
			preparedStatement.setString(3, user.getDob());
			preparedStatement.setString(4, user.getGender().substring(0,1));
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getEmail());
			
			return preparedStatement.executeUpdate();	
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return 0;
		}
		finally {
			closeConnections();
		}	
	}
	
	private UserData checkLogin(UserData user) {
		String query = "select * from user_data where mobile_num=? and password=?";
		
		try {
			establishConnection();
			prepareTheStatement(query);
			preparedStatement.setString(1, user.getMobNum());
			preparedStatement.setString(2, user.getPassword());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				user.setName(resultSet.getString("name"));
				user.setDob(resultSet.getString("dateofbirth"));
				user.setGender(resultSet.getString("gender"));
				user.setEmail(resultSet.getString("email"));
				return user;
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			closeConnections();
		}
		return null;
				
	}
	
	private int addJourneyForUser(Travel journey) {
		String query = "insert into journey values(?, ?, ?, ?, ?, ?);";
		
		try {
			establishConnection();
			prepareTheStatement(query);
			preparedStatement.setString(1, journey.getUserMobile());
			preparedStatement.setString(2, journey.getCustomerName());
			preparedStatement.setInt(3, journey.getCustomerAge());
			preparedStatement.setString(4, journey.getCustomerMobilenum());
			preparedStatement.setString(5, journey.getJourneyDate());
			preparedStatement.setInt(6, journey.getFlightNumber());
			
			return preparedStatement.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			closeConnections();
		}
		return 0;
	}
	private List<Flights> filterFlights(SearchFlights filterFlights) {
		String query = "select * from flight_details where flight_origin=? and flight_destination=?";
		List<Flights> searchedFlights=null;
		try {
			establishConnection();
			prepareTheStatement(query);
			preparedStatement.setString(1, filterFlights.getFrom());
			preparedStatement.setString(2, filterFlights.getTo());
			
			
			resultSet = preparedStatement.executeQuery();
			searchedFlights = new ArrayList<>();
			while(resultSet.next()) {
				Flights flight = new Flights();
				flight.setFlightNumber(resultSet.getInt("flight_number"));
				flight.setFlightName(resultSet.getString("flight_name"));
				flight.setStartPlace(resultSet.getString("flight_origin"));
				flight.setDestinationPlace(resultSet.getString("flight_destination"));
				flight.setStartTime(resultSet.getString("start_time"));
				flight.setEndTime(resultSet.getString("end_time"));
				flight.setTicketPrice(resultSet.getInt("price"));
				searchedFlights.add(flight);
			}
			
			if(searchedFlights.size()>0) 
				return searchedFlights;
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			closeConnections();
		}
		return null;
	}
	
	private List<Travel> jouneyHistory(UserData user) {
		String query = "select * from journey where user_mobile=? order by journey_date desc";
		try {
			establishConnection();
			prepareTheStatement(query);
			preparedStatement.setString(1, user.getMobNum());
			resultSet = preparedStatement.executeQuery();
			List<Travel> journeyList = new ArrayList<>();
			while(resultSet.next()) {
				Travel journey = new Travel();
				journey.setUserMobile(user.getMobNum());
				journey.setCustomerName(resultSet.getString("journee_name"));
				journey.setCustomerAge(resultSet.getInt("journee_age"));
				journey.setCustomerMobilenum(resultSet.getString("journee_mobilenum"));
				journey.setJourneyDate(resultSet.getString("journey_date"));
				journey.setFlightNumber(resultSet.getInt("flight_number"));
				journeyList.add(journey);
			}
			if(journeyList.size()>0) 
				return journeyList;
					
		} catch (SQLException | ClassNotFoundException e) {
		}
		finally {
			closeConnections();
		}
		return null;
		
	}
	
	public int newUserRegistration(UserData user) {
		return signUpNewUser(user);
	}
	public int bookJourney(Travel journey) {
		return addJourneyForUser(journey);
	}
	public List<Flights> getDesiredFlights(SearchFlights filterFlights) {
		return filterFlights(filterFlights);
	}
	public UserData verifyLogin(UserData user) {
		return checkLogin(user);
	}
	public List<Travel> travelHistory(UserData user) {
		return jouneyHistory(user);
	}
}
