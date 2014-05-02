Feature: Costruire in C++ o Java un generatore congruente moltiplicativo che generi interi Xn
         in uno degli insiemi di cui al quesito 1teoria. Generare poi da detto insieme una
         sequenza <Xn> e condurre sulla relativa sequenza <Rn> un test di Uniformità e un test Seriale.

  Scenario Outline: Test di Uniformitá
    Given a = <a>, seed = <seed>, b = <b>, d = <d> e <prove> prove
    Then il test risulta accettabile <successi> volte su <prove>

  Examples:
    |  a | seed |  b |   d | prove | successi |
    | 15 |    1 | 19 |  64 |     3 |        2 |
    | 79 |    1 | 19 |  64 |     3 |        2 |
    | 65 |    3 | 19 |  64 |     3 |        2 |
    | 85 |    3 | 19 |  64 |     3 |        2 |