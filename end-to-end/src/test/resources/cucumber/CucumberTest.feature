Feature: Two launchers

  Background:
    Given Properties:
      | first.db.driverClassName=org.h2.Driver  |
      | first.db.url=jdbc:h2:mem:firstdb        |
      | second.db.driverClassName=org.h2.Driver |
      | second.db.url=jdbc:h2:mem:seconddb      |

  Scenario: Run first app
    Given  firstDb table Person is empty
    When Application firstApp runs
    Then firstDb table Person will have records:
      | name  | age | country |
      | Petya | 12  | Ukraine |
      | Eric  | 10  | USA     |

  Scenario: Run first app with exception
    Given  firstDb table Person is empty
    When Application firstApp runs with params: '-fail', it fails with exception: App failed

  Scenario: Run second app
    Given  secondDb table Country is empty
    When Application secondApp runs
    Then secondDb table Country will have records:
      | name    | capital | region |
      | Ukraine | Kyiv    | Europe |
      | Germany | Berlin  | Europe |
      | Japan   | Tokio   | Asia   |

  Scenario: Two apps run in one test
    Given  firstDb table Person is empty
    Given  secondDb table Country is empty
    When Application firstApp runs
    And Application secondApp runs
    Then firstDb table Person will have records:
      | name  | age | country |
      | Petya | 12  | Ukraine |
      | Eric  | 10  | USA     |
    Then secondDb table Country will have records:
      | name    | capital | region |
      | Ukraine | Kyiv    | Europe |
      | Germany | Berlin  | Europe |
      | Japan   | Tokio   | Asia   |