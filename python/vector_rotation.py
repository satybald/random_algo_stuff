#
# Vector Rotation
# The Problem
# Rotate vector x[n] left by d positions.
# For n=8 and d=3, change abcdefgh to defghabc. Constraints: O ( n ) time, O ( 1 ) extra space.

def shiftR(d, arr):
	tmp = arr[0]
	N = len(arr)
	for i in range(1, N):
		idx = (i + 1) % N
		arr[i] = tmp
		tmp = arr[idx]
		
	return arr

print(shiftR(1, [1,2,3,4]))
