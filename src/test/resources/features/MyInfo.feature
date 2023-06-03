#Proyecto de pruebas Cargo QA Lead
#01/06/2023
#Yeymi Triana
@Regresion
Feature: my informations

  @HU003
  Scenario Outline: update personal details
    Given the user open brower
    And the user fill out user <user> password <password>
    When the user updates my information personal detail middle <middleName> nationality <nationality> marital status <maritalStatus>
    Then the user validate update field <nationality> <maritalStatus>
    And the user close brower

    Examples:
      | user  | password | middleName | nationality | maritalStatus |
      | Admin | admin123 | Julieta    | Colombian   | Other         |

  @HU004
  Scenario Outline: fill out contact details
    Given the user open brower
    And the user fill out user <user> password <password>
    When the user fill out contact details <streetOne> country <country> street <streetTwo>
    Then the user validate save information contact details
    And the user close brower

    Examples:
      | user  | password | streetOne | country     | streetTwo |
      | Admin | admin123 | calle 5   | Afghanistan | Tv 85G    |