package it.unimarconi.due;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

import static org.junit.Assert.assertTrue;

public class ProdottoStepDefinition {

    Prodotto prodotto;

    @Given("^(\\d+) and (\\d+)$")
    public void and(int a, int b) {
        prodotto = new Prodotto(a, b);
    }

    @Then("^the product is (\\d+)$")
    public void the_product_is(double total) {
        assertTrue(total == prodotto.prodotto());
    }

}