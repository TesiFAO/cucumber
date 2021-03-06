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
    Then there should be an exponential sequence

  Examples:
    | a | seed |  b | avg |
    | 5 |    1 | 12 |  20 |
    | 5 |    1 | 12 |  50 |
    | 5 |    1 | 12 |  75 |

  Scenario Outline: Generare una sequenza iperesponenziale di media 20 e parametro p = 0.38
    Given a = <a>, seed = <seed>, b = <b>, p = <p> and avg = <avg>
    Then there should be an hyperexponential sequence of p = <p>

  Examples:
    | a | seed |  b | avg |    p |
    | 5 |    1 | 12 |  20 | 0.38 |