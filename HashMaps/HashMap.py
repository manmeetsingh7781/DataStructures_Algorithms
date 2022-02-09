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


class HashMap:

    # in this class we will keep pair of (key, value)
    def __init__(self):
        self.data = []  # buckets | to store data in it


class Node:

    def __init__(self, data, next):
        self.data = data
        self.next = next



class LinkedList:

    def __init__(self, item):
        self.head = Node(item, None)

    def __add__(self, item):
        if self.head:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next =  Node(item, None)
            head = temp


l = LinkedList(10)
l.__add__(20)
l.__add__(30)

print(l.head.data)
print(l.head.next.data)
print(l.head.next.next.data)