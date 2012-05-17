package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Archive;

public class ArchiveManagerTest {
	ArchiveManager archiveManager = new ArchiveManager();
	
	private final static String NAME_1 = "Centrum";
	private final static int TEAMNUMBER_1 = 189;
	private final static String PHONE_1 = "(52) 339-54-01";
	
	private final static String NAME_2 = "Oddział";
	private final static int TEAMNUMBER_2 = 178;
	private final static String PHONE_2 = "(78) 888-99-45";
	
	private final static String NAME_3 = "Filia";
	private final static int TEAMNUMBER_3 = 159;
	private final static String PHONE_3 = "(78) 123-45-12";
	
	@Test
	public void checkConnection(){
		assertNotNull(archiveManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		Archive archive1 = new Archive(NAME_1, TEAMNUMBER_1, PHONE_1);
		Archive archive2 = new Archive(NAME_2, TEAMNUMBER_2, PHONE_2);
		archiveManager.clearArchives();
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		
		List<Archive> archives = archiveManager.getAllArchives();
		Archive archiveRetrieved1 = archives.get(0);
		Archive archiveRetrieved2 = archives.get(1);
		
		assertEquals(NAME_1, archiveRetrieved1.getName());
		assertEquals(TEAMNUMBER_1, archiveRetrieved1.getTeamNumber());
		assertEquals(PHONE_1, archiveRetrieved1.getPhone());
		
		assertEquals(NAME_2, archiveRetrieved2.getName());
		assertEquals(TEAMNUMBER_2, archiveRetrieved2.getTeamNumber());
		assertEquals(PHONE_2, archiveRetrieved2.getPhone());
	}
	
	@Test
	public void checkReading(){
		Archive archive1 = new Archive(NAME_1, TEAMNUMBER_1, PHONE_1);
		Archive archive2 = new Archive(NAME_2, TEAMNUMBER_2, PHONE_2);
		archiveManager.clearArchives();
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		
		List<Archive> archives = archiveManager.getAllArchives();
		assertEquals(2, archives.size());
		
		Archive archiveRetrieved1 = archives.get(0);
		Archive archiveRetrieved2 = archives.get(1);
		
		assertEquals(NAME_1, archiveRetrieved1.getName());
		assertEquals(TEAMNUMBER_1, archiveRetrieved1.getTeamNumber());
		assertEquals(PHONE_1, archiveRetrieved1.getPhone());
		
		assertEquals(NAME_2, archiveRetrieved2.getName());
		assertEquals(TEAMNUMBER_2, archiveRetrieved2.getTeamNumber());
		assertEquals(PHONE_2, archiveRetrieved2.getPhone());
	}

	@Test
	public void checkUpdating(){
		Archive archive1 = new Archive(NAME_1, TEAMNUMBER_1, PHONE_1);
		Archive archive2 = new Archive(NAME_2, TEAMNUMBER_2, PHONE_2);
		archiveManager.clearArchives();
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		
		Archive archive3 = new Archive(NAME_3, TEAMNUMBER_2, PHONE_3);
		assertEquals(1, archiveManager.updateArchive(archive3));
		List<Archive> archives = archiveManager.getAllArchives();
		
		Archive archiveRetrieved = archives.get(1);
		
		assertEquals(NAME_3, archiveRetrieved.getName());
		assertEquals(TEAMNUMBER_2, archiveRetrieved.getTeamNumber());
		assertEquals(PHONE_3, archiveRetrieved.getPhone());
	}

	@Test
	public void checkDeleting(){
		Archive archive1 = new Archive(NAME_1, TEAMNUMBER_1, PHONE_1);
		Archive archive2 = new Archive(NAME_2, TEAMNUMBER_2, PHONE_2);
		archiveManager.clearArchives();
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		
		assertEquals(1, archiveManager.deleteArchive(archive1));
		
		List<Archive> archives = archiveManager.getAllArchives();
		
		assertEquals(1, archives.size());
	}
	
	@Test
	public void checkSearching(){
		Archive archive1 = new Archive(NAME_1, TEAMNUMBER_1, PHONE_1);
		Archive archive2 = new Archive(NAME_2, TEAMNUMBER_2, PHONE_2);
		archiveManager.clearArchives();
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		
		assertEquals(1, archiveManager.searchArchive(archive1));
		
		List<Archive> archives = archiveManager.getAllArchives();
		
		Archive archiveRetrieved = archives.get(0);
		
		assertEquals(NAME_1, archiveRetrieved.getName());
		assertEquals(TEAMNUMBER_1, archiveRetrieved.getTeamNumber());
		assertEquals(PHONE_1, archiveRetrieved.getPhone());
	}

}
