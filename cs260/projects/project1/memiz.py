#########################################
#										#
# Dave Nearing								#
# CS 260, Project 1						#
# Due September 27, 2013				#
#										#
# Making Fibonacci shorter by using		#
# memoization.							#
#########################################
d = {}
global e
e = []

def fib_M(n):
	global e
	e.append(1)

	if n<2:
		d[n]=n
	else:
		if (n-2) in d.keys():
			d[n]= d[n-2]+d[n-1]

def fib_R(n):
	global e
	e.append(1)
	if n<2:
		return n
	else:
		return ((fib_R(n-2))+(fib_R(n-1)))

def main():
	f=open('./Fiblog','w+')
	global e
	problemSize=37
	print("Recursive:", file=f)
	print("%12s%15s" % ("Term", "Iterations"),file=f)
	for n in range(0,problemSize):
		fib_R(n)
		print("%d,%d" % (n, len(e)),file=f)

	e = []

	problemSize=1000
	print()
	print("Memoized:",file=f)
	print("%12s%15s" % ("Term", "Iterations"),file=f)
	for n in range(0,problemSize):
		fib_M(n)
		print("%d,%d" % (n,len(e)),file=f)

main()