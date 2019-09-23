package br.edu.univali.lia.cogroo;

import java.io.IOException;
import java.util.Locale;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.cogroo.analyzer.Analyzer;
import org.cogroo.analyzer.ComponentFactory;
import org.cogroo.checker.CheckDocument;
import org.cogroo.checker.GrammarChecker;
import org.cogroo.text.Document;
import org.cogroo.text.impl.DocumentImpl;

public class CogrooPythonInterface {

	public ComponentFactory factory;
	public Analyzer cogroo;
	public GrammarChecker gc;

	public CogrooPythonInterface() throws IllegalArgumentException, IOException {
		factory = ComponentFactory.create(new Locale("pt", "BR"));
		cogroo = factory.createPipe();
		gc = new GrammarChecker(cogroo);

		Logger globalLogger = Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
		globalLogger.setLevel(Level.OFF);
		Logger cogrooLogger = Logger.getLogger("org.cogroo.interpreters.FlorestaTagInterpreter");
		cogrooLogger.setLevel(Level.OFF);
		Logger.getRootLogger().setLevel(Level.OFF);
	}

	public Document analyze(String text) {
		DocumentImpl doc = new DocumentImpl();
		doc.setText(text);
		cogroo.analyze(doc);
		return doc;
	}

	public CheckDocument grammarCheck(String text) {
		CheckDocument doc = new CheckDocument(text);
		gc.analyze(doc);
		return doc;
	}

}
