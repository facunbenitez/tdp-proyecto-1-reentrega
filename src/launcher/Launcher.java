package launcher;

import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	entities.Student est = new entities.Student(130605, "Benitez", "Facundo", "facubenitez2001@hotmail.com.ar", "https://github.com/facunbenitez", "/images/icono.jpg");
            	
            	SimplePresentationScreen frame = new SimplePresentationScreen(est);
            	
            	frame.setVisible(true);
            }
        });
    }
}