Feature: Test the contact form alert

  Scenario: Alert appears when no name is entered
    Given I am on the page "https://www.thetestroom.com/webapp/contact.html"
    And I click on the "Send" button
    Then an alert window appears

