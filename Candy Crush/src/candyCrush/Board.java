package candyCrush;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
	String Grid[][];
	int level;
	int gridSize;
	int cursorX, cursorY;
	List<Mapping> mapList = new ArrayList<Mapping>(); 
	int funcNumber;
	//String[] colors = {" Blue ", " Green ", "  Red  ", " Yellow ", " Orange ", " Violet "};
	String[] colors = {"B", "G", "R", "Y", "O", "V"};
	Random random = new Random();
	int Score;
	
	// Constructor
	Board(int level){
		this.level = level;
		gridSize = level + 4;
		Grid = new String[gridSize][gridSize];
		
		cursorX = 0;
		cursorY = 0;
	}
	// Board Generation
	public void generateBoard() {
		Score = 0;
		for(int i=0;i<gridSize;i++) {
			for(int j=0;j<gridSize;j++) {
				Grid[i][j] = colors[random.nextInt(level + 2)];
			}
		}
	}
	// get Random Colors
	public String getRandom() {
		Score++;
		return colors[random.nextInt(level + 2)];
	}
	
	// Print Board
	public void showBoard() {
		for(int i=0;i<gridSize;i++) {
			for(int j=0;j<gridSize;j++) {
				if(cursorX == i && cursorY == j) {
					System.out.print("*"+Grid[i][j]+"*"+"\t");
				}else
					System.out.print(Grid[i][j]+"\t");
			}System.out.println("\n");
		}
	}
	// Navigation
	public void navigateToLeft() {
		System.out.println("Navigate to left");
		if(cursorY > 0) {
			cursorY--;
		}
		else if(cursorY == 0) {
			cursorY = gridSize - 1;
		}
		
		
	}
	public void navigateToRight() {
		System.out.println("Navigate to Right");
		if(cursorY >= 0) {
			cursorY++;
		}
		else if(cursorY == (gridSize - 1)) {
			cursorY = 0;
		}
		
	}
	public void navigateToTop() {
		System.out.println("Navigate to Top");
		if(cursorX > 0) {
			cursorX--;
		}
		else if(cursorX == 0) {
			cursorX = gridSize - 1;
		}
	}
	public void navigateToDown() {
		System.out.println("Navigate to Down");
		if(cursorX >= 0) {
			cursorX++;
		}
		else if(cursorX == (gridSize - 1)) {
			cursorX = 0;
		}
	}
	/*public void callOK() {
		int i = cursorX;
		int j = cursorY;
		OK(i, j);		
	}*/
	public void OK() {
		int i = cursorX;
		int j = cursorY;
		String color = Grid[i][j];
		Mapping mapping = new Mapping();
		mapList = new ArrayList<Mapping>();
		boolean check = true;
		
		// left to RIght
		if(j+2 < gridSize) {
			if(Grid[i][j+1].equals(color) &&  Grid[i][j+2].equals(color)) {
				mapping.put(i, j);
				mapList.add(mapping);
				funcNumber = 1;
			}
		}
		
		// Right to Left
		if(j-2 >= 0) {
			if(Grid[i][j-1].equals(color) && Grid[i][j-2].equals(color)) {
				mapping.put(i, j);
				mapList.add(mapping);
				funcNumber = 2;
			}
		}
		
		// Top to Bottom
		if(i+2 < gridSize) {
			if(Grid[i+1][j].equals(color) && Grid[i+2][j].equals(color)) {
				mapping.put(i, j);
				mapList.add(mapping);
				funcNumber = 3;
			}
		}
		
		// Bottom to Up
		if(i-2 >= 0) {
			if(Grid[i-1][j].equals(color) && Grid[i-2][j].equals(color)) {
				mapping.put(i, j);
				mapList.add(mapping);
				funcNumber = 4;
			}
		}
		
		// Center Horizontal
		if(j+1 < gridSize && j-1 >= 0) {
			if(Grid[i][j+1].equals(color) && Grid[i][j-1].equals(color)) {
				mapping.put(i, j);
				mapList.add(mapping);
				funcNumber = 5;
			}
		}
		
		// Center Vertical
		if(i+1 < gridSize && i-1 >= 0) {
			if(Grid[i+1][j].equals(color) && Grid[i-1][j].equals(color)) {
				mapping.put(i, j);
				mapList.add(mapping);
				funcNumber = 6;
			}
		}
		
		// Invalid Selection
		if(funcNumber == 0) {
			System.out.println("Invalid Selection");
			check = false;
		}
		
		// Replace()
		if(check)
			replaceCells();
		
	}
	public void replaceCells() {
		for(int index=0;index<mapList.size();index++) {
			Mapping mapping = new Mapping();
			mapping = mapList.get(index);
			switch(funcNumber) {
			case 1 : {
				// L - R
				for(int i=mapping.i;i>=0;i--) {
					if(i != 0) {
						for(int j=mapping.j;j<mapping.j+3;j++) {
							Grid[i][j] = Grid[i-1][j];
						}
					}
					else {
						for(int j=mapping.j;j<mapping.j + 3;j++) {
							Grid[0][j] = getRandom();
						}
					}
				}
				break;
			}
			case 2 : {
				// R - L
				for(int i=mapping.i;i>=0;i--) {
					if(i != 0) {
						for(int j=mapping.j;j>mapping.j-3;j--) {
							Grid[i][j] = Grid[i-1][j];
						}
					}
					else {
						for(int j=mapping.j;j>mapping.j - 3;j--) {
							Grid[0][j] = getRandom();
						}
					}
				}
				break;
			}
			case 3 : {
				// T - B
				for(int i=mapping.i+2;i>=0;i--) {
					if(i-3 >= 0)
						Grid[i][mapping.j] = Grid[i-3][mapping.j];
					else
						Grid[i][mapping.j] = getRandom();
				}
				break;
			}
			case 4 : {
				// B - T
				for(int i=mapping.i;i>=0;i--) {
					if(i-3 >= 0)
						Grid[i][mapping.j] = Grid[i-3][mapping.j];
					else
						Grid[i][mapping.j] = getRandom();
				}
				break;
			}
			case 5 : {
				// C H
				for(int i=mapping.i;i>=0;i--) {
					if(i != 0) {
						for(int j=mapping.j-1;j<mapping.j + 2;j++) {
							Grid[i][j] = Grid[i-1][j];
						}
					}
					else {
						for(int j=mapping.j-1;j<mapping.j + 2;j++) {
							Grid[0][j] = getRandom();
						}
					}
				}
				break;
			}
			case 6 : {
				// C V
				for(int i=mapping.i+1;i>=0;i--) {
					if(i-3 >= 0)
						Grid[i][mapping.j] = Grid[i-3][mapping.j];
					else
						Grid[i][mapping.j] = getRandom();
				}
				break;
			}
			
			}
			
			
		}
	}
	/*public Mapping getMapping(int i, int j) {
		Mapping mapping = new Mapping();
		mapping.put()
		if(Grid[i][j+1].equals(color)) {
			mapping.put(i, j+1);
		}
		if(Grid[i][j-1].equals(color)) {
			mapping.put(i, j-1);
		}
		if(Grid[i+1][j].equals(color)) {
			mapping.put(i+1, j);
		}
		if(Grid[i-1][j].equals(color)) {
			mapping.put(i-1, j);
		}
		return mapping;
	}*/
}
