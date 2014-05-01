Feature: Costruire in C++ o Java un generatore congruente moltiplicativo di interi Xn
         che consenta di verificare quali e quanti insiemi differenti di interi é possibile
         generare, e per quali valori del seed.

  Scenario Outline: Generare sequenze di numeri interi pseudo-casuali
    Given a = <a>, seed = <seed> and b = <b>
    Then  there are <sequences> different sequeces

  Examples:
    | a | seed | b | sequences |
    | 5 |    1 | 5 |        16 |
    | 5 |    1 | 6 |        32 |
    | 5 |    1 | 3 |         4 |
    | 5 |    1 | 9 |       256 |