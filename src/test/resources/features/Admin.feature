#Proyecto de pruebas Cargo QA Lead
#01/06/2023
#Yeymi Triana 
@Regresion
Feature: Admin

  @HU005
  Scenario Outline: Add a new user 
    Given the user open brower
    And the user fill out user <user> password <password>
    And the user select option admin and new user
    When the user fill out <employee> rol <rol> status <status> user <userName> password <pass> confirm <confirmPass>
    Then the user validate save information contact details
    And the user close brower

    Examples:
      | user  | password | employee | rol | status  | userName | pass     | confirmPass |
      | Admin | admin123 | Li       | ESS | Enabled | YeyTest1 | Prueba01 | Prueba01    |
