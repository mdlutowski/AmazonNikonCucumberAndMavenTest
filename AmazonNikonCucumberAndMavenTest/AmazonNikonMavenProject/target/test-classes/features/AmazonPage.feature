Feature: As a user I want to search for chosen product in Amazon Page

Scenario: Check whether Nikon D3X is the second-most expensive Nikon's model
Given I launch browser
When I go to Amazon Page
And I search for product
And I sort results by given filter
And I choose model position from the top
And I check model topic
Then I verify whether topic contains expected model