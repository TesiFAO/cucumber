package it.unimarconi.pratica2;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import it.unimarconi.pratica1.Pratica1;
import it.unimarconi.utils.Utils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Pratica2StepDefinition {

    Pratica2 p2;

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+), min = (\\d+), max = (\\d+)$")
    public void a_seed_and_b_(int a, int seed, int b, int min, int max) {
        p2 = new Pratica2(a, seed, b, min, max);
    }

    @Then("^there should be a sequence of elements between (\\d+) and (\\d+)")
    public void calculate_sequences(double min, double max) {
        List<Double> l = p2.generaIntervallo();
        for (Double d : l)
            assertTrue(d >= min && d <= max);
    }

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+) and avg = (\\d+)$")
    public void a_seed_b_(int a, int seed, int b, int avg) {
        p2 = new Pratica2(a, seed, b, avg);
    }

    @Then("^there should be an exponential sequence$")
    public void there_should_be_an_exponential_sequence_of_average() {
        List<Double> l = p2.generaEsponenziale();
    }

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+), p = (.+) and avg = (\\d+)$")
    public void type_a_seed_b_and_avg_(int a, int seed, int b, double p, int avg) {
        p2 = new Pratica2(a, seed, b, avg, p);
    }

    @Then("^there should be an hyperexponential sequence of p = (.+)$")
    public void there_should_be_an_hyperexponential_sequence_of_average(double p) {
        List<Double> l = p2.generaIperesponenziale();
    }

}