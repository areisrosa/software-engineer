import turtle
bob = turtle.Turtle()

def polygon(t, lenght, n):
    angle = 360 / n
    for i in range(n):
        t.fd(lenght)
        t.lt(angle)
        
polygon(bob,70,7)
