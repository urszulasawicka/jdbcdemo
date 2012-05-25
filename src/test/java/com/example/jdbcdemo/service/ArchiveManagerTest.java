package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
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
	/*
	@Before
	public void init(){
		Archive archive1 = new Archive(NAME_1, TEAMNUMBER_1, PHONE_1);
		Archive archive2 = new Archive(NAME_2, TEAMNUMBER_2, PHONE_2);
		archiveManager.clearArchives();
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		
	}
	
	@Test
	public void checkConnection(){
		assertNotNull(archiveManager.getConnection());
	}
	
	@Test
	public void checkAdding() {
		Set<Archive> archives = archiveManager.getAllArchives();
		for (Archive a : archives) {
			if (a.getTeamNumber() == TEAMNUMBER_1) {
				assertEquals(NAME_1, a.getName());
				assertEquals(TEAMNUMBER_1, a.getTeamNumber());
				assertEquals(PHONE_1, a.getPhone());
			} else if (a.getTeamNumber() == TEAMNUMBER_2) {
				assertEquals(NAME_2, a.getName());
				assertEquals(TEAMNUMBER_2, a.getTeamNumber());
				assertEquals(PHONE_2, a.getPhone());
			}
		}
	}
	
	@Test
	public void checkReading(){
		Set<Archive> archives = archiveManager.getAllArchives();
		assertEquals(2, archives.size());
		for (Archive a : archives) {
			if (a.getTeamNumber() == TEAMNUMBER_1) {
				assertEquals(NAME_1, a.getName());
				assertEquals(TEAMNUMBER_1, a.getTeamNumber());
				assertEquals(PHONE_1, a.getPhone());
			} else if (a.getTeamNumber() == TEAMNUMBER_2) {
				assertEquals(NAME_2, a.getName());
				assertEquals(TEAMNUMBER_2, a.getTeamNumber());
				assertEquals(PHONE_2, a.getPhone());
			}
		}
	}

	@Test
	public void checkUpdating(){
		Archive archive3 = new Archive(NAME_3, TEAMNUMBER_2, PHONE_3);
		assertEquals(1, archiveManager.updateArchive(archive3));
		Set<Archive> archives = archiveManager.getAllArchives();
		for (Archive a : archives) {
			if (a.getTeamNumber() == TEAMNUMBER_2) {
				assertEquals(NAME_3, a.getName());
				assertEquals(TEAMNUMBER_2, a.getTeamNumber());
				assertEquals(PHONE_3, a.getPhone());
			}
		}
	}

	@Test
	public void checkDeleting(){
		Archive archive3 = new Archive(NAME_1, TEAMNUMBER_1, PHONE_1);
		assertEquals(1, archiveManager.deleteArchive(archive3));
		
		Set<Archive> archives = archiveManager.getAllArchives();
		
		assertEquals(1, archives.size());
	}
	
	@Test
	public void checkSearching(){
		Archive archive3 = new Archive(NAME_1, TEAMNUMBER_1, PHONE_1);
		
		assertEquals(1, archiveManager.searchArchive(archive3));
		Set<Archive> archives = archiveManager.getAllArchives();
		for (Archive a : archives) {
			if (a.getTeamNumber() == TEAMNUMBER_1) {
				assertEquals(NAME_1, a.getName());
				assertEquals(TEAMNUMBER_1, a.getTeamNumber());
				assertEquals(PHONE_1, a.getPhone());
			}
		}
	}*/

}
