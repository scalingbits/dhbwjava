package s1.block3;

public class WeckzeitLoesung {
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
        result = ((h>=0) && (h<=12 && (m>=0) && (m<=59)&& (s>=0) && (s<=59)));
        return result;
    }
    public boolean klingeln(int aktH, int aktM, int aktS) {
        boolean result;
        // benutzen die Variablen der aktuellen Zeit aktH (Stunde),
        // aktM (Minute), aktS (Sekunde) und die Weckzeit wzmh, wzm, wzs
        // um zu bestimmern ob der Wecker klingeln soll
        // Bestimme aktuelle Zeit in Sekunden
        int aktZeit  = aktH*3600 + aktM*60+aktS;
        // Bestimme Weckzeit in Sekunden
        int weckZeit = wzh *3600 + wzm *60+wzs;
        // Ist die aktuelle Zeit größer aber nicht größer als 10 Sekunden?
        result = (aktZeit-weckZeit>=0) && (aktZeit-weckZeit<10);
        return result;
    }
}
