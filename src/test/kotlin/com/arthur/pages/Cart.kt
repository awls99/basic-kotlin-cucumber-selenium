package com.arthur.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import kotlin.Exception

class Cart(private val driver: RemoteWebDriver):Base(driver) {
    override fun validationElement(): WebElement?{
        return driver.findElementByName("proceedToRetailCheckout")
    }

    fun removeFirstItemFromCart(){
        driver.findElementsByCssSelector("input[value=\"Delete\"]").first().click()
    }

    fun has(item: String): Boolean {
        try{
            driver.findElementByClassName("sc-your-amazon-cart-is-empty").isDisplayed
            return false
        }catch (e: Exception){
        }
        try{
            return driver.findElementByPartialLinkText(item).isDisplayed
            return true
        }catch (e: Exception){
        }
        return false
    }

}
