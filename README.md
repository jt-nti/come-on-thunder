# Come on thunder

Simple Java MIDlet to calculate your distance from a lightning strike

## Why?

For some reason I started wondering how doable it would be to build MIDlets with [Travis](https://travis-ci.org/). Could be a knock to the head recently. Anyway, I probably [should have stopped being daft and done something useful instead](https://twitter.com/jtonline/status/900817931977838594)... but here I am writing this readme instead!

Before I can attempt to build a MIDlet, I need a MIDlet to build, so this is it. Plus it's the perfect excuse to resurect my favourite mobile app, from way back before the time of 'smart' phones and 'apps'. If you missed out on it the first time round, [Flash Boom](https://archive.org/details/tucows_33513_Flash_Boom) brought counting the number of seconds between a flash of lightning and the rumble of thunder to PalmOS touch screen perfection. 'Come on thunder' is a poor quality imitation in MIDlet form.

## Does it build?

Not in Travis (yet) but, thanks to a [Java Mobile Edition Development Tools](http://tjworld.net/wiki/Linux/Ubuntu/JavaMobileEditionDevelopmentTools) Wiki page, it's looking promising with OpenJDK, MicroEmulator and ProGuard. I'm thinking I'll probably need a suitable Docker image with those in and I may, relutantly, give maven a try, but so far I've managed to build a simple hello world MIDlet on the command line:

### Compile

```
javac -target 1.3 -source 1.3 -bootclasspath /home/ubuntu/microemulator-2.0.3/lib/cldcapi10.jar:/home/ubuntu/microemulator-2.0.3/lib/midpapi20.jar -d target src/main/java/uk/me/nti/midp/ComeOnThunder.java
```

### Create unverified jar

```
jar cfm ComeOnThunder_unverified.jar src/main/resources/MANIFEST.MF -C target .
```

### Preverify

```
java -jar /home/ubuntu/proguard5.3.3/lib/proguard.jar @midlet.pro
```
