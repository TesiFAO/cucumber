Feature: Costruire in C++ o Java un generatore congruente moltiplicativo di interi Xn
         che consenta di verificare quali e quanti insiemi differenti di interi é possibile
         generare, e per quali valori del seed.

  Scenario Outline: Generare sequenze di numeri interi pseudo-casuali
    Given a = <a>, seed = <seed> and b = <b>
    Then  there is 1 match either with Corollario A1 or Corollario A2

  Examples:
    |  a | seed | b |
    |  5 |    1 | 9 |
    | 13 |    3 | 9 |
    | 21 |    5 | 9 |
    | 29 |    7 | 9 |
    | 37 |  253 | 9 |