package com.ferbo.gestion.tools;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBManager {
	
	private static Logger log = LogManager.getLogger(DBManager.class);
	public static final String DEFAULT_DATA_SOURCE = "jdbc/gestion";
	
	public static synchronized Connection getConnection() throws SQLException {
		return getConnection(DEFAULT_DATA_SOURCE);
	}
	
	public static synchronized Connection getConnection(String jndiName) throws SQLException {
		Connection conn = null;
		Context initContext = null;
		Context envContext = null;
		DataSource ds = null;

		try {

			try {
				initContext = new InitialContext();
				ds = (DataSource) initContext.lookup(jndiName);
			} catch (NameNotFoundException inEx) {
				envContext = (Context) initContext.lookup("java:/comp/env");
				ds = (DataSource) envContext.lookup(jndiName);
			} catch (NamingException e) {
				log.error("Problema para obtener la fuente de datos " + jndiName, e);
			}

			if (ds != null) {
				conn = ds.getConnection();
				conn.setAutoCommit(false);
			}
		} catch (NamingException e) {
			log.error(e.getLocalizedMessage(), e);
		}

		return conn;
	}
	
	public static synchronized void close(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException ex) {
			log.error("Problema al cerrar el objeto Connection.", ex);
		} catch (Exception ex) {
			log.error("Problema general al cerrar el objeto Connection.", ex);
		} finally {
			connection = null;
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null)
				conn.rollback();
		} catch (SQLException ex) {
			log.error("Problema al realizar rollback de la conexion.", ex);
		}
	}

}
