#Proyecto de pruebas Cargo QA Lead
#01/06/2023
#Yeymi Triana
@Regresion
Feature: Login

  @HU001
  Scenario Outline: login successful
    Given the user open brower
    When the user fill out user <user> password <password>
    Then the user validate page Dashboard
    And the user close brower

    Examples:
      | user  | password |
      | Admin | admin123 |
