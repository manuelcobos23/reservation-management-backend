Feature: Example Prices Api
  Scenario Outline: Get applicable price for product/date
  	Given I perform basic authorization
    When I request to get applicable price for concrete <brandId> and <productId> in a specific <date>
  	Then I get the applicable <price>
    Examples:
      | brandId | productId | date 								| price |
      | 1 			| 35455 		| 2020-06-14T10:00 		|35.50	|
      | 1 			| 35455 		| 2020-06-14T16:00 		|25.45	|
	    | 1 			| 35455 		| 2020-06-14T21:00 		|35.50	|
      | 1 			| 35455 		| 2020-06-15T10:00 		|30.50	|
      | 1 			| 35455 		| 2020-06-16T21:00		|38.95	|