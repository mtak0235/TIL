import sys
input = sys.stdin.readline
n, p = map(int, input().split())
cnt = 0
guitar = {_:[] for _ in range(1,7)}
for _ in range(n):
	ln, fn = map(int, input().split())
	line = guitar[ln]
	if len(line) == 0 or line[-1] < fn:
		line.append(fn)
		cnt += 1
	elif line[-1] > fn:
		line.pop()
		cnt += 1
		while not (len(line) == 0 or line[-1] <= fn):
			line.pop()
			cnt+=1
		if len(line) != 0 and line[-1] == fn: continue
		line.append(fn)
		cnt+=1
print(cnt)