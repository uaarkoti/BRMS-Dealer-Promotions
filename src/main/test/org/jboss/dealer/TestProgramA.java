package org.jboss.dealer;

import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestProgramA {

	KnowledgeBase kbase;

	@Test(enabled = true)
	public void test1() {
		Dealer d = new Dealer("Dealer 1", 8, 6);

		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "/Users/uaarkoti/case1");

		//LANCER(1), GALANT(1), SPYDER(0), ENDEAVOR(1), EVO(0), ECLIPSE(0), OUTLANDER(0), RAIDERS(0);
		List<Object> vehicles = getVehicles(1, 1, 0, 1, 0, 0, 0, 0);
		vehicles.add(d);
		ksession.execute(vehicles);

		logger.close();
		System.out.println(d);
		
		assertEquals(d.getTotalAward(), 0.0);
	}
	
	@Test(enabled = true)
	public void test2() {
		Dealer d = new Dealer("Dealer 2", 8, 8);

		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case2");

		//LANCER(1), GALANT(1), SPYDER(0), ENDEAVOR(0), EVO(1), ECLIPSE(1), OUTLANDER(0), RAIDERS(0);
		List<Object> vehicles = getVehicles(1, 1, 0, 0, 1, 1, 0, 0);
		vehicles.add(d);
		ksession.execute(vehicles);

		logger.close();
		System.out.println(d);
		
		assertEquals(1300.0, d.getTotalAward());

	}
	
	@Test(enabled = true)
	public void test3() {
		Dealer d = new Dealer("Dealer 3", 15, 18);

		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case3");

		//LANCER(3), GALANT(0), SPYDER(2), ENDEAVOR(0), EVO(0), ECLIPSE(2), OUTLANDER(2), RAIDERS(0);
		List<Object> vehicles = getVehicles(3, 0, 2, 0, 0, 2, 2, 0);
		vehicles.add(d);
		ksession.execute(vehicles);

		logger.close();
		System.out.println(d);
		
		assertEquals(5400.0, d.getTotalAward());

	}	

	@Test(enabled = true)
	public void test4() {
		Dealer d = new Dealer("Dealer 4", 30, 38);

		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case4");

		//LANCER(4), GALANT(2), SPYDER(0), ENDEAVOR(0), EVO(0), ECLIPSE(9), OUTLANDER(2), RAIDERS(2);
		List<Object> vehicles = getVehicles(4, 2, 0, 0, 0, 9, 2, 2);
		vehicles.add(d);
		ksession.execute(vehicles);

		logger.close();
		System.out.println(d);
		
		assertEquals(16800.0, d.getTotalAward());

	}

	@Test(enabled = true)
	public void test5() {
		Dealer d = new Dealer("Dealer 5", 40, 52);

		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case5");

		//LANCER(6), GALANT(5), SPYDER(0), ENDEAVOR(0), EVO(2), ECLIPSE(10), OUTLANDER(3), RAIDERS(0);
		List<Object> vehicles = getVehicles(6, 5, 0, 0, 2, 10, 3, 0);
		vehicles.add(d);
		ksession.execute(vehicles);

		logger.close();
		System.out.println(d);
		
		assertEquals(34400.0, d.getTotalAward());

	}	
	
	@BeforeSuite
	public void beforeSuite() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		//kbuilder.add(ResourceFactory.newClassPathResource("Programs.dsl"), ResourceType.DSL);
		//kbuilder.add(ResourceFactory.newClassPathResource("February2009StairstepNationalProgram.dslr"),
		//				ResourceType.DSLR);
		kbuilder.add(ResourceFactory.newClassPathResource("NewProgramLogic.drl"), ResourceType.DRL);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		
		kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
	}
	
	//LANCER, GALANT, SPYDER, ENDEAVOR, EVO, ECLIPSE, OUTLANDER, RAIDERS;
	private List<Object> getVehicles(int lancers, int galants, int spyders, 
			int endeavors, int evos, int eclipses,int outlanders, int raiders) {
		List<Object> vehicles = new ArrayList<Object>();
		
		for(int i=0 ; i<lancers; i++) {
			vehicles.add(new Vehicle(VehicleModel.LANCER));
		}
		
		for(int i=0 ; i<galants; i++) {
			vehicles.add(new Vehicle(VehicleModel.GALANT));
		}

		for(int i=0 ; i<spyders; i++) {
			vehicles.add(new Vehicle(VehicleModel.SPYDER));
		}
		
		for(int i=0 ; i<endeavors; i++) {
			vehicles.add(new Vehicle(VehicleModel.ENDEAVOR));
		}
		
		for(int i=0 ; i<evos; i++) {
			vehicles.add(new Vehicle(VehicleModel.EVO));
		}
		
		for(int i=0 ; i<eclipses; i++) {
			vehicles.add(new Vehicle(VehicleModel.ECLIPSE));
		}
		
		for(int i=0 ; i<outlanders; i++) {
			vehicles.add(new Vehicle(VehicleModel.OUTLANDER));
		}

		for(int i=0 ; i<raiders; i++) {
			vehicles.add(new Vehicle(VehicleModel.RAIDERS));
		}

		return vehicles;
	}

}
