package com.pruebas.ft.story;

import static com.pruebas.util.Constants.SERVER_PORT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pruebas.Application;
import com.pruebas.ft.base.page.Page;
import com.pruebas.ft.driver.Driver.DriverType;
import com.pruebas.ft.step.CalculadoraStep;

/**
 * 
 * @author juan.castano
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest(SERVER_PORT)
public class RunnerStory extends AbstractStory {

	private Page pages;
	
	/**
	 * 
	 * @throws IOException
	 */
	public RunnerStory() throws IOException {
    	super(DriverType.CHROME);    	
    }

	private Page getPages() {
		if(pages==null) {
			pages = new Page(driverProvider);
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
