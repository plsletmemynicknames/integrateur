package integrateur;


import javax.swing.JFrame;

public class Main {
	
	Main(){ 
		JFrame f = new JFrame("interface");
		Panneau pan = new Panneau();
		f.getContentPane().add(pan);
		//pan.paintComponent();
		
        f.add(pan);
		//setting grid layout of 3 rows and 3 columns  
		f.setSize(700,560);  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		f.setVisible(true); 
	}
	
	
	
	
	public static void main(String[] args) {

		new Main();
	}


}
