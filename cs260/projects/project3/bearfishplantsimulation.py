import turtle
import random
import sys
import time

class World:
    def __init__(self, mx, my):
        random.seed()

        self.maxX = mx
        self.maxY = my
        self.thingList = []
        self.grid = []
        self.terrainMap = {}
        self.fishCounter = 0
        self.bearCounter = 0
        self.plantCounter = 0
        self.berryCounter = 0
    
        for arow in range(self.maxY):     
            row = []
            for acol in range(self.maxX):

                row.append(None)
            self.grid.append(row)

        for acol in range(self.maxX):
            terrainCol = []
            for arow in range(self.maxY):
                r = random.randint(0,1)
                if r == 0:
                    terrainCol.append("water")
                else:
                    terrainCol.append("land")
            self.terrainMap[acol]=terrainCol

        #print(self.terrainMap)

        self.wturtle = turtle.Turtle()
        self.wscreen = turtle.Screen()
        self.wscreen.setworldcoordinates(0,0,self.maxX-1,self.maxY-1)   
        self.wscreen.addshape("Bear.gif")
        self.wscreen.addshape("Fish.gif")
        self.wscreen.addshape("Plant.gif")
        self.wscreen.addshape("Berry.gif")
        #self.wscreen.addshape("target.gif")
        self.wturtle.hideturtle()               

    def draw(self):
        self.wturtle.speed(0)
        self.wscreen.tracer(0)
        self.wturtle.forward(self.maxX-1)
        self.wturtle.left(90)
        self.wturtle.forward(self.maxY-1)
        self.wturtle.left(90)
        self.wturtle.forward(self.maxX-1)
        self.wturtle.left(90)
        self.wturtle.forward(self.maxY-1)
        self.wturtle.left(90)    
        for i in range(self.maxY-1):
            self.wturtle.forward(self.maxX-1)
            self.wturtle.backward(self.maxX-1)
            self.wturtle.left(90)
            self.wturtle.forward(1)
            self.wturtle.right(90)
        self.wturtle.forward(1)
        self.wturtle.right(90)
        for i in range(self.maxX-2):
            self.wturtle.forward(self.maxY-1)
            self.wturtle.backward(self.maxY-1)
            self.wturtle.left(90)
            self.wturtle.forward(1)
            self.wturtle.right(90)
        self.wscreen.tracer(1)

    def freezeWorld(self):
        self.wscreen.exitonclick()
    
    def genTerrain(self):
        self.wturtle.up()
        for i in range(len(self.terrainMap)):
            for j in range(len(self.terrainMap[i])):
                self.wturtle.goto(i,j)
                if self.terrainMap[i][j]=='water':
                    self.wturtle.color('blue')
                else:
                    self.wturtle.color('brown')
                self.wturtle.dot(10)
                self.wturtle.up()

    def addThing(self, athing, x, y):   
        if athing.identity() == 'fish':
            self.fishCounter+=1
            #print(self.fishCounter)
        elif athing.identity() == 'bear':
            self.bearCounter+=1
        elif athing.identity() == 'plant':
            self.plantCounter+=1
        elif athing.identity() == 'berry':
            self.berryCounter+=1
            
        athing.setX(x)
        athing.setY(y)
        self.grid[y][x]=athing
        athing.setWorld(self)
        self.thingList.append(athing)   
        athing.appear()                 
    
    def delThing(self,athing):
        if athing.identity() == 'fish':
            self.fishCounter-=1
        elif athing.identity() == 'bear':
            self.bearCounter-=1
        elif athing.identity() == 'plant':
            self.plantCounter-=1
        elif athing.identity() == 'berry':
            self.berryCounter-=1
        else:
            pass
        athing.hide()                                     
        self.grid[athing.getY()][athing.getX()] = None     
        self.thingList.remove(athing)                      
    
    def moveThing(self,oldx,oldy,newx,newy):
        self.grid[newy][newx] = self.grid[oldy][oldx]
        self.grid[oldy][oldx] = None
    
    def getMaxX(self):
        return self.maxX
    
    def getMaxY(self):
        return self.maxY
    
    def liveALittle(self):                                  
        if self.thingList != [ ]:
           athing = random.randrange(len(self.thingList))    
           randomthing = self.thingList[athing]              
           randomthing.liveALittle()                       
     
    def emptyLocation(self,x,y):
        if self.grid[y][x] == None:
            return True
        else:
            return False
        
    def lookAtLocation(self,x,y):
       return self.grid[y][x]

    def getFishAlive(self):
        return self.fishCounter

    def getBearAlive(self):
        return self.bearCounter

    def getPlantAlive(self):
        return self.plantCounter

    def getBerryAlive(self):
        return self.berryCounter


