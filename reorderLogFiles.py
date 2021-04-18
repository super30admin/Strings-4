class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        output_letter = []
        output_digit = []
        def compareTo(l1,l2):
            v1 = l1.split(" ")[1:]
            v1 = " ".join(v1)
            v2 = l2.split(" ")[1:]
            v2 = " ".join(v2)
            if(v1==v2):
                if(l1>l2):
                    return 1
                else:
                    return 0
            elif(v1>v2):
                return 1
            else:
                return 0
        for i in logs:
            z = i.split(" ")
            if(z[1][0].isdigit()):
                output_digit.append(i)
            else:
                output_letter.append(i)
        
        # quicksort
        def partition(arr,start,end):
            pivot = end
            i = start
            j = start
            while(j<end):
                if(compareTo(arr[j],arr[pivot])==0):
                    arr[i],arr[j] = arr[j],arr[i]
                    i+=1
                j+=1
            arr[i],arr[pivot] = arr[pivot],arr[i]
            return i
        
        def quicksort(arr,i,j):
            if(i>j):
                return
            ind = partition(arr,i,j)
            quicksort(arr,i,ind-1)
            quicksort(arr,ind+1,j)
        
        quicksort(output_letter, 0, len(output_letter)-1)
        return output_letter + output_digit
