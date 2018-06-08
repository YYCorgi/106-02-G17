package tetris;

public class Setsel {
	
	private Scolor color = new Scolor();
	
	public void select(int i) {
		switch(i) {
		case 1:
			System.out.println("Set Color");
			color.set();
			break;
		}
		
	}

}
