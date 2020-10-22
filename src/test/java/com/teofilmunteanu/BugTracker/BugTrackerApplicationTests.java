package com.teofilmunteanu.BugTracker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.security.auth.message.config.AuthConfig;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.teofilmunteanu.BugTracker.domain.Task;
import com.teofilmunteanu.BugTracker.domain.User;
import com.teofilmunteanu.BugTracker.service.TaskService;
import com.teofilmunteanu.BugTracker.service.UserService;

//@RunWith(SpringRunner.class)
@SpringBootTest
class BugTrackerApplicationTests {
	/*@Autowired
	private UserService userService;
	@Autowired
	private TaskService taskService;
	
	@Before
	public void initDB()
	{
		{
			User newUser = new User("testUser@mail.com","testUser","123456");
			userService.createUser(newUser);	
		}
		
		{
			User newUser = new User("testAdmin@mail.com","testAdmin","123456");
			userService.createUser(newUser);	
		}
		
		Task userTask = new Task("03/01/2020", "00:11", "11:00", "U gotta work m8");
		User user = userService.findOne("testUser@mail.com");
		taskService.addTask(userTask, user);
	}
	
	@Test
	public void testUser()
	{
		User user = userService.findOne("testUser@mail.com");
		assertNotNull(user);
		User admin = userService.findOne("testAdmin@mail.com");
		assertEquals(admin.getEmail(),"testAdmin@mail.com");
	}
	
	@Test
	public void testTask()
	{
		User user = userService.findOne("testUser@mail.com");
		List<Task> task = taskService.findUserTask(user);
		assertNotNull(task);
	}
	@Test
	void contextLoads() 
	{
		
	}*/

}
