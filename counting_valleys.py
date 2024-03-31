#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countingValleys' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER steps
#  2. STRING path
#

def countingValleys(steps, path):
    # Write your code here
    altitude = 0
    num_valley = 0
    for step in path:
        if step == 'U':
            altitude += 1
            if exit_valley(altitude):
                num_valley += 1
        else:
            altitude -= 1
    return num_valley
        
    
def exit_valley(altitude):
    if altitude == 0:
        return True
    return False

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    steps = int(input().strip())

    path = input()

    result = countingValleys(steps, path)

    fptr.write(str(result) + '\n')

    fptr.close()