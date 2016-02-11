package br.com.neoway.login.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = {"br.com.neoway.login.step_definitions","br.com.neoway.firefly.hooks"}, plugin = { "pretty",
		"html:target/cucumber" }, monochrome = true, snippets = SnippetType.CAMELCASE)
public class LoginRun {
	
}
