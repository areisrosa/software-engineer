digit = input("Enter a number with an even number of digits: ")
checksum = 0
position = 1

while (int(digit) != 10):
    if(position % 2 == 0):
        checksum += int(digit) - int('0')
    else:
        checksum += 2 * (int(digit) - int('0'))
position = position + 1

print("Checksum is ", checksum)
if (checksum % 10 == 0):
    print("Checksum is divisible by 10. Valid.")
else:
    print("Checksum is not divisible by 10. Invalid.")
