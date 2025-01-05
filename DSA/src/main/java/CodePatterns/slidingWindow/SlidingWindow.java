package CodePatterns.slidingWindow;
import java.util.Map;
import java.util.HashMap;
public class SlidingWindow {
    //template:
    /*
fixed_window()
{
    int low = 0, high = 0, windowsize = k;
    while (high < sizeofarray)
    {
        // Step 1: Create a window that is one element smaller than the desired window size
        if (high - low + 1 < windowsize)
        {
            // Generate the window by increasing the high index
            high++;
        }
        // Step 2: Process the window
        else
        {
            // Window size is now equal to the desired window size
            // Step 2a: Calculate the answer based on the elements in the window
            // Step 2b: Remove the oldest element (at low index) from the window for the next window

            // Proceed to the next window by incrementing the low and high indices
            low++;high++;
        }
    }
    }


     */
    public int numOfSubArrays(int[] arr, int k, int threshold) {
        int i = 0;
        int j = 0;
        int avg = 0;
        int sum = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;
            } else {
                if (j - i + 1 == k) {
                    if (sum / k >= threshold)
                        avg += 1;
                }
                sum -= arr[i];
                i++;
                j++;
            }

        }
        return avg;
    }
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0, j = 0;
        int count = 0; // Tracks the number of distinct elements
        long maxSum = 0;
        long sum = 0;
        Map<Integer, Integer> subArray = new HashMap<>();

        while (j < nums.length) {
            // Add nums[j] to the sum and update its count in the map
            sum += nums[j];
            subArray.put(nums[j], subArray.getOrDefault(nums[j], 0) + 1);

            // If nums[j] was not already in the map, increase the distinct count
            if (subArray.get(nums[j]) == 1) {
                count++;
            }

            // Check if the window size is less than k
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) { // When the window size is exactly k
                // If all elements in the window are distinct, consider the sum
                if (count == k) {
                    maxSum = Math.max(maxSum, sum);
                }

                // Remove nums[i] from the window
                sum -= nums[i];
                subArray.put(nums[i], subArray.get(nums[i]) - 1);

                // If nums[i] count becomes zero, reduce the distinct count
                if (subArray.get(nums[i]) == 0) {
                    subArray.remove(nums[i]);
                    count--;
                }

                // Slide the window forward
                i++;
                j++;
            }
        }
        return maxSum;
    }
/*
variable_window()
{
    int start = 0, end = 0;
    while (end < n)
    {
        // Perform calculations or operations within the window

         Case 1: Expand the window
           If the window size is less than the desired value (k), increase the end index

        if (end - start + 1 < k)
    {
        end++;
    }

         Case 2: Window of desired size
           If the window size is equal to the desired value (k), process the window and calculate the answer

        else if (end - start + 1 == k)
    {
        // Perform the required calculations or operations to obtain the answer
        // Store the answer in a variable (ans)

        end++;
    }

      Case 3: Reduce the window size
           If the window size is greater than the desired value (k), adjust the window by moving the start index

        else if (end - start + 1 > k)
    {
        while (end - start + 1 > k)
        {
            // Remove calculations or operations involving the element at the start index

            start++;
        }

        // Check if the window size becomes equal to the desired value (k) after adjustment
        if (end - start + 1 == k)
        {
            // Perform calculations or operations and store the answer if necessary
        }

        end++;
    }
}

// Return the final answer (ans)
}
 */
}
