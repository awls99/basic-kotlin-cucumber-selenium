package com.arthur.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

class Results(private val driver: RemoteWebDriver):Base(driver) {

    override fun validationElement():WebElement?{
        return driver.findElementsByClassName("a-spacing-top-small").find { element -> element.text.contains("results") }
    }

    fun isResultPresent(result:String): Boolean {
        waiter.until { driver.findElementByPartialLinkText(result).isDisplayed }
        return true
    }

    fun clickFirstResult(): PDP {
        val first = driver.findElementByCssSelector("div.sg-col-inner h2 a.a-link-normal")
        first.click()
        return PDP(driver)
    }

}