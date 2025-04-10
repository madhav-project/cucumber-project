Feature: Search and place the order for the products
@OffersPage
Scenario Outline: Search experience for product search in both home and offers page

Given Verify that user is on greenkart website
When User searched with short name <Name> and extract actual name of the product
Then User go and search for the <Name> shortname in offers page
And Validate product name in offers page matches with Landing Page

Examples:
| Name |
| Tom  |
| beet |