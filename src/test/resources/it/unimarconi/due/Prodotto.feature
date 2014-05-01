Feature: multiply two numbers

  Scenario Outline: multiply two numbers
    Given <a> and <b>
    Then the product is <c>

  Examples:
    | a | b | c  |
    | 3 | 5 | 15 |
    | 2 | 8 | 16 |
    | 7 | 6 | 42 |