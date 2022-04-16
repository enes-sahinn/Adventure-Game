import java.util.Scanner;

public class Game {
	private Player player;
	private Location location;
	private int locID;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		System.out.println("Welcome to Adventure Game!");
		System.out.println("Please enter your name before starting the game: ");
		String playerName = scan.nextLine();
		player = new Player("enes");
		player.selectCha();
		System.out.println("The game has started!");
	}
	
	public void start() {
		while (true) {
			System.out.println("\n================================================\n");
			System.out.println("Please choose a place to go!");
			System.out.println("1. Safe House \t--> Your own safe place, no enemies.");
			System.out.println("2. Cave \t--> You may encounter zombies.");
			System.out.println("3. Forest \t--> You may encounter vampires.");
			System.out.println("4. River \t--> You may encounter bears.");
			System.out.println("5. Tool Store \t--> You can buy gun or armor.");
			System.out.print("Your choice: ");
			while (true) {
				locID = scan.nextInt();
				if (locID >= 1 && locID <= 5) 
					break;
				System.out.print("Please choose a appropriate location: ");
			}
			switch(locID) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				break;
			}
			if (location.getName().equals("Safe House")) {
				if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Congrulations! You have collected all 3 ingredients! You won the game!");
					break;
				}
			}
			if (!location.getLocation()) {
				System.out.println("Game Over!");
				break;
			}
		}
	}

	public void run() {
		login();
		start();
	}
}
