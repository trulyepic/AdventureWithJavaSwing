package ryi.snow;

import model.Player;
import weapon.Knife;
import weapon.LongSword;

public class Story {

	private Game game;
	private UI ui;
	private VisiblilityManager vm;
	private Player player = new Player();
	
	public Story(Game game, UI ui, VisiblilityManager vm) {
		
		this.game = game;
		this.ui = ui;
		this.vm = vm;
	}
	
	public void defalutSetup() {
		
		player.setHp(10);
		ui.hpNumberLabel.setText(String.valueOf(player.getHp()));
		
		player.setCurrentWeapon(new Knife());
		ui.weaponNameLabel.setText(player.getCurrentWeapon().getName());
		
	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "talkGuard": talkGaurd(); break;
		case "attackGuard": attakGuard();break;
		case "crossRoad": crossRoad(); break;
		case "townGate": townGate(); break;
		case "north": north();break;
		case "east": east();break;
		case "west": west();break;
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
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
