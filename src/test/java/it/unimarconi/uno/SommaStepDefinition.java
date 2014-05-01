package it.unimarconi.uno;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

import static org.junit.Assert.assertTrue;

public class SommaStepDefinition {

    Somma somma;

    @Given("^(\\d+) and (\\d+)$")
    public void and(int a, int b) {
        somma = new Somma(a, b);
    }

    @Then("^the sum is (\\d+)$")
    public void the_sum_is(double total) {
        assertTrue(total == somma.somma());
    }

}