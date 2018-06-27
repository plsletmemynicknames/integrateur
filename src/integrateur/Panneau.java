package integrateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

	
public class Panneau extends JPanel {
	Serial serial;
	Main main;
	
	private static final long serialVersionUID = 2273950183076632054L;
	
	String tab[][]  = { 
			{"8", "20" ,"20","20", "7","20","20","20","20","20", "6","20","20","20", "5","20", "4"},
            {"20", "0", "0","0","20", "0", "0", "0", "0", "0","20", "0", "0", "0", "20","0","20"},
            {"20", "0", "0", "0","20", "0", "0", "0", "0", "0","20", "0", "0", "0", "20","0","20"},
            {"20", "0", "0", "0","20", "0", "0", "0", "0", "0","20", "0", "0", "0", "20","0","20"},
            {"9", "20","20","20","16","20","20","20","20","20","15", "0", "0", "0", "20","0","20"},
            {"20", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "20","0","20"},
            {"20", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "20","0","20"},
            {"20", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "20","0","20"},
            {"10","20","20","20","20","20","20","20","20","20","20","20","20","20", "14","20","3"},
            {"20", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "20","0","20"},
            {"20", "0", "0", "0", "0", "0","12","20","20","20","20","20","20","20", "13","0","20"},
            {"20", "0", "0", "0", "0", "0","20", "0", "0", "0", "0", "0", "0", "0", "0", "0","20"},
            {"11","20","20","20","20","20","1" ,"20","20","20","20","20","20","20","20","20", "2"}
};
		

    public Panneau(Main main) {
        super();
        setOpaque(false); // we don't paint all our bits
        setLayout(new BorderLayout());
        this.serial  = new Serial(this);
        serial.definePort();
        serial.initialize();
        this.main = main;
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
		int X = 0;
		int Y = 0;
	    super.paintComponent(g);
	    for (int y = 0; y < 17; y++) {
	        for (int x = 0; x < 13; x++) {
	            //check each tile and assign in a color based on its value
	        	switch (tab[x][y]) {
                case "20" : 
                    // afficher le sprite de la route
                	g.setColor(Color.BLACK);
                    break;
                case "0" : 
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
	    if (serial.getFinish() == false) {
	    	switch(serial.getPosition()) {
		    case "1" :
		    	X = 6;
		    	Y = 12;
		    	break;
		    case "2":
		    	X = 16;
		    	Y = 12;
		    	break;
		    case "3" :
		    	X = 16;
		    	Y = 8;
		    	break;
		    case "4":
		    	X = 16;
		    	Y = 0;
		    	break;
		    case "5" :
		    	X = 14;
		    	Y = 0;
		    	break;
		    case "6":
		    	X = 10;
		    	Y = 0;
		    	break;
		    case "7" :
		    	X = 4;
		    	Y = 0;
		    	break;
		    case "8":
		    	X = 0;
		    	Y = 0;
		    	break;
		    case "9" :
		    	X = 0;
		    	Y = 4;
		    	break;
		    case "10":
		    	X = 0;
		    	Y = 8;
		    	break;
		    case "11" :
		    	X = 0;
		    	Y = 12;
		    	break;
		    case "12":
		    	X = 6;
		    	Y = 10;
		    	break;
		    case "13" :
		    	X = 14;
		    	Y = 10;
		    	break;
		    case "14":
		    	X = 14;
		    	Y = 8;
		    	break;
		    case "15" :
		    	X = 10;
		    	Y = 4;
		    	break;
		    case "16":
		    	X = 4;
		    	Y = 4;
		    	break;
		    case "20":
		    	X = 100;
		    	Y = 100;
		    }
		    g.setColor(Color.red);
			g.fillRect(X*40, Y*40, 40, 40);
	    }
	    else {
	    	X = 0;
	    	for (Place p: serial.getPlaces()) {
	    		//System.out.println("La place entre les points " + p.PointA + " et " + p.PointB + " mesure : " + p.Distance + " cm");
	    		X++;
	    		Font font = new Font("Serif", Font.PLAIN, 18);
	            g.setFont(font);
	    		g.drawString("La place entre les points " + p.PointA + " et " + p.PointB + " mesure : " + p.Distance + " cm.",50,520 + X * 20); 
	    	}
	    	main.f.setSize(700, 800);
	    }
	    
	}
}