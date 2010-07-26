package org.jboss.dealer;

import java.util.Arrays;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

/**
 * This is a sample class to launch a rule.
 */
public class ProgramTest {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KnowledgeBase kbase = readKnowledgeBase();

			case1(kbase);
			case2(kbase);
			case3(kbase);
			case4(kbase);
			case5(kbase);

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private static void case1(KnowledgeBase kbase) throws Exception {

		Dealer d = new Dealer("Dealer 1", 8, 6);
		Vehicle v1 = new Vehicle("Galant");
		Vehicle v2 = new Vehicle("Lancer");
		Vehicle v3 = new Vehicle("Endeavor");

		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case1");
		//ksession.addEventListener(new DebugAgendaEventListener());
		//ksession.addEventListener(new DebugWorkingMemoryEventListener());
		ksession.execute(Arrays.asList(new Object[] { d, v1, v2, v3 }));

		System.out.println(d);
		logger.close();
	}

	private static void case2(KnowledgeBase kbase) throws Exception {

		Dealer d = new Dealer("Dealer 2", 8, 8);
		Vehicle v1 = new Vehicle("Galant");
		Vehicle v2 = new Vehicle("Lancer");
		Vehicle v3 = new Vehicle("Eclipse");
		Vehicle v4 = new Vehicle("EVO");

		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case2");
		//ksession.addEventListener(new DebugAgendaEventListener());
		//ksession.addEventListener(new DebugWorkingMemoryEventListener());

		ksession.execute(Arrays.asList(new Object[] { d, v1, v2, v3, v4 }));

		logger.close();
		System.out.println(d);
	}

	private static void case3(KnowledgeBase kbase) throws Exception {

		Dealer d = new Dealer("Dealer 3", 15, 18);

		Vehicle v1 = new Vehicle("Spyder");
		Vehicle v2 = new Vehicle("Spyder");
		Vehicle v3 = new Vehicle("Eclipse");
		Vehicle v4 = new Vehicle("Eclipse");
		Vehicle v5 = new Vehicle("Outloander");
		Vehicle v6 = new Vehicle("Outloander");
		Vehicle v7 = new Vehicle("Lancer");
		Vehicle v8 = new Vehicle("Lancer");
		Vehicle v9 = new Vehicle("Lancer");
		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		
//		StatefulKnowledgeSession ssession = kbase.newStatefulKnowledgeSession();
//		ssession.dispose();
		
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case3");
		//ksession.addEventListener(new DebugAgendaEventListener());
		//ksession.addEventListener(new DebugWorkingMemoryEventListener());

		ksession.execute(Arrays.asList(new Object[] { d, v1, v2, v3, v4, v5,
				v6, v7, v8, v9 }));
		System.out.println(d);
		logger.close();
	}

	private static void case4(KnowledgeBase kbase) throws Exception {

		Dealer d = new Dealer("Dealer 4", 30, 38);

		Vehicle v1 = new Vehicle("Galant");
		Vehicle v2 = new Vehicle("Galant");
		Vehicle v3 = new Vehicle("Eclipse");
		Vehicle v4 = new Vehicle("Eclipse");
		Vehicle v5 = new Vehicle("Eclipse");
		Vehicle v6 = new Vehicle("Eclipse");
		Vehicle v7 = new Vehicle("Eclipse");
		Vehicle v8 = new Vehicle("Eclipse");
		Vehicle v9 = new Vehicle("Eclipse");
		Vehicle v10 = new Vehicle("Eclipse");
		Vehicle v11 = new Vehicle("Eclipse");
		Vehicle v12 = new Vehicle("Raiders");
		Vehicle v13 = new Vehicle("Raiders");
		Vehicle v14 = new Vehicle("Lancer");
		Vehicle v15 = new Vehicle("Lancer");
		Vehicle v16 = new Vehicle("Lancer");
		Vehicle v17 = new Vehicle("Lancer");
		Vehicle v18 = new Vehicle("Outlander");
		Vehicle v19 = new Vehicle("Outlander");

		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case4");
		//ksession.addEventListener(new DebugAgendaEventListener());
		//ksession.addEventListener(new DebugWorkingMemoryEventListener());

		ksession.execute(Arrays.asList(new Object[] { d, v1, v2, v3, v4, v5,
				v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18,
				v19 }));

		System.out.println(d);
		logger.close();
	}

	private static void case5(KnowledgeBase kbase) throws Exception {

		Vehicle v1 = new Vehicle("Galant");
		Vehicle v2 = new Vehicle("Galant");
		Vehicle v3 = new Vehicle("Galant");
		Vehicle v4 = new Vehicle("Galant");
		Vehicle v5 = new Vehicle("Galant");
		Vehicle v6 = new Vehicle("Eclipse");
		Vehicle v7 = new Vehicle("Eclipse");
		Vehicle v8 = new Vehicle("Eclipse");
		Vehicle v9 = new Vehicle("Eclipse");
		Vehicle v10 = new Vehicle("Eclipse");
		Vehicle v11 = new Vehicle("Eclipse");
		Vehicle v12 = new Vehicle("Eclipse");
		Vehicle v13 = new Vehicle("Eclipse");
		Vehicle v14 = new Vehicle("Eclipse");
		Vehicle v15 = new Vehicle("Eclipse");
		Vehicle v16 = new Vehicle("EVO");
		Vehicle v17 = new Vehicle("EVO");
		Vehicle v18 = new Vehicle("Lancer");
		Vehicle v19 = new Vehicle("Lancer");
		Vehicle v20 = new Vehicle("Lancer");
		Vehicle v21 = new Vehicle("Lancer");
		Vehicle v22 = new Vehicle("Lancer");
		Vehicle v23 = new Vehicle("Lancer");
		Vehicle v24 = new Vehicle("Outlander");
		Vehicle v25 = new Vehicle("Outlander");
		Vehicle v26 = new Vehicle("Outlander");

		Dealer d = new Dealer("Dealer 5", 40, 52);

		StatelessKnowledgeSession ksession = kbase
				.newStatelessKnowledgeSession();
		KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
				.newFileLogger(ksession, "/Users/uaarkoti/case5");
		//ksession.addEventListener(new DebugAgendaEventListener());
		//ksession.addEventListener(new DebugWorkingMemoryEventListener());

		ksession.execute(Arrays.asList(new Object[] { d, v1, v2, v3, v4, v5,
				v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18,
				v19, v20, v21, v22, v23, v24, v25, v26 }));

		System.out.println(d);
		logger.close();
	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("Programs.dsl"),
				ResourceType.DSL);
		kbuilder
				.add(
						ResourceFactory
								.newClassPathResource("February2009StairstepNationalProgram.dslr"),
						ResourceType.DSLR);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}
}