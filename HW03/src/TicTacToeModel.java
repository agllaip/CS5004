package src;

public interface TicTacToeModel {

    /**
     * Places an X or O in the specified cell. Whether it places an X or an O depends on which players turn it is.
     * @param row the row of the cell.
     * @param column the column of the cell.
     * @throws IllegalArgumentException if the cell is invalid.
     * @throws IllegalStateException if the game is over or if there is already a mark in the cell.
     */
    // Unchecked Exceptions (Java doesn't mandate you put these in the method signature):
    //      IllegalArgumentException - If the position given to it is invalid.
    //      IllegalStateException - If the player attempts to play at an occupied position or
    //      play after the game is over, doing either of these will put the game in an invalid state.
    void move(int row, int column) throws IllegalArgumentException, IllegalStateException;

    /**
     * Returns the player whose turn is next.
     * @return the next player.
     * @throws IllegalStateException if the game is over.
     */
    // Returns player enum type value: X or Y.
    // IllegalStateException - If the player attempts to play once the game is over.
    Player nextPlayer() throws IllegalStateException;

    /**
     * Determines if the game is over.
     * @return whether the game is over.
     */
    // True = Yes
    // False = No
    boolean isGameOver();

    /**
     * Returns the winner of the game, or {@code null} if the game is a tie.
     * @return the winner of the game or {@code null}.
     * @throws IllegalStateException if the game is not over.
     */
    // Returns player enum type value: X or Y.
    // Exception - when the game ends in a draw.
    // IllegalStateException - If the player attempts to ask who the winner is in the middle of the game.
    Player getWinner() throws IllegalStateException;

    /**
     * Returns a 2D array representing the state of the grid. The first index is column and the second is the row.
     * The resulting array is newly allocated and unconnected to the model; thus mutating it will have no effect
     * on the model or subsequent calls to {@code getBoard}.
     * @return a copy of the board.
     */
    // Return the board as a 2D array of Player objects.
    // Empty cells = null
    // This can also be represented as: getCell(int row, int column) throws IllegalArgumentException;
    Player [][] getBoard();
}