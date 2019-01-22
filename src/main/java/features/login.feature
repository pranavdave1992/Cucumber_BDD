Feature: Free CRM log in Feature

#Scenario: Free CRM login test

#Given User is already on login page
#When title of log in page is Free CRM
#Then User enters username and password
#Then Click on Login BTN
#Then User is on home page
#Then Close the browser

# Without Example Keyword
#Scenario: Create a new contact

#Given User is already logged in
#Then Login with "Pranav1992" and "Ecd#0000"
#When Title of home page is CRMPRO
#Then User Hovers on Contacts and click on New Contact
#Then Enter Contact information
#Then click on Save
#Then Hover on Contacts and select Full Search Form
#Then Contact must be displayed on the table
#Then Close the browser

# With Example Keyword
Scenario Outline: Create a new contact

Given User is already logged in
Then Login with "<username>" and "<password>"
When Title of home page is CRMPRO
Then User Hovers on Contacts and click on New Contact
Then Enter Contact information
Then click on Save
Then Hover on Contacts and select Full Search Form
Then Contact must be displayed on the table
Then Close the browser

Examples:
	| username | password |
	| Pranav1992 | Ecd#0000 |
	| Pranav1991 | Ecd#0000 |