package com.arthur.features

import com.arthur.pages.*
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.RemoteWebDriver

class basicSteps : En {
    lateinit var page: Base
    lateinit var results: Results
    lateinit var added: Added

    val driver:RemoteWebDriver = if (System.getProperty("driver") == "Firefox") {
        FirefoxDriver()
    } else {
        ChromeDriver()
    }

    init {
        Given("I open the browser") {
            //  semantic step, browser inits with the steps
        }
        When("I search for {string}") { searchTerm: String ->
            results = page.search(searchTerm)
            assert(results.pageIsOpen())
            assert(results.isResultPresent(searchTerm))
        }
        And("navigate to {string}") { url: String ->
            driver.get(url)
            page = Base(driver)
            assert(page.pageIsOpen())
        }
        And("add the first result to the cart") {
            val pdp = results.clickFirstResult()
            assert(pdp.pageIsOpen())
            added = pdp.addItemToCart()
            assert(added.pageIsOpen())
        }
        Then("I can go to the shopping cart find the {word}") { what: String ->
            val cart = added.openCart()
            assert(cart.has(what))
        }
        And("remove the {word}") { what: String ->
            val cart = page.openCart()
            cart.removeFirstItemFromCart()
        }

        After { s: Scenario -> driver.quit() }
    }
}