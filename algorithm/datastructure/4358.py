import sys
from collections import defaultdict
input = sys.stdin.readline
dic = defaultdict(int)
sum = 0
got = input().strip()
while got:
    sum+=1
    dic[got]+=1
    got = input().strip()

for name, portion in sorted(dic.items()):
    print(f"{name} {round((portion * 100)  + 0.00005/ sum, 4)}")
    
for name, portion in sorted(dic.items()):
    print(name, '%.4f' % (dic[name]*100 / sum))

# 소수점 자릿수 5번쨰가 5일 때
# 소수점 자릿수 4번째가 (홀수/짝수)일 경우 (버림/올림)이 일어난다
# %: 
#     홀수:버림
#     짝수:버림
# round
#     홀수:버림
#     짝수:버림

# 5번쨰가 6일 때
# 소수점 자릿수 4번째가 (홀수/짝수)일 경우 (버림/올림)이 일어난다
# %: 
#     홀수:올림
#     짝수:올림
# round
#     홀수:올림
#     짝수:올림
    