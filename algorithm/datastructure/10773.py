import sys
input = sys.stdin.readline
book = []
k = int(input())
for _ in range(k):
    got = int(input())
    if got == 0:
        book.pop()
        continue
    book.append(got)
print(sum(book))