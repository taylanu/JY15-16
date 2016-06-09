package Game.Working;

/**
 * Created by taylanu on 6/7/2016.
 */
public class generator {
    /**
     * Clear the matrix.
     */
    private void clear(final byte[][] array) {
        for (byte y = 0; y < 9; y++) {
            for (byte x = 0; x < 9; x++) {
                array[x][y] = 0;
            }
        }
    }


}
