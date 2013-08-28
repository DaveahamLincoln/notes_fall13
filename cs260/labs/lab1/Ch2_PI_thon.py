# Miller & Ranum, chapter 2
#  PI-thon

import math

def archimedes(numSides):
    
    innerangleB = 360.0/numSides
    halfangleA = innerangleB/2

    onehalfsideS = math.sin(math.radians(halfangleA))

    sideS = onehalfsideS * 2

    polygonCircumference = numSides * sideS
    pi = polygonCircumference/2

    return pi

######################

def leibniz(terms):
    acc = 0    
    num = 4   
    den = 1      

    for aterm in range(terms):
        nextterm = num/den * (-1)**aterm

        acc = acc + nextterm  

        den = den + 2         

    return acc

#####################

def wallis(pairs):
   acc = 1
   num = 2
   for apair in range(pairs):
       leftterm = num/(num-1)
       rightterm = num/(num+1)
       
       acc = acc * leftterm * rightterm

       num = num + 2

   pi = acc * 2
   return pi

####################

import random
import math

def montePi(numDarts):
    
    inCircle = 0       

    for i in range(numDarts):
    	x = random.random()
    	y = random.random()

    	d = math.sqrt(x**2 + y**2)   
	
    	if d <= 1:
    		inCircle = inCircle + 1
	
    pi = inCircle/numDarts * 4

    return pi

###
# import random
# import math
import turtle

def showMontePi(numDarts):
    wn = turtle.Screen()
    drawingT = turtle.Turtle()
    
    wn.setworldcoordinates(-2,-2,2,2)
    
    drawingT.up()
    drawingT.goto(-1,0)
    drawingT.down()
    drawingT.goto(1,0)
    
    drawingT.up()
    drawingT.goto(0,1)
    drawingT.down()
    drawingT.goto(0,-1)
    
    circle = 0
    drawingT.up()

    for i in range(numDarts):
        x = random.random()
        y = random.random()

        d = math.sqrt(x**2 + y**2)

        drawingT.goto(x,y)
        
        if d <= 1:
            circle = circle + 1
            drawingT.color("blue")
        else:
            drawingT.color("red")
            
        drawingT.dot()

    pi = circle/numDarts * 4

    wn.exitonclick()
    
    return pi

