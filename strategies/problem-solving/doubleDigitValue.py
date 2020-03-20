import sys

def doubleDigitValue(number):
    doubleDigit = number * 2
    if doubleDigit >= 10:
        sum = 1 + doubleDigit % 10
        return sum
    else:
        sum = doubleDigit
        return sum

__name__ == "__main__"

number = int(input('Enter a single digit number, 0-9: '))

print('Sum of digit in doubled number:', doubleDigitValue(number))
