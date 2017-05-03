package utility;

public class ServiceStatus {
	private int statusCode;
	private String statusMessage;
	
	public ServiceStatus(){
		
	}
	public ServiceStatus(int c,String m){
		statusCode=c;
		statusMessage=m;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
