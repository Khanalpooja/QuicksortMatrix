import random 
  
# Initializing list  
li = list(range(100)) 

random.shuffle(li)
for i in range(0, len(li)): 
    print (li[i], end=" ") 
print("\r") 
