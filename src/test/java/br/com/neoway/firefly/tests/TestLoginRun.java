package br.com.neoway.firefly.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "br.com.neoway.firefly.step_definitions", plugin = { "pretty",
		"html:target/cucumber" }, monochrome = true, snippets = SnippetType.CAMELCASE)
public class TestLoginRun {
	
}
