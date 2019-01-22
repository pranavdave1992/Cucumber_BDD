Feature: Free CRM deals creation

Scenario: Create deals on Free CRM

Given User is already on login page
When title of log in page is Free CRM
Then User enters username and password
| username | password |
| Pranav1992 | Ecd#0000 |

Then Click on Login BTN
Then User is on home page
Then User moves to new deal page
Then User enters deal details
| title | amount | probability | commission |
| test deal 1 | 1000 | 10 | 50 |
| test deal 2 | 2000 | 5 | 20 |
| test deal 3 | 3000 | 20 | 30 |
| test deal 4 | 4000 | 25 | 50 |

Then Close the browser