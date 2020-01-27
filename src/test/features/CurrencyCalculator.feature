Feature: Currency Calculator Add Currency

	@RegressionTest
  	Scenario: I need to check Home screen
		Given I am on Home screen
		When I check Home screen
		Then Home screen has all required assets

	@RegressionTest
	Scenario: I need to add currency AUD
		Given I am on Home screen
		When I click Add button
		And I am on Currency List screen
		And Currency List screen has all required assets
		And I select currency "AUD"
