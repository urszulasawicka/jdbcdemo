package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Resource;

public class ResourceManagerTest {
	ResourceManager resourceManager = new ResourceManager();
	
	private final static String NAME_1 = "Księgi ziemskie";
	private final static String AUTHOR_1 = "Przasnysiensia";
	private final static int DATE_1 = 1585;
	
	@Test
	public void checkConnection(){
		assertNotNull(resourceManager.getConnection());
	}

	@Test
	public void checkAdding(){
		Resource resource = new Resource(NAME_1, AUTHOR_1, DATE_1);
		resourceManager.clearResources();
		assertEquals(1, resourceManager.addResource(resource));
		
		List<Resource> resources = resourceManager.getAllResources();
		Resource resourceRetrieved = resources.get(0);
		
		assertEquals(NAME_1, resourceRetrieved.getName());
		assertEquals(AUTHOR_1, resourceRetrieved.getAuthor());
		assertEquals(DATE_1, resourceRetrieved.getDate());
	}
}
