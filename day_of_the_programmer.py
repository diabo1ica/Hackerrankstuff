#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'dayOfProgrammer' function below.
#
# The function is expected to return a STRING.
# The function accepts INTEGER year as parameter.
#

def dayOfProgrammer(year):
    # Write your code here
    date = None
    if year == 1918:
        date = '26.09.'
    elif year % 400 == 0 or (year % 4 == 0 and year % 100 != 0):
        date = '12.09.'
    elif year < 1918 and year % 4 == 0:
        date = '12.09.'
    else:
        date = '13.09.'
    return date + str(year)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    year = int(input().strip())

    result = dayOfProgrammer(year)

    fptr.write(result + '\n')

    fptr.close()
