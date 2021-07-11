package model;

public class Monster {
	
	private String name;
	private int hp;
	private int attack;
	private String attackMessage;
	
	public Monster(String name, int hp, int attack, String msg) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
		attackMessage = msg;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public String getAttackMessage() {
		return attackMessage;
	}
	

}
