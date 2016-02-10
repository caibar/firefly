package br.com.neoway.firefly.support;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	public static final Logger LOG = Logger.getLogger(Log.class.getName());

	public static void info(String message) {
		LOG.info(message);
	}

	public static void error(String message) {
		LOG.severe(message);
	}
	
	public static void error(String message, Throwable thrown) {
		LOG.log(Level.SEVERE, message, thrown);
	}
}
