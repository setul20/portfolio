#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int main()
{
  //all the variables go here
  int playing, difficulty, secretnumber, guess, correct, sum, count;
  int mainloop = 1, difflevel = 1;

  srand(time(NULL));

  //main loop that will ask if they want to play or not
  while (mainloop)
  {
    printf("Would you like to play Mastermind (Enter 1 for yes, 0 for no)? ");
    scanf("%d", &playing);

    //if said yes than it will go into here
    if (playing == 1)
    {
      while (difflevel)
      {
        //ask them for the level they want to play
        printf("Please enter the level of difficulty (beginner (1), intermediate (2), advanced (3)): ");
        scanf("%d", &difficulty);

        //the first level with 3 digits
        if (difficulty == 1)
        {
          secretnumber = rand()%900+100;
          printf("(Testing Mode - the 3 digits number: %d)\n", secretnumber);

          //loops over and checks if they are getting close or if they got it or not
          for (count = 1; count <= 30; count++)
          {
            printf("Please guess that 3 digits number: ");
            scanf("%d", &guess);

            if (guess == secretnumber)
            {
              printf("You Won!!!\n");
              difflevel = 0;
              break;
            }

            if (guess - 1000 <= 0 && guess - 99 > 0)
            {
              correct = 0, sum = 0;

              if (secretnumber/100 == guess/100)
              {
                correct++;
                sum += secretnumber/100;
              }
              if (secretnumber%100/10 == guess%100/10)
              {
                correct++;
                sum += secretnumber%100/10;
              }
              if (secretnumber%10 == guess%10)
              {
                correct++;
                sum += secretnumber%10/1;
              }

              printf("Number of Correct Digits: %d\n", correct);
              printf("Sum: %d\n", sum);

            }
            else
              printf("The guess you have entered is ill-formed.\n");

            //checks if they have reached their max tries
            if (count == 30)
            {
              printf("Sorry, you lost!!!\n");
            }
          }
        }
        //second level with 4 digits
        else if (difficulty == 2)
        {
          secretnumber = rand()%9000+1000;
          printf("(Testing Mode - the 4 digits number: %d)\n", secretnumber);

          //does the same, checks and tell if they are close
          for (count = 1; count <= 20; count++)
          {
            printf("Please guess that 4 digits number: ");
            scanf("%d", &guess);

            if (guess == secretnumber)
            {
              printf("You Won!!!\n");
              difflevel = 0;
              break;
            }

            if (guess - 10000 <= 0 && guess - 999 > 0)
            {
              correct = 0, sum = 0;

              if (secretnumber/1000 == guess/1000)
              {
                correct++;
                sum += secretnumber/1000;
              }
              if (secretnumber%1000/100 == guess%1000/100)
              {
                correct++;
                sum += secretnumber%1000/100;
              }
              if (secretnumber%100/10 == guess%100/10)
              {
                correct++;
                sum += secretnumber%100/10;
              }
              if (secretnumber%10/1 == guess%10/1)
              {
                correct++;
                sum += secretnumber%10/1;
              }

              printf("Number of Correct Digits: %d\n", correct);
              printf("Sum: %d\n", sum);

            }
            else
              printf("The guess you have entered is ill-formed.\n");

            //checks if they reach their max tries
            if (count == 20)
            {
              printf("Sorry, you lost!!!\n");
            }
          }
        }
        //third level with 5 digit number
        else if (difficulty == 3)
        {
          secretnumber = rand()%90000+10000;
          printf("(Testing Mode - the 5 digits number: %d)\n", secretnumber);

          //checks and tell them if its close to the secret number
          for (count = 1; count <= 10; count++)
          {
            printf("Please guess that 5 digits number: ");
            scanf("%d", &guess);

            if (guess == secretnumber)
            {
              printf("You Won!!!\n");
              difflevel = 0;
              break;
            }

            if (guess - 100000 <= 0 && guess - 9999 > 0)
            {
              correct = 0, sum = 0;

              if (secretnumber/10000 == guess/10000)
              {
                correct++;
                sum += secretnumber/10000;
              }
              if (secretnumber%10000/1000 == guess%10000/1000)
              {
                correct++;
                sum += secretnumber%10000/1000;
              }
              if (secretnumber%1000/100 == guess%1000/100)
              {
                correct++;
                sum += secretnumber%1000/100;
              }
              if (secretnumber%100/10 == guess%100/10)
              {
                correct++;
                sum += secretnumber%100/10;
              }
              if (secretnumber%10/1 == guess%10/1)
              {
                correct++;
                sum += secretnumber%10/1;
              }

              printf("Number of Correct Digits: %d\n", correct);
              printf("Sum: %d\n", sum);
            }
            else
              printf("The guess you have entered is ill-formed.\n");

            //checks if they have reached max tries
            if (count == 10)
            {
              printf("Sorry, you lost!!!\n");
            }
          }
        }
        else
        {
          printf("Sorry, this is not a correct level.\n");
        }
      }
      difflevel = 1;
    }
    //terminates the game
    else if (playing == 0)
    {
      printf("The game has terminated. Goodbye.\n");
      exit(0);
    }
  }
  return 0;
}
