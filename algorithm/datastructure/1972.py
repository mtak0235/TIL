
while True:
    got = input()
    if got == "*":break
    n = len(got)
    def isSurprising():
        result = True
        for i in range(0, n-1):
            d = {}
            for f in range(0, n - 1 - i):
                cand = got[f] + got[f + i + 1]
                if cand in d:
                    return False
                d[cand] = 0
        return True
    if isSurprising():
        print(f"{got} is surprising.")
    else:
        print(f"{got} is NOT surprising.")