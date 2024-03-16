# time out
# import queue
# q = queue.Queue()
# for i in range(1,int(input()) + 1):
#     q.put(i)
# while q.qsize()!= 1:
#     q.get()
#     if q.qsize() == 1: break
#     q.put(q.get())
# print(q.get())

from collections import deque
q = deque(range(1,int(input()) + 1))
while len(q) != 1:
    q.popleft()
    # if len(q) == 1:break #시간이 단축
    q.append(q.popleft())
print(q.popleft())
