package tetris;

public class Setsel {
	
	private Scolor color = new Scolor();
	private Smode mode = new Smode();
	
	public void select(int i) {
		switch(i) {
		case 1:
			System.out.println("Set Color");
			color.set();
			break;
			
		case 2:
			System.out.println("Change Mode");
			mode.set();
			break;
		}
		
	}

}
