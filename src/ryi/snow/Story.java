package ryi.snow;

import java.util.Random;

import model.Monster;
import model.Player;
import monsters.Monster_Goblin;
import weapon.Knife;
import weapon.LongSword;

public class Story {

	private Game game;
	private UI ui;
	private VisiblilityManager vm;
	private Player player = new Player();
	Monster monster;
	int silverRing;
	
	public Story(Game game, UI ui, VisiblilityManager vm) {
		
		this.game = game;
		this.ui = ui;
		this.vm = vm;
	}
	
	/**
	 * Default player setup
	 * player and player weapon
	 */
	public void defalutSetup() {
		
		player.setHp(10);
		ui.hpNumberLabel.setText(String.valueOf(player.getHp()));
		
		player.setCurrentWeapon(new Knife());
		ui.weaponNameLabel.setText(player.getCurrentWeapon().getName());
		
		silverRing = 0;
		
	}
	
	
	/**
	 * @param nextPosition
	 * game control based on choice clicked
	 * It directs what to display and what methods to call
	 */
	public void selectPosition(String nextPosition) {
		
		
		switch(nextPosition) {
		case "talkGuard": talkGaurd(); break;
		case "attackGuard": attakGuard();break;
		case "crossRoad": crossRoad(); break;
		case "townGate": townGate(); break;
		case "north": north();break;
		case "east": east();break;
		case "west": west();break;
		case "fight": fight();break;
		case "playerAttack": playerAttack(); break;
		case "monsterAttack": monsterAttack();break;
		case "win": win(); break;
		case "lose": lose();break;
		case "toTitle": toTitle(); break;
		}
	}
	
	public void townGate() {
		ui.mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. "
				+ "\n\nWhat do you do?");
		
		ui.choice1.setText("Talk to the guard");
		ui.choice2.setText("Attack the guard");
		ui.choice3.setText("Leave");
		ui.choice4.setText("");
		
		game.nextPosition1 = "talkGuard";
		game.nextPosition2 = "attackGuard";
		game.nextPosition3 = "crossRoad";
	}
	
	public void talkGaurd() {
		
		if(silverRing ==1) {
			ending();
		}else {
		ui.mainTextArea.setText("Guard: Hello stranger. I have never seen your face. \nI'm sorry but we "
				+ "cannot let you enter our town.");
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		}
		
	}

	

	public void attakGuard() {
		
		ui.mainTextArea.setText("Guard: Hey don't be stupid! \n\nThe guard attacked you so hard and you gave"
				+ "up. \n(You receive 3 damage)");
		
		player.setHp(player.getHp()-3);
		ui.hpNumberLabel.setText(String.valueOf(player.getHp()));
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		
	}
	
	public void crossRoad() {
		
		ui.mainTextArea.setText("You are at a crossroad. \nIf you go south, you will go back to the town");
		
		ui.choice1.setText("Go north");
		ui.choice2.setText("Go east");
		ui.choice3.setText("Go south");
		ui.choice4.setText("Go west");
		
		game.nextPosition1 = "north";
		game.nextPosition2 = "east";
		game.nextPosition3 = "townGate";
		game.nextPosition4 = "west";
		
	}
	
	public void north() {
		
		ui.mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside.\n\n"
				+ "(Your HP is recovered by 2");
		
		player.setHp(player.getHp()+2);
		ui.hpNumberLabel.setText(String.valueOf(player.getHp()));
		
		ui.choice1.setText("Go south");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		
	}
	
	public void east() {
		ui.mainTextArea.setText("You walked into a forest and find a Long Sword!\n\n(You obtain a Long Sword)");
		
		player.setCurrentWeapon(new LongSword());
		
		ui.weaponNameLabel.setText(player.getCurrentWeapon().getName());
		
		ui.choice1.setText("Go west");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void west() {
		
		monster = new Monster_Goblin();
		
		ui.mainTextArea.setText("You encounter a " + monster.getName() + "!");
		
		
		ui.choice1.setText("Fight");
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void fight() {
		
		ui.mainTextArea.setText(monster.getName()+" HP: " + monster.getHp() + "\n\nWhat do you do?");
		
		
		ui.choice1.setText("Attack");
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "playerAttack";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void playerAttack() {
		
		int playerWeaponDamage = player.getCurrentWeapon().getDamage();
		int playerDamage = new Random().nextInt(playerWeaponDamage);
		
		ui.mainTextArea.setText("You attacked the "+ monster.getName()+" and gave "+playerDamage+" damage!");
		
		monster.setHp(monster.getHp()-playerDamage);
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(monster.getHp() >0) {
			game.nextPosition1 = "monsterAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
		} else if(monster.getHp() < 1) {
			game.nextPosition1 = "win";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		
	}
	
	public void monsterAttack() {
		
		int monsterDamage = new Random().nextInt(monster.getAttack());
		
		ui.mainTextArea.setText(monster.getAttackMessage() +"\nYou receive "+monsterDamage +" damage!");
		
		player.setHp(player.getHp()- monsterDamage);
		
		ui.hpNumberLabel.setText(String.valueOf(player.getHp()));
		
		
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(player.getHp() > 0) {
			
			game.nextPosition1 = "fight";
			game.nextPosition2 = "crossRoad";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		} else if(player.getHp() < 1) {
			
			game.nextPosition1 = "lose";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void win() {
		
		ui.mainTextArea.setText("You've defeated the " + monster.getName() +"!\nThe monster drops a ring!"
				+ "\n\n(You obtained a Silver Ring!)");
		
		silverRing = 1;
		
		ui.choice1.setText("Go east");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void lose() {
		
		ui.mainTextArea.setText("You are dead!\n\n<GAME OVER>");
		
		
		ui.choice1.setText("To The Title Screen");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "toTitle";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	private void ending() {
		
		ui.mainTextArea.setText("Guard: Oh you killed the goblin!?\nThank you so much. You are a hero!\n"
				+ "Welcome to our town!\n\n<THE END>");
		
		ui.choice1.setVisible(false);
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
	}
	
	public void toTitle() {
		
		defalutSetup();
		vm.showTitleScreen();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
