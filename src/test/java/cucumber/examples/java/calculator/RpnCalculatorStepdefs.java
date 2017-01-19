package cucumber.examples.java.calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class RpnCalculatorStepdefs {
    private RpnCalculator calc;

    @Given("^a calculator I just turned on$")
    public void a_calculator_I_just_turned_on() {
        calc = new RpnCalculator();
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void adding(int arg1, int arg2) {
        calc.push(arg1);
        calc.push(arg2);
        calc.push("+");
    }

    @When("^(I press (/+))$")
    public void I_press(String what) {
        calc.push(what);
    }

    @When("^(I press (/*))$")
    public void I_press_star(String what) {
        calc.push(what);
    }

    @When("^I enter (\\d+)$")
    public void iEnter(int i) throws Throwable {
        calc.push(i);
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(int expected) {
        assertEquals(expected, calc.value());
    }
}
