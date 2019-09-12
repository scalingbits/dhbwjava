package s1.block2.clock;
public class Weckzeit {
    int wzh = 0; // Weckzeit in Stunden
    int wzm = 0; // Weckzeit in Minuten
    int wzs = 0; // Weckzeit in Sekunden
    public void setzeWeckzeit(int hh, int mm, int ss) {
        if (korrekteWeckzeit(hh,mm,ss)) {
            wzh = hh;
            wzm = mm;
            wzs = ss;
        }
    }
    public boolean korrekteWeckzeit(int h, int m, int s) {
        boolean result;
        // benutzen die Variablen h,m,s um eine gültige Zeit zu bestimmen



        boolean korrekteS = (s >=0) && (s <60);
        boolean korrekteM = (m >=0) && (m <60);
        boolean korrekteH = (h >=0) && (h <12);

        result = (korrekteS) & (korrekteM) & (korrekteH);
        return result;
    }
    public boolean klingeln(int aktH, int aktM, int aktS) {
        boolean result;
        // benutzen die Variablen der aktuellen Zeit aktH (Stunde),
        // aktM (Minute), aktS (Sekunde) und die Weckzeit wzmh, wzm, wzs
        // um zu bestimmern ob der Wecker klingeln soll

        // Verbessern Sie diese Zuweisung
        // In der aktuellen Implementieren klingelt der Wecker
        // alle 10 Sekunden für 1 Sekunde

        int aktuelleZeitinS = aktH*3600+aktM*60+aktS;
        int weckzeitZeitinS = wzh*3600+wzm*60+wzs;

        result = (aktuelleZeitinS-weckzeitZeitinS>=0) &&
                (aktuelleZeitinS-weckzeitZeitinS<10);
        return result;
    }









}
