Feature: Costruire in C++ o Java un generatore che produca sequenze <Rn>

  Scenario Outline: Generare una una sequenza uniforme <Rn>
    Given a = <a>, seed = <seed>, b = <b>
    Then there should be a sequence of elements 123

  Examples:
    | a | seed |  b |
    | 5 |    1 | 12 |

  Scenario Outline: Generare una una sequenza uniforme in (30, 50)
    Given a = <a>, seed = <seed>, b = <b>, min = <min>, max = <max>, classi = <classi>
    Then there should be a sequence of elements between <min> and <max> with <classi> classi

  Examples:
    | a | seed |  b | min | max | classi |
    | 5 |    1 | 12 |  30 |  50 |     10 |

  Scenario Outline: Generare una sequenza esponenziale di media 20
    Given a = <a>, seed = <seed>, b = <b> and avg = <avg>
    Then there should be an exponential sequence of average <avg>

  Examples:
    | a | seed |  b | avg |
    | 5 |    1 | 12 |  20 |

  Scenario Outline: Generare una sequenza iperesponenziale di media 20 e parametro p = 0.38
    Given a = <a>, seedA = <seedA>, seedB = <seedB>, b = <b>, p = <p> and avg = <avg>
    Then there should be an hyperexponential sequence of average <avg> and p = <p>

  Examples:
    |  a |  seedA |  seedB |  b | avg |    p |
    | 61 |      1 |     15 | 12 |  20 | 0.38 |