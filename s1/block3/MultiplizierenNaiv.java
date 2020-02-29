package s1.block3;

class MultiplizierenNaiv {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int result = 0;
        for (int i = 1; i <= a; i++) {
            System.out.println("Äussere Schleife i = " + i);
            for (int j = 1; j <= b; j++) {
                System.out.println("Innere Schleife j = " + j);
                result++;
            }
        }
        System.out.println(a +"*"+b+" = "+result);
    }
}