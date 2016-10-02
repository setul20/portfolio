#include <stdio.h>
#include <stdlib.h>
#include "rect.c"

int main(int argc, char *argv[])
{
	int area, valid;
  struct rect my_rect;
	InitRect(&my_rect);
	valid = ValidateRect(my_rect);

   if(valid)
	{
	   PrintRect(my_rect);
	   area = RectArea(my_rect);

	   printf("area is: %d\n", area);
	   RotateRect(&my_rect);
	   PrintRect(my_rect);
	}
	else
	{
		printf("Your rectangle is invalid\n");
	}
   return 0;
}
