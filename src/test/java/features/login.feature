Feature: Test the login functionality

  @Positive
  Scenario:Verify signing in with valid email & password

    Given User open the website on login page
    When User enter valid credentials email & password
    | tstman_gwizzxe_atomashn@tfbnw.net | omar.alaa12 |
    Then The user should be logged in

  @Negative
 Scenario Outline:Verify signing in with empty or wrong email
    Given User open the website on login page
    When User click login button with empty or  wrong "<email or Phone number>" & correct "<password>"
    Then A validation message should appear for email field
    Examples:
      |  email or Phone number  |     password     |
      |   900800700333          |     omar.alaa12  |
      | tst_atom@yahoo.com      |     omar.alaa12  |
      |                         |     omar.alaa12  |


  @Negative
 Scenario Outline:Verify signing in with valid email & empty or wrong password
    Given User open the website on login page
    When User enter valid "<email>" & invalid  or empty "<password>"
    Then A password error message should appear
    Examples:
      |               email               |   password  |
      | tstman_gwizzxe_atomashn@tfbnw.net |             |
      |tstman_gwizzxe_atomashn@tfbnw.net  | omar.alaa34 |


