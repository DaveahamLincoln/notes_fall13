# Miller & Ranum - page 30

def drawSquare(myTurtle, sideLength):
    myTurtle.forward(sideLength)
    myTurtle.right(90)
    myTurtle.forward(sideLength)
    myTurtle.right(90)
    myTurtle.forward(sideLength)
    myTurtle.right(90)
    myTurtle.forward(sideLength)
    myTurtle.right(90)

# Page 34

def drawSquare2(myTurtle, sideLength):
    for i in range(4):
        myTurtle.forward(sideLength)
        myTurtle.right(90)

def drawSpiral(myTurtle, maxSide):
    for sidelength in range(1, maxSide - 1, 5):
        myTurtle.forward(sideLength)
        myTurtle.right(90)

def drawTriangle(myTurtle, sideLength):
    for i in range(3):
        myTurtle.forward(sideLength)
        myTurtle.right(120)

# page 38
def drawPolygon(myTurtle, sideLength, numSides):
    turnAngle = 360/numSides
    for i in range(numSides):
        myTurtle.forward(sideLength)
        myTurtle.right(turnAngle)

# page 40
def drawCircle(myTurtle, radius):
    circumference = 2 * 3.14159 * radius
    sideLength = circumference / 360
    drawPolygon(myTurtle, sideLength, 360)











    myTurtle.forward(sideLength)
    myTurtle.right(90)




# import turtle
# sven = turtle.Turtle()

        

               