class Fish:
    def __init__(self):
        self.turtle = turtle.Turtle()
        self.turtle.up()
        self.turtle.hideturtle()
        self.turtle.shape("Fish.gif")

        self.xpos = 0
        self.ypos = 0
        self.world = None                 
        
        self.breedTick = 0
        self.baseHp = 10
        self.hp = 10

    def identity(self):
        return "fish"

    def setX(self,newx):
        self.xpos = newx
    
    def setY(self,newy):
        self.ypos = newy
    
    def getX(self):
        return self.xpos
    
    def getY(self):
        return self.ypos
    
    def setWorld(self,aworld):
        self.world = aworld
 
    def appear(self):
        self.turtle.goto(self.xpos, self.ypos)
        self.turtle.showturtle()

    def hide(self):
        self.turtle.hideturtle()
    
    def move(self,newx,newy):
        self.world.moveThing(self.xpos,self.ypos,newx,newy)
        self.xpos = newx
        self.ypos = newy
        self.turtle.goto(self.xpos, self.ypos)
        self.hp-=1

    def liveALittle(self):
        if self.hp <=0:
            self.world.delThing(self) 
            return 0

        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)]     
        adjfish = 0                                  
        for offset in offsetList:                    
            newx = self.xpos + offset[0]             
            newy = self.ypos + offset[1]
            if 0 <= newx < self.world.getMaxX()  and  0 <= newy < self.world.getMaxY():          
                if (not self.world.emptyLocation(newx,newy)) and isinstance(self.world.lookAtLocation(newx,newy),Fish):
                    adjfish = adjfish + 1   
     
        if adjfish >= 2:                   
            self.world.delThing(self)      
        else:
            self.breedTick = self.breedTick + 1
            if self.breedTick >= 12:
                self.tryToBreed()

            self.tryToEat()
            self.tryToMove()

    def tryToBreed(self):
        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)]    
        randomOffsetIndex = random.randrange(len(offsetList))
        randomOffset = offsetList[randomOffsetIndex]
        nextx = self.xpos + randomOffset[0]
        nexty = self.ypos + randomOffset[1]
        while not (0 <= nextx < self.world.getMaxX() and 
                   0 <= nexty < self.world.getMaxY() ):  
            randomOffsetIndex = random.randrange(len(offsetList))
            randomOffset = offsetList[randomOffsetIndex]
            nextx = self.xpos + randomOffset[0]
            nexty = self.ypos + randomOffset[1]
    
        if self.world.emptyLocation(nextx,nexty) and self.world.terrainMap[nextx][nexty]=='water':    
           childThing = Fish()
           self.world.addThing(childThing,nextx,nexty)
           self.breedTick = 0
           self.hp-=5

    def tryToMove(self):
        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)]   
        randomOffsetIndex = random.randrange(len(offsetList))
        randomOffset = offsetList[randomOffsetIndex]
        nextx = self.xpos + randomOffset[0]
        nexty = self.ypos + randomOffset[1]
        while not(0 <= nextx < self.world.getMaxX() and 
                  0 <= nexty < self.world.getMaxY() ):
            randomOffsetIndex = random.randrange(len(offsetList))
            randomOffset = offsetList[randomOffsetIndex]
            nextx = self.xpos + randomOffset[0]
            nexty = self.ypos + randomOffset[1]
    
        if self.world.emptyLocation(nextx,nexty) and self.world.terrainMap[nextx][nexty]=='water':
           self.move(nextx,nexty)
           
    def tryToEat(self):
        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)] 
        adjprey = []                 
        for offset in offsetList:
            newx = self.xpos + offset[0]
            newy = self.ypos + offset[1]
            if 0 <= newx < self.world.getMaxX() and 0 <= newy < self.world.getMaxY():
                if (not self.world.emptyLocation(newx,newy)) and isinstance(self.world.lookAtLocation(newx,newy),Plant):
                    adjprey.append(self.world.lookAtLocation(newx,newy))       
        #print(adjprey)        
        if len(adjprey)>0:                
            randomprey = adjprey[random.randrange(len(adjprey))]   
            preyx = randomprey.getX()
            preyy = randomprey.getY()
        
            self.hp=self.hp+randomprey.getHp()
            self.world.delThing(randomprey)
            print("nibble")                            
            self.move(preyx,preyy)                                      
            #self.starveTick = 0                     
        #else:
            #self.starveTick = self.starveTick + 1  

    def getHp(self):
        return self.baseHp

