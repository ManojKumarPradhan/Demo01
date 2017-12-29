package com.bigob.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyUtil {

	@Autowired
	public Environment envo;
	
	public String getDateFormatByKey(String key) {
		return envo.getProperty(key);
	}
}
