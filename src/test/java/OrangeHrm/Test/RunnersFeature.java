package OrangeHrm.Test;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"OrangeHrm.Definitions"}, tags = "@Regresion")

public class RunnersFeature {

}
