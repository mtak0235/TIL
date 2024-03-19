import sys
input = sys.stdin.readline
n, m = map(int, input().split())
dogam = dict()
chit = [0] * (n + 1)
for i in range(1, n + 1):
    name = input().strip()
    dogam[name] = i
    chit[i] = name
    pass
for j in range(m):
    quiz = input().strip()
    if quiz.isdigit():
        print(chit[int(quiz)])
    else:
        print(dogam[quiz])
    