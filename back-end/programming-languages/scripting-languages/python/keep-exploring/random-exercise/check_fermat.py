import math
import time

def check_fermat(a, b, c, n):
    if(n >= 2):
        if (pow(a,n) + pow(b,n) == pow(c,n)):
            print("Holy smokes, Fermat was wrong!")
        else:
            print("No, that doesn't work")
    else:
        print("Type n greater than 2.")

a = int(input("Type the value a: "))
b = int(input("Type the value b: "))
c = int(input("Type the value c: "))
n = int(input("Type the value n: "))

check_fermat(a,b,c,n)
