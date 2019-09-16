( cd ../out/production/dhbwjava; \
  jar cvfem ../../../jar/Kurs1Applet.jar \
   s1.block1.Kubikwurzel \
   ../../../scripts/additional-manifest.txt \
   s1/block1/Kubikwurzel*.class \
   s1/block1/HelloWorldApplet.class \
   s1/block2/BinaerIntApplet*.class \
   s1/block2/BinaerFloatApplet*.class \
   s1/block2/BinaerCastApplet*.class \
   s1/block2/IntShiftApplet*.class \
   s1/block8/Generation.class \
   s1/block8/SpielDesLebens*.class
)
#jarsigner -keystore myKeyStore -storepass sschneid -signedjar SignedApplet.jar Kurs1Applet.jar sschneid
echo "Baue Kubikwurzel.jar"
( cd ../out/production/dhbwjava; \
  jar cvfem ../../../jar/Kubikwurzel.jar \
   s1.block1.Kubikwurzel \
   ../../../scripts/Kubikwurzel-manifest.txt \
   s1/block1/Kubikwurzel*.class 
)
echo "Baue BinaerIntApplet.jar"
( cd ../out/production/dhbwjava; \
  jar cvfem ../../../jar/BinaerIntApplet.jar \
   s1.block2.BinaerIntApplet \
   ../../../scripts/BinaerIntApplet-manifest.txt \
   s1/block2/BinaerIntApplet.class 
)
echo "Baue BinaerFloatApplet.jar"
( cd ../out/production/dhbwjava; \
  jar cvfem ../../../jar/BinaerFloatApplet.jar \
   s1.block2.BinaerFloatApplet \
   ../../../scripts/BinaerFloatApplet-manifest.txt \
   s1/block2/BinaerFloatApplet.class 
)
echo "Baue BinaerCastApplet.jar"
( cd ../out/production/dhbwjava; \
  jar cvfem ../../../jar/BinaerCastApplet.jar \
   s1.block2.BinaerCastApplet \
   ../../../scripts/BinaerCastApplet-manifest.txt \
   s1.block2/BinaerCastApplet.class 
)
echo "Baue IntShiftApplet.jar"
( cd ../out/production/dhbwjava; \
  jar cvfem ../../../jar/IntShiftApplet.jar \
   s1.block2.IntShiftApplet \
   ../../../scripts/IntShiftApplet-manifest.txt \
   s1.block2/IntShiftApplet.class 
)
