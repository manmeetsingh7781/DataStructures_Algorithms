# find max product of 2 numbers within O(N)
def greatest_product(array: list):
    max_number = max(array)
    result = -1

    for i in range(len(array)):
        if i != array.index(max_number) and result < (max_number * array[i]):
            result = max_number * array[i]

    return result


# find common elements appear in the array
def intersection(a: list, b: list):
    common_elements = []

    for i in range(len(a)):
        for j in b:
            if a[i] == j:
                common_elements.append(j)
                """
                    * adding this break statement will avoid unnecessary steps and make our code slightly faster
                    * the average case with "break" would be between O(N) and O(N^2)
                    * without "break" the complexity would be O(N^2) in all cases
                """
                break

    return common_elements


"""
    *** Time complexity ***
    Best-case: when first two number of array's are sum of total
    Average-case: when numbers are somewhere in the middle of the array
    Worst-case: when pair is not in any of the array and code runs N^2 times
"""


def two_sum(a: list, b: list, total: int):
    for i in a:
        for j in b:
            if (i + j) == total:
                return True
    return False


"""
    Function to find average of even numbers in the array
    Big O is all about asking a key question: if there are N data elements, how many steps
    will the algorithm take?

        The first thing we want to do is determine what the N data elements are
        Next we need to determine how many steps the algorithm takes to process N values

    **** Time Complexity ****
        Big O is all about worst-case scenarios:
        if array contains all the even numbers then the T(N) = O(3N + 3) => O(N)
        
"""


def average_even_numbers(arr: list):
    total = 0.0  # +1 step
    count_of_even_numbers = 0  # +1 step

    for i in arr:  # iterates N times
        if i % 2 == 0:  # N steps | checks each number if its even
            total += i  # +1 step if number is even | executes some N times
            count_of_even_numbers += 1  # +1 step update number of evens | executes some N times

    return total / count_of_even_numbers  # +1 step


"""
    Function that collects every combination of two character strings built from an array of single characters
    input = ['a', 'b', 'c', 'd']
    output = ['ab', 'ac', 'ad', 'ba', 'bc', 'bd', 'ca', 'cb', 'cd', 'da', 'db', 'dc']
    
"""


def word_builder(arr: list):
    result = []

    # 2 loops creates com,bination of two characters ab, ac ... dc
    for i in arr:
        for j in arr:
            for k in arr:
                for l in arr:
                    if i != j != k != l:
                        result.append(str(i) + str(j) + str(k) + str(l))
    return result


"""
    Code Example: Create 5 shirts of each shirt given in an array

    O(N * M) where N is size of array and M is size of inner loop
    therefore M (count) = 5
    So, T(N) = O(5N) => O(N)
"""


def create_shirts(shirts: list):
    for shirt in shirts:  # runs for N times depends on size N (array of shirts)
        for count in range(1, 6):  # 6 is excluded, no matter what N is it will always run 5 times
            print(f"{shirt}: {count}")


"""
    Code Example: Count the Ones
    This function accepts an array or arrays, where the inner arrays contains 1's and 0's.
    The function then returns how many 1's tehre are:

    input = [
                [0, 1, 1, 1, 0],
                [0, 1, 0, 1, 0, 1],
                [1, 0]
            ]

    output = 7, there are 7 1's 

    As we can see that size of every array  is different.

    **** Time Complexity ****
    It seems like it's time complexity is O(N^2) but if look at it, it's O(N). Here's how

        * The outter loop is iterating over the inner arrays
        * The ineer array is iterating over the actual numbers
        * Therefore, our inner loop only runs for as many numbers as there are in total
        * Because of this we can say that N represents how many numbers there are, and since
            our algorithjm simply process each number, the function's time complexity is O(N)
"""


def count_ones(arrays):
    ones = 0

    # 2D array, extract each array from arrays
    for inner_array in arrays:

        # extract each number from inner_array
        for each_number in inner_array:
            if each_number == 1:
                ones += 1

    return ones




"""
    Permutations & Combinations
    
    - Permutation: ~ Arranging things in different order.
                   ~ Order matters
                   
                   n_P_r = (n!) / (n-r)!
                   n = total number
                   r = how many numbers we choosing from n
   
   - Combination:  ~ Combining things
                   ~ Order does not matter = No duplicate values
                   
                   n_C_r = n_P_r / r!  = permutations / r!
"""
