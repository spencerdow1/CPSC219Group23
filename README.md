## Authors

CPSC 219 Group 23

## Files
Coord.java, Knight.java, Main.java, Pawn.java, Piece.java, PieceType.java, Player.java, PlayerTeam.java, Space.java , Board.Java

Coord.java creates coordaninates used throught the program to refrence specific spaces

Piece.Java creates pieces with types(Pawn and Knight) and teams (Black and White)

Piece.Type creates types of pieces.

Pawn.Java sets allowable movements for pieces of type pawn.

Knight.Java sets allowable moves for knights.

Player.java creates new players with names and teams.

PlayerTeam.Java creates teams black and white.

Space.Java creates spaces that will populate the board with a piece. 

Board.Java initializes the starting game board, takes user input runs movement and validates moves for the game as well as checks for a condition to stop the game.

Main.java initializes with user input the players and runs the game

Controllor.java

MainControllor.java

GameBoard.Java

MainMenu.FXML

sample.FXML

### Prerequisites
Jdk.9.0.4

Files included in this pakage

### Get Started
To run this project,you must first download jdk.9.0.4 and set a path to this in your eclipse, then you can create a new java project in eclipse, copy the sample flie into the src folder. Simply run the GameBoard Class to start the game.

## Instructions on How To Play

###Overview

Apocalypse is a variation of the game chess played on a 5x5 board.  Each Player has two knights and two pawns. The pieces can be moved and captured identical to chess. The game can either be played against an AI or against another invididual.

###Movement
Moves are done simultaneously. This means in each turn, the players choses their move without knowledge of the other, then moves are executed on the board at the same time. If two pawns or two knights are moved to the same position on the board,they are both removed from the board. If a knight from one player and a pawn from another are moved to the same spot then the pawn is captured by the knight.If a pawn reaches the opponents side of the board, then the pawn is upgraded to a knight.

####To Win
To win the game a player must either: capturing all of the players pawns or the opponent is unable to make a move.

## Refrences
Resources used for CPSC 219 Project group 23
These are all the websites I used while making the project
Used for information about java and the game and different approaches to tackle the project.


https://dzone.com/articles/using-java-enums

https://www.tutorialspoint.com/java/java_abstraction.htm

https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array

https://beginnersbook.com/2013/05/static-vs-non-static-methods/

https://codereview.stackexchange.com/questions/71790/design-a-chess-game-using-object-oriented-principles

https://stackoverflow.com/questions/218384/what-is-a-nullpointerexception-and-how-do-i-fix-it

https://codereview.stackexchange.com/questions/82312/simple-chess-game-part-2-the-pieces

https://codereview.stackexchange.com/questions/194736/chess-application-in-java

https://en.wikipedia.org/wiki/Apocalypse_(chess_variant)

http://apocalypsechess.online/

https://www.chessvariants.com/rules/apocalypse

https://www.makeareadme.com/

https://courses.cs.washington.edu/courses/cse326/02wi/homework/hw5/good-readmes.html

https://stackoverflow.com/questions/43647368/how-can-i-get-make-my-program-wait-until-javafx-window-has-been-closed-before-co

https://stackoverflow.com/questions/21083945/how-to-avoid-not-on-fx-application-thread-currentthread-javafx-application-th

https://docs.oracle.com/javafx/scenebuilder/1/overview/jsbpub-overview.htm

https://docs.oracle.com/javase/8/javafx/api/overview-summary.html

https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/choice-box.htm#BCEDJAEH

https://stackoverflow.com/questions/22145327/nullpointerexception-javafx-label-settext

https://stackoverflow.com/questions/22848829/how-do-i-add-an-image-inside-a-rectangle-or-a-circle-in-javafx


