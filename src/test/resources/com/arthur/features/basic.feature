Feature: Open a web page

  Scenario: Go to amazon add batteries to shopping cart and then remove them
    Given I open the browser
    And navigate to "http://amazon.com"
    When I search for "Batteries"
    And add the first result to the cart
    Then I can go to the shopping cart find the Batteries
    And remove the Batteries