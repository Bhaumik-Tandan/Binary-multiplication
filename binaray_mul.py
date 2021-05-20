from tabulate import tabulate
def fun(a,b):
    if len(b)<len(a):
        b.zfill(len(a))
    elif len(b)>len(a):
        a.zfill(len(b))
    e=0
    i=len(a)-1
    c=0
    while i>=0:
        s=(int(b[i])^int(a[i]))^c
        c=(int(b[i])&int(a[i]))|(c&(int(b[i])^int(a[i])))
        b=b[:i]+str(s)+b[i+1:]
        i-=1
    return c,b
        
o=input("19BIT0292\n1.Binary\n2.Decimal\nEnter your choice: ")
mul=input("ENTER THE MULTIPLICAND: ")
mp=input("ENTER THE MULTIPLIER: ")
if o=="2":
    mul=str(bin(int(mul)))[2:]
    mp=str(bin(int(mp)))[2:]
e=0
q=mp
tu="0"
for i in range(1,len(q)):
    tu+="0"
i=len(q)
sc=str(bin(i))[2:]
t=[["","0",tu,q,sc]]
a=tu
p=i
i-=1
while i>=0:
    sc=str(bin(i))[2:]
    i-=1
    e=0
    if q[p-1]=="1":
        e,b=fun(a,mul)
        t.append(["ADD",e,mul])
        t.append(["","",b])
        a=b
    q=a[len(a)-1]+q[:len(q)-1]
    a=str(e)+a[:len(a)-1]
    e=0
    t.append(["SHIFT",e,a,q,sc.zfill(len(str(bin(p))[2:]))])
print(tabulate(t,["OPERATION","E","A","Q","SC"]))
print("\nRESULT in BINARY= "+a+q)
print("\nRESULT in DECIMAL= "+str(int(a+q,2)))
