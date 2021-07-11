package ryi.snow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	
	UI ui = new UI();
	ChoiceHandler cHandler = new ChoiceHandler();
	VisiblilityManager vm = new VisiblilityManager(ui);
	Story story = new Story(this, ui, vm);
	
	String nextPosition1,nextPosition2,nextPosition3,nextPosition4;
	
	public Game() {
		ui.creatUI(cHandler);
		story.defalutSetup();
		vm.showTitleScreen();
	}
	
	
	public static void main (String [] args) {
		
		new Game();
		
	}
	
	public class ChoiceHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String yourChoice= e.getActionCommand();
			switch(yourChoice) {
			case "start":vm.titleToTown(); story.townGate();break;
			case "c1": story.selectPosition(nextPosition1); break;
			case "c2": story.selectPosition(nextPosition2); break;
			case "c3": story.selectPosition(nextPosition3); break;
			case "c4": story.selectPosition(nextPosition4); break;
			}
			
		}
		
	}

}
