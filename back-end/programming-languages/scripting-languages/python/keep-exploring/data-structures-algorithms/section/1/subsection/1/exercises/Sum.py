class SumSeq:
    """Write a short Python function that takes a positive integer n and
    returns the sum of the squares of all the positive integers smaller than n
    """
    def sumSeq(number):
        while number <= 0:
            try:
                number = int(input("Type the number: "))
                if number <= 0:
                    print("Your age must be positive")
            except ValueError:
                print("That is an invalid age specification")
            except EOFError:
                print("There was an unexpected error reading input.")
                raise
            result = 0

            if number > 0:
                for i in range(number):
                    result += i * i
                return result

if __name__ == '__main__':

    number = int(input("Type the number: "))
    sumSeq(number)

