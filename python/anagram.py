"""
An Anagram Detection
"""

def _ord(st):
	return ord(st) - ord('a')

def is_anagram(input1, input2):
	if(len(input1) != len(input2)):
		return False
	
	ls1 = [0] * 26
	ls2 = [0] * 26
	for x in input1:
		ls1[_ord(x)] = ls1[_ord(x)] + 1

	for x in input2:
		ls2[_ord(x)] = ls2[_ord(x)] + 1	

	for (idx, _) in enumerate(ls1):
		if ls1[idx] != ls2[idx]:
			return False
	return True

assert is_anagram('heart', 'earth'),  'heart == earth'
assert not is_anagram('heart', 'aarth'),  'heart != aarth'