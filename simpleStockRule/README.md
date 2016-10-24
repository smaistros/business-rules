# Scenario

Simple rule scenario and test.

Stock has id, price and tradingSignal.

- First rule says tha "If stock price is less than 100 trading signal is set to BUY"
- Second rule says tha "If stock price is more than 100 trading signal is set to SELL"


# Environment

JBoss Developer Studio
- version 9.1.0 with integration stacked installed
- JBDS "Windows">"Preferences">"Installed Drools Runtime" setup to "jboss-bpmsuite-6.3-engine". Runtime engine is downloaded separately at any location and is linked here.

# Maven
- Archetype "https://mvnrepository.com/artifact/org.kie/kie-drools-archetype 6.4.0 final" has been used, pomEclipseCompatible set to TRUE.
