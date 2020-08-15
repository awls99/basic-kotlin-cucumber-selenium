package com.arthur

import org.openqa.selenium.chrome.ChromeDriver

class SeleniumTest {
    val driver = ChromeDriver()

    init {
        driver.get("http://google.com")
    }

}