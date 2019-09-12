package s1.block1;
import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author sschneid
 * @version 1.1
 *
 * Copyright (c) 2013, Dr. Stefan Schneider, schneider4me.de All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 2. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are
 * those of the authors and should not be interpreted as representing official
 * policies, either expressed or implied, of the FreeBSD Project.
 */
public class HelloWorldApplet extends Applet{
    /*
     * Diese Methode wird aufgerufen wenn das Applet started
     *
     */
    public void init() {
         // Die Methode ist notwendig. Sie muss aber nicht mit Inhalt gefüllt
         // werden.
         System.out.println("HelloWorldApplet.init() aufgerufen");
     }

    /*
     * Diese Methode wird aufgerufen wenn das Applet beendet wird.
     * Der Benutzer hat die html Seite verlassen
     */
     public void stop()
     {
     System.out.println("HelloWorldApplet.stop() aufgerufen");
     }

     /*
      * Die Standardmethode um etwas auf den Bildschirm zu malen
      */
     public void paint(Graphics g)
     {
     //Diese Methode malt Text auf den Bildschirm
     // Text, x Koordinate, y Koordinate
      g.drawString("Dies ist ein Text",20,20);
      g.drawString("Hello World!",20,40);
     }
}
