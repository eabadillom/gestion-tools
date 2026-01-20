package com.ferbo.gestion.tools;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JndiManager {

	private static Logger log = LogManager.getLogger(JndiManager.class);
	
	public static final String DEFAULT_DATA_SOURCE = "jdbc/iresa";

	public String getJndiName(String name) {
		InitialContext initContext = null;
		String jndiName = null;

		try {
			initContext = new InitialContext();
			jndiName = (String) initContext.lookup(name);
		} catch (NamingException ex) {
			log.error(ex);
		} catch (Exception ex) {
			log.error(ex);
		}

		return jndiName;
	}

	public static String getJndiParameter(String name) {

		Context initContext = null;
		String parameter = null;
		try {
			initContext = new InitialContext();
			parameter = (String) initContext.lookup(name);

		} catch (NamingException ex) {
			try {
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				parameter = (String) envContext.lookup(name);
			} catch (NamingException inEx) {
				log.error("Problema para obtener el valor JNDI: " + name, inEx);
			}
		}

		return parameter;
	}
}