class Bear:
    def __init__(self):
        self.turtle = turtle.Turtle()
        self.turtle.up()
        self.turtle.hideturtle()
        self.turtle.shape("Bear.gif")

        self.xpos = 0
        self.ypos = 0
        self.world = None
        
        self.starveTick = 0
        self.breedTick = 0
        self.hp = 14

    def identity(self):
        return "bear"
        
    def setX(self,newx):
        self.xpos = newx
    
    def setY(self,newy):
        self.ypos = newy
    
    def getX(self):
        return self.xpos
    
    def getY(self):
        return self.ypos
    
    def setWorld(self,aworld):
        self.world = aworld
 
    def appear(self):
        self.turtle.goto(self.xpos, self.ypos)
        self.turtle.showturtle()

    def hide(self):
        self.turtle.hideturtle()
    
    def move(self,newx,newy):
        self.world.moveThing(self.xpos,self.ypos,newx,newy)
        self.xpos = newx
        self.ypos = newy
        self.turtle.goto(self.xpos, self.ypos)
        self.hp-=1

    def liveALittle(self):
        if self.hp <=0:
            self.world.delThing(self) 
            return 0

        self.breedTick = self.breedTick + 1

        if self.breedTick >= 8:
            self.tryToBreed()
    
        self.tryToEat()          
    
        if self.starveTick == 10:
            self.world.delThing(self)
        else:
            self.tryToMove()

    def tryToEat(self):
        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)] 
        adjprey = []                 
        for offset in offsetList:
            newx = self.xpos + offset[0]
            newy = self.ypos + offset[1]
            if 0 <= newx < self.world.getMaxX() and 0 <= newy < self.world.getMaxY():
                #if (not self.world.emptyLocation(newx,newy)) and isinstance(self.world.lookAtLocation(newx,newy),Fish) or isinstance(self.world.lookAtLocation(newx,newy),Berry):
                if (not self.world.emptyLocation(newx,newy)) and isinstance(self.world.lookAtLocation(newx,newy),Fish):
                    adjprey.append(self.world.lookAtLocation(newx,newy))       
                elif (not self.world.emptyLocation(newx,newy)) and isinstance(self.world.lookAtLocation(newx,newy),Berry):
                    adjprey.append(self.world.lookAtLocation(newx,newy))       

        if len(adjprey)>0:                
            randomprey = adjprey[random.randrange(len(adjprey))]   
            preyx = randomprey.getX()
            preyy = randomprey.getY()
        
            self.hp = self.hp+randomprey.getHp()
            self.world.delThing(randomprey)
            print("chomp")                            
            self.move(preyx,preyy)                                      
            self.starveTick = 0                     
        else:
            self.starveTick = self.starveTick + 1  
            
    def tryToBreed(self):
        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)]    
        randomOffsetIndex = random.randrange(len(offsetList))
        randomOffset = offsetList[randomOffsetIndex]
        nextx = self.xpos + randomOffset[0]
        nexty = self.ypos + randomOffset[1]
        while not (0 <= nextx < self.world.getMaxX() and 
                   0 <= nexty < self.world.getMaxY() ):  
            randomOffsetIndex = random.randrange(len(offsetList))
            randomOffset = offsetList[randomOffsetIndex]
            nextx = self.xpos + randomOffset[0]
            nexty = self.ypos + randomOffset[1]
    
        if self.world.emptyLocation(nextx,nexty) and self.world.terrainMap[nextx][nexty]=='land':    
           childThing = Bear()
           self.world.addThing(childThing,nextx,nexty)
           self.breedTick = 0
           self.hp-=5

    def tryToMove(self):
        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)]   
        randomOffsetIndex = random.randrange(len(offsetList))
        randomOffset = offsetList[randomOffsetIndex]
        nextx = self.xpos + randomOffset[0]
        nexty = self.ypos + randomOffset[1]
        while not(0 <= nextx < self.world.getMaxX() and 
                  0 <= nexty < self.world.getMaxY()):
            randomOffsetIndex = random.randrange(len(offsetList))
            randomOffset = offsetList[randomOffsetIndex]
            nextx = self.xpos + randomOffset[0]
            nexty = self.ypos + randomOffset[1]
    
        if self.world.emptyLocation(nextx,nexty):
           self.move(nextx,nexty)
           
