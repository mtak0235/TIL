import heapq
_list = [32, 16, 54, 94, 81, 31]
heapq.heapify(_list)
print(_list)

heapq.heappush(_list, 7)
print(_list)
print(heapq.heappop(_list))
print(_list)
print(heapq.heappushpop(_list, 100))
print(_list)
small_elements = heapq.nsmallest(4, _list)
print(small_elements)

large_element = heapq.nlargest(4, _list)
print(large_element)

