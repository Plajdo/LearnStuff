from turtle import *
import numbers

def rectangle(x, y):
    right(90)
    forward(x * 0.5)
    left(90)
    forward(y)
    left(90)
    forward(x)
    left(90)
    forward(y)
    left(90)
    forward(x * 0.5)
    left(90)
    penup()
    forward(y)
    pendown()

def kresli_vezu(velkostVeze):
    x = velkostVeze
    y = 1

    left(90)
    rectangle(velkostVeze, 1)
    while True:
        x = x / 2
        y = y * 2

        if not x.is_integer():
            break

        rectangle(x, y)

    hideturtle()
    done()

kresli_vezu(128)