class Plant:
    def __init__(self):
        self.turtle = turtle.Turtle()
        self.turtle.up()
        self.turtle.hideturtle()
        self.turtle.shape("Plant.gif")

        self.xpos = 0
        self.ypos = 0
        self.world = None
        
        self.starveTick = 0
        self.breedTick = 0
        self.baseHp = 8
        self.hp = 8

    def identity(self):
        return "plant"
        
    def setX(self,newx):
        self.xpos = newx
    
    def setY(self,newy):
        self.ypos = newy
    
    def getX(self):
        return self.xpos
    
    def getY(self):
        return self.ypos
    
    def setWorld(self,aworld):
        self.world = aworld
 
    def appear(self):
        self.turtle.goto(self.xpos, self.ypos)
        self.turtle.showturtle()

    def hide(self):
        self.turtle.hideturtle()
    
    def move(self,newx,newy):
        self.world.moveThing(self.xpos,self.ypos,newx,newy)
        self.xpos = newx
        self.ypos = newy
        self.turtle.goto(self.xpos, self.ypos)

    def liveALittle(self):
            self.breedTick = self.breedTick + 1
            if self.breedTick >= 5:
                self.tryToBreed()
            
    def tryToBreed(self):
        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)]    
        randomOffsetIndex = random.randrange(len(offsetList))
        randomOffset = offsetList[randomOffsetIndex]
        nextx = self.xpos + randomOffset[0]
        nexty = self.ypos + randomOffset[1]
        while not (0 <= nextx < self.world.getMaxX() and 
                   0 <= nexty < self.world.getMaxY() ):  
            randomOffsetIndex = random.randrange(len(offsetList))
            randomOffset = offsetList[randomOffsetIndex]
            nextx = self.xpos + randomOffset[0]
            nexty = self.ypos + randomOffset[1]
    
        if self.world.emptyLocation(nextx,nexty) and self.world.terrainMap[nextx][nexty]=='water':    
           childThing = Plant()
           self.world.addThing(childThing,nextx,nexty)
           self.breedTick = 0

    def getHp(self):
        return self.hp

class Berry:
    def __init__(self):
        self.turtle = turtle.Turtle()
        self.turtle.up()
        self.turtle.hideturtle()
        self.turtle.shape("Berry.gif")

        self.xpos = 0
        self.ypos = 0
        self.world = None
        
        self.starveTick = 0
        self.breedTick = 0
        self.baseHp = 4
        self.hp = 4

    def identity(self):
        return "berry"
        
    def setX(self,newx):
        self.xpos = newx
    
    def setY(self,newy):
        self.ypos = newy
    
    def getX(self):
        return self.xpos
    
    def getY(self):
        return self.ypos
    
    def setWorld(self,aworld):
        self.world = aworld
 
    def appear(self):
        self.turtle.goto(self.xpos, self.ypos)
        self.turtle.showturtle()

    def hide(self):
        self.turtle.hideturtle()
    
    def move(self,newx,newy):
        self.world.moveThing(self.xpos,self.ypos,newx,newy)
        self.xpos = newx
        self.ypos = newy
        self.turtle.goto(self.xpos, self.ypos)

    def liveALittle(self):
            self.breedTick = self.breedTick + 1
            if self.breedTick >= 5:
                self.tryToBreed()
            
    def tryToBreed(self):
        offsetList = [(-1,1) ,(0,1) ,(1,1),          
                      (-1,0)        ,(1,0),
                      (-1,-1),(0,-1),(1,-1)]    
        randomOffsetIndex = random.randrange(len(offsetList))
        randomOffset = offsetList[randomOffsetIndex]
        nextx = self.xpos + randomOffset[0]
        nexty = self.ypos + randomOffset[1]
        while not (0 <= nextx < self.world.getMaxX() and 
                   0 <= nexty < self.world.getMaxY() ):  
            randomOffsetIndex = random.randrange(len(offsetList))
            randomOffset = offsetList[randomOffsetIndex]
            nextx = self.xpos + randomOffset[0]
            nexty = self.ypos + randomOffset[1]
    
        if self.world.emptyLocation(nextx,nexty) and self.world.terrainMap[nextx][nexty]=='land':    
           childThing = Berry()
           self.world.addThing(childThing,nextx,nexty)
           self.breedTick = 0

    def getHp(self):
        return self.baseHp

