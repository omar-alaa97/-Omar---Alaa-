Feature: Test the register functionality

#  @Negative
#  Scenario:Verify required fields by submitting empty form
#
#    Given User open the website and open the register form
#    When User click submit without filling any fields
#    Then a validation message appears for all required fields

    @Positive
    Scenario:Verify filling the form and submitting data

      Given User open the website and open the register form
      When User submit all required fields
        |Omar | Alaa | omar.alaa@yahoo.com | omar.alaa12|22|5|1997|Male|
      Then user should move to next step of register


      @Positive
      Scenario:Verify email confirmation appear only after valid format is entered

        Given User open the website and open the register form
        When User fill email field with proper format
        | omar.alaa@gmail.com|
        Then Email confirmation field appears

