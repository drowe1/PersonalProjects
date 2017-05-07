package robotTester;

public class Robot {
	

	int id;
	public void getNum(int num){
		id = num;
	}
	
	public boolean isValidNum(){
		if(id == 733262 || id == 753875)
			return true;
		return false;
	}
	
	public boolean isTJ(){
		if(id  == 753875)
			return true;
		return false;
	}
}
