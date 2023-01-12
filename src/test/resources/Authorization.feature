Feature: Авторизация на сайте

  Background:
    Given authorization page opened


  @hooks
  @close
  Scenario Outline:
    When enter '<username>'
    And enter also '<password>'
    And click on the login button
    And greeting field should be correct
    Then page contains a blog with posts

    Examples:
      | username       | password   |
      | GB202301271f49 | b71e07f1ca |


  @hooks
    @close
  Scenario Outline:
    When enter '<username>'
    And enter also '<password>'
    And click on the login button
    And greeting field should be missing
    Then page contains error code "401"

    Examples:
      | username              | password   |
      |                       |            |
      | GB                    | b71e07f1ca |
      | GBdsййй21212121212212 | b71e07f1ca |

