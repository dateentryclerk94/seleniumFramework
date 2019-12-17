Feature: user registeration
I want to check if user can register in our e-commerce website

Scenario Outline: user registeration
Given the user in the home page
When I click on the register link 
And I entered "<firstName>" , "<lastName>" , "<email>" , "<password>"
Then the registeration page displayed successfully

Examples:
|firstName  |lastName   |email                  |password       |
|one        |jksdh      |k1sd1008017@gmail.com    |167577617     |
|sdhi       |gauy       |fdt19nr01@gmail.com      |876218211     |