package s1.block5;

public class FlugzeugTest {
        public static Flugzeug jumbo;
        public static Flugzeug a380;


        /**
         * Die Methode main() wir zum Starten des Programms benutzt
         * @param args Übergabe von Konsolenparameter. Hier nicht genutzt
         */
        public static void main(String[] args) {
            phase1(); // 9.  Phase 1 testen
            phase2(); // 14. Phase 2 testen
            phase3(); // 15. Phase 3 testen
            phase4();
        }

        public static void phase1() {
            System.out.println(" Phase 1: 2 Flugzeuge");
            // Erzeugen zweier Objekte
            jumbo = new Flugzeug("D-ABYT",360,191000,400000);
            a380 = new Flugzeug("D-AIMD",560,286000,500000);

            // Drucken der beiden Objekte auf der Konsole
            jumbo.drucken();
            a380.drucken();
        }

        public static void phase2() {
            // 7. Testen des vorangehenden Hauptprogramms
            System.out.println(" Phase 2: Einsteigen mit Überbuchung");
            System.out.println("Ein Passagier in Jumbo einsteigen");
            jumbo.einsteigen();
            jumbo.drucken();
            System.out.println("300 Passagiere in Jumbo einsteigen");
            for (int i=0; i<300; i++) jumbo.einsteigen();
            jumbo.drucken();
            System.out.println("200 Passagiere aus Jumbo aussteigen");
            for (int i=0; i<200; i++) jumbo.aussteigen();
            jumbo.drucken();
            System.out.println("200 Passagiere aus Jumbo aussteigen");
            for (int i=0; i<200; i++) jumbo.aussteigen();
            jumbo.drucken();
        }

        public static void phase3() {
            System.out.println(" Phase 3: Jumbo Flugzeugdefekt");
            Flugzeug jumboAlt = new Flugzeug("D-ABYU",360,191000,400000);
            Flugzeug a380Neu = new Flugzeug("D-AIME",560,286000,500000);
            jumboAlt.drucken();
            a380Neu.drucken();

            System.out.println("300 Passagiere in JumboAlt einsteigen");
            for (int i=0; i<300; i++) jumboAlt.einsteigen();
            System.out.println("100 Passagiere in Airbus 380 Neu einsteigen");
            for (int i=0; i<100; i++) a380Neu.einsteigen();
            jumboAlt.drucken();
            a380Neu.drucken();
            System.out.println("Jumbo ist defekt. Alle in Airbus umsteigen");
            while (jumboAlt.anzahlPassagiere()> 0) {
                jumboAlt.aussteigen();
                a380Neu.einsteigen();
            }
            System.out.println("Alle umgestiegen. Bereit zum Start");
            jumboAlt.drucken();
            a380Neu.drucken();
        }

        public static void phase4() {
            System.out.println(" Phase 4: A380 Flugzeugdefekt mit 560 Passagieren");
            Flugzeug jumbo1 = new Flugzeug("D-ABYV",360,191000,400000);
            Flugzeug jumbo2 = new Flugzeug("D-ABYW",360,191000,400000);
            Flugzeug a380Defekt = new Flugzeug("D-AIME",560,286000,500000);
            jumbo1.drucken();
            jumbo2.drucken();
            a380Defekt.drucken();
            System.out.println("50 Passagiere in Jumbo 1 und 2 einsteigen");
            // 17. Lassen Sie 200 Passagiere in jeden Jumbo einsteigen
            //     Hiermit ist nicht mehr Platz für alle Airbuspassagiere
            //     Testen Sie den Fall der Überbuchung
            for (int i=0; i<50; i++) {
                jumbo1.einsteigen();
                jumbo2.einsteigen();
            }
            System.out.println("560 Passagiere in Airbus 380 (defekt) einsteigen");
            for (int i=0; i<560; i++) a380Defekt.einsteigen();
            jumbo1.drucken();
            jumbo2.drucken();
            a380Defekt.drucken();

            System.out.println("Airbus ist defekt. Alle in Jumbos umsteigen");
            // 16. Implementieren Sie das Evakuieren des Airbus
            //     Beide Jumbos sollen benutzt werden falls notwendig
            //     Drucken Sie eine Warnung aus falls Sie einen Passagier
            //     nicht umsteigen lassen.
            while (a380Defekt.anzahlPassagiere()> 0) {
                if (jumbo1.anzahlPassagiere() < jumbo1.passagierkapazitaet()) {
                    a380Defekt.aussteigen();
                    jumbo1.einsteigen();
                }
                else // Jumbo 1 is voll...
                    if (jumbo2.anzahlPassagiere() < jumbo2.passagierkapazitaet()) {
                        a380Defekt.aussteigen();
                        jumbo2.einsteigen();
                    }
                    else // Beide Jumbos sind voll
                    {
                        a380Defekt.aussteigen();
                        System.out.println("Ein Passagier bleibt zurück...");
                    }

            }
            System.out.println("Airbus evakuiert. Bereit zum Start");
            jumbo1.drucken();
            jumbo2.drucken();
            a380Defekt.drucken();
        }
    }
