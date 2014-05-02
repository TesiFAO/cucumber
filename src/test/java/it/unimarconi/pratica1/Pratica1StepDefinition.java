package it.unimarconi.pratica1;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

import static org.junit.Assert.assertTrue;

public class Pratica1StepDefinition {

    Pratica1 p;

    @Given("^a = (\\d+), seed = (\\d+) and b = (\\d+)$")
    public void a_seed_and_b_(int a, int seed, int b) {
        p = new Pratica1(a, seed, b);
    }

    @Then("^there are (\\d+) different sequeces$")
    public void calculate_sequences(int sequences) {
        assertTrue(sequences == p.generaInsiemeInteri().size());
    }

}