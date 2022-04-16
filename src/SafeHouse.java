
public class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player, "Safe House");
	}
	
	@Override
	public boolean getLocation() {
		int oldHealth = player.getHealth();
		player.setHealth(player.getrHealth());
		System.out.println("You are in the safe house now.");
		System.out.println("You are healed!");
		System.out.println("Old health: " + oldHealth + "  New health: " + player.getHealth());
		return true;
	}
	
}
