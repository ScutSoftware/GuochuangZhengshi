package com.lis.service;

public interface ImportFileToDatabaseService {
	public void importFile(String filePath);
	
	public void run();
	public void scanDirectory() ;
}
