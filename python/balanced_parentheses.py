"""
Balanced Parentheses
"""
def is_balanced(input):
	plist = filter(lambda x: len(x) != 0, input.split(' '))
	que = []

	for x in plist:
		if x == '(':
			que.append(x)
		elif x == ')':
			if len(que) == 0:
				return False			
			s = que.pop()
			if(s != '('):
				return False
		else:
			raise 'Unexpected symbol' 
	return len(que) == 0

assert is_balanced("( ) ( )")
assert is_balanced("( ( ) ( ) )")
assert not is_balanced("( ( ) ) ( ) ( ) )")
assert not is_balanced("( ( ) ( ) ( ( )")
assert is_balanced("( ( ) ( ( ( ) ) ( ) ) )")
assert is_balanced("( ( ( ( ) ) ) )")

