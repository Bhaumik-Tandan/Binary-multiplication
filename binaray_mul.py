from tabulate import tabulate
def fun(a,b):
    if len(b)<len(a):
        b=b.zfill(len(a))
    elif len(b)>len(a):
        a=a.zfill(len(b))
    e=0
    i=len(a)-1
    c=0
    while i>=0:
        s=(int(b[i])^int(a[i]))^c
        c=(int(b[i])&int(a[i]))|(c&(int(b[i])^int(a[i])))
        b=b[:i]+str(s)+b[i+1:]
        i-=1
    return c,b
f=1      
o=input("19BIT0292\n1.Binary\n2.Decimal\nEnter your choice: ")
mul=input("ENTER THE MULTIPLICAND: ")
mp=input("ENTER THE MULTIPLIER: ")
if o=="2":
    mul=int(mul)
    mp=int(mp)
    if mul<0:
        mul*=-1
        f*=-1
    if mp<0:
        mp*=-1
        f*=-1
    mul=str(bin(mul))[2:]
    mp=str(bin(mp))[2:]
e=0
q=mp
a="0"
for i in range(1,len(q)):
    a+="0"
i=len(q)
sc=str(bin(i))[2:]
t=[["","0",a,q,sc]]
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
if f==1:
    print("\nRESULT in BINARY= "+a+q)
    print("\nRESULT in DECIMAL= "+str(int(a+q,2)))
else:
    s=list(a+q)
    for i in range(len(s)):
        if s[i]=="0":
         s[i]="1"
        else:
         s[i]="0"
    _,s=fun(s,"1")
    print("\nRESULT in BINARY= "+s)
    print("\nRESULT in DECIMAL= "+str(int(a+q,2)*-1))
