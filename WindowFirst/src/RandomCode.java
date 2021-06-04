

public class RandomCode {
public String randomNum(int len) {
	String s="";
	for(int i=0;i<len;i++) {
	int random = (int) (Math.random()*10);
	s=s+random;
	}
	
	
	return  s;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
