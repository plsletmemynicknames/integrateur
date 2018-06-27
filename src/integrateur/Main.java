package integrateur;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {
	
	JFrame f;
	Panneau pan;
	Dimension dimension;


	Main(){ 
		f = new JFrame("Informations ACAR");
		pan = new Panneau(this);
		f.getContentPane().add(pan);
		//pan.paintComponent();
		
        f.add(pan);
		//setting grid layout of 3 rows and 3 columns  
		f.setSize(700,560);  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		f.setVisible(true);
	}	
	
	
	public static void main(String[] args) throws Exception{

		
		
	    /*Serial main = new Serial();
	    main.definePort();
	    main.initialize();*/
	    new Main();
	    Thread t=new Thread() {
	        public void run() {
	            //the following line will keep this app alive for 1000    seconds,
	            //waiting for events to occur and responding to them    (printing incoming messages to console).
	            try {Thread.sleep(1000000);} catch (InterruptedException    ie) {}
	        }
	    };
	    t.start();
	    //System.out.println("L'écoute du port a commencé");
	}


}
