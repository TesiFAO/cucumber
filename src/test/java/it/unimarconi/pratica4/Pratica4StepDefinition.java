package it.unimarconi.pratica4;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import it.unimarconi.pratica2.Pratica2;
import it.unimarconi.utils.Utils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Pratica4StepDefinition {

    Pratica4 p4;

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+), d = (\\d+) e (\\d+) prove$")
    public void a_seed_b_d(int a, int seed, int b, int d, int prove) {
        p4 = new Pratica4(a, seed, b, d, prove);
    }

    @Then("^il test risulta accettabile (\\d+) volte su (\\d+)")
    public void test_uniformita(double successi, double prove) {
        boolean[] out = p4.uniformita();
        int count = 0;
        for (int i = 0 ; i < out.length ; i++)
            if (out[i])
                count++;
        assertTrue(count >= successi);
    }

}