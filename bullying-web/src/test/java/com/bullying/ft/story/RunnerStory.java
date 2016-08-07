package com.bullying.ft.story;

import static com.bullying.util.Constants.SERVER_PORT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bullying.Application;
import com.bullying.ft.base.page.Pages;
import com.bullying.ft.driver.Driver.DriverType;
import com.bullying.ft.step.CalculadoraStep;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest(SERVER_PORT)
public class RunnerStory extends AbstractStory {

	private Pages pages;
	
	public RunnerStory() throws IOException {
    	super(DriverType.CHROME);    	
    }

	private Pages getPages() {
		if(pages==null) {
			pages = new Pages(driverProvider);
		}
		return pages;
	}
	
	@Override
	protected List<Object> getSteps() {
		List<Object> steps =  new ArrayList<Object>();
		steps.add(new CalculadoraStep(this.getPages()));
		return steps;
	}
}
