package com.arthur.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

class PDP(private val driver: RemoteWebDriver):Base(driver) {

    override fun validationElement(): WebElement?{
        return driver.findElementById("add-to-cart-button")
    }

    fun addItemToCart(): Added {
        validationElement()?.click()
        return Added(driver)
    }
}
