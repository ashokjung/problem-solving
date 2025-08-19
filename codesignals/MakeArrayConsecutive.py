def MakeArrayConsecutive(statues):
   s=0
   statues.sort()

   for i in range(0,len(statues)-1):
       s+=statues[i+1]-statues[i]-1
   return s

if __name__== "__main__":
    test_statues = [6, 2, 3, 8]
    print(f"Number of additional statues needed: {MakeArrayConsecutive(test_statues)}")
    
    test_statues2 = [1, 3, 5]
    print(f"Number of additional statues needed: {MakeArrayConsecutive(test_statues2)}")