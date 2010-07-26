package org.jboss.dealer;

import org.drools.RuleBase;

import org.drools.agent.RuleAgent;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DealerProgramTest {
	
	RuleBase kbase;
	
	@Test
	public void test5() {
		Dealer d = new Dealer("Dealer 5", 40, 52);
		kbase.newStatelessSession().execute(new Object[] { d, new Vehicle("Lancer"), new Vehicle("Lancer"), new Vehicle("Lancer"), new Vehicle("Lancer"), new Vehicle("EVO") });
		assertEquals(d.getTotalAward(), 3200.0);
	}

	@BeforeSuite
	public void beforeSuite() throws Exception {
		RuleAgent agent = RuleAgent
				.newRuleAgent("/brms_agent.properties");
		kbase = agent.getRuleBase();

//		FactType appType = rb.getFactType("mortgages.LoanApplication");
//		FactType incomeType = rb.getFactType("mortgages.IncomeSource");
//
//		Object application = appType.newInstance();
//		Object income = incomeType.newInstance();
//
//		appType.set(application, "amount", 25000);
//		appType.set(application, "deposit", 1500);
//		appType.set(application, "lengthYears", 20);
//
//		incomeType.set(income, "type", "Job");
//		incomeType.set(income, "amount", 65000);
//
//		rb.newStatelessSession().execute(new Object[] { application, income });
	}

}
