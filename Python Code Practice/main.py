
# Daniel Wolfe
# Various coding design methods.

# Bubble Sort Method
def bubble_sort(array):

    size = len(array)

    for i in range(size - 1):
        for j in reversed(range(i + 1, size)):

            if array[j] < array[j-1]:
                array[j], array[j-1] = array[j-1], array[j]

    return array


# Recursive method that returns fibbonachi sequence number
def recursive_fibbonachi(n):

    if n < 3:
        return 1
    else:
        return recursive_fibbonachi(n-1) + recursive_fibbonachi(n-2)


if __name__ == '__main__':
    print(recursive_fibbonachi(7))
