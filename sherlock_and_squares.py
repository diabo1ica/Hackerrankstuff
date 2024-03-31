#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the squares function in the editor below. It should return an integer representing the number of square integers in the inclusive range from a to b.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER a
#  2. INTEGER b
#

# To find the square integers in the range a to b
# Find the root of a (start) and b (end)
# Loop through start to end and if the squared value exists in the range a to be
# Then we have foud our squared integer
def squares(a, b):
    res = 0
    start = math.ceil(math.sqrt(a))
    end = math.ceil(math.sqrt(b + 1))
    for i in range(start, end):
        if pow(i, 2) in range(a, b+1):
            res += 1
    return res
        

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        a = int(first_multiple_input[0])

        b = int(first_multiple_input[1])

        result = squares(a, b)

        fptr.write(str(result) + '\n')

    fptr.close()
