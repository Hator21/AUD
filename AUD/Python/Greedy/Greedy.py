def ein () :
    o=1
    while o==1:
        print("Zuzahlende Summe:")
        x=input()
        try:
            x=int(x)
            o=0
        except:
            print("Das war keine Zahl!")
    return x

def be():
    o=1
    while o==1:
        print("Gegebener Betrag:")
        b=input()
        try:
            b=int(b)
            o=0
        except:
            print("Das war keine Zahl!")
    return b

def mue():
    x=0
    while x==0:
        print("Wie viele Muenzarten:")
        z=input()
        try:
            z=int(z)
            x=1
        except:
            print("Keine Zahl")
    return z
def re(z):        
    for i in range(len(z)):
        o=1
        while o==1:        
            print("Muenzwert "+str(i+1)+":")
            y=input()
            try:
                l[i][0]=int(y)                               
                o=0
            except:
                print("Das war keine Zahl!") 

    for i in range(len(z)):
        o=1
        while o==1:
            print("Muenzanzahl"+" "+str(i+1)+":")
            y=input()
            try:
                l[i][1]=int(y)              
                o=0
            except:
                print("Das war keine Zahl!")
    return l

    #1,2,5,10,20,50,100,200
def greedy(l,z,b):
    p=[0 for x in range(20)] 
    j=0
    x=0
    g=b-z
    l.sort(key=lambda k: (k[0], -k[1]), reverse=True)
    while(g!=0):
        for i in range(len(l)):
            m=0
            x=x+1
            if(x==2000):
                g=0 
            if (0<l[i][1]):
                m=l[i][0]
                if( m<=g):    
                    l[i][1]=l[i][1]-1
                    g=g-m
                    p[j]=m
                    j=j+1
                    
                    
    if(x==2000):
        print("Kein ergebnis Moeglich")
    else:
        print("Rueckgabe:")                
        for i in range(len(p)):
            if(p[i]>0):
                print(p[i])
            else:
                return 0

#--------------------------------------------------------------------------------
w=2
z=0
b=0
z=ein()
b=be()
h=mue()
l=[[0 for x in range(w)] for y in range(h)]
l=re(l)

greedy(l,z,b)

                
                
            
            
        
    