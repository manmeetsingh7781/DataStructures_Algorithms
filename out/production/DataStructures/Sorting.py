class Sorting:

    def __init__(self, array):
        self.array = array

    """
     * At each pass through we bubble out the largest item and place it at the end (length of an array)
     * then we decrement the length by 1
     * if value needs to be swapped then we swap and mark that swapping was done
     * repeat until there is no swapping
     * T(N) = O(N^2) Quadratic Time
    """

    def bubble_sort(self):
        was_swapped = True
        limit = len(self.array) - 1

        while was_swapped:
            was_swapped = False
            for i in range(limit):
                # compare two and bubble out largest value at the end(limit)
                if self.array[i] > self.array[i + 1]:
                    self.array[i], self.array[i + 1] = self.array[i + 1], self.array[i]
                    was_swapped = True

            # at this point we know that our largest value is at the end so no need to compare any more values to it
            limit -= 1

    """ 
        * Idea is to find the smallest value in each pass through
        * At the end of the pass through replace the i'th index with the value that we found smallest in the array
        * T(N) = O(N^2 / 2) and twice faster then bubble sort

        **** Time Complexity ****
            O(N^2 / 2) in all cases

            Better thne insert_sort if the array is in reverse order
            If array is mostly sorted then use insert_sort 
        """

    def selection_sort(self):
        for i in range(len(self.array)):
            # initial value of our smallest item in the list
            smallest_value_at = i

            # finds the smallest item in the array and updates the index
            for j in range(i + 1, len(self.array)):
                if self.array[j] < self.array[smallest_value_at]:
                    smallest_value_at = j

            # now that we have the smallest value in the array, we just want to replace it with the i'th index
            # then
            # if index's are not same then we know that it has different value and we need to swap
            if smallest_value_at != i:
                self.array[i], self.array[smallest_value_at] = self.array[smallest_value_at], self.array[i]

    """
        * We temporarily store value that is at index 1 and store it into temporary variable
        * Then we compare that stored value to each item towards the left of the array and shift elements to the right
        * the fill the gap with value that we had store in temp variable
        * we repeat this process until N - 1

        **** Time Complexity ****
        In worst-case: Performs O(N^2) same as bubble sort | compare and shift all of the values | array is in reverse order
        In best-case: Only 1 comparison per pass through O(N) | array is already sorted
        In average-case: we perform some shifts and comparisons and we can say that it's O(N^2 / 2)  
    """

    def insert_sort(self):
        for i in range(len(self.array) - 1):

            # store selected value as a temporary
            selected_value = self.array[i + 1]

            # while selected value is less then item on left shift the items in array to the right
            while i >= 0 and selected_value < self.array[i]:
                self.array[i + 1] = self.array[i]
                i -= 1

            # place the item at the empty block
            self.array[i + 1] = selected_value


