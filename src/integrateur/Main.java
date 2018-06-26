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
	
	
	
	
	public static void main(String[] args) throws Exception{

		//new Main();
		
	    Serial main = new Serial();
	    main.definePort();
	    main.initialize();
	    Thread t=new Thread() {
	        public void run() {
	            //the following line will keep this app alive for 1000    seconds,
	            //waiting for events to occur and responding to them    (printing incoming messages to console).
	            try {Thread.sleep(1000000);} catch (InterruptedException    ie) {}
	        }
	    };
	    t.start();
	    System.out.println("L'écoute du port a commencé");
	}


}
