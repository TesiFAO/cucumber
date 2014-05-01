Feature: sum two numbers

  Scenario Outline: sum two numbers
    Given <a> and <b>
    Then the sum is <c>

  Examples:
    | a | b | c |
    | 3 | 5 | 8 |
    | 2 | 2 | 4 |
    | 1 | 6 | 7 |