package it.unimarconi.pratica3;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import it.unimarconi.Pratica3.Pratica3;
import it.unimarconi.pratica2.Pratica2;
import it.unimarconi.utils.Utils;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Pratica3StepDefinition {

    Pratica3 p3;

    DecimalFormat df = new DecimalFormat("#0.0000");

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+)$")
    public void given_rn(int a, int seed, int b) {
        p3 = new Pratica3(a, seed, b);
    }

    @Then("^there should be a sequence of elements (\\d+)$")
    public void there_should_be_a_sequence_of_elements(int arg1) {
        p3.printRn();
    }

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+), min = (\\d+), max = (\\d+), classi = (\\d+)$")
    public void a_seed_and_b_(int a, int seed, int b, int min, int max, int classi) {
        p3 = new Pratica3(a, seed, b, min, max);
    }

    @Then("^there should be a sequence of elements between (\\d+) and (\\d+) with (\\d+) classi")
    public void calculate_sequences(double min, double max, int numeroClassi) {
        p3.printRange();
    }

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+) and avg = (\\d+)$")
    public void a_seed_b_(int a, int seed, int b, int avg) {
        p3 = new Pratica3(a, seed, b, avg);
    }

    @Then("^there should be an exponential sequence of average (\\d+)$")
    public void there_should_be_an_exponential_sequence_of_average(double avg) {
        p3.printExp();
    }

    @Given("^a = (\\d+), seedA = (\\d+), seedB = (\\d+), b = (\\d+), p = (.+) and avg = (\\d+)$")
    public void a_seedA_seedB_b_p_and_avg_(int a, int seedA, int seedB, int b, double p, int avg) {
        p3 = new Pratica3(a, seedA, seedB, b, avg, p);
    }

    @Then("^there should be an hyperexponential sequence of average (\\d+) and p = (.+)$")
    public void there_should_be_an_hyperexponential_sequence_of_average(double avg, double p) {
        p3.printHyperExp();
    }

}