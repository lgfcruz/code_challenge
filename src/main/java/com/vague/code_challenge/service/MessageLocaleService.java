package com.vague.code_challenge.service;

public interface MessageLocaleService {
	
	public String getMessage(String id);
    public String getMessage(String id, String args);
    public String getMessage(String id, String[] args);
    
}
