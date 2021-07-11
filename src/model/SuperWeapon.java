package model;

public class SuperWeapon {
	
	private String name;
	private int damage;
	
	public SuperWeapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}

	public String getName() {
		return name;
	}
	
	public int getDamage() {
		return damage;
	}
}
