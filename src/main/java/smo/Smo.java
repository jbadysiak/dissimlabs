package smo;
/**
 * @author Dariusz Pierzchala
 * 
 * Description: Description: Klasa gniazda obsługi obiektów - zgłoszeń 
 */

import dissimlab.broker.INotificationEvent;
import dissimlab.broker.IPublisher;
import dissimlab.simcore.BasicSimObj;
import dissimlab.simcore.SimControlException;
import smo.newpackage.MyQueue;
import smo.newpackage.QueueException;
import smo.newpackage.QueueType;

import java.util.LinkedList;


public class Smo extends BasicSimObj
{
    private MyQueue<Zgloszenie> kolejka;
	private boolean wolne = true;
    public RozpocznijObsluge rozpocznijObsluge;
    public ZakonczObsluge zakonczObsluge;

    /** Creates a new instance of Smo 
     * @throws SimControlException */
    public Smo() throws SimControlException
    {
        // Utworzenie wewnętrznej listy w kolejce
        kolejka = new MyQueue<>(QueueType.FIFO, -1, true);
    }

    // Wstawienie zgłoszenia do kolejki
    public int dodaj(Zgloszenie zgl) throws SimControlException {
        try {
            kolejka.add(zgl);
        } catch (QueueException e) {
            return -1;
        }
        return kolejka.getSize();
    }

    // Pobranie zgłoszenia z kolejki
    public Zgloszenie usun()
    {
    	return kolejka.get();
    }

    // Pobranie zgłoszenia z kolejki
    public boolean usunWskazany(Zgloszenie zgl)
    {
    	return kolejka.usunWskazany(zgl);
    }
    
    public int liczbaZgl()
    {
        return kolejka.getSize();
    }

	public boolean isWolne() {
		return wolne;
	}

	public void setWolne(boolean wolne) {
		this.wolne = wolne;
	}
	
	@Override
	public void reflect(IPublisher publisher, INotificationEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean filter(IPublisher publisher, INotificationEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

    public RozpocznijObsluge getRozpocznijObsluge() {
        return rozpocznijObsluge;
    }

    public void setRozpocznijObsluge(Smo rozpocznijObsluge) throws SimControlException {
        this.rozpocznijObsluge = new RozpocznijObsluge(rozpocznijObsluge);
    }
}