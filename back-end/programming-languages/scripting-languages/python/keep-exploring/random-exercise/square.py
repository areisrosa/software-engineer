import turtle
bob = turtle.Turtle()

def squate(t, lenght):
    for i in range(4):
        t.fd(lenght)
        t.lt(90)
        
squate(bob,120)
