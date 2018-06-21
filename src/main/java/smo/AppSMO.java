package smo;

/**
 * @author Dariusz Pierzchala
 * 
 * Description: Klasa główna. Tworzy dwa SMO, inicjalizuje je.Startuje symulację. Wyświetla statystyki.
 * 
 * Wersja testowa.
 */

import dissimlab.simcore.SimControlEvent;
import dissimlab.simcore.SimControlException;
import dissimlab.simcore.SimManager;
import dissimlab.simcore.SimParameters.SimControlStatus;
import py4j.GatewayServer;

public class AppSMO {

	public static void main(String[] args) throws SimControlException {
		try {
			SimManager model = SimManager.getInstance();
			// Powołanie Smo 
			Smo smo = new Smo();
			// Utworzenie otoczenia
			Otoczenie generatorZgl = new Otoczenie(smo);
			// Dwa sposoby zaplanowanego końca symulacji
			//model.setEndSimTime(10000);
			// lub
			SimControlEvent stopEvent = new SimControlEvent(1000.0, SimControlStatus.STOPSIMULATION);
			// Uruchomienie symulacji za pośrednictwem metody "startSimulation"

//			GatewayServer gatewayServer = new GatewayServer(new ZakonczObsluge(generatorZgl, 1, ));
//			gatewayServer.start();

			model.startSimulation();

		} catch (SimControlException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
