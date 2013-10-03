#################################
# CS260-03 LAB2					#
# Dave Nearing					#
# September 04,2013				#
#################################

alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']

def rot13(message):
	message = message.lower()
	textArray = list(message)
	cipherOut = []
	for i in range(0,len(textArray)):
		if textArray[i] in alpha:
			indexNumber=alpha.index(textArray[i])+13
			if indexNumber>25:
				indexNumber=indexNumber-26
				cipherOut.append(alpha[indexNumber])
			else:
				cipherOut.append(alpha[indexNumber])
		else:
			cipherOut.append(textArray[i])
	cipherText = ''.join(cipherOut)
	return(cipherText)

def rotEncrypt(msg,num):
	msg = msg.lower()
	textArray = list(msg)
	cipherOut = []
	for i in range(0,len(textArray)):
		if textArray[i] in alpha:
			indexNumber=alpha.index(textArray[i])+num
			if indexNumber>25:
				indexNumber=indexNumber-26
				cipherOut.append(alpha[indexNumber])
			else:
				cipherOut.append(alpha[indexNumber])
		else:
			cipherOut.append(textArray[i])
	cipherText = ''.join(cipherOut)
	return(cipherText)

def rotDecrypt(msg,num):
	return(rotEncrypt(msg,-num))

#Testing Block
def main():
	#print(rot13('Hello, My Name Is Dave.'))
	#print(rotDecrypt('uryyb, zl anzr vf qnir.',13))
	print(rotEncrypt("It so chanced, that after the Parsee's disappearance, I was he whom the Fates ordained to take the place of Ahab's bowsman, when that bowsman assumed the vacant post; the same, who, when on the last day the three men were tossed from out of the rocking boat, was dropped astern. So, floating on the margin of the ensuing scene, and in full sight of it, when the halfspent suction of the sunk ship reached me, I was then, but slowly, drawn towards the closing vortex. When I reached it, it had subsided to a creamy pool. Round and round, then, and ever contracting towards the button-like black bubble at the axis of that slowly wheeling circle, like another Ixion I did revolve. Till, gaining that vital centre, the black bubble upward burst; and now, liberated by reason of its cunning spring, and, owing to its great buoyancy, rising with great force, the coffin life-buoy shot lengthwise from the sea, fell over, and floated by my side. Buoyed up by that coffin, for almost one whole day and night, I floated on a soft and dirgelike main. The unharming sharks, they glided by as if with padlocks on their mouths; the savage sea-hawks sailed with sheathed beaks. On the second day, a sail drew near, nearer, and picked me up at last. It was the devious-cruising Rachel, that in her retracing search after her missing children, only found another orphan.",5))
	#print(rotDecrypt('mjqqt, rd sfrj nx ifaj.',5))

main()



