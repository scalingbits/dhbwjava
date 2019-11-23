package s1.block11;

import java.io.Serializable;
/**
 *
 * @author s@scalingbits.com
 */
public class Person implements Serializable {
    String name;
    Adresse wohnort;
    public Person(String n, Adresse w) {
        wohnort = w;
        name=n;
    }
}
