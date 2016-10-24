package com.smaistros.business_rules.simpleStockRule;

import static org.junit.Assert.*;

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

	@Test
	public void test() {
		KieServices kieServices = KieServices.Factory.get();

		KieContainer kContainer = kieServices.getKieClasspathContainer();
		Results verifyResults = kContainer.verify();
		for (Message m : verifyResults.getMessages()) {
			LOG.info("{}", m);
		}

		LOG.info("Creating kieBase");
		KieBase kieBase = kContainer.getKieBase();

		LOG.info("There should be rules: ");
		for (KiePackage kp : kieBase.getKiePackages()) {
			for (Rule rule : kp.getRules()) {
				LOG.info("kp " + kp + " rule " + rule.getName());
			}
		}

		LOG.info("Creating kieSession");
		KieSession session = kieBase.newKieSession();

		LOG.info("Now running data");

		Stock googleStock = new Stock("google", 99);
		session.insert(googleStock);
		session.fireAllRules();

		LOG.info("Final checks");

		assertTrue("Stock google has trade signal BUY", googleStock.getTradingSignal() == TradingSignal.BUY);
	}
}