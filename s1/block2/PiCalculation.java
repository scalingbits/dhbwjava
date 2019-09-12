package s1.block2;
public class PiCalculation {

    public static void main(String[] args) {
        double pi;

        pi = (1.0 - 1.0/3.0 + 1.0/5.0 - 1.0/7.0 + 1.0/9.0 - 1.0/11.0 + 1.0/13.0)*4;
        System.out.println("Pi = "+ pi);
        System.out.println("\n oder ...");

        pi=1;
        for (int i=1;i<=10000;i++) {
            pi = pi + Math.pow(-1,i)/(2*i+1);
        }
        pi=pi*4;
        System.out.println("Pi = "+ pi);

    }

}
