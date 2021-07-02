package flight_layer_architecture;

public class Travel {
	private String userMobile;
	private String customerName;
	private int customerAge;
	private String customerMobilenum;
	private String journeyDate;
	private int flightNumber;
	public Travel() {}
	public Travel(String userMobile, String customerName, int customerAge, String customerMobilenum, String journeyDate,
			int flightNumber) {
		super();
		this.userMobile = userMobile;
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerMobilenum = customerMobilenum;
		this.journeyDate = journeyDate;
		this.flightNumber = flightNumber;
	}
	
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerMobilenum() {
		return customerMobilenum;
	}
	public void setCustomerMobilenum(String customerMobilenum) {
		this.customerMobilenum = customerMobilenum;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	@Override
	public String toString() {
		return "Journee Name      : " + getCustomerName() +
			   "Journee Age       : " + getCustomerAge() + "\n"
			 + "flightNumber      : " + String.valueOf(getFlightNumber()) + 
			   "Journey Date      : " + getJourneyDate() +"\n";
	}


}
