Feature: Place the order for the products

@PlaceOrder
Scenario Outline: Search experience for product search in both home and offers page

Given Verify that user is on greenkart website
When User searched with short name <Name> and extract actual name of the product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And Verify user has ability to enter promocode and place the order

Examples:
|	Name	|
|	Tom		|