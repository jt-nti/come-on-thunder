# Come on thunder

Simple Java MIDlet to calculate your distance from a lightning strike

## Why?

For some reason I started wondering how doable it would be to build MIDlets with [Travis](https://travis-ci.org/). Could be a knock to the head recently. Anyway, I probably [should have stopped being daft and done something useful instead](https://twitter.com/jtonline/status/900817931977838594)... but here I am writing this readme instead!

Before I can attempt to build a MIDlet, I need a MIDlet to build, so this is it. Plus it's the perfect excuse to resurect my favourite mobile app, from way back before the time of 'smart' phones and 'apps'. If you missed out on it the first time round, [Flash Boom](https://archive.org/details/tucows_33513_Flash_Boom) brought counting the number of seconds between a flash of lightning and the rumble of thunder to PalmOS touch screen perfection. 'Come on thunder' is a poor quality imitation in MIDlet form.

## Does it build?

Not in Travis (yet) but, thanks to a [Java Mobile Edition Development Tools](http://tjworld.net/wiki/Linux/Ubuntu/JavaMobileEditionDevelopmentTools) Wiki page, it's looking promising with OpenJDK, MicroEmulator and ProGuard. So far I've got a maven build working, based on Marek's [Building a Java ME application with Maven](https://mobileswdev.wordpress.com/2009/03/13/building-a-java-me-application-with-maven/) blog post, so I can build MIDlets on the command line, which is nice:

### Create unverified jar

```
mvn package
```

### Preverify

```
java -jar ~/proguard5.3.3/lib/proguard.jar @midlet.pro
```
