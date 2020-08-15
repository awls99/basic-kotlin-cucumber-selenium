package com.arthur.pages
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class Base(private val driver: RemoteWebDriver) {
    val waiter = WebDriverWait(driver, 5)

    open fun validationElement(): WebElement? {
        return driver.findElementById("twotabsearchtextbox")
    }

    fun pageIsOpen(): Boolean {
        waiter.until{ validationElement()!=null && validationElement()!!.isDisplayed  }
        return true
    }

    fun search(query:String): Results {
        validationElement()?.sendKeys(query)
        validationElement()?.sendKeys(Keys.ENTER)
        return Results(driver)
    }

    fun openCart(): Cart {
        val cartButton = driver.findElementById("nav-cart-count")
        waiter.until{ ExpectedConditions.elementToBeClickable(cartButton)  }
        cartButton.click()
        return Cart(driver)
    }
}