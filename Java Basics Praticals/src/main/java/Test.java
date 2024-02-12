public class Test {
    public static int findFirstOnePosition(int[] stream) {
        int low = 0;
        int high = 1;

        // Keep doubling the high index until a '1' is found
        while (stream[high] == 0) {
            low = high;
            high *= 2;
        }

        // Perform binary search in the range [low, high]
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (stream[mid] == 1 && (mid == 0 || stream[mid - 1] == 0)) {
                return mid + 1; // Position of the first '1'
            } else if (stream[mid] == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // '1' not found in the stream
    }

    public static void main(String[] args) {
        int[] stream1 = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1};
        int[] stream2 = {0, 1, 1, 1, 1, 1, 1};
        int[] stream3 = {1, 1, 1, 1, 1, 1, 1};

        System.out.println("Position of the first '1' in stream1: " + findFirstOnePosition(stream1)); // Output: 8
        System.out.println("Position of the first '1' in stream2: " + findFirstOnePosition(stream2)); // Output: 2
        System.out.println("Position of the first '1' in stream3: " + findFirstOnePosition(stream3)); // Output: 1
    }
}
