import sys
input = sys.stdin.readline
n, m = map(int, input().split())
s = set()
count = 0
while n:
    n-=1
    s.add(input().strip())
while m:
    m-=1
    if input().strip() in s: count+=1
print(count)
