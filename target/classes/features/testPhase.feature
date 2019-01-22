@FunctionalTest
Feature: This is a demo test for different test Phases of the development

@smokeTest
Scenario: Login testing
Given User name and password

@abc
Scenario: Failed Login testing
Given Invalid User name and password

@smokeTest
Scenario: Sign up testing
Given sign up with User details

@smokeTest
Scenario: Forgot password testing
Given forgot password link

@sanity
Scenario: sanity Login testing
Given sanity testing User name and password

@sanity
Scenario: Login failure testing
Given failed User name and password