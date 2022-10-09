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
        void testXWinsDiagonaL3() {
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

}

    /*
    Napisz testy weryfikujące zwycięstwa O w wierszach.
        Napisz testy weryfikujące zwycięstwa O w kolumnach.
        Napisz testy weryfikujące zwycięstwa O po przekątnych planszy.
        Napisz testy weryfikujące zwycięstwa X w wierszach.
        Napisz testy weryfikujące zwycięstwa X w kolumnach.
        Napisz testy weryfikujące zwycięstwa X po przekątnych planszy.
        Napisz testy weryfikujące układy, które prowadzą do remisu.
        Napisz testy weryfikujące, czy w przypadku błędnie wykonanych ruchów zostanie rzucony odpowiedni wyjątek.
        */