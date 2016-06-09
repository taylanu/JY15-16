package Shell_3;

import java.util.Arrays;

public class HorseBarn {
    /**
     * The spaces in the barn. Each array element holds a reference to the horse
     * that is currently occupying the space. A null value indicates an empty space.
     */
    private Horse[] spaces;

    public HorseBarn(Horse[] horses) {
        int n = horses.length;
        spaces = new Horse[n];
        for (int i = 0; i < n; i++)
            spaces[i] = horses[i];
    }

    // Part (a)

    /**
     * Returns the index of the space that contains the horse with the specified name.
     * Precondition: No two horses in the barn have the same name.
     *
     * @param name the name of the horse to find
     * @return the index of the space containing the horse with the specified name;
     * -1 if no horse with the specified name is in the barn.
     */
    public int findHorseSpace(String name) {
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] != null && name.equals(spaces[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    // Part (b)

    /**
     * Consolidates the barn by moving horses so that the horses are in adjacent spaces,
     * starting at index 0, with no empty space between any two horses.
     * Postcondition: The order of the horses is the same as before the consolidation.
     */
    public void consolidate() {
        // int nextAvailiable = 0;
        // Horse temp = null;
        for (int i = 0; i < spaces.length - 1; i++) {
            if (spaces[i] == null) {
                for (int j = i + 1; j < spaces.length; j++)
                    if (spaces[j] != null) {
                        spaces[i] = spaces[j];
                        spaces[j] = null;
                    }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(spaces);
    }
}