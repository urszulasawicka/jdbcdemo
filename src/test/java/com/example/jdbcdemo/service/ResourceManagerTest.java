package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Archive;
import com.example.jdbcdemo.domain.Resource;

public class ResourceManagerTest {
	ResourceManager resourceManager = new ResourceManager();
	ArchiveManager archiveManager = new ArchiveManager();
	
	private final static String NAME_1 = "Księgi ziemskie";
	private final static String AUTHOR_1 = "Przasnysiensia";
	private final static int DATE_1 = 1585;
	private final static int TEAMNUMBER_1 = 189;
	
	private final static String NAME_2 = "Akta malborskie";
	private final static String AUTHOR_2 = "Kanclerz Namiestnik";
	private final static int DATE_2 = 1832;
	
	private final static String NAME_3 = "Odczyty staromodne";
	private final static String AUTHOR_3 = "Kowalska";
	private final static int DATE_3 = 1788;
	
	private final static String NAMEARCHIVE_1 = "Centrum";
	private final static int TEAMNUMBERARCHIVE_1 = 189;
	private final static String PHONEARCHIVE_1 = "(52) 339-54-01";
	
	private final static String NAMEARCHIVE_2 = "Oddział";
	private final static int TEAMNUMBERARCHIVE_2 = 178;
	private final static String PHONEARCHIVE_2 = "(78) 888-99-45";
	private final static int TEAMNUMBERARCHIVE_3 = 100;
	
	@Test
	public void checkConnection(){
		assertNotNull(resourceManager.getConnection());
	}

	/*@Test
	public void checkAdding(){
		Resource resource1 = new Resource(NAME_1, AUTHOR_1, DATE_1);
		Resource resource2 = new Resource(NAME_2, AUTHOR_2, DATE_2);
		resourceManager.clearResources();
		assertEquals(1, resourceManager.addResource(resource1));
		assertEquals(1, resourceManager.addResource(resource2));
		
		List<Resource> resources = resourceManager.getAllResources();
		Resource resourceRetrieved1 = resources.get(0);
		
		assertEquals(NAME_1, resourceRetrieved1.getName());
		assertEquals(AUTHOR_1, resourceRetrieved1.getAuthor());
		assertEquals(DATE_1, resourceRetrieved1.getDate());
		
		Resource resourceRetrieved2 = resources.get(1);
		
		assertEquals(NAME_2, resourceRetrieved2.getName());
		assertEquals(AUTHOR_2, resourceRetrieved2.getAuthor());
		assertEquals(DATE_2, resourceRetrieved2.getDate());
	}
	
	@Test
	public void checkAddingResourceToArchive(){
		Resource resource1 = new Resource(NAME_1, AUTHOR_1, DATE_1);
		Resource resource2 = new Resource(NAME_2, AUTHOR_2, DATE_2);
		Resource resource3 = new Resource(NAME_3, AUTHOR_3, DATE_3);
		Archive archive1 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_1, PHONEARCHIVE_1);
		Archive archive2 = new Archive(NAMEARCHIVE_2, TEAMNUMBERARCHIVE_2, PHONEARCHIVE_2);
		Archive archive3 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_3, PHONEARCHIVE_1);
		resourceManager.clearResources();
		assertEquals(1, resourceManager.addResource(resource1));
		assertEquals(1, resourceManager.addResource(resource2));
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		assertEquals(2, resourceManager.countRows());
		assertEquals(1, resourceManager.addResourceToArchive(resource3, archive3));
		assertEquals(3, resourceManager.countRows());
		List<Resource> resources2 = resourceManager.getAllResources();
		Resource resourceRetrieved1 = resources2.get(2);
		System.out.println(resourceRetrieved1);
		assertEquals(NAME_3, resourceRetrieved1.getName());
		assertEquals(AUTHOR_3, resourceRetrieved1.getAuthor());
		assertEquals(DATE_3, resourceRetrieved1.getDate());
		assertEquals(100, resourceRetrieved1.getTeamNumber());
		
	}
	
	@Test
	public void checkDeletingResourceFromArchive(){
		Resource resource1 = new Resource(NAME_1, AUTHOR_1, DATE_1);
		Resource resource2 = new Resource(NAME_2, AUTHOR_2, DATE_2);
		Resource resource3 = new Resource(NAME_3, AUTHOR_3, DATE_3);
		Archive archive1 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_1, PHONEARCHIVE_1);
		Archive archive2 = new Archive(NAMEARCHIVE_2, TEAMNUMBERARCHIVE_2, PHONEARCHIVE_2);
		Archive archive3 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_3, PHONEARCHIVE_1);
		resourceManager.clearResources();
		assertEquals(1, resourceManager.addResource(resource1));
		assertEquals(1, resourceManager.addResource(resource2));
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		assertEquals(2, resourceManager.countRows());
		assertEquals(1, resourceManager.addResourceToArchive(resource3, archive3));
		assertEquals(3, resourceManager.countRows());
		assertEquals(1, resourceManager.deleteResourceFromArchive(resource3, archive3));
		List<Resource> resources2 = resourceManager.getAllResources();
		Resource resourceRetrieved1 = resources2.get(2);
		System.out.println(resourceRetrieved1);
		assertEquals(NAME_3, resourceRetrieved1.getName());
		assertEquals(AUTHOR_3, resourceRetrieved1.getAuthor());
		assertEquals(DATE_3, resourceRetrieved1.getDate());
		assertEquals(0, resourceRetrieved1.getTeamNumber());
		
	}
	
	@Test
	public void checkSelectingResourceFromArchive(){
		Resource resource1 = new Resource(NAME_1, AUTHOR_1, DATE_1);
		Resource resource2 = new Resource(NAME_2, AUTHOR_2, DATE_2);
		Resource resource3 = new Resource(NAME_3, AUTHOR_3, DATE_3);
		Archive archive1 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_1, PHONEARCHIVE_1);
		Archive archive2 = new Archive(NAMEARCHIVE_2, TEAMNUMBERARCHIVE_2, PHONEARCHIVE_2);
		Archive archive3 = new Archive(NAMEARCHIVE_1, TEAMNUMBERARCHIVE_3, PHONEARCHIVE_1);
		resourceManager.clearResources();
		assertEquals(1, resourceManager.addResource(resource1));
		assertEquals(1, resourceManager.addResource(resource2));
		assertEquals(1, archiveManager.addArchive(archive1));
		assertEquals(1, archiveManager.addArchive(archive2));
		assertEquals(2, resourceManager.countRows());
		assertEquals(1, resourceManager.addResourceToArchive(resource3, archive3));
		assertEquals(1, resourceManager.addResourceToArchive(resource2, archive3));
		assertEquals(3, resourceManager.countRows());
		assertEquals(2, resourceManager.selectResourceFromArchive(archive3));
		
	}*/
}
