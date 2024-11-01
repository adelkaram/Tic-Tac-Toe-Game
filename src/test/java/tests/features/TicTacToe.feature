Feature: Tic Tac Toe Game

  Scenario: Player X wins the game
    Given the Tic Tac Toe game is open
    When player X selects cell 0
    Then cell 0 should display "X"
    When player O attempts to select cell 0
    Then cell 0 should still display "X" and should not be overridden

