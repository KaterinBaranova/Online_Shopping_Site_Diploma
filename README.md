-----------------------------------------------------------------------------------------------------------------------------------------------------
<img width="595" alt="Screenshot 2022-02-10 at 18 43 35" src="https://user-images.githubusercontent.com/89603016/153443120-79276ef8-385e-4dcc-a316-763dcbf777e8.png">

-------------------------------------------------------------------------------------------------------------------------------------

# Online_Shopping_Site Diploma #
http://prestashop.qatestlab.com.ua/en/ is an end-end e-commerce website.

## Overview: ##

> Is an end-end e-commerce website. It covers the complete online shopping workflow. So there is lot of back and forth between server and client, lots of validations built into it to give you a complete experience to practice the scenarios you might find in real time projects.

## Clone the repository into your projects directory: ##

https://github.com/KaterinBaranova/Online_Shopping_Site.git

## Installation: ##

* IDE: IntelliJ
* Programming Language:  JAVA
* Project Type:  Maven

## Frameworks: ##
* Selenium
* TestNG
* lombok
* Test listener

## Design Patterns used:
* POM (Page Object Module)

## Reporting:
* Allure reporting

## Global Usage:
* GitHub
* CircleCI

## Project structure:

### pages
* BasePage
* CartHoverPage
* CheckOutPage
* ItemPage
* SignInPage
* WishlistPage

### tests
* BaseTest
* CartHoverTest
* CheckOutTest
* ItemTest
* SignInTest
* WishlistTest

### Checklist:

#### Sign In:
* Verify that user can login with valid credentials.
* Verify that user is not able to login with Empty Login and valid Password.
* Verify that user is not able to login with valid Login and empty Password.
* Verify that user is not able to login with invalid credentials.
* Verify that user is able to logout.

#### WishList:
* Verify that user is able to create a wishlist.
* Verify that user is able to update the wishlist.

#### Cart Hover:
* Verify that cart hover display the correct quantity of items in cart.
* Verify that user is able to remove items in cart in the cart hover.
* Verify that user is able to proceed to checkout prom cart Hover

#### Item:
* Verify that user is able to add item to cart.
* Verify that user is able to add several items to cart.
* Verify that user is able to select item color

#### Checkout:
* Verify that user is able to buy items from cart.
* Verify that user is able to change quantity of items in cart.
* Verify that user is able to remove items from cart

# Our Team:
*  QA Student: Katsiaryna Shauliuk
*  Mentor: Oleg Voropaev