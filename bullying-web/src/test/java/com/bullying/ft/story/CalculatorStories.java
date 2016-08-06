package com.bullying.ft.story;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.bullying.ft.step.CalculatorSteps;

public class CalculatorStories extends JUnitStories {

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
			.useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE,Format.TXT));
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new CalculatorSteps());
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/test/resources"),"**/calculator.story", "");
	}
}