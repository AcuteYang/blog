package utility;

public enum StatusCode {
	PENDING(1),
	READ(2),
	ACCEPTED(3),
	DECLINED(4),
	UNREAD(5);
	
	private int value;
	
	private StatusCode(int v){
		this.value = v;
	}
	
	public int toValue(){
		return this.value;
	}
}
