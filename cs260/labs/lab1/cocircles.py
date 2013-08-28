#################################
# CS260-03 LAB1					#
# Dave Nearing					#
# August 28,2013				#
#################################

from Ch1_simpleTurtle import drawCircle
from Ch1_simpleTurtle import drawPolygon
import turtle

steve=turtle.Turtle()
steve.speed(0)
radius=15
color=["red","green","yellow","blue","black"]
blotter=60

for i in range(0,5):
	steve.down()
	steve.color(color[i])
	drawCircle(steve,radius)
	steve.up()
	steve.home()
	steve.goto(0,radius)
	radius = radius + 15

input("Continue?")

steve.clear()
steve.home()

for i in range(0,5):
	steve.color(color[i])
	steve.dot(blotter)
	blotter = blotter-10

input("End?")