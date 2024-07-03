n = int(input())
res = []
for _ in range(n):
    day, cost = map(int, input().split())
    res.append({'day': day, 'cost': cost})

maximum_tot_cost = 0

def rec(today, money):
    global maximum_tot_cost
    if today == n:  # 마지막 날(N+1일째)
        maximum_tot_cost = max(maximum_tot_cost, money)
        return
    if today > n:  # 퇴사일 이후
        return
    rec(today + 1, money)  # 오늘 상담을 하지 않는 경우
    if today + res[today]['day'] <= n:  # 오늘 상담을 할 수 있는 경우
        rec(today + res[today]['day'], money + res[today]['cost'])

rec(0, 0)
print(maximum_tot_cost)