from collections import deque
t = int(input())
while t:
    t -= 1
    p = input()
    dq_length = int(input())
    got =  input().strip('[]').split(',')
    dq = deque(map(int,filter(lambda x: x != "",got)))
    flag = True
    direction = True
    for op in p:
        if op == 'R':
            direction = not direction
        elif len(dq) == 0:
                print("error")
                flag = False
                break
        else: 
            if direction:
                dq.popleft()
            else:
                dq.pop()
    if not flag:continue
    to_print = ""
    if direction:
        to_print = str(list(dq)).replace(" ", "")
    else:
        to_print = str(list(dq)[::-1]).replace(" ", "")
    print(to_print)