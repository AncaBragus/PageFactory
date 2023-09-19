#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
Feature: Login into Keyfood application
	Backgroud:
		Given User is on Login page
		
  @ValidCredentials
  Scenario: Login with valid credentials
    Given User enters corect credentials
    When User should be able to see success message
    
  @ValidCredentials
  Scenario Outline: Login with invalid credentials
    Given User enters incorect credentials
    When User should not be able to see success message
    

   
