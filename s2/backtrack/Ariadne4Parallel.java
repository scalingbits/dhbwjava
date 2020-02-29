package s2.backtrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 *
 * @author s@scalingbits.com
 * @version 1.0
 */
public class Ariadne4Parallel extends Ariadne {
    private static final ForkJoinPool THREADPOOL = new ForkJoinPool();
    
    /**
     * Innere statische Klasse die Fork and Join aus dem Concurrency package
     * implementiert. Sie macht aus Methodenaufrufen, Taskaufrufe von Threads
     */
    public class SearchCallable implements Callable<List<Position>> {
        Position von;
        Position nach;
        Ariadne4Parallel a;

        /**
         * 
         * @param a Instanz von Ariadne
         * @param von Start
         * @param nach Ziel
         */
        SearchCallable(Ariadne4Parallel a,Position von, Position nach) {
            this.a =a;
            this.von = von;
            this.nach = nach;
        }
        /**
         * Führe Task in eigenem Thread aus und nutze Instanzvariablen
         * als Parameter um Aufgabe auszuführen.
         * @throws java.lang.Exception
         */
        @Override
        public List<Position> call() throws Exception {
            return a.suche(von, nach);
        }
    }
    
    /**
     * Erzeuge eine Loesung
     * @param bt Rueckzeiger auf Backtrack. Wird für dynamische Updates benötigt
     */
    public Ariadne4Parallel(BacktrackSuche bt) {
        super(bt);
    }
    
    /**
     * Suche ab einer gegebenen Situation
     * @param von
     * @param nach
     * @return eine Liste des Pfades wenn Kösung gefunden wurde
     */
    @Override
    public List<Position> suche(Position von, Position nach) {
        List<Position> besterFaden = null;
        List<Position> einFaden;
        System.out.println("Thread: " + Thread.currentThread());
        bt.laby.update(laby);
        bt.updateButtons();
        if (von.equals(nach)) {
            bt.statusfeld.setText("Heureka!");
                besterFaden = new LinkedList<>();
                besterFaden.add(nach);
            }
        else { // Wir suchen weiter
            // Bin nicht am Ziel
            // Markiere aber Feld, damit ich nicht nochmal drüber laufe
            //laby.feld[x][y].zustand =Position.Status.KRUEMEL;
            // Lasse Kruemmel fallen
            von.zustand = Position.Status.KRUEMEL;
            //System.out.println("Kruemel auf Position["+von.x + "][" + von.y + "]");
            // Ermittele alle Optionen
            Set<Position> optionen = findeOptionen(von);
            if (optionen.isEmpty())
                bt.statusfeld.setText("Ende auf Position (" + von.x + "," +
                        von.y +"). Muss zurück...");
            List<Future<List<Position>>> list = new LinkedList<>();
            for (Position p:optionen) {
                Callable<List<Position>> worker = new SearchCallable(this,p, laby.ziel);
                Future<List<Position>> submit = THREADPOOL.submit(worker);
                list.add(submit);
            }
            try {
                    Thread.sleep(WARTEN);
                } catch (InterruptedException ex) {
                    System.out.println("Probleme mit Thread aufwachen");
                }
            for (Future<List<Position>> future : list) {
                try {
                    einFaden = future.get();
                    if (einFaden!=null) {
                        //einFaden.add(0, p);
                        if (besterFaden == null) besterFaden = einFaden;
                        else 
                            if (einFaden.size() < besterFaden.size())
                                besterFaden=einFaden;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            if (besterFaden!=null) besterFaden.add(von);

        }  // Ende else
        return besterFaden;
    } // Ende Methode suche()
}