class Plotter:
    def __init__(self):
        self.fishPlot = []
        self.bearPlot = []
        self.plantPlot = []
        self.berryPlot = []
        self.window = turtle.Screen()
        self.steve = turtle.Turtle()

    def plot(self,infile):
        self.window.setworldcoordinates(0,0,2500,100)
        with open(infile) as f:
            for line in f:
                if line.startswith('t'):
                    f.readline()
                else:
                    a = line.split()
                    self.fishPlot.append(int(a[1]))
                    self.bearPlot.append(int(a[2]))
                    self.plantPlot.append(int(a[3]))
                    self.berryPlot.append(int(a[4]))
        f.close()
        
        self.steve.speed(0)

        #fish
        self.steve.color("blue")
        self.steve.up()
        for i in range(len(self.fishPlot)):
            self.steve.goto(i,self.fishPlot[i])
            self.steve.down()
        
        #bears    
        self.steve.up()
        self.steve.home()
        self.steve.color('brown')    
        self.steve.up()
        for i in range(len(self.bearPlot)):
            self.steve.goto(i,self.bearPlot[i])
            self.steve.down()
        
        #plants
        self.steve.up()
        self.steve.home()
        self.steve.color('green')    
        self.steve.up()
        for i in range(len(self.plantPlot)):
            self.steve.goto(i,self.plantPlot[i])
            self.steve.down()

        #berries
        self.steve.up()
        self.steve.home()
        self.steve.color('red')    
        self.steve.up()
        for i in range(len(self.berryPlot)):
            self.steve.goto(i,self.berryPlot[i])
            self.steve.down()

        self.window.exitonclick()

def mainSimulation():
    #prod
    numberOfBears = 7
    numberOfFish = 20
    numberOfPlants = 4
    numberOfBerries = 2
    worldLifeTime = 2500
    worldWidth = 50
    worldHeight = 25

    #a
    #numberOfBears = 0
    #numberOfFish = 0
    #numberOfPlants = 0
    #numberOfBerries= 0
    #worldLifeTime = 2500
    #worldWidth = 10
    #worldHeight = 10

    fishAlive = []
    bearAlive = []
    plantAlive = []
    berryAlive = []

    myworld = World(worldWidth,worldHeight)   
    myworld.draw()
    myworld.genTerrain()                               

    for i in range(numberOfFish):  
        newfish = Fish()
        x = random.randrange(myworld.getMaxX())
        y = random.randrange(myworld.getMaxY())
        while not myworld.terrainMap[x][y]=='water':
            x = random.randrange(myworld.getMaxX())
            y = random.randrange(myworld.getMaxY())
        while not myworld.emptyLocation(x,y):
            x = random.randrange(myworld.getMaxX())
            y = random.randrange(myworld.getMaxY())
        myworld.addThing(newfish,x,y)        

    for i in range(numberOfBears):   
        newbear = Bear()
        x = random.randrange(myworld.getMaxX())
        y = random.randrange(myworld.getMaxY())

        while not myworld.terrainMap[x][y]=='land':
            x = random.randrange(myworld.getMaxX())
            y = random.randrange(myworld.getMaxY())

        while not myworld.emptyLocation(x,y):   
            x = random.randrange(myworld.getMaxX())
            y = random.randrange(myworld.getMaxY())
        myworld.addThing(newbear,x,y)    
        
    for i in range(numberOfPlants):   
        newplant = Plant()
        x = random.randrange(myworld.getMaxX())
        y = random.randrange(myworld.getMaxY())

        while not myworld.terrainMap[x][y]=='water':
            x = random.randrange(myworld.getMaxX())
            y = random.randrange(myworld.getMaxY())

        while not myworld.emptyLocation(x,y):   
            x = random.randrange(myworld.getMaxX())
            y = random.randrange(myworld.getMaxY())
        myworld.addThing(newplant,x,y)      
    
    for i in range(numberOfBerries):   
        newberry = Berry()
        x = random.randrange(myworld.getMaxX())
        y = random.randrange(myworld.getMaxY())

        while not myworld.terrainMap[x][y]=='land':
            x = random.randrange(myworld.getMaxX())
            y = random.randrange(myworld.getMaxY())

        while not myworld.emptyLocation(x,y):   
            x = random.randrange(myworld.getMaxX())
            y = random.randrange(myworld.getMaxY())
        myworld.addThing(newberry,x,y)

    for i in range(worldLifeTime):     
        fishAlive.append(myworld.getFishAlive())
        #print(myworld.getFishAlive())
        bearAlive.append(myworld.getBearAlive())
        plantAlive.append(myworld.getPlantAlive())
        berryAlive.append(myworld.getBerryAlive())
        #print(myworld.grid)
        myworld.liveALittle()          
        
    myworld.freezeWorld()
    
    f = open("outfile.dat", "w")          
    print("time          fish          bears          plants          berries",file=f)
    for i in range(0,worldLifeTime):
        print("%s              %s              %s               %s                %s"%(i,fishAlive[i],bearAlive[i],plantAlive[i],berryAlive[i]),file=f)
    f.close()

    myplotter = Plotter()
    myplotter.plot('outfile.dat')

mainSimulation()