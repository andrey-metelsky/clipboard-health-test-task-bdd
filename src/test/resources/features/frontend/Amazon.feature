@RunThisFeature
Feature: Amazon

  Background:
    Given I am on the "Amazon Home" page

  @TEST_JIRA_ID @RunThisTest
  Scenario: Check item description text
    When I open navigation menu
    And I select "TV, Appliances, Electronics" row in the menu
    And I select "Televisions" row in the menu
    And I select "Samsung" filter in the "Brands" section
    And I sort products by Price: High to Low
    And I select search result item at position 2
    And I navigate to the new browser tab
    
    Then I should see " About this item " text on the page
    And I print item details text to the console

