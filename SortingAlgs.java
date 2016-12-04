// Sorting Algorithms class
// Frank Serrano

public class SortingAlgs 
{
    // card comparison
    public int compares(Card c1, Card c2)
    {
		// TODO: implement this method
      if (c1.getSuit() < c2.getSuit())
         return -1;
      if (c1.getSuit() > c2.getSuit())
         return 1;
    
      if (c1.getRank() < c2.getRank())
         return -1;
      if (c1.getRank() > c2.getRank())
         return 1;
          
      return 0;
    }
    
    // selection sort
    public void selectionSort(Card[] cardArray)
    {
        // TODO: implement this method
        int endIndex = cardArray.length - 1;
        int i;
        Card tempCard;
        int tempIndex;
        
        for (i = 0; i <= endIndex; i++)
        {
            tempCard = cardArray[i];                                                            ;
            tempIndex = minIndex(cardArray, i, endIndex);
            
            cardArray[i] = cardArray[tempIndex];
            cardArray[tempIndex] = tempCard;
        }
    }
    
    // method that finds the index of the smallest element in the specified range
    public int minIndex(Card[] cardArray, int startIndex, int endIndex)
    {
        // TODO: implement this method
        int i;
        int minIndex = startIndex;
        
        for (i = startIndex; i <= endIndex; i++)
        {
            if (compares(cardArray[i], cardArray[minIndex]) == -1)
            {
                  minIndex = i;
            }
            
        }
        
        return minIndex;
    }    

    // merge sort
    public void mergeSort(Card[] cardArray)
    {
        mergeSortRec(cardArray, 0, cardArray.length - 1);
    } 
    
    // merge sort helper recursive method
    public void mergeSortRec(Card[] cardArray, int startIndex, int endIndex)
    {
        if (startIndex < endIndex)
        {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSortRec(cardArray, startIndex, midIndex);
            mergeSortRec(cardArray, midIndex + 1, endIndex);
            merge(cardArray, startIndex, endIndex);
        }
    } 
    
    // method that merges two sorted halves into one sorted array
    public void merge(Card[] cardArray, int startIndex, int endIndex)
    {        
		// TODO: implement this method
         Card[] tempArray = new Card[endIndex - startIndex + 1];
         int leftFirst = startIndex;
         int leftLast = (startIndex + endIndex) / 2;
         int rightFirst = (startIndex + endIndex) / 2 + 1;
         int rightLast = endIndex;
         int i = 0;
         int j = 0;
         
         while ((leftFirst <= leftLast) && (rightFirst <= rightLast))
         {
               if (compares(cardArray[leftFirst], cardArray[rightFirst]) == -1)
               {
                     tempArray[i] = cardArray[leftFirst];
                     leftFirst++;
               }
               else
               {
                     tempArray[i] = cardArray[rightFirst];
                     rightFirst++;
               }
               i++;
         }
         
         while (leftFirst <= leftLast)
         {
               tempArray[i] = cardArray[leftFirst];
               leftFirst++;
               i++;
         }
         
         while (rightFirst <= rightLast)
         {
               tempArray[i] = cardArray[rightFirst];
               rightFirst++;
               i++;
         }
         
         
         for (i = startIndex; i <= endIndex; i++)
         {
               cardArray[i] = tempArray[j];
               j++;
         }
              
    }  
}
