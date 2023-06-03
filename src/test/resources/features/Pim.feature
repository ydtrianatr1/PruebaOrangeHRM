#Proyecto de pruebas Cargo QA Lead
#01/06/2023
#Yeymi Triana
@Regresion
Feature: Pim

  @HU002
  Scenario Outline: Add employee
    Given the user open brower
    And the user fill out user <user> password <password>
    When the user select add employee and fill out first name <firstName> last name <lastName>
    Then the user validate new employee <firstName> <lastName>
    And the user close brower

    Examples:
      | user  | password | firstName | lastName |
      | Admin | admin123 | Emilio    | Triana   |
