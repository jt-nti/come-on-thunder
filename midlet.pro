-injars ComeOnThunder_unverified.jar
-outjars ComeOnThunder.jar
-libraryjars <user.home>/.m2/repository/org/microemu/midpapi20/2.0.3/midpapi20-2.0.3.jar
-libraryjars <user.home>/.m2/repository/org/microemu/cldcapi11/2.0.3/cldcapi11-2.0.3.jar
-overloadaggressively
-repackageclasses ''
-allowaccessmodification
-microedition
-printseeds

-keep public class * extends javax.microedition.midlet.MIDlet
