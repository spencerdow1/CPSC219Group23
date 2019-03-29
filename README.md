## Authors

CPSC 219 Group 23

## Files
Text Based: AIPlayer.java, ApocalypseTerminal.java, Board.java, Coord.java, CustomGameSet.java, DefaultGameSet.java, GameDynamicsTerminal.java, GameSet.java, HumanPlayer.java, Movement.java, Piece.java, Player.java

GUI Version (All in the GUI package): AIPlayer.java, ApocalypseClick.java, Board.java, Coord.java, CustomGameSet.java, DefaultGameSet.java, GameDynamics.java, GameSet.java, GUIBOARD.java, HumanPlayer.java, MainMenu, Movement.java, Piece.java, Player.java, black_knight.png, black_pawn.png, white_knight.png, white_pawn.java

### Prerequisites
Java
JavaFX

Files included in this pakage

### Get Started
To run this project you can create a new java project in eclipse, copy the flies into the src folder. Simply run the ApocalypseTerminal Class to start the text game or the Mainmenu class in the GUI package to run the GUI version.

## Instructions on How To Play

### Overview

Apocalypse is a variation of the game chess played on a 5x5 board.  Each Player has two knights and two pawns. The pieces can be moved and captured identical to chess. The game can either be played against an AI or against another individual.

### Movement
Moves are done simultaneously. This means in each turn, the players chooses their move without knowledge of the other, then moves are executed on the board at the same time. If two pawns or two knights are moved to the same position on the board,they are both removed from the board. If a knight from one player and a pawn from another are moved to the same spot then the pawn is captured by the knight.If a pawn reaches the opponents side of the board, then the pawn is upgraded to a knight.

### To Win
To win the game a player must either: Capture all of the players pawns or the opponent is unable to make a move.

## Reference
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


