package com.bigob.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class PropertyUtil {

	@Autowired
	Environment envo;
	
	public String getPropertyFromKey(String key) {
		return envo.getProperty(key);
	}
}
