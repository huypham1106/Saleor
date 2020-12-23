Feature: Login feature

  Scenario Outline: Test login with valid account
    Given User click login button
    When User enters <username> and <password>
    And Click on login button
    Then User login successfull with user profile

    Examples:
		    | username | password |
		    | ABC				| 123			|
		    | DEF				| 456			| 