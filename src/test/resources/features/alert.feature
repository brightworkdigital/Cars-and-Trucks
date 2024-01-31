Feature: Test the contact form alert

  Scenario: Alert appears when no name is entered
    Given I am on the page "https://www.thetestroom.com/webapp/contact.html"
    When I click on the "Send" button
    Then an alert window appears

  Scenario: No name entered, clear alert
    Given I am on the page "https://www.thetestroom.com/webapp/contact.html"
    When I click on the "Send" button
    And I dismiss the alert
    Then I am on the "Contact" page

