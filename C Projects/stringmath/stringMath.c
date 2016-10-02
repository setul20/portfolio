#include <stdio.h>
#include <stdlib.h>



int main()
{
  //variables
  int inputloop = 1, i, j, opvalid = 0, firstvalid = 0, secondvalid = 0, k, l, m;
  char operator;

  //introduction to the program
  printf("Welcome to a String Math Program!\n");
  printf("To use this program you can enter a string plus any of these \nfour operators (+,*,/,-) followed by another string.\n");
  printf("It should be in this format: abc+def   \nThank You! Have fun! :)\n");

  //the main loop for inputs
  while(inputloop)
  {
    //variables needed in the loop
    char mainstring[70], stringone[70], secondstring[70], tempstring[70], finalstring[70], dstring[70],dfinalstring[70];

    //prompt to inter an input
    printf("Enter Input: ");
    scanf("%s", mainstring);

    //going through and checking if there is an valid operator
    for (i = 0; i <= 70; i++)
    {
      if (mainstring[i] == '+' || mainstring[i] == '-' || mainstring[i] == '*' || mainstring[i] == '/')
      {
        operator = mainstring[i];
        opvalid = 1;
        break;
      }

    }

    //setting the first part till the operator to another string
    j = 0;
    while(mainstring[j] != operator)
    {
      if (mainstring[j] >= 'a' && mainstring[j] <= 'z')
      {
        stringone[j] = mainstring[j];
        j++;
        firstvalid = 1;
      }
      //else
      //{
        //printf("You entered an illegal character!\n");
        //break;
      //}
    }

    //setting the second part after the operator to another string
    l = 0;
    i++;
    while (mainstring[i] != '\0')
    {
      if (mainstring[i] >= 'a' && mainstring[i] <= 'z')
      {
        secondstring[l] = mainstring[i];
        i++;
        l++;
        secondvalid = 1;
      }
      //else
      //{
        //printf("You entered an illegal character!\n");
        //break;
      //}
    }


    //if(opvalid != '1')
    //{
      //printf("You have entered a wrong operator!\n");
    //}
    //else if(opvalid != '1' && firstvalid != '1' && secondvalid != '1')
    //{
      //printf("The format of the string you entered is wrong!\n");
    //}

    //for loop that will do all the manipulations
    for (k =0; mainstring[k] != '\0'; k++)
    {
      //manipulations for pluses
      if(operator == '+')
      {
        tempstring[k] = (stringone[k]-96) + (secondstring[k]-96);

        //checks if its inside the lowercase letters
        if (tempstring[k] > 0 && tempstring[k] <= 26)
        {
          tempstring[k] = tempstring[k] + 96;
          finalstring[k] = tempstring[k];
        }
        else
        {
          if(stringone[k] == 'a')
          {
            finalstring[k] = 'A';
          }
          if(stringone[k] == 'b')
          {
            finalstring[k] = 'B';
          }
          if(stringone[k] == 'c')
          {
            finalstring[k] = 'C';
          }
          if(stringone[k] == 'd')
          {
            finalstring[k] = 'D';
          }
          if(stringone[k] == 'e')
          {
            finalstring[k] = 'E';
          }
          if(stringone[k] == 'f')
          {
            finalstring[k] = 'F';
          }
          if(stringone[k] == 'g')
          {
            finalstring[k] = 'G';
          }
          if(stringone[k] == 'h')
          {
            finalstring[k] = 'H';
          }
          if(stringone[k] == 'i')
          {
            finalstring[k] = 'I';
          }
          if(stringone[k] == 'j')
          {
            finalstring[k] = 'J';
          }
          if(stringone[k] == 'k')
          {
            finalstring[k] = 'K';
          }
          if(stringone[k] == 'l')
          {
            finalstring[k] = 'L';
          }
          if(stringone[k] == 'm')
          {
            finalstring[k] = 'M';
          }
          if(stringone[k] == 'n')
          {
            finalstring[k] = 'N';
          }
          if(stringone[k] == 'o')
          {
            finalstring[k] = 'O';
          }
          if(stringone[k] == 'p')
          {
            finalstring[k] = 'P';
          }
          if(stringone[k] == 'q')
          {
            finalstring[k] = 'Q';
          }
          if(stringone[k] == 'r')
          {
            finalstring[k] = 'R';
          }
          if(stringone[k] == 's')
          {
            finalstring[k] = 'S';
          }
          if(stringone[k] == 't')
          {
            finalstring[k] = 'T';
          }
          if(stringone[k] == 'u')
          {
            finalstring[k] = 'U';
          }
          if(stringone[k] == 'v')
          {
            finalstring[k] = 'V';
          }
          if(stringone[k] == 'w')
          {
            finalstring[k] = 'W';
          }
          if(stringone[k] == 'x')
          {
            finalstring[k] = 'X';
          }
          if(stringone[k] == 'y')
          {
            finalstring[k] = 'Y';
          }
          if(stringone[k] == 'z')
          {
            finalstring[k] = 'Z';
          }
        }
      }
      //manipulations for minuses
      else if (operator == '-')
      {
        tempstring[k] = (stringone[k]-96) - (secondstring[k]-96);


        if (tempstring[k] > 0 && tempstring[k] <= 26)
        {
          tempstring[k] = tempstring[k] + 96;
          finalstring[k] = tempstring[k];
        }
        //else if (k == j && j > l)
        //{
          //finalstring[k] = stringone[k];
          //printf("%s\t%s", finalstring, stringone);
          //break;
        //}
        else
        {
          if (k == j && j > l)
          {
            finalstring[k] = stringone[k];
          }
          if(stringone[k] == 'a')
          {
            finalstring[k] = 'A';
          }
          if(stringone[k] == 'b')
          {
            finalstring[k] = 'B';
          }
          if(stringone[k] == 'c')
          {
            finalstring[k] = 'C';
          }
          if(stringone[k] == 'd')
          {
            finalstring[k] = 'D';
          }
          if(stringone[k] == 'e')
          {
            finalstring[k] = 'E';
          }
          if(stringone[k] == 'f')
          {
            finalstring[k] = 'F';
          }
          if(stringone[k] == 'g')
          {
            finalstring[k] = 'G';
          }
          if(stringone[k] == 'h')
          {
            finalstring[k] = 'H';
          }
          if(stringone[k] == 'i')
          {
            finalstring[k] = 'I';
          }
          if(stringone[k] == 'j')
          {
            finalstring[k] = 'J';
          }
          if(stringone[k] == 'k')
          {
            finalstring[k] = 'K';
          }
          if(stringone[k] == 'l')
          {
            finalstring[k] = 'L';
          }
          if(stringone[k] == 'm')
          {
            finalstring[k] = 'M';
          }
          if(stringone[k] == 'n')
          {
            finalstring[k] = 'N';
          }
          if(stringone[k] == 'o')
          {
            finalstring[k] = 'O';
          }
          if(stringone[k] == 'p')
          {
            finalstring[k] = 'P';
          }
          if(stringone[k] == 'q')
          {
            finalstring[k] = 'Q';
          }
          if(stringone[k] == 'r')
          {
            finalstring[k] = 'R';
          }
          if(stringone[k] == 's')
          {
            finalstring[k] = 'S';
          }
          if(stringone[k] == 't')
          {
            finalstring[k] = 'T';
          }
          if(stringone[k] == 'u')
          {
            finalstring[k] = 'U';
          }
          if(stringone[k] == 'v')
          {
            finalstring[k] = 'V';
          }
          if(stringone[k] == 'w')
          {
            finalstring[k] = 'W';
          }
          if(stringone[k] == 'x')
          {
            finalstring[k] = 'X';
          }
          if(stringone[k] == 'y')
          {
            finalstring[k] = 'Y';
          }
          if(stringone[k] == 'z')
          {
            finalstring[k] = 'Z';
          }
        }//inside else
      }//else
      //manipulations for multiplications
      else if(operator == '*')
      {
        tempstring[k] = (stringone[k]-96) * (secondstring[k]-96);


        if (tempstring[k] > 0 && tempstring[k] <= 26)
        {
          tempstring[k] = tempstring[k] + 96;
          finalstring[k] = tempstring[k];
        }
        else
        {
          if(stringone[k] == 'a')
          {
            finalstring[k] = 'A';
          }
          if(stringone[k] == 'b')
          {
            finalstring[k] = 'B';
          }
          if(stringone[k] == 'c')
          {
            finalstring[k] = 'C';
          }
          if(stringone[k] == 'd')
          {
            finalstring[k] = 'D';
          }
          if(stringone[k] == 'e')
          {
            finalstring[k] = 'E';
          }
          if(stringone[k] == 'f')
          {
            finalstring[k] = 'F';
          }
          if(stringone[k] == 'g')
          {
            finalstring[k] = 'G';
          }
          if(stringone[k] == 'h')
          {
            finalstring[k] = 'H';
          }
          if(stringone[k] == 'i')
          {
            finalstring[k] = 'I';
          }
          if(stringone[k] == 'j')
          {
            finalstring[k] = 'J';
          }
          if(stringone[k] == 'k')
          {
            finalstring[k] = 'K';
          }
          if(stringone[k] == 'l')
          {
            finalstring[k] = 'L';
          }
          if(stringone[k] == 'm')
          {
            finalstring[k] = 'M';
          }
          if(stringone[k] == 'n')
          {
            finalstring[k] = 'N';
          }
          if(stringone[k] == 'o')
          {
            finalstring[k] = 'O';
          }
          if(stringone[k] == 'p')
          {
            finalstring[k] = 'P';
          }
          if(stringone[k] == 'q')
          {
            finalstring[k] = 'Q';
          }
          if(stringone[k] == 'r')
          {
            finalstring[k] = 'R';
          }
          if(stringone[k] == 's')
          {
            finalstring[k] = 'S';
          }
          if(stringone[k] == 't')
          {
            finalstring[k] = 'T';
          }
          if(stringone[k] == 'u')
          {
            finalstring[k] = 'U';
          }
          if(stringone[k] == 'v')
          {
            finalstring[k] = 'V';
          }
          if(stringone[k] == 'w')
          {
            finalstring[k] = 'W';
          }
          if(stringone[k] == 'x')
          {
            finalstring[k] = 'X';
          }
          if(stringone[k] == 'y')
          {
            finalstring[k] = 'Y';
          }
          if(stringone[k] == 'z')
          {
            finalstring[k] = 'Z';
          }
        }
      }//else
      //manipulations for devisions
      else if(operator == '/')
      {
        tempstring[k] = (stringone[k]-96) / (secondstring[k]-96);


        if (tempstring[k] > 0 && tempstring[k] <= 26)
        {
          tempstring[k] = tempstring[k] + 96;
          dstring[k] = tempstring[k];
        }
        else
        {
          if(stringone[k] == 'a')
          {
            dstring[k] = 'A';
          }
          if(stringone[k] == 'b')
          {
            dstring[k] = 'B';
          }
          if(stringone[k] == 'c')
          {
            dstring[k] = 'C';
          }
          if(stringone[k] == 'd')
          {
            dstring[k] = 'D';
          }
          if(stringone[k] == 'e')
          {
            dstring[k] = 'E';
          }
          if(stringone[k] == 'f')
          {
            dstring[k] = 'F';
          }
          if(stringone[k] == 'g')
          {
            dstring[k] = 'G';
          }
          if(stringone[k] == 'h')
          {
            dstring[k] = 'H';
          }
          if(stringone[k] == 'i')
          {
            dstring[k] = 'I';
          }
          if(stringone[k] == 'j')
          {
            dstring[k] = 'J';
          }
          if(stringone[k] == 'k')
          {
            dstring[k] = 'K';
          }
          if(stringone[k] == 'l')
          {
            dstring[k] = 'L';
          }
          if(stringone[k] == 'm')
          {
            dstring[k] = 'M';
          }
          if(stringone[k] == 'n')
          {
            dstring[k] = 'N';
          }
          if(stringone[k] == 'o')
          {
            dstring[k] = 'O';
          }
          if(stringone[k] == 'p')
          {
            dstring[k] = 'P';
          }
          if(stringone[k] == 'q')
          {
            dstring[k] = 'Q';
          }
          if(stringone[k] == 'r')
          {
            dstring[k] = 'R';
          }
          if(stringone[k] == 's')
          {
            dstring[k] = 'S';
          }
          if(stringone[k] == 't')
          {
            dstring[k] = 'T';
          }
          if(stringone[k] == 'u')
          {
            dstring[k] = 'U';
          }
          if(stringone[k] == 'v')
          {
            dstring[k] = 'V';
          }
          if(stringone[k] == 'w')
          {
            dstring[k] = 'W';
          }
          if(stringone[k] == 'x')
          {
            dstring[k] = 'X';
          }
          if(stringone[k] == 'y')
          {
            dstring[k] = 'Y';
          }
          if(stringone[k] == 'z')
          {
            dstring[k] = 'Z';
          }
        }
      }
    }//forloop

    //if it was devision than it makes another final string to put its results
    if (operator == '/')
    {
      for (m = 0; m <= j-1; m++)
      {
        dfinalstring[m] = dstring[m];
      }
    }

    if(opvalid != 1)
    {
      printf("You entered an invalid operator!");
    }

    //prints the right output depending on whether it was devision or not
    if(operator == '/')
    {
      printf("%s %c %s => %s\n",stringone, operator, secondstring, dfinalstring);
    }
    else
      printf("%s %c %s => %s\n",stringone, operator, secondstring, finalstring);


  }
}
