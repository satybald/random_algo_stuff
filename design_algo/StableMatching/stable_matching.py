## @Buggy
# implementation of Stable Matching problem

k = raw_input()
while k[0] == '#':
	k = raw_input()

mpref = []
wpref = []

n = int(k)
free_man = range(n)

for idx in range(n):
	row = map(lambda x: x -1, map(int, raw_input().split(' ')))
	mpref.append([-1, row]) # tuple with highest ranging woman to whom he proposed

for idx in range(n):
	row = map(lambda x: x -1, map(int, raw_input().split(' ')))
	wpref.append([-1, row]) # current partner with its pref.

print mpref, wpref, free_man

def getRank(val, lPref):
	return lPref.index(val)

assert(getRank(1, [1, 2, 3]) == 0)
assert(getRank(2, [1, 2, 3]) == 1)
assert(getRank(3, [1, 2, 3]) == 2)

while len(free_man) > 0:
	fm_id = free_man.pop(0) # man's id
	
	# let's make a proposal
	wm_id = mpref[fm_id][0] + 1 #highest priority woman 
	feence = wpref[wm_id][0]

	if feence == -1: #free. engage!
		wpref[wm_id][0] = fm_id
		mpref[fm_id][0] = wm_id
	#not free. let's compare priorities
	elif getRank(feence, wpref[wm_id][1]) < getRank(fm_id, wpref[wm_id][1]): # unstable pair. swap
		wpref[wm_id][0] = fm_id
		mpref[fm_id][0] = wm_id	
		free_man.append(feence)			
	# else fm_id remains free

print mpref, wpref, free_man
