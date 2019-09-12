
package s1.block2;

public class Expressions {
    
    public static void main(String[] args) {
      long a = 3;
      int b = 4;
      short c = 5;
      byte d = 6;
      
      int  result1;
      long result2;

      result2 = d / b * a;
      System.out.println("d / b * a = " + result2 );

      result1 = c + b * (d + 1);
      System.out.println("c + b * (d + 1) = " + result1 );

      result1 = d / (c - 1) * b / 2;
      System.out.println("d / (c - 1) * b / 2 = " + result1 );

      result1 = d % b;
      System.out.println("d % b = " + result1 );

      result1 = -c % b;
      System.out.println("-c % b = " + result1 );
    }

}
