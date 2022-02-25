"""
Hash Map
"""

"""
Blazing fast lookup with O(1) time complexity

- we use array to store, and instead of using index to access value. we pass in key and hash it to get the index
- Hash function should create same results every time we hash the key
- Invalid hash functions include functions that use random numbers or the current time as part of their calculations
- Simple hash functions as follow:
        -- we will take character code of each char and multiply them or add them together
        -- hash(bad) -> b * a * d => 2 * 1 * 4 = 8
        -- hash(bad) -> b + a + d = 2 + 1 + 4 = 7

- Each key can exist only once in the hash table, but there can be multiple values stored associated with the same key
- In many languages, if we try to store a key-value pair where key already exists, it will simply override the old ones
    while keeping the same key. To avoid this we can simple append it to the old value.

# One-Directional Lookups
- Hash tables are most of the time one directional look up which means that you can use key to get the value
    but can not use value to get the key
- Some programming languages stores key value pairs (key, value)

"""

class Node:

    def __init__(self, data, next):
        self.data = data
        self.next = next




class LinkedList:

    def __init__(self, item):
        self.head = Node(item, None)

    def add(self, item):
        if self.head:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = Node(item, None)
            head = temp

class HashMap:

    # in this class we will keep a pair of (key, value)
    def __init__(self, size):
        self.data = [None for _ in range(size)]  # buckets | to store data in it
        self.size = size


    def __str__(self):
        return str(self.data)


    def hash(self, key):
        result = 0

        for i in key:
            result += ord(i)

        return result % self.size


    def put(self, key, value):
        self.data[self.hash(key)] = value




hash = HashMap(10)
print(hash)