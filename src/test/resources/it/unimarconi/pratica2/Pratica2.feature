Feature: Costruire in C++ o Java un generatore che produca sequenze <Rn>

  Scenario Outline: Generare una una sequenza uniforme in (30, 50)
    Given a = <a>, seed = <seed>, b = <b>, min = <min>, max = <max>
    Then there should be a sequence of elements between <min> and <max>

  Examples:
    | a | seed |  b | min | max |
    | 5 |    1 | 12 |  30 |  50 |
    | 5 |    1 | 12 |   0 |   1 |
    | 5 |    1 | 12 |  50 |  70 |

  Scenario Outline: Generare una sequenza esponenziale di media 20
    Given a = <a>, seed = <seed>, b = <b> and avg = <avg>
    Then there should be an exponential sequence of average <avg>

  Examples:
    | a | seed |  b | avg |
    | 5 |    1 | 12 |  20 |
    | 5 |    1 | 12 |  50 |
    | 5 |    1 | 12 |  75 |