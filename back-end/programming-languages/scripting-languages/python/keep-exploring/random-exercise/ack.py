from __future__ import print_function, division

def ack(m,n):
    if not isinstance(m, int):
        if not isinstance(n, int):
            print('Ack is only defined for integers.')
        return None
    if( n < 0 and m < 0):
        print('Ack is not defined for negative integers.')
        return None
    if(m == 0):
        return n+1
    if(n == 0):
        return ack(m-1, 1)
    return  ack(m-1, ack(m,n-1))

print(ack(3,4))
