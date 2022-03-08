class Searching:

    def __init__(self, array):
        self.array = array

    """
        Linear Search: can be performed on unordered list
        Time Complexity: O(N)
        Space Complexity: O(1)
   """

    def linear_search(self, key):
        for element in self.array:
            if element == key:
                return True
        return False

    """
        Binary Search: can be performed only on ordered list
    Time Complexity: O(log_2(N))
    Space complexity: O(1)

    Every time we iterate, we must check value at the middle point with key and make decision
        whether to go left or right by slicing the array in halves

         Calculate MID_POINT at each iteration
         Adjust Low/High based on the direction

    to find element in list of size 100 it will take 7 steps only
    and to find in size of 200 it will take 8 steps
    Log_2(200) = 8
    Everytime we double the data, it only adds 1 step

    """

    def binary_search(self, key):
        low = 0
        high = len(self.array) - 1

        while low <= high:
            mid = (high + low) / 2
            if self.array[mid] == key:
                return True
            elif self.array[mid] > key:
                high = mid - 1
            elif self.array[mid] < key:
                low = mid + 1

        return False
