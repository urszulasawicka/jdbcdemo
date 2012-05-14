package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Archive;

public class ArchiveManagerTest {
	ArchiveManager archiveManager = new ArchiveManager();
	
	private final static String NAME1 = "Centrum";
	private final static int ID = 1;
	private final static int TEAMNUMBER1 = 189;
	private final static int TEAMNUMBER2 = 178;
	private final static String PHONE1 = "(52) 339-54-01";
	private final static String PHONE2 = "(78) 888-99-45";
	
	@Test
	public void checkConnection(){
		assertNotNull(archiveManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		Archive archive = new Archive(NAME1, TEAMNUMBER1, PHONE1);
		
		archiveManager.clearArchives();
		assertEquals(1, archiveManager.addArchive(archive));
		
		List<Archive> archives = archiveManager.getAllArchives();
		Archive archiveRetrieved = archives.get(0);
		
		assertEquals(NAME1, archiveRetrieved.getName());
		assertEquals(TEAMNUMBER1, archiveRetrieved.getTeamNumber());
		assertEquals(PHONE1, archiveRetrieved.getPhone());
	}
	
	@Test
	public void checkReading(){
		List<Archive> archives = archiveManager.getAllArchives();
		assertEquals(1, archives.size());
		archiveManager.clearArchives();
		Archive archiveRetrieved = archives.get(0);
		
		assertEquals(NAME1, archiveRetrieved.getName());
		assertEquals(TEAMNUMBER1, archiveRetrieved.getTeamNumber());
		assertEquals(PHONE1, archiveRetrieved.getPhone());
	}
	
	@Test
	public void checkUpdating(){
		Archive archive = new Archive(NAME1, TEAMNUMBER1, PHONE1);
		archiveManager.clearArchives();
		
		assertEquals(1, archiveManager.addArchive(archive));
		
		Archive archive1 = new Archive(NAME1, TEAMNUMBER2, PHONE2);
		assertEquals(1, archiveManager.updateArchive(archive1));
		archiveManager.clearArchives();
		List<Archive> archives1 = archiveManager.getAllArchives();
		
		Archive archiveRetrieved1 = archives1.get(0);
		
		assertEquals(NAME1, archiveRetrieved1.getName());
		assertEquals(TEAMNUMBER2, archiveRetrieved1.getTeamNumber());
		assertEquals(PHONE2, archiveRetrieved1.getPhone());
	}
	
	@Test
	public void checkDeleting(){
		Archive archive = new Archive(NAME1, TEAMNUMBER1, PHONE1);
		archiveManager.clearArchives();
		
		assertEquals(1, archiveManager.addArchive(archive));
		
		Archive archive1 = new Archive(NAME1, TEAMNUMBER2, PHONE2);
		
		archiveManager.clearArchives();
		assertEquals(1, archiveManager.deleteArchive(archive1));
		
		List<Archive> archives = archiveManager.getAllArchives();
		
		assertEquals(0, archives.size());
	}

}
