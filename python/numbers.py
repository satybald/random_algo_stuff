""" Greatest common divisor of a and b
        Using Euclid's algorithm
"""
def gcd(a, b):
	print(a,b)
	if(a == 0):
		return b
	elif(b == 0):
		return a
	else:
		gcd(b, a % b)

if __name__ == '__main__':
	print(gcd(270, 192))
