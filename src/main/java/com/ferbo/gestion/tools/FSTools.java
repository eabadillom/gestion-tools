package com.ferbo.gestion.tools;

import java.io.File;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FSTools {
	
	private static Logger log = LogManager.getLogger(FSTools.class);
	
	public String getResourcePath(String resource) {
		
		String resourcePath = null;
		File fileResourcePath = null;
		try {
			fileResourcePath = new File(getClass().getResource(resource).getFile());
			resourcePath = fileResourcePath.getPath();
		} catch (Exception e) {
			log.error("Recurso no encontrado...", e);
		}
		
		return resourcePath;
	}
	
	public InputStream getResourceStream(String resource) {
		InputStream input = null;
		
		try {
			input = getClass().getClassLoader().getResourceAsStream(resource);
		} catch(Exception e) {
			log.error("Recurso no encontrado...", e);
		}
		
		return input;
	}

}
