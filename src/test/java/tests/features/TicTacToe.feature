Feature: Tic Tac Toe Game

  Scenario: Player cannot override a cell that is already occupied
    Given the Tic Tac Toe game is open
    When player X selects cell 0
    Then cell 0 should display "X"
    When player O attempts to select cell 0
    Then cell 0 should still display "X" and should not be overridden

  Scenario Outline: Player can go back to a previous move
    Given the Tic Tac Toe game is open
    When player X selects cell 0
    And player O selects cell 1
    And player X selects cell 2
    And player X selects cell 3
    When the player goes back to move <CellNumber>
    Then Check if board state reverts accurately to the chosen previous move <CellNumber>
    Examples:
    |CellNumber|
    |   1 |