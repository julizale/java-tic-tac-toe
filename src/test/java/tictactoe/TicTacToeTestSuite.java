package tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TicTacToeTestSuite {


    @Nested
    @DisplayName("Tests for Wins in Rows")
    class TestsForRows {

        @Test
        void testOWinsRow1() {
            //Given
            Sign[][] testBoard = {
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.NOUGHT},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testOWinsRow2() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.NOUGHT},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testOWinsRow3() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.NOUGHT},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testXWinsRow1() {
            //Given
            Sign[][] testBoard = {
                    {Sign.CROSS, Sign.CROSS, Sign.CROSS},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testXWinsRow2() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.CROSS, Sign.CROSS, Sign.CROSS},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testXWinsRow3() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.CROSS, Sign.CROSS, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

    }

    @Nested
    @DisplayName("Tests for Wins in columns")
    class TestsForColumns {

        @Test
        void testOWinsColumn1() {
            //Given
            Sign[][] testBoard = {
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testOWinsColumn2() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testOWinsColumn3() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testXWinsColumn1() {
            //Given
            Sign[][] testBoard = {
                    {Sign.CROSS, Sign.BLANK, Sign.BLANK},
                    {Sign.CROSS, Sign.BLANK, Sign.BLANK},
                    {Sign.CROSS, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testXWinsColumn2() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.BLANK, Sign.CROSS, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testXWinsColumn3() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

    }

    @Nested
    @DisplayName("Tests for Wins in diagonals")
    class TestsForDiagonals {

        @Test
        void testOWinsDiagonal1() {
            //Given
            Sign[][] testBoard = {
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testOWinsDiagonal3() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT},
                    {Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testXWinsDiagonal1() {
            //Given
            Sign[][] testBoard = {
                    {Sign.CROSS, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testXWinsDiagonal3() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS},
                    {Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.CROSS, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

    }

    @Nested
    @DisplayName("Tests for Draw")
    class TestsForDraw {

        @Test
        void testDraw1() {
            //Given
            Sign[][] testBoard = {
                    {Sign.NOUGHT, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.CROSS, Sign.NOUGHT},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.BLANK);
            assertTrue(game.checkIfBoardIsFull());
        }

        @Test
        void testDraw2() {
            //Given
            Sign[][] testBoard = {
                    {Sign.CROSS, Sign.NOUGHT, Sign.CROSS},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS},
                    {Sign.CROSS, Sign.CROSS, Sign.NOUGHT},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.BLANK);
            assertTrue(game.checkIfBoardIsFull());
        }

        @Test
        void testDraw3() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.NOUGHT, Sign.CROSS},
                    {Sign.NOUGHT, Sign.BLANK, Sign.CROSS},
                    {Sign.CROSS, Sign.BLANK, Sign.NOUGHT},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.BLANK);
            assertFalse(game.checkIfBoardIsFull());
        }
    }

    @Nested
    @DisplayName("Tests for throwing exception")
    class TestsForThrows {

        @Test
        void testPutXonOThrowsException() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertThrows(Exception.class, () -> game.putSignOnTheBoard(Sign.CROSS, 2, 2));
        }

        @Test
        void testPutOonXThrowsException() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertThrows(Exception.class, () -> game.putSignOnTheBoard(Sign.NOUGHT, 3, 3));
        }

        @Test
        void testPutXonXThrowsException() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertThrows(Exception.class, () -> game.putSignOnTheBoard(Sign.CROSS, 2, 1));
        }

        @Test
        void testPutOonOThrowsException() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard);

            //Then
            assertThrows(Exception.class, () -> game.putSignOnTheBoard(Sign.NOUGHT, 3, 1));
        }
    }

    @Nested
    @DisplayName("Tests on bigger board")
    class TestsOnBiggerBoard {

        @Test
        void testWinRowBoard7NumberToWin4() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.NOUGHT, Sign.NOUGHT, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard, 4);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testWinColumnBoard7NumberToWin4() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard, 4);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testWinDiagonalBoard7NumberToWin5() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard, 5);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testWinLowerDiagonalLeftToRightBoard7NumberToWin5() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard, 5);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testWinLowerDiagonalRightToLeftBoard7NumberToWin5() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard, 5);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testWinDiagonalBoard7NumberToWin6() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.BLANK},
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard, 6);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testDrawBoard7NumberToWin5() {
            //Given
            Sign[][] testBoard = {
                    {Sign.NOUGHT, Sign.CROSS, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.NOUGHT},
                    {Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.NOUGHT},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.CROSS},
                    {Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT},
            };

            //When
            Game game = new Game(testBoard, 5);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.BLANK);
            assertTrue(game.checkIfBoardIsFull());
        }

        @Test
        void testPutXonOThrowsExceptionOnBoard7() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.BLANK},
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS},
            };

            //When
            Game game = new Game(testBoard,6);

            //Then
            assertThrows(Exception.class, () -> game.putSignOnTheBoard(Sign.CROSS, 6, 7));
        }
    }

    @Nested
    @DisplayName("Tests for random move")
    class TestsForMakeRandomMove {

        @Test
        void testMakeRandomMoveWhenManyBlanks() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.BLANK},
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS},
            };
            Game game = new Game(testBoard,6);

            //When
            game.makeRandomMove(Sign.CROSS);

            //Then
            assertEquals(31, game.getNumberOfSignsOnTheBoard(Sign.BLANK));
            assertEquals(9, game.getNumberOfSignsOnTheBoard(Sign.CROSS));
        }

        @Test
        void testMakeRandomMoveWhenOnlyOneBlank() {
            //Given
            Sign[][] testBoard = {
                    {Sign.NOUGHT, Sign.CROSS, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT},
                    {Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.NOUGHT},
                    {Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.CROSS, Sign.NOUGHT},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.CROSS},
                    {Sign.NOUGHT, Sign.BLANK, Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS},
                    {Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT, Sign.CROSS, Sign.CROSS, Sign.NOUGHT, Sign.NOUGHT},
            };
            Game game = new Game(testBoard,6);

            //When
            game.makeRandomMove(Sign.NOUGHT);

            //Then
            assertEquals(0, game.getNumberOfSignsOnTheBoard(Sign.BLANK));
            assertEquals(23, game.getNumberOfSignsOnTheBoard(Sign.NOUGHT));
            assertTrue(game.checkIfBoardIsFull());
        }

        @Test
        void testMakeRandomMoveWhenEmptyBoard() {
            //Given
            Game game = new Game(10, 5);

            //When
            game.makeRandomMove(Sign.NOUGHT);

            //Then
            assertEquals(99, game.getNumberOfSignsOnTheBoard(Sign.BLANK));
            assertEquals(1, game.getNumberOfSignsOnTheBoard(Sign.NOUGHT));
        }
    }

    @Nested
    @DisplayName("Tests for wins corners")
    class TestsForWinsInCorners {

        @Test
        void testWinUpperLeftCorner() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard, 4);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testWinUpperRightCorner() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.NOUGHT},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard, 4);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.NOUGHT);
        }

        @Test
        void testWinLowerLeftCorner() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard, 4);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }

        @Test
        void testWinLowerRightCorner() {
            //Given
            Sign[][] testBoard = {
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK},
                    {Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.BLANK, Sign.CROSS, Sign.BLANK, Sign.BLANK, Sign.BLANK},
            };

            //When
            Game game = new Game(testBoard, 4);

            //Then
            assertEquals(game.checkIfWeHaveAWinner(), Sign.CROSS);
        }
    }

}
