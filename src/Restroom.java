/**
 *  Title:           Bathroom Stall Selection
 *  @author          Matthew Hall
 *
 *  This program uses an array of boolean values to indicate
 *  if a stall is occupied. The purpose of this program is to find
 *  the middle of the largest section of unoccupied stalls
 */

/**
   A class that shows how restroom stalls are occupied.
*/

public class Restroom
{
   private boolean[] isStallOccupied;
   private int numOfStalls;
   public int selectedSeat;

   /**
      Constructs a restroom with a given number of stalls.
      @param ns the number of stalls
   */
   public Restroom(int ns)
   {
      numOfStalls = ns;
      isStallOccupied = new boolean[numOfStalls];
      for (int i = 0; i < numOfStalls; ++i) {
         isStallOccupied[i] = false;
      }
   }

   /*
      Adds an occupant in the middle of the longest sequence of
      unoccupied places. 
   */
   public void addOccupant() {
      int mostConsecutiveSpaces = 0; // This variable will reset each time
      int combinedIndexValue = 0; // This variable will reset each time
      int maxSpaces = 0; // This variable will reset each time
      int maxTotalIndex = 0; // This variable will reset each time
      for (int i = 0; i < numOfStalls; i++) { // This for loop is here to iterate through each one of the stalls
         if (isStallOccupied[i] == false) { //Checking if a stall is occupied/ false
            ++mostConsecutiveSpaces; // Counting the number of spaces which are empty
            combinedIndexValue += i; // Adding the index value of the spaces

         }
         if (mostConsecutiveSpaces == numOfStalls) { // This part updates the max consecutive spaces
            maxSpaces = mostConsecutiveSpaces;
            maxTotalIndex = combinedIndexValue;
         } else if (isStallOccupied[i] == true) {
            if (mostConsecutiveSpaces > maxSpaces) {
               maxSpaces = mostConsecutiveSpaces;
               maxTotalIndex = combinedIndexValue;
               mostConsecutiveSpaces = 0; // This is reset after updating the maxSpaces
               combinedIndexValue = 0; // This is reset after updating the maxTotalIndex
            } else {
               mostConsecutiveSpaces = 0;
               combinedIndexValue = 0;
            }
         } else if (i == numOfStalls - 1) { // This accounts for the last stall in the list
            if (mostConsecutiveSpaces > maxSpaces) {
               maxSpaces = mostConsecutiveSpaces;
               maxTotalIndex = combinedIndexValue;
               mostConsecutiveSpaces = 0;
               combinedIndexValue = 0;
            }
         }
      }
         selectedSeat = Math.ceilDiv(maxTotalIndex, maxSpaces); // This divides total index value by the counted stalls
         isStallOccupied[selectedSeat] = true; // This updates the stalls to being occupied
   }
   /*
      Gets a string describing the current stall occupation
      @return a string with _ for an empty stall and X for an occupied one
   */
      public String getStalls ()
      {
         String result = ""; // This returns a _ if the stall is empty and X for a stall that is occupied
         for (int i = 0; i < numOfStalls; i++) {
            if (isStallOccupied[i] == true) {
               result += "X";
            } else if (isStallOccupied[i] == false) {
               result += "_";
            }
         }
         return result;
      }

   }