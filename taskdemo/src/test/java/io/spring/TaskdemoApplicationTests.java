package io.spring;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

public class TaskdemoApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	final String TEST_DATE_DOTS = ".......";
	final String CREATE_TASK_MESSAGE = "Creating: TaskExecution{executionId=";
	final String UPDATE_TASK_MESSAGE = "Updating: TaskExecution with executionId=";
	final String EXIT_CODE_MESSAGE = "with the following {exitCode=0";

	@Test
	public void contextLoads() {
		SpringApplication.run(TaskdemoApplication.class);

		String output = this.outputCapture.toString();
		assertTrue("Test results do not show create task message: " + output,
				output.contains(CREATE_TASK_MESSAGE));
		assertTrue("Test results do not show success message: " + output,
				output.contains(UPDATE_TASK_MESSAGE));
		assertTrue("Test results have incorrect exit code: " + output,
				output.contains(EXIT_CODE_MESSAGE));
	}

}
