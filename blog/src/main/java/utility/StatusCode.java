package utility;

public enum StatusCode {
	PENDING(0),
	READ(1),
	ACCEPTED(2),
	DECLINED(3),
	UNREAD(4);
	
	private int value;
	
	private StatusCode(int v){
		this.value = v;
	}
	
	public int toValue(){
		return this.value;
	}
}
