from time import*
from sys import *

z=0
a=[]
for i in range (0,3001):
    a=a+[i]
n=len(a)
maxsumme=-maxsize-2
von=bis=0
t1=clock()
for i in range (0,n):
    for j in range(i, n):
        summe=0
        for k in range (i,j):
            summe+=a[k]
            z+=1
        if(summe>maxsumme):
            maxsumme=summe
            von=i
            bis=j
t2=clock()
print("max. Teilsumme: "+str(maxsumme))
print("erster Index: "+str(von))
print("letzter Index: "+str(bis))
print("Additionen: "+str(z))
print(t2-t1)
        
