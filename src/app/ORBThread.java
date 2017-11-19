package app;

import org.omg.CORBA.ORB;

public class ORBThread implements Runnable{
	
	private ORB orba;
	    
    public ORBThread(ORB orb){
        this.orba = orb;
    }
	
	@Override
	public void run() {
		try {
            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            orba.run();
        } catch (Exception e) {
        	
        }
	}

}
