package easy;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * Given two strings of letters, determine whether the second can be made from
 * the first by removing one letter. The remaining letters must stay in the
 * same order.
 */
class Challenge366 {

    boolean funnel(String container, String search) {
        for (int i = 0; i < container.length(); i++) {
            if ((container.substring(0, i) + container.substring(i + 1)).equals(search)) {
                return true;
            }
        }
        return false;
    }

}
