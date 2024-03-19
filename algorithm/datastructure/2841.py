from collections import deque
n, p = map(int, input())
cnt = 0
guitar = {_:deque() for _ in range(1,7)}
for _ in range(n):
	ln, fn = map(int, input())
	line = guitar[ln]
	#top에 있는게 없거나 나보다 낮으면 push
	if len(line) == 0 or line[0] < fn:
	#top에 있는게 나보다 높으면
	#	top에 있는게 없거나 나보다 낮을 때 까지 pop
	#	나를 push
	