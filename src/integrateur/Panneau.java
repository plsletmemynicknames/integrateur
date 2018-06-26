package integrateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

	
public class Panneau extends JPanel {
	private static final long serialVersionUID = 2273950183076632054L;
	
	int tab[][]  = { 
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
};
		

    public Panneau() {
        super();
        setOpaque(false); // we don't paint all our bits
        setLayout(new BorderLayout());
    }


	

	@Override
	protected void paintComponent(Graphics g){
	    super.paintComponent(g);
	    for (int y = 0; y < 17; y++) {
	        for (int x = 0; x < 13; x++) {
	            //check each tile and assign in a color based on its value
	        	switch (tab[x][y]) {
                case 1 : 
                    // afficher le sprite de la route
                	g.setColor(Color.BLACK);
                    break;
                case 0 : 
                    // Afficher une case blanche
                	g.setColor(Color.WHITE);
                    break;                
                default:
                	g.setColor(Color.WHITE);
                    // Afficher une case blanche
                }
	            g.fillRect(y*40, x*40, 40, 40);
	        }
	    }
	}
}