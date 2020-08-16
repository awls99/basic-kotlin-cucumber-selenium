# What's this?
Very barebones Kotlin + Cucumber + Selenium starter kit.

It has a minimalist setup of getting these to work together and implements a very simple scenario with a basic Page Object Model implementation to make it work.

# What's where?

src/test/kotlin/com/arthur/features/basicSteps is the glue that implements the Gherkin Steps in Kotlin.
src/test/kotlin/com/arthur/features/pages has the POM classes.
src/test/kotlin/com/arthur/RunTests needed for running with JUnit.
src/test/resources/com/arthur/features/basic.feature basic feature
src/test/resources/chromedriver OSX chromedriver
src/test/resources/geckodriver OSX geckodriver (Firefox)

# What does it test?
Nothing fancy, opens the browser, goes to Amazon.com, searches for batteries, adds the first one on the list to the shopping cart, then goes to the shopping cart and removes it.

# How to run this?
Just run the gradle task `test`.

## Browsers
By default this will just open Chrome, but if you pass the `-Ddriver=Firefox` as an argument to the task it will use Firefox instead.

The selection is not done in any fancy way, just an `if driver==Firefox` kind of check, doing more than this was kind of beyond the point of this little repo.

## Other OS'es
This was made to be run on OSX, that's why it has the OSX drivers in the resources, to run in another OS there are two simple ways:
edit `build.gradle` on lines 38 and 39 there are the paths to the drivers OR just overwrite the properties via command line with `-Dwebdriver.chrome.driver=src/path/to/driver`.
 

