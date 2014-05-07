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
        List<Double> l = p3.generaRn();
        int numeroClassi = 10;
        System.out.println("RN");
        List<Double> soglie = Utils.generaSoglie(l, numeroClassi);
        List<Integer> classi = Utils.generaClassi(l, numeroClassi);
        List<Double> freqRelative = Utils.calcolaFrequenzeRelative(classi, l.size());
        List<Double> densita = Utils.calcolaDensita(l, freqRelative);
        List<Double> cumulata = Utils.calcolaCumulata(freqRelative, classi);
        String occorrenze = "data: [";
        String f = "FREQ RELATIVE: data: [";
        String d = "DENSITA: data: [";
        String c = "CUMULATA: data: [";
        String cat = "categories: [";
        for (int z = 0 ; z < soglie.size() - 1; z++) {
            cat += "'" + soglie.get(z) + " to " + soglie.get(1 + z) + "'";
            if (z < soglie.size() - 1)
                cat += ", ";
        }
        for (int i = 0 ; i < freqRelative.size() ; i++) {
            f += df.format(freqRelative.get(i));
            d += df.format(densita.get(i));
            c += df.format(cumulata.get(i));
            occorrenze += classi.get(i);
            if (i < freqRelative.size() - 1) {
                f += ", ";
                d += ", ";
                c += ", ";
                occorrenze += ", ";
            }
        }
        f += "]";
        d += "]";
        c += "]";
        cat += "]";
        occorrenze += "]";
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(cat);
        System.out.println(occorrenze);
        System.out.println("RN");
    }

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+), min = (\\d+), max = (\\d+), classi = (\\d+)$")
    public void a_seed_and_b_(int a, int seed, int b, int min, int max, int classi) {
        p3 = new Pratica3(a, seed, b, min, max);
    }

    @Then("^there should be a sequence of elements between (\\d+) and (\\d+) with (\\d+) classi")
    public void calculate_sequences(double min, double max, int numeroClassi) {
        List<Double> l = p3.generaIntervallo();
        List<Double> soglie = Utils.generaSoglie(l, numeroClassi);
        List<Integer> classi = Utils.generaClassi(l, numeroClassi);
        List<Double> freqRelative = Utils.calcolaFrequenzeRelative(classi, l.size());
        List<Double> densita = Utils.calcolaDensita(l, freqRelative);
        List<Double> cumulata = Utils.calcolaCumulata(freqRelative, classi);
        String occorrenze = "data: [";
        String f = "FREQ RELATIVE: data: [";
        String d = "DENSITA: data: [";
        String c = "CUMULATA: data: [";
        String cat = "categories: [";
        for (int z = 0 ; z < soglie.size() - 1; z++) {
            cat += "'" + soglie.get(z).intValue() + " to " + soglie.get(1 + z).intValue() + "'";
            if (z < soglie.size() - 1)
                cat += ", ";
        }
        for (int i = 0 ; i < freqRelative.size() ; i++) {
            f += df.format(freqRelative.get(i));
            d += df.format(densita.get(i));
            c += df.format(cumulata.get(i));
            occorrenze += classi.get(i);
            if (i < freqRelative.size() - 1) {
                f += ", ";
                d += ", ";
                c += ", ";
                occorrenze += ", ";
            }
        }
        f += "]";
        d += "]";
        c += "]";
        cat += "]";
        occorrenze += "]";
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(cat);
        System.out.println(occorrenze);
    }

    @Given("^a = (\\d+), seed = (\\d+), b = (\\d+) and avg = (\\d+)$")
    public void a_seed_b_(int a, int seed, int b, int avg) {
        p3 = new Pratica3(a, seed, b, avg);
    }

    @Then("^there should be an exponential sequence of average (\\d+)$")
    public void there_should_be_an_exponential_sequence_of_average(double avg) {
        List<Double> l = p3.generaEsponenziale();
        int numeroClassi = 10;
        System.out.println("EXPONENTIAL");
        List<Double> soglie = Utils.generaSoglie(l, numeroClassi);
        List<Integer> classi = Utils.generaClassi(l, numeroClassi);
        List<Double> freqRelative = Utils.calcolaFrequenzeRelative(classi, l.size());
        List<Double> densita = Utils.calcolaDensita(l, freqRelative);
        List<Double> cumulata = Utils.calcolaCumulata(freqRelative, classi);
        String occorrenze = "data: [";
        String f = "FREQ RELATIVE: data: [";
        String d = "DENSITA: data: [";
        String c = "CUMULATA: data: [";
        String cat = "categories: [";
        for (int z = 0 ; z < soglie.size() - 1; z++) {
            cat += "'" + soglie.get(z).intValue() + " to " + soglie.get(1 + z).intValue() + "'";
            if (z < soglie.size() - 1)
                cat += ", ";
        }
        for (int i = 0 ; i < freqRelative.size() ; i++) {
            f += df.format(freqRelative.get(i));
            d += df.format(densita.get(i));
            c += df.format(cumulata.get(i));
            occorrenze += classi.get(i);
            if (i < freqRelative.size() - 1) {
                f += ", ";
                d += ", ";
                c += ", ";
                occorrenze += ", ";
            }
        }
        f += "]";
        d += "]";
        c += "]";
        cat += "]";
        occorrenze += "]";
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(cat);
        System.out.println(occorrenze);
    }

    @Given("^a = (\\d+), seedA = (\\d+), seedB = (\\d+), b = (\\d+), p = (.+) and avg = (\\d+)$")
    public void a_seedA_seedB_b_p_and_avg_(int a, int seedA, int seedB, int b, double p, int avg) {
        p3 = new Pratica3(a, seedA, seedB, b, avg, p);
    }

    @Then("^there should be an hyperexponential sequence of average (\\d+) and p = (.+)$")
    public void there_should_be_an_hyperexponential_sequence_of_average(double avg, double p) {
        List<Double> l = p3.generaIperesponenziale();
        int numeroClassi = 10;
        System.out.println("HYPER______EXPONENTIAL");
        List<Double> soglie = Utils.generaSoglie(l, numeroClassi);
        List<Integer> classi = Utils.generaClassi(l, numeroClassi);
        List<Double> freqRelative = Utils.calcolaFrequenzeRelative(classi, l.size());
        List<Double> densita = Utils.calcolaDensita(l, freqRelative);
        List<Double> cumulata = Utils.calcolaCumulata(freqRelative, classi);
        String occorrenze = "data: [";
        String f = "FREQ RELATIVE: data: [";
        String d = "DENSITA: data: [";
        String c = "CUMULATA: data: [";
        String cat = "categories: [";
        for (int z = 0 ; z < soglie.size() - 1; z++) {
            cat += "'" + soglie.get(z).intValue() + " to " + soglie.get(1 + z).intValue() + "'";
            if (z < soglie.size() - 1)
                cat += ", ";
        }
        for (int i = 0 ; i < freqRelative.size() ; i++) {
            f += df.format(freqRelative.get(i));
            d += df.format(densita.get(i));
            c += df.format(cumulata.get(i));
            occorrenze += classi.get(i);
            if (i < freqRelative.size() - 1) {
                f += ", ";
                d += ", ";
                c += ", ";
                occorrenze += ", ";
            }
        }
        f += "]";
        d += "]";
        c += "]";
        cat += "]";
        occorrenze += "]";
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);
        System.out.println(cat);
        System.out.println(occorrenze);
    }

}