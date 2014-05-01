package it.unimarconi.pratica2;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import it.unimarconi.pratica1.Pratica1;
import it.unimarconi.utils.Utils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Pratica2StepDefinition {

    Pratica2 p;

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+), min = (\\d+), max = (\\d+)$")
    public void a_seed_and_b_(int a, int seed, int b, int min, int max) {
        p = new Pratica2(a, seed, b, min, max);
    }

    @Then("^there should be a sequence of elements between (\\d+) and (\\d+)")
    public void calculate_sequences(double min, double max) {
        List<Double> l = p.generaIntervallo();
        for (Double d : l)
            assertTrue(d >= min && d <= max);
    }

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+) and avg = (\\d+)$")
    public void a_seed_b_(int a, int seed, int b, int avg) {
        p = new Pratica2(a, seed, b, avg);
    }

    @Then("^there should be an exponential sequence of average (\\d+)$")
    public void there_should_be_an_exponential_sequence_of_average(double avg) {
        List<Double> l = p.generaEsponenziale();
        double media = Utils.calcolaMedia(l);
        assertEquals((int)avg, (int)media);
    }

}