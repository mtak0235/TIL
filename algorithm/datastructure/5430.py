from collections import deque
cases = int(input())
while cases:
    cases -= 1
    ops = input()
    arr_length = int(input())
    got =  input().strip('[]').split(',')
    if got[0] == '':
        print("error")
        continue
    arr = deque(map(int,got))
    direction = True
    for op in ops:
        if op == 'R':
            direction = not direction
        elif op == 'D':
            if len(arr) == 0:
                print("error")
                break
            if direction:
                arr.popleft()
            else:
                arr.pop()
    to_print = "["+",".join([str(arr.popleft() if direction else arr.pop()) for _ in range(len(arr))]) + "]"
    print(to_print)


