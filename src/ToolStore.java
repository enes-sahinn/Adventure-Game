public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		super(player, "Tool Store");
	}

	@Override
	public boolean getLocation() {
		System.out.println("You are in the tool store now.");
		System.out.println("Your money: " + player.getMoney() + "$");
		System.out.println("What do you want to buy?");
		System.out.println("1. Weapons");
		System.out.println("2. Armors");
		System.out.println("3. Exit");
		System.out.print("Your choice: ");
		int toolID, itemID;
		while (true) {
			toolID = scan.nextInt();
			if (toolID >= 1 && toolID <= 3)
				break;
			System.out.print("Please choose a appropriate option: ");
		}		
		switch (toolID) {
		case 1:
			itemID = weaponMenu();
			buyWeapon(itemID);
			break;
		case 2:
			itemID = armorMenu();
			buyArmor(itemID);
			break;
		default:
			break;
		}
		
		return true;
	}
	
	public int weaponMenu() {
		System.out.println("1. Sword:\t Damage: 2  Price: 25");
		System.out.println("2. Pistol:\t Damage: 3  Price: 35");
		System.out.println("3. Rifle:\t Damage: 7  Price: 45");
		System.out.println("4. Exit");
		System.out.print("Your choice: ");
		int selWeapon;
		while (true) {
			selWeapon = scan.nextInt();
			if (selWeapon >= 1 && selWeapon <= 4)
				break;
			System.out.print("Please choose a appropriate option: ");
		}
		return selWeapon;
	}
	
	public void buyWeapon(int itemID) {
		String wName = null;
		int damage = 0, price = 0;
		switch (itemID) {
		case 1: 
			wName = "Sword";
			damage = 2;
			price = 25;
			break;
		case 2:
			wName = "Pistol";
			damage = 3;
			price = 35;
			break;
		case 3:
			wName = "Rifle";
			damage = 7;
			price = 45; 
			break;
		default:
			break;
		}
		if (price > 0) {
			if (player.getMoney() >= price) {
				int oldDamage = player.getDamage() + player.getInv().getDamage();
				int oldMoney = player.getMoney();
				player.getInv().setwName(wName);
				player.getInv().setDamage(damage);
				player.setMoney(player.getMoney() - price);
				System.out.println("You bought the " + wName + ".");
				System.out.println("Old damage: " + oldDamage + "  New damage: " + player.getTotalDamage());
				System.out.println("Old money: " + oldMoney + "$  New money: " + player.getMoney() + "$");
			}
			else {
				System.out.println("Not enough money!");
			}
		}
	}
	
	public int armorMenu() {
		System.out.println("1. Weak Armor:\t Armor: 1  Price: 15");
		System.out.println("2. Middle Armor: Armor: 3  Price: 25");
		System.out.println("3. Heavy Armor:\t Armor: 5  Price: 40");
		System.out.println("4. Exit");
		System.out.print("Your choice: ");
		int selArmor;
		while (true) {
			selArmor = scan.nextInt();
			if (selArmor >= 1 && selArmor <= 4)
				break;
			System.out.print("Please choose a appropriate option: ");
		}
		return selArmor;
	}
	
	public void buyArmor(int itemID) {
		String aName = null;
		int armor = 0, price = 0;
		switch (itemID) {
		case 1: 
			aName = "Weak Armor";
			armor = 1;
			price = 15;
			break;
		case 2:
			aName = "Intermediate Armor";
			armor = 3;
			price = 25;
			break;
		case 3:
			aName = "Heavy Armor";
			armor = 5;
			price = 40; 
			break;
		default:
			break;
		}
		if (price > 0) {
			if (player.getMoney() >= price) {
				int oldArmor = player.getInv().getArmor();
				int oldMoney = player.getMoney();
				player.getInv().setaName(aName);
				player.getInv().setArmor(armor);
				player.setMoney(player.getMoney() - price);
				System.out.println("You bought the " + aName + ".");
				System.out.println("Old armor: " + oldArmor + "  New armor: " + player.getInv().getArmor());
				System.out.println("Old money: " + oldMoney + "$  New money: " + player.getMoney() + "$");
			}
			else {
				System.out.println("Not enough money!");
			}
		}
	}
	
}






