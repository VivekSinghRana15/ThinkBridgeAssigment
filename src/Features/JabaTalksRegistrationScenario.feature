Feature: This feature is for Automating Assignment Question 2

  @Vivek
  Scenario Outline: Sc - "<Number>" - Registration Scenario
    Given We open the Jaba Talks Website
    And We Validate the Dropdown Options
    And We fill the "<FullName>","<OrganizationName>" and "<EmailId>"
    And Click on Agree to Terms Checkbox
    When We click on GetStarted Button
    Then We should get a message that email has been sent

    Examples:
      | Number | FullName         | OrganizationName | EmailId                       |
      | 001    | Vivek Singh Rana | Vivek            | vivek_singh_rana_15@yahoo.com |
