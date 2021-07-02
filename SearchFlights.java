package flight_layer_architecture;

public class SearchFlights {
	private String from;
	private String to;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public SearchFlights(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}
	public SearchFlights() {
		
	}
	
	
}
