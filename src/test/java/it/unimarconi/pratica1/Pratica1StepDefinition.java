package it.unimarconi.pratica1;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Pratica1StepDefinition {

    private Pratica1 p;

    @Given("^a = (\\d+), seed = (\\d+) and b = (\\d+)$")
    public void a_seed_and_b_(int a, int seed, int b) {
        p = new Pratica1(a, seed, b);
    }

    @Then("^there is (\\d+) match either with Corollario A1 or Corollario A2$")
    public void calculate_sequences(int matches) {
        int count = p.generaInsiemeInteri();
        assertTrue(count == matches);
    }

}