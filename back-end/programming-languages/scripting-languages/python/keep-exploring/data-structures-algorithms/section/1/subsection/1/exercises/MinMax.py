# Write a short Python function, minmax(data), that takes a sequence of one or
# more numbers, and returns the smallest and largest numbers, in the form of a
# tuple of length two. Do not use the built-in functions min or max in
# implementing your solution.
class MinMax:
    """Return a tuple of min and max."""

def minmax(data):
    min = max = None
    for val in data:
        if min is None or val < min:
            min = val
        if max is None or val > max:
            max = val
    return min, max

data = 1,3,4,5,33,55,76,88
print(minmax(data))

