#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'migratoryBirds' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def migratoryBirds(arr):
    # Write your code here
    hashmap = {}
    for bird in arr:
        if bird in hashmap:
            hashmap[bird] += 1
        else:
            hashmap[bird] = 1
            
    # Look for smallest bird_id with biggest sum
    bird_id = 5
    id_sum = 0
    for item_id in hashmap:
        print(item_id, hashmap[item_id])
        if id_sum <= hashmap[item_id]:
            if id_sum == hashmap[item_id]:
                bird_id = min(bird_id, item_id)
                continue
            id_sum = hashmap[item_id]
            bird_id = item_id
    return bird_id
        

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    result = migratoryBirds(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
