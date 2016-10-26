# Scenario

Simple rule scenario and tests all in one project

### Facts
- The fact is *Stock* having an *id*, *price* and *tradingSignal*

### Rules
- First rule says that "If stock price is less than 100 trading signal is set to BUY"
- Second rule says that "If stock price is more than 100 trading signal is set to SELL"

### JUnit test scenarios
- test *tradingSignal* value when *price* < 100
- test *tradingSignal* value when *price* > 100
- test *tradingSignal* value when *price* = 100

# Environment

JBoss Developer Studio
- version 9.1.0 with integration stacked installed
- *optional:* At JBDS "Windows">"Preferences">"Installed Drools Runtime" setup to "jboss-bpmsuite-6.3-engine". Runtime engine is downloaded separately at any location and is linked here.

# Maven project
- Archetype [kie-drools-archetype](https://mvnrepository.com/artifact/org.kie/kie-drools-archetype "kie-drools-archetype") v.6.4.0 Final has been used with *pomEclipseCompatible* set to *TRUE*.

# Run example

```bash
git clone https://github.com/smaistros/business-rules.git .
cd simpleStockRule
mvn clean verify test
```
