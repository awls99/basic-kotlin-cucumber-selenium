package com.arthur.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver

class Added(private val driver: RemoteWebDriver):Base(driver) {
    override fun validationElement(): WebElement?{
        return driver.findElementsByTagName("h1").find { element -> element.text.contains("Added to Cart") }
    }

}
