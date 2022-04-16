public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	
	public BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;	
		this.obstacle = obstacle;
		this.award = award;
	}
	
	public boolean getLocation() {
		int obsNumber = this.obstacle.obsNumber();
		System.out.println("You are in the " + this.name + " now." );
		System.out.println("Be careful! There are " + obsNumber + " " + this.obstacle.getName() + " here.");
		stats();
		System.out.print("<F>ight or <R>un: ");
		String selCase;
		while (true) {
			selCase = scan.next();
			if (selCase.equalsIgnoreCase("F") || selCase.equalsIgnoreCase("R"))
				break;
			System.out.print("Please choose a appropriate action: ");
		}
		if (selCase.equalsIgnoreCase("F")) {
			if (combat(obsNumber)) {
				//System.out.println("You defeated all the enemies in the " + this.name + ".");
				return true;
			}
			else {
				System.out.println("YOU DIED!");
				return false;
			}
		}
		return true;
	}
	
	public boolean combat(int obsNumber) {
		for (int i = 0; i < obsNumber; i++) {
			int defObsHealth = obstacle.getHealth();
			while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
				System.out.print("<H>it or <R>un: ");
				String selCase;
				while (true) {
					selCase = scan.next();
					if (selCase.equalsIgnoreCase("H") || selCase.equalsIgnoreCase("R"))
						break;
					System.out.print("Please choose a appropriate action: ");
				}
				if (selCase.equalsIgnoreCase("H")) {
					System.out.println("\nYou hit the " + obstacle.getName());
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					afterHit();
					if (obstacle.getHealth() > 0) {
						System.out.println("\nThe " + obstacle.getName() + " hit you.");
						player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
						afterHit();
					}
				} else {
					return true;
				}
			}
			if (player.getHealth() > 0 && obstacle.getHealth() <= 0) {
				System.out.println("You defetead a " + obstacle.getName());
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Your current money: " + player.getMoney() + "$");
				obstacle.setHealth(defObsHealth);
			}
			else {
				return false;
			}
		}
		if (this.award.equals("Food") && player.getInv().isFood() == false) {
			player.getInv().setFood(true);
			System.out.println("You earned " + this.award + "!");
		}
		else if (this.award.equals("Water") && player.getInv().isWater() == false) {
			player.getInv().setWater(true);
			System.out.println("You earned " + this.award + "!");
		}
		else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
			player.getInv().setFirewood(true);
			System.out.println("You earned " + this.award + "!");
		}
		return true;
	}
	
	public void afterHit() {
		System.out.println("Player Health: " + player.getHealth());
		System.out.println(obstacle.getName() + " Health: " + obstacle.getHealth());
	}
	
	public void stats() {
		System.out.println("Player Stats \t " + this.obstacle.getName() + " Stats");
		System.out.println("============ \t =============");
		System.out.println("Damage: " + player.getTotalDamage() + "\t Damage: " + this.obstacle.getDamage());
		System.out.println("Health: " + player.getHealth() + "\t Health: " + this.obstacle.getHealth());
		System.out.println("Money: " + player.getMoney() + "\t Award: " + this.obstacle.getAward());
		System.out.println("Armor: " + player.getInv().getArmor());	
	}
}
