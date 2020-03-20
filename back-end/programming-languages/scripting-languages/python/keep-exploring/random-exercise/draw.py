import turtle
import math
t = turtle.Turtle()

def draw(t,lenght,n):
    if n == 0:
        return
    angle = 60
    t.fd(lenght*n)
    t.lt(angle)
    draw(t,lenght,n-1)
    t.rt(2*angle)
    draw(t,lenght,n-1)
    t.lt(angle)
    t.bk(lenght*n)

if __name__ == '__main__':
    draw(t,5,5)
