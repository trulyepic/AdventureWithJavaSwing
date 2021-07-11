package ryi.snow;

public class VisiblilityManager {
	
	UI ui;
	
	public VisiblilityManager(UI ui) {
		this.ui = ui;
	}
	
	public void showTitleScreen() {
		
//		show the title screen
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
//		hide the game screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		
	}
	
	public void titleToTown() {
		
//		hide the title screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
//		show the game screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
	}

}
