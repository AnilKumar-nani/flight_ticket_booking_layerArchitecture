package flight_layer_architecture;

public class Flights {
	private int flightNumber;
	private String flightName;
	private String startPlace;
	private String destinationPlace;
	private String startTime;
	private String endTime;
	private int ticketPrice;
	
	public Flights() {}
	public Flights(int flightNumber, String flightName, String startPlace, String destinationPlace,
			String startTime, String endTime, int ticketPrice) {
		super();
		this.flightNumber = flightNumber;
		this.flightName = flightName;
		this.startPlace = startPlace;
		this.destinationPlace = destinationPlace;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ticketPrice = ticketPrice;
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getDestinationPlace() {
		return destinationPlace;
	}
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	@Override
	public String toString() {
		return "\n[flightNumber=" + flightNumber + ", flightName=" + flightName + ", flightOrigin=" + startPlace
				+ ", flightDestination=" + destinationPlace + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", price=" + ticketPrice + "]";
	}
	
	
		
}
