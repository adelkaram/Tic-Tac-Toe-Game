Feature: Tic Tac Toe Game

  Scenario: Player cannot override a cell that is already occupied
    Given the Tic Tac Toe game is open
    When player X selects cell 0
    Then cell 0 should display "X"
    When player O attempts to select cell 0
    Then cell 0 should still display "X" and should not be overridden

  Scenario: Player can go back to a previous move
    Given the Tic Tac Toe game is open
    When player X selects cell 1
    And player O selects cell 2
    And player X selects cell 3
    Then cell 3 should display "X"
    When the player goes back to move 1
    Then cell 2 should be empty