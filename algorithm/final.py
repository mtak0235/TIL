
def permutations(arr, r):
    result = []
    visited = [False] * len(arr)
    def backtrack(path):
        if len(path) == r:
            result.append(path[:])
            return
        for i in range(len(arr)):
            if not visited[i]:
                visited[i] = True
                path.append(arr[i])
                backtrack(path)
                path.pop()
                visited[i] = False
    backtrack([])
    return result

test = [1,2,3,4]
permu = permutations(test, 2)
print(permu)


def combinations(arr, r):
    result = []
    def backtrack(start, path):
        if len(path) == r:
            result.append(path[:])
            return
        for i in range(start, len(arr)):
            path.append(arr[i])
            backtrack(i + 1, path)
            path.pop()
        return result
    backtrack(0, [])
    return result
comb = combinations(test, 2)
print(comb)