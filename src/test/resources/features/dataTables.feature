Feature: Examples of cucumber data table implementations


  Scenario: List of fruits I like
    Then user should see fruits I like
      | kiwi        |
      | banana      |
      | cucumber    |
      | grape       |
      | orange      |
      | mango       |
      | pomegranate |