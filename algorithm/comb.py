def dup_combinations(arr, r):
    result = []
    def backtrack(start, path):
        if len(path) == r:
            result.append(path[:])
            return
        for i in range(start, len(arr)):
            path.append(arr[i])
            backtrack(i, path)
            path.pop()
    backtrack(0, [])
    return result

def combinations(arr, r):
    result =  []
    def backtrack(start, path):
        if (len(path) == r):
            result.append(path[:])
            return
        for i in range(start, len(arr)):
            path.append(arr[i])
            backtrack(i + 1, path)
            path.pop()
    backtrack(0, [])
    return result
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
# result = combinations(test, 2)
result = permutations(test, 2)
print(result)
if len(result) == 12:
    print(True)
# if result == [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]:
    # print(True)
