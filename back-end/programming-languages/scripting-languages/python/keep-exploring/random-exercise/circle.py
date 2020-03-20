import turtle
import math
t = turtle.Turtle()

def polygon(t, n, lenght):
    angle = 360 / n
    for i in range(n):
        t.fd(lenght)
        t.lt(angle)

def circle(t, r):
    circumference = 2 * math.pi * r
    n = 50
    lenght = circumference / n
    polygon(t,n,lenght)


