# Low Level Design

## Case Studies
* Tic-Tac-Toe
* Parking Lot
* Book-My-Show
* Splitwise

## Case Study : Tic-Tac-Toe


### Overview
**Design a system to play a classic 2-player Tic-Tac-Toe game on a 3x3 grid. The game should support a turn-based interaction between two players, validate moves, declare a winner or a draw, and optionally allow resetting or replaying.**

### Requirements

#### Functional Requirements
* Two players take turns.
* Players choose a symbol (X or O).
* Players can make a move in an empty cell.
* System validates if a move is valid (not out of bounds or already filled).
* After every move, system checks:
* Has any player won?
* Is it a draw?
* Once the game ends, no more moves are allowed.
* Option to replay the entire game (optional).

#### Non-Functional Requirements
* Code should be modular and extensible (like adding an NxN grid or a bot).
* Should be testable and maintainable.
* CLI-based (for simplicity), but easily extendable to GUI/Web.

#### Optional Enhancements (future-ready mindset)
* Play against a computer (Bot logic).
* Leaderboard tracking.
* Replay past games.

### Class Diagram
![Class Diagram](./Tic-Tac-Toe/class_diagram.drawio.svg)


## Case Study : Parking Lot
coming soon...

