Anish
11:13 PM
import io, os

def predFirst(ar, i, x) :
  n = len(ar)
  if i == -1 :
    return 0
  elif i == n :
    return 1
  elif ar[i] < x :
    return 0
  return 1
  
def predLast(ar, i, x) :
  n = len(ar)
  if i == -1 :
    return 0
  elif i == n :
    return 1
  elif ar[i] <= x :
    return 0
  return 1
  

def solution(ar, x) :
  n = len(ar)
  first, last = -1, -1
  
  left, right = -1, n
  while left < right - 1 :
    mid = left + (right - left)//2
    if predFirst(ar, mid, x) == 0 :
      left = mid
    else :
      right = mid
  first = right
  
  left, right = -1, n
  while left < right - 1 :
    mid = left + (right - left)//2
    if predLast(ar, mid, x) == 0 :
      left = mid
    else :
      right = mid
  last = left
  
  return (first, last)

buf = io.BytesIO(os.read(0, os.fstat(0).st_size))
input = buf.readline
n, q = [int(i) for i in input().decode().split(" ")]
input = buf.readline
ar = [int(i) for i in input().decode().split(" ")]
for i in range(q) :
  input = buf.readline
  qr = int(input().decode())
  first, last = solution(ar, qr)
  if first == -1 or last == -1 :
    first = -1
    last = -1
  if first == n or last == n :
    first = -1
    last = -1
  print(first, last)