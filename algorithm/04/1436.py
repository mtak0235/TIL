n = int(input())
res = []
for _ in range(n):
	day, cost = map(int, input().split())
	res.append({'day':day, 'cost':cost})
maximum_tot_cost = 0
def rec(today, remain, money):
	global maximum_tot_cost
	print(f"today:{today}")
	if today == n: # 마지막 근무날
		if remain == 0:
			maximum_tot_cost = max(maximum_tot_cost, money)
		print(f"maximum:{maximum_tot_cost}")
		return
	if remain <= 0: #현재 진행중인 상담이 없는 경우
		rec(today + 1, res[today]['day'] - 1,money + res[today]['cost'])
	rec(today + 1, remain - 1, money)
rec(0, 0, 0)
print(maximum_tot_cost)