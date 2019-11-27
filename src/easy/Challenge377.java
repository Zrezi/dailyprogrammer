package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge Fit1                                                   |
 * +---------------------------------------------------------------------------+
 * You have a 2-dimensional rectangular crate of size X by Y, and a bunch of
 * boxes, each of size x by y. The dimensions are all positive integers.
 * <p>
 * Give X, Y, x, and y, determine how many boxes can fit into a single crate
 * if they have to be placed so that the x-axis of the boxes is aligned with
 * the x-axis of the crate, and the y-axis of the boxes is aligned with the
 * y-axis of the crate. That is, you can't rotate the boxes. The best you can
 * do is to build a rectangle of boxes as large as possible in each dimension.
 * <p>
 * For instance, if the crate is size X = 25 by Y = 18, and the boxes are size
 * x = 6 by y = 5, then the answer is 12. You can fit 4 boxes along the x-axis
 * (because 6 * 4 <= 25), and 3 boxes along the y-axis (because 5 * 3 <= 18),
 * so in total you can fit 4 * 3 = 12 boxes in a rectangle.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge Fit2                                                      |
 * +---------------------------------------------------------------------------+
 * You upgrade your packing robot with the latest in packing technology:
 * turning stuff. You now have the option of rotating all boxes by 90 degrees,
 * so that you can treat a set of 6-by-5 boxes as a set of 5-by-6 boxes. You
 * do not have the option of rotating some of the boxes, but not others.
 * <p>
 * Note that this is not the maximum possible number of boxes you could get if
 * you rotated them independently. For instance, if you're fitting 3-by-2
 * boxes into a 5-by-5 crate, it's possible to fit 4 by varying the
 * orientations, but fit2(5, 5, 3, 2) is 2, not 4. Handling the general case
 * is much more complicated, and beyond the scope of today's challenge.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge Fit3                                                      |
 * +---------------------------------------------------------------------------+
 * You upgrade your warehouse to the third dimension. You're now given six
 * parameters, X, Y, Z, x, y, and z. That is, you're given the X, Y, and Z
 * dimensions of the crate, and the x, y, and z dimensions of the boxes.
 * There are now six different possible orientations of the boxes. Again,
 * boxes cannot be rotated independently: they all have to have the same
 * orientation.
 * <p>
 * +---------------------------------------------------------------------------+
 * | Bonus Challenge Fit3                                                      |
 * +---------------------------------------------------------------------------+
 * You upgrade your warehouse to the Nth dimension. Now you take a list of N
 * crate dimensions, and N box dimensions. Assume that the boxes may be
 * rotated in any of N! orientations so that each axis of the crate aligns
 * with a different axis of the boxes. Again, boxes cannot be rotated
 * independently.
 */
class Challenge377 {

    int fit1(int crateX, int crateY, int boxX, int boxY) {
        return (crateX / boxX) * (crateY / boxY);
    }

    int fit2(int crateX, int crateY, int boxX, int boxY) {
        return Math.max(
                fit1(crateX, crateY, boxX, boxY),
                fit1(crateX, crateY, boxY, boxX)
        );
    }

    int fit3(int crateX, int crateY, int crateZ, int boxX, int boxY, int boxZ) {
        return Stream.of(
                fit3_helper(crateX, crateY, crateZ, boxX, boxY, boxZ),
                fit3_helper(crateX, crateY, crateZ, boxX, boxZ, boxY),
                fit3_helper(crateX, crateY, crateZ, boxY, boxX, boxZ),
                fit3_helper(crateX, crateY, crateZ, boxY, boxZ, boxX),
                fit3_helper(crateX, crateY, crateZ, boxZ, boxX, boxY),
                fit3_helper(crateX, crateY, crateZ, boxZ, boxY, boxX)
        ).max(Integer::compare).get();
    }

    private int fit3_helper(int crateX, int crateY, int crateZ, int boxX, int boxY, int boxZ) {
        return (crateX / boxX) * (crateY / boxY) * (crateZ / boxZ);
    }

    int fitN(int[] crateDimensions, int[] boxDimensions) {
        int maxBoxes = -1;
        List<int[]> permutationList = new ArrayList<>();
        permutate(boxDimensions.length, boxDimensions, permutationList);

        for (int i = 0; i < permutationList.size(); i++) {
            int[] currentBoxDimensions = permutationList.get(i);
            int boxesFit = 1;
            for (int dimension = 0; dimension < currentBoxDimensions.length; dimension++) {
                boxesFit *= (crateDimensions[dimension] / currentBoxDimensions[dimension]);
            }
            maxBoxes = Math.max(maxBoxes, boxesFit);
        }

        return maxBoxes;
    }

    /**
     * Implementing Heap's Algorithm
     */
    private void permutate(int n, int[] array, List<int[]> list) {
        if (n == 1) {
            list.add(Arrays.copyOf(array, array.length));
        } else {
            for (int i = 0; i < n - 1; i++) {
                permutate(n - 1, array, list);
                if (n % 2 == 0) {
                    swap(array, i, n - 1);
                } else {
                    swap(array, 0, n - 1);
                }
            }
            permutate(n - 1, array, list);
        }
    }

    private void swap(int[] input, int first, int second) {
        int temp = input[first];
        input[first] = input[second];
        input[second] = temp;
    }

}
