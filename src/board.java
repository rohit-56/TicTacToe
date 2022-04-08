
public class board {

	private char arr[][];
	private int count=0;
	public char p1symbol,p2symbol;
	public final static int PLAYER1_WINS=1;
	public final static int PLAYER2_WINS=2;
	public final static int DRAW=3;
	public final static int INCOMPLETE=4;
	public final static int INVALID=5;
	
	public  board(char p1,char p2) {
		arr=new char[3][3];
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				arr[i][j]=' ';
		this.p1symbol=p1;
		this.p2symbol=p2;
	}
	
	public int move(char symbol,int x,int y) {
		if(x<0 || y<0 || x>=3 || y>=3 || arr[x][y]!=' ')
			return INVALID;
		arr[x][y]=symbol;
		count++;
		if(arr[x][0]!=' ' && arr[x][0]==arr[x][1] && arr[x][0]==arr[x][2])
			return symbol==p1symbol?PLAYER1_WINS:PLAYER2_WINS;
		if(arr[0][y]!=' ' && arr[0][y]==arr[1][y] && arr[0][y]==arr[2][y])
			return symbol==p1symbol?PLAYER1_WINS:PLAYER2_WINS;
		if(arr[0][0]!=' ' && arr[0][0]==arr[1][1] && arr[0][0]==arr[2][2])
			return symbol==p1symbol?PLAYER1_WINS:PLAYER2_WINS;
		if(arr[0][2]!=' ' && arr[0][2]==arr[1][1] && arr[0][2]==arr[2][0])
			return symbol==p1symbol?PLAYER1_WINS:PLAYER2_WINS;
		if(count==9)
			return DRAW;
		else
			return INCOMPLETE;
	}
	public void print() {
		System.out.println("*********************");
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++) {
				System.out.print("| "+arr[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println("*********************");
	}
}
