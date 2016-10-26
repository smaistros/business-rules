# Scenario

Simple rule scenario and tests using two projects. One for fact model and one for rules

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

# Maven
- Archetype "https://mvnrepository.com/artifact/org.kie/kie-drools-archetype 6.4.0 final" has been used, pomEclipseCompatible set to TRUE.

# Run example

```bash
git clone https://github.com/smaistros/business-rules.git .
cd tradeStock/tradeStockModel
mvn clean verify build
cd ../tradeStockRules
mvn clean verify test
```
