package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.example.jdbcdemo.domain.Archive;
import com.example.jdbcdemo.domain.Resource;

public class ResourceManagerTest {
	ResourceManager resourceManager = new ResourceManager();
	ArchiveManager archiveManager = new ArchiveManager();
	
	private final static String NAME_1 = "Księgi ziemskie";
	private final static String AUTHOR_1 = "Przasnysiensia";
	private final static int ISBN_1 = 43;
	private final static int DATE_1 = 1585;
	private final static int TEAMNUMBER_1 = 189;
	
	private final static String NAME_2 = "Akta malborskie";
	private final static String AUTHOR_2 = "Kanclerz Namiestnik";
	private final static int ISBN_2 = 67;
	private final static int DATE_2 = 1832;
	
	private final static String NAME_3 = "Odczyty staromodne";
	private final static String AUTHOR_3 = "Kowalska";
	private final static int ISBN_3 = 89;
	private final static int DATE_3 = 1788;
	
	private final static String NAMEARCHIVE_1 = "Centrum";
	private final static int TEAMNUMBERARCHIVE_1 = 189;
	private final static String PHONEARCHIVE_1 = "(52) 339-54-01";
	
	private final static String NAMEARCHIVE_2 = "Oddział";
	private final static int TEAMNUMBERARCHIVE_2 = 178;
	private final static String PHONEARCHIVE_2 = "(78) 888-99-45";
	private final static int TEAMNUMBERARCHIVE_3 = 100;
	
	@Before
	public void init(){
		Resource resource1 = new Resource(NAME_1, AUTHOR_1, ISBN_1, DATE_1);
		Resource resource2 = new Resource(NAME_2, AUTHOR_2, ISBN_2, DATE_2);
		Archive archive1 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_1, PHONEARCHIVE_1);
		Archive archive2 = new Archive(NAMEARCHIVE_2, TEAMNUMBERARCHIVE_2, PHONEARCHIVE_2);
		resourceManager.clearResources();
		assertEquals(1, resourceManager.addResource(resource1));
		assertEquals(1, resourceManager.addResource(resource2));
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
	}
	
	@Test
	public void checkConnection(){
		assertNotNull(resourceManager.getConnection());
	}

	@Test
	public void checkAdding() {
		Set<Resource> resources = resourceManager.getAllResources();
		for (Resource s : resources) {
			if (s.getIsbn() == ISBN_1) {
				assertEquals(NAME_1, s.getName());
				assertEquals(AUTHOR_1, s.getAuthor());
				assertEquals(ISBN_1, s.getIsbn());
				assertEquals(DATE_1, s.getDate());
			} else if (s.getIsbn() == ISBN_2) {
				assertEquals(NAME_2, s.getName());
				assertEquals(AUTHOR_2, s.getAuthor());
				assertEquals(ISBN_2, s.getIsbn());
				assertEquals(DATE_2, s.getDate());
			}
		}
	}
	
	@Test
	public void checkAddingResourceToArchive(){
		Resource resource3 = new Resource(NAME_3, AUTHOR_3, ISBN_3, DATE_3);
		Archive archive3 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_3, PHONEARCHIVE_1);
		assertEquals(0, resourceManager.countRows(archive3));
		assertEquals(1, resourceManager.addResourceToArchive(resource3, archive3));
		assertEquals(1, resourceManager.countRows(archive3));
		Set<Resource> resources2 = resourceManager.getAllResources();
		for (Resource s : resources2) {
			if (s.getIsbn() == ISBN_3) {
				assertEquals(NAME_3, s.getName());
				assertEquals(AUTHOR_3, s.getAuthor());
				assertEquals(ISBN_3, s.getIsbn());
				assertEquals(DATE_3, s.getDate());
				assertEquals(TEAMNUMBERARCHIVE_3, s.getTeamNumber());
			}
		}
	}
	
	@Test
	public void checkDeletingResourceFromArchive(){
		Resource resource3 = new Resource(NAME_3, AUTHOR_3, ISBN_3, DATE_3);
		Archive archive3 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_3, PHONEARCHIVE_1);
		assertEquals(0, resourceManager.countRows(archive3));
		assertEquals(1, resourceManager.addResourceToArchive(resource3, archive3));
		assertEquals(1, resourceManager.countRows(archive3));
		assertEquals(1, resourceManager.deleteResourceFromArchive(resource3, archive3));
		assertEquals(0, resourceManager.countRows(archive3));
		Set<Resource> resources2 = resourceManager.getAllResources();
		for (Resource s : resources2) {
			if (s.getIsbn() == ISBN_3) {
				assertEquals(NAME_3, s.getName());
				assertEquals(AUTHOR_3, s.getAuthor());
				assertEquals(ISBN_3, s.getIsbn());
				assertEquals(DATE_3, s.getDate());
				assertEquals(0, s.getTeamNumber());
			}
		}
		
	}
	
	@Test
	public void checkSelectingResourceFromArchive(){
		Resource resource2 = new Resource(NAME_2, AUTHOR_2, ISBN_2, DATE_2);
		Resource resource3 = new Resource(NAME_3, AUTHOR_3, ISBN_3, DATE_3);
		Archive archive3 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_3, PHONEARCHIVE_1);
		resourceManager.clearResources();
		assertEquals(0, resourceManager.countRows(archive3));
		assertEquals(1, resourceManager.addResourceToArchive(resource3, archive3));
		assertEquals(1, resourceManager.addResourceToArchive(resource2, archive3));
		assertEquals(2, resourceManager.countRows(archive3));
		assertEquals(2, resourceManager.selectResourceFromArchive(archive3));
		
	}
	
	@Test
	public void checkSelectingResourceFromArchiveAfter(){
		Resource resource2 = new Resource(NAME_2, AUTHOR_2, ISBN_2, DATE_2);
		Resource resource3 = new Resource(NAME_3, AUTHOR_3, ISBN_3, DATE_3);
		Archive archive3 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_3, PHONEARCHIVE_1);
		resourceManager.clearResources();
		assertEquals(0, resourceManager.countRows(archive3));
		assertEquals(1, resourceManager.addResourceToArchive(resource3, archive3));
		assertEquals(1, resourceManager.addResourceToArchive(resource2, archive3));
		assertEquals(2, resourceManager.countRows(archive3));
		assertEquals(2, resourceManager.selectResourceFromArchiveAfter(archive3, 1787));
		
	}
}
