package candyCrush;
import java.util.Scanner;

public class CandyCrush {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean looping = true;
		while(looping) {
			System.out.println("\n>>>--- Candy Crush ---<<<\n");
			System.out.print("1. New Game\n2. Options\n3. Exit\n\n\tYour Choice : ");
			int Option = sc.nextInt();
			
			switch(Option) {
			case 1: {
				// New Game
				
				// Get level
				int level;
				while(true) {
					System.out.print("\n\nSelect Level\n\n1. Easy\n2. Medium\n3. Hard\n\n\tYour choice :  ");
					level = sc.nextInt();
					if(level < 1 && level > 3) {
						System.out.println("Invalid Selection !!!");
					}else break;
				}
				
				// Generate Board
				Board board = new Board(level);
				board.generateBoard();
				
				boolean loop = true;
				while(loop) {
					System.out.println("\n\n\t*** Board ***\n\n");
					System.out.println("Current Score : "+board.Score+"\n");
					board.showBoard();
					System.out.print("\n>>> Navigations <<< \n\n\t1. Left\n\t2. Right\n\t3. Top\n\t4. Down\n\t5. Select\n\t6. Reset\n\n\t\tYour Choice : ");
					int navigation = sc.nextInt();
					
					switch(navigation) {
					case 1 : {
						//Left
						board.navigateToLeft();
						break;
					}
					case 2 : {
						//Right
						board.navigateToRight();
						break;
					}
					case 3 : {
						//Top
						board.navigateToTop();
						break;
					}
					case 4 : {
						//Down
						board.navigateToDown();
						break;
					}
					case 5 : {
						//OK
						board.OK();
						break;
					}
					case 6 : {
						// Reset
						System.out.print("\n\nAre You Sure to Reset?\n1. Yes\n2. No\n\tYour Choice : ");
						int reset = sc.nextInt();
						if(reset == 1)
							board.generateBoard();
						break;
					}
					default : {
						//Invalid
						System.out.println("Invalid Option !!!");
						break;
					}
					}
				}
				break;
			}
			case 2: {
				// Option
				break;
			}
			case 3: {
				// Exit
				System.out.println("EXIT");
				looping = false;
				break;
			}
			default : {
				// Invalid
				break;
			}
			}
		}
	}
}
