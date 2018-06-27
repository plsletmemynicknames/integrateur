package integrateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

	
public class Panneau extends JPanel {
	Serial serial;
	private static final long serialVersionUID = 2273950183076632054L;
	
	String tab[][]  = { 
			{"8", "20" ,"20","20", "7","20","20","20","20","20", "6","20","20","20", "5","20", "4"},
            {"20", "0", "0"," 0","20", "0", 0, 0, 0, 0,20, 0, 0, 0, 20,0,20},
            {20, 0, 0, 0,20, 0, 0, 0, 0, 0,20, 0, 0, 0, 20,0,20},
            {20, 0, 0, 0,20, 0, 0, 0, 0, 0,20, 0, 0, 0, 20,0,20},
            {9, 20,20,20,16,20,20,20,20,20,15, 0, 0, 0, 20,0,20},
            {20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20,0,20},
            {20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20,0,20},
            {20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20,0,20},
            {10,20,20,20,20,20,20,20,20,20,20,20,20,20, 14,20,3},
            {20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20,0,20},
            {20, 0, 0, 0, 0, 0,12,20,20,20,20,20,20,20, 13,0,20},
            {20, 0, 0, 0, 0, 0,20, 0, 0, 0, 0, 0, 0, 0, 0, 0,20},
            {11,20,20,20,20,20,1 ,20,20,20,20,20,20,20,20,20, 2}
};
		

    public Panneau() {
        super();
        setOpaque(false); // we don't paint all our bits
        setLayout(new BorderLayout());
        this.serial  = new Serial(this);
        serial.definePort();
        serial.initialize();
        try {
			paint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    public void paint() throws InterruptedException {
    	repaint();
    }
	

	@Override
	protected void paintComponent(Graphics g){
	    super.paintComponent(g);
	    for (int y = 0; y < 17; y++) {
	        for (int x = 0; x < 13; x++) {
	            //check each tile and assign in a color based on its value
	        	switch (tab[x][y]) {
                case 20 : 
                    // afficher le sprite de la route
                	g.setColor(Color.BLACK);
                    break;
                case 0 : 
                    // Afficher une case blanche
                	g.setColor(Color.WHITE);
                    break;                
                default:
                	g.setColor(Color.black);
                    // Afficher une case blanche
                }
	            g.fillRect(y*40, x*40, 40, 40);
	        }
	    }
	    System.out.println("paintComponent : " + serial.getValue());
	    for (int y = 0; y < 17; y++) {
	        for (int x = 0; x < 13; x++) {
	        	if (tab[x][y] == serial.getValue()) {
	        		//draw image of car to cordonate (y*40, x*40, 40, 40);
	        	}
	        }
	    }
	}
}