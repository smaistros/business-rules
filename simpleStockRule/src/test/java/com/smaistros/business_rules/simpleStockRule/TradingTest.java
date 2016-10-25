package com.smaistros.business_rules.simpleStockRule;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smaistros.business_rules.simpleStockRule.TradingSignal;

public class TradingTest {
	static final Logger LOG = LoggerFactory.getLogger(TradingTest.class);

	private KieSession session;
	
	@Before
	public void setup(){
		LOG.info("Setup resources");
		KieServices kieServices = KieServices.Factory.get();

		KieContainer kContainer = kieServices.getKieClasspathContainer();
		Results verifyResults = kContainer.verify();
		for (Message m : verifyResults.getMessages()) {
			LOG.info("{}", m);
		}

		LOG.info("Creating kieBase");
		KieBase kieBase = kContainer.getKieBase();

		LOG.info("Rules are: ");
		for (KiePackage kp : kieBase.getKiePackages()) {
			for (Rule rule : kp.getRules()) {
				LOG.info("kp " + kp + " rule " + rule.getName());
			}
		}

		LOG.info("Creating kieSession");
		session = kieBase.newKieSession();		
	}
	
	@Test
	public void testPriceLessThan100() {
		LOG.info("Running testPriceLessThan100");

		Stock googleStock = new Stock("google", 99);
		session.insert(googleStock);
		session.fireAllRules();

		LOG.info("Final checks");

		assertTrue("Stock google has trade signal BUY", googleStock.getTradingSignal() == TradingSignal.BUY);
	}

	@Test
	public void testPriceEquals100() {
		LOG.info("Running testPriceEquals100");

		Stock oneHStock = new Stock("oneH stock", 100);
		session.insert(oneHStock);
		session.fireAllRules();

		LOG.info("Final checks");

		assertTrue("oneH has trade signal NULL", oneHStock.getTradingSignal() == null);
	}
	
	
	@Test
	public void testPriceMoreThan100() {
		LOG.info("Running testPriceMoreThan100");

		Stock appleStock = new Stock("apple", 101);
		session.insert(appleStock);
		session.fireAllRules();

		LOG.info("Final checks");

		assertTrue("Stock apple has trade signal SELL", appleStock.getTradingSignal() == TradingSignal.SELL);
	}	
	
	@After
	public void cleanup() {
		if ( session != null) {
			session.dispose();
		}
	}
	
}