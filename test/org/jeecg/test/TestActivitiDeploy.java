package org.jeecg.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-mvc-hibernate.xml")
public class TestActivitiDeploy {
	
	@Resource
	private RepositoryService repositoryService;
	@Test
	public void test() throws Exception {
		System.out.println(repositoryService+"_-----------");
	}
}
