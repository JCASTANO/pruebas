package com.bullying.ft.story;

import static com.bullying.util.Constants.CONSTANTS;
import static com.bullying.util.Constants.ERROR_SERVIDOR;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.MarkUnmatchedStepsAsPending;
import org.jbehave.web.selenium.DelegatingWebDriverProvider;
import org.jbehave.web.selenium.PerStoriesWebDriverSteps;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.WebDriverProvider;
import org.jbehave.web.selenium.WebDriverScreenshotOnFailure;
import org.jbehave.web.selenium.WebDriverSteps;
import org.openqa.selenium.WebDriver;

import com.bullying.ft.driver.Driver;
import com.bullying.ft.driver.Driver.DriverType;
import com.google.common.util.concurrent.MoreExecutors;

/**
 * @author juan.castano
*/
public abstract class AbstractStory extends JUnitStories {
	
	private static final Logger LOGGER = LogManager.getLogger(AbstractStory.class);
	private static final String INGLES = "en";
	protected WebDriverProvider driverProvider;
    protected WebDriverSteps lifecycleSteps; 
    protected SeleniumContext context;
    protected Keywords keywords = new LocalizedKeywords(new Locale(INGLES));
    protected Configuration configuration;
    
    /**
     * @return AbstractStory
     * */
    public AbstractStory(DriverType driverType) {
    	this(driverType, PerStoriesWebDriverSteps.class);
    } 
    
    /**
     * @return AbstractStory
     * */
    public AbstractStory(DriverType driverType, Class<? extends WebDriverSteps> stepsClass) {
    	driverProvider = initWebDriverProvider(driverType);
    	try {
			lifecycleSteps = stepsClass.getConstructor(WebDriverProvider.class).newInstance(driverProvider);
		} catch (Exception e) {
			LOGGER.error(ResourceBundle.getBundle(CONSTANTS).getString(ERROR_SERVIDOR), e);
			lifecycleSteps = new PerStoriesWebDriverSteps(driverProvider);
		}
    	context = new SeleniumContext();
    			
        if ( lifecycleSteps instanceof PerStoriesWebDriverSteps ){
            configuredEmbedder().useExecutorService(MoreExecutors.sameThreadExecutor());
        }
    } 
 
    @Override
	public Configuration configuration() {
		if (configuration == null) {
			Class<? extends Embeddable> embeddableClass = this.getClass();
			configuration = new SeleniumConfiguration()
					.useSeleniumContext(context)
					.useWebDriverProvider(driverProvider)
					.useStoryLoader(new LoadFromClasspath(embeddableClass))
					.useKeywords(keywords)
					.useStepCollector(new MarkUnmatchedStepsAsPending(keywords))
					.useStoryParser(new RegexStoryParser(keywords))
					.useStoryReporterBuilder(
							new StoryReporterBuilder()
									.withCodeLocation(
											codeLocationFromClass(embeddableClass))
									.withDefaultFormats()
									.withFormats(CONSOLE, TXT, HTML, XML)
									.withKeywords(keywords));
		} 
		return configuration;
	}
    
    protected WebDriverProvider initWebDriverProvider(final Driver.DriverType type) {
		return new DelegatingWebDriverProvider() {

			public void initialize() {
				Driver drivers = Driver.getInstance();
				WebDriver driver =drivers.getWebDriver(type);
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				delegate.set(driver);
			}
		};
	}
    
    @Override
    public InjectableStepsFactory stepsFactory() {
    	List<Object> baseSteps = new ArrayList<Object>();
    	baseSteps.addAll(getSteps());
    	baseSteps.add(lifecycleSteps);
    	baseSteps.add(new WebDriverScreenshotOnFailure(driverProvider, configuration.storyReporterBuilder()));
	    return new InstanceStepsFactory(configuration, baseSteps);
    }
    
    @Override
    protected List<String> storyPaths() {
    	return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()), "**/*.story", "**/excluded*.story");
    }
	
	protected abstract List<Object> getSteps();
}
