Feature:  Add Product to Cart
  @ReservationStep
  Scenario:  Add Product to Cart and Remove
    Given user opens page
    When user types the keyword
    When user clicks on search button
    When user clicks second page
    When user clicks product
    When user saves product info to file
    When user add product to cart
    When user goes to cart page
    When user compares prices
    When user increases the product count
    When user clicks to delete button
    Then user must be seen the cart is empty



