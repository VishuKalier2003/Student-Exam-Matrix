/* Given a m * n matrix seats  that represent seats distributions in a classroom. If a seat is broken, it is denoted 
by '#' character otherwise it is denoted by a '.' character. Students can see the answers of those sitting next to 
the left, right, upper left and upper right, but he cannot see the answers of the student sitting directly in front 
or behind him. Return the maximum number of students that can take the exam together without any cheating being 
possible. Students must be placed in seats in good condition. 
* Eg 1 : seats = [['#','.','#','#','.','#'],['.','#','#','#','#','.'],                Output = 4  
*                 ['#','.','#','#','.','#']]                                                      
* Eg 2 : seats = [[".","#"],["#","#"],["#","."],["#","#"],[".","#"]]                  Output = 3  
* Eg 3 : seats = [["#",".",".",".","#"],[".","#",".","#","."],[".",".","#",".","."],  Output = 10 
*                [".","#",".","#","."],["#",".",".",".","#"]]                                     
*/
public class StudentExam
{
      public int MaximumStudentsThatCanGiveExam(char seats[][])
      {
            int colsEven = 0, colsOdd = 0;    //* Variable to store students Column Wise -> O(1)
            for(int i = 0; i < seats[0].length; i++)    //! Grid Traversal -> O(N x M)
            {
                  for(int j = 0; j < seats.length; j++)
                  {
                        if(i % 2 == 0)    // If the column is even...
                              colsEven = colsEven + ((seats[j][i] == '.') ? 1 : 0);   // Conditional Increment...
                        else              // If the column is odd...
                              colsOdd = colsOdd + ((seats[j][i] == '.') ? 1 : 0);   // Conditional Increment...
                  }
            }
            int oddRows = 0, evenRows = 0;              //* Variable to store studenst Row Wise -> O(1)
            for(int i = 0; i < seats.length; i++)    //! Grid Traversal -> O(N x M)
            {
                  int j = 1;          // Setting the starting index as 1...
                  while((j < seats[0].length) && (i % 2 == 0))  // For Even Rows...
                  {
                        if((seats[i][j] == '#') && (seats[i][j - 1] == '.'))
                        {     // If two students can be placed after a gap...
                              evenRows++;
                              j += 2;      // Increment index by two...
                        }
                        else if((seats[i][j] == '.') && (seats[i][j - 1] == '#'))
                        {     // If two students can be placed after a gap...
                              evenRows++;
                              j += 2;        // Increment index by two...
                        }
                        else  j++;     // Else increase the index by 1...
                  }
                  while((j < seats[0].length) && (i % 2 != 0))   // For Odd Rows...
                  {
                        if((seats[i][j] == '#') && (seats[i][j - 1] == '.'))
                        {    // If two students can be placed after a gap...
                              oddRows++;
                              j += 2;        // Increment index by two...
                        }
                        else if((seats[i][j] == '.') && (seats[i][j - 1] == '#'))
                        {     // If two students can be placed after a gap...
                              oddRows++;
                              j += 2;         // Increment index by two...
                        }
                        else  j++;      // Otherwise, increase the index by 1...
                  }
            }
            // Returning the Maximum value variable among the four variables...
            return Math.max(Math.max(oddRows, evenRows), Math.max(colsEven, colsOdd));   // Nested Max Statement...
      }
      public static void main(String args[])
      {
            //? Test Case - I
            char seat1[][] = {{'#','.','#','#','.','#'}, {'.','#','#','#','#','.'},
                              {'#','.','#','#','.','#'}};
            //? Test Case - II
            char seat2[][] = {{'.','#'}, {'#','#'}, {'.','#'}, {'#','#'}, {'.','#'}};
            //? Test Case - III
            char seat3[][] = {{'#','.','.','.','#'}, {'.','#','.','#','.'}, {'.','.','#','.','.'},
                              {'.','#','.','#','.'}, {'#','.','.','.','#'}};
            StudentExam studentExam = new StudentExam();     // Object creation...
            System.out.println("(Test Case 1) : Maximum Students : "+studentExam.MaximumStudentsThatCanGiveExam
            (seat1));           // Function call...
            System.out.println("(Test Case 2) : Maximum Students : "+studentExam.MaximumStudentsThatCanGiveExam
            (seat2));           // Function call...
            System.out.println("(Test Case 3) : Maximum Students : "+studentExam.MaximumStudentsThatCanGiveExam
            (seat3));           // Function call...
      }
}



//! Time Complexity -> O(N x M)
//* Space Complexity -> O(1)