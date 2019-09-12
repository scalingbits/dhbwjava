package s1.block2;
public class TimeCalculation {

    public static void main(String[] args) {
        int a,h,m,s;

        a = 0;
        h = a/3600;
        m = (a-h*3600)/60;
        s = a - h*3600 - m*60;
        System.out.println("Sekunden = " + a + " = " + h + ":" + m + ":" +s);

        a = 59;
        h = a/3600;
        m = (a-h*3600)/60;
        s = a - h*3600 - m*60;
        System.out.println("Sekunden = " + a + " = " + h + ":" + m + ":" +s);

        a = 60;
        h = a/3600;
        m = (a-h*3600)/60;
        s = a - h*3600 - m*60;
        System.out.println("Sekunden = " + a + " = " + h + ":" + m + ":" +s);

        a = 100;
        h = a/3600;
        m = (a-h*3600)/60;
        s = a - h*3600 - m*60;
        System.out.println("Sekunden = " + a + " = " + h + ":" + m + ":" +s);

        a = 3600;
        h = a/3600;
        m = (a-h*3600)/60;
        s = a - h*3600 - m*60;
        System.out.println("Sekunden = " + a + " = " + h + ":" + m + ":" +s);

        a = 4000;
        h = a/3600;
        m = (a-h*3600)/60;
        s = a - h*3600 - m*60;
        System.out.println("Sekunden = " + a + " = " + h + ":" + m + ":" +s);
    }

}
