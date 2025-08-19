def MakeArrayConsecutive(statues):
   s=0
   statues.sort()

   for i in range(0,len(statues)-1):
    return statues[-1] - statues[0] - (len(statues) - 1)

if __name__== "__main__":
    test_statues = [6, 2, 3, 8]
    print(f"Number of additional statues needed: {MakeArrayConsecutive(test_statues)}")
    
    test_statues2 = [1, 3, 5]
    print(f"Number of additional statues needed: {MakeArrayConsecutive(test_statues2)}")