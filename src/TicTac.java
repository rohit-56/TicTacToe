import java.util.*;
public class TicTac {

	private players player1;
	private players player2;
	
	public TicTac() {
		player1=new players();
		player2=new players();
	}
	public void startgame() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter player1 name:");
		player1.setname(s.nextLine());
		System.out.println("Eneter player1 symbol:");
		player1.setsymbol(s.next().charAt(0));
		s.nextLine();
		System.out.println("Enter player2 name:");
		player2.setname(s.nextLine());
		System.out.println("Eneter player2 symbol:");
		player2.setsymbol(s.next().charAt(0));
		while(player2.getsybmol()==player1.getsybmol()) {
			System.out.println("Please enter another symbol this symbol already taken !!");
			player2.setsymbol(s.next().charAt(0));
		}
		board Board=new board(player1.getsybmol(),player2.getsybmol());
		int status=Board.INCOMPLETE;
		boolean player1_turn=true;
		while(status==Board.INCOMPLETE || status==Board.INVALID) {
			if(player1_turn) {
				System.out.println("Enter the position for:"+player1.getname());
				System.out.println("Enter the value of x:");
				int x=s.nextInt();
				System.out.println("Enter the value of y:");
				int y=s.nextInt();
				status=Board.move(player1.getsybmol(),x,y);
				if(status==Board.INVALID) {
					System.out.println("INVALID INPUT !! TRY AGAIN !!");
				}
				else {
					Board.print();
				player1_turn=false;
				}
			}else {
				System.out.println("Enter the position for:"+player2.getname());
				System.out.println("Enter the value of x:");
				int x=s.nextInt();
				System.out.println("Enter the value of y:");
				int y=s.nextInt();
				status=Board.move(player2.getsybmol(),x,y);
				if(status==Board.INVALID) {
					System.out.println("INVALID INPUT !! TRY AGAIN !!");
				}
				else {
					Board.print();
				player1_turn=true;
				}
			}
		}
		if(status==Board.PLAYER1_WINS)
			System.out.println(player1.getname()+" Wins !!");
		else if(status==Board.PLAYER2_WINS)
			System.out.println(player2.getname()+" Wins !!");
		else
			System.out.println("DRAW !!");
	}
}
