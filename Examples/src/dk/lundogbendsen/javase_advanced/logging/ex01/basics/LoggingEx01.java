package dk.lundogbendsen.javase_advanced.logging.ex01.basics;

/*
 * Viser et simpelt eksempel med logging:
 * - bruger anonym logger
 * - alle log-beskeder bliver på info-niveau
 * - bruger standard-konfiguration (...\j2re1.4.2\lib\logging.properties):
 * - ConsoleHandler (skriver log-beskeder til konsollen)
 * - SimpleFormatter (formaterer output som simpel tekst)
 * - Level.INFO (nivau info og mere kritiske log-beskeder medtages)
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingEx01 {

	private static Logger logger = Logger.getAnonymousLogger();

	public static void main(final String[] args) throws Exception {

		initLoggingSystem();

		logger.info("Entering main-method");

		logger.info("About to print the result of 2 + 2");
		System.out.println(2 + 2);
		logger.info("Finished printing the result of 2 + 2");

		logger.info("About to sleep 2 seconds");
		Thread.sleep(2000);
		logger.info("Woke up");

		logger.info("Exiting main-method");
	}

	private static void initLoggingSystem() throws Exception {
		String fileName = "logging.properties";
		File loggingSystemConfigFile = new File(fileName);
		InputStream is = new FileInputStream(loggingSystemConfigFile);
		LogManager.getLogManager().readConfiguration(is);
	}
}