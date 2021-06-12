a=int(input("Enter the number: "))
b=str(bin(a))[2:]
if len(b)%2!=0:
    b=b.zfill(len(b)+1)
q=""
print("\n\n\n")
for i in range(0,len(b),2):
    print(b[i]+b[i+1],end="\t")
print()
c=2
u=b[:2]
while len(b)>0:
    j=(q+"01").zfill(c)
    for i in range(0,len(j),2):
        print(j[i]+j[i+1],end="\t")
    print()
    r=int(u,2)-int(j,2)
    if r>=0:
        jo=str(bin(r))[2:]
        p=jo.zfill(c)
        for i in range(0,len(p),2):
            print(p[i]+p[i+1],end="\t")
        b=b[2:]
        print(b[:2])
        u=jo+b[:2] 
        c+=2
        q=q+"1"
    else:
        print("negative")
        b=b[2:]
        u=u+b[:2] 
        q=q+"0"
        c+=2
        if len(u)%2!=0:
            u=u.zfill(len(u)+1)
        for i in range(0,len(u),2):
            print(u[i]+u[i+1],end="\t")    
    print()
print("Quoitient in binary = "+q)
print("Quoitient in integer = "+str(int(q,2)))
print("Remainder in binary = "+u)
print("Remainder in integer = "+str(int(u,2)))


        
        
    
    
    
    
    