import java.util.Scanner;

public class Player {
	
	private int charID, damage, health, money, rHealth;
	private String name, chaName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}
	
	public void selectCha() {
		System.out.println("Please choose a character!");
		System.out.println("1-> Samurai: \t Damage:5 \t Health:21 \t Money:15");
		System.out.println("2-> Archer: \t Damage:7 \t Health:18 \t Money:20");
		System.out.println("3-> Knight: \t Damage:8 \t Health:24 \t Money:5");
		System.out.print("Your choice: ");
		while (true) {
			charID = scan.nextInt();
			if (charID >= 1 && charID <= 3) 
				break;
			System.out.print("Please choose a appropriate character: ");
		}
		switch(charID) {
		case 1:
			initPlayer("Samurai", 5, 21, 15);
			break;
		case 2:
			initPlayer("Archer", 7, 18, 20);
			break;
		case 3:
			initPlayer("Knight", 8, 24, 5);
			break;
		default:
			initPlayer("Samurai", 5, 21, 15);
			break;	
		}
		System.out.println("Your character was created:");
		System.out.println(getCharID() + "-> " + getChaName() + ": \t Damage:" + getDamage() + " \t Health:" + getHealth() + " \t Money:" + getMoney());
	}
	
	public void initPlayer(String cName, int dmg, int hlth, int mny) {
		setChaName(cName);
		setDamage(dmg);
		setHealth(hlth);
		setMoney(mny);
		setrHealth(health);
	}
	
	public int getTotalDamage() {
		return this.getInv().getDamage() + this.getDamage();
	}
	
	public int getCharID() {
		return charID;
	}

	public void setCharID(int charID) {
		this.charID = charID;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChaName() {
		return chaName;
	}

	public void setChaName(String chaName) {
		this.chaName = chaName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getrHealth() {
		return rHealth;
	}

	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	
	
	
}
