
public class players {

	private String name;
	private char symbol;
	
	public void setname(String name) {
		this.name=name;
	}
	
	public boolean setsymbol(char symbol) {
		if(symbol>='1' && symbol<='9')
			return false;
		this.symbol=symbol;
		return true;
	}
	public String getname() {
		return name;
	}
	public char getsybmol() {
		return symbol;
	}
}
