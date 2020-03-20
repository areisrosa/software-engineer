import turtle
import math
t = turtle.Turtle()

def polyline(t, lenght, n, angle):
    for i in range(n):
        t.fd(lenght)
        t.lt(angle)

def polygon(t, n, lenght):
    angle = 360 / n
    polyline(t, n, lenght, angle)

def arc(t, r, angle):
    arc_length = 2 * math.pi * r * angle / 360
    n = int(arc_length / 3) + 1
    step_length = arc_length / n
    step_angle = angle / n
    polyline(t, n, step_length, step_angle)

def circle(t, r):
    arc(t, r, 360)

