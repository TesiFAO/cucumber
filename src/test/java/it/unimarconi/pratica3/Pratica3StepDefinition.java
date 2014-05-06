package it.unimarconi.pratica3;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import it.unimarconi.pratica2.Pratica2;
import it.unimarconi.utils.Utils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Pratica3StepDefinition {

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

    @Then("^there should be an exponential sequence of average (\\d+)$")
    public void there_should_be_an_exponential_sequence_of_average(double avg) {
        List<Double> l = p2.generaEsponenziale();
        double media = Utils.calcolaMedia(l);
        assertEquals((int)avg, (int)media);
    }

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+), p = (.+) and avg = (\\d+)$")
    public void type_a_seed_b_and_avg_(int a, int seed, int b, double p, int avg) {
        p2 = new Pratica2(a, seed, b, avg, p);
    }

    @Then("^there should be an hyperexponential sequence of average (\\d+) and p = (.+)$")
    public void there_should_be_an_hyperexponential_sequence_of_average(double avg, double p) {
        List<Double> l = p2.generaIperesponenziale();
        double media = Utils.calcolaMedia(l);
        double varianza = Utils.calcolaVarianza(l, 20);
        System.out.println("iperesponenziale " + media);
        System.out.println("NOSTRA: " + varianza);
        double k = (1.0 / (2.0 * p * (1.0 - p))) - 1.0;
        System.out.println("K: " + k);
        double expVariance = 400 * k;
        System.out.println("EXP: " + expVariance);
        System.out.println();
        assertEquals((int)avg, (int)media);
    }

}