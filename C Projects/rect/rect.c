#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

extern void InitRect(struct rect *rectangle)
{
  printf("Please enter the South West Coordinates seperated by a space: ");
  scanf("%d %d", &rectangle->sw.x, &rectangle->sw.y);

  printf("Please enter the North West Coordinates seperated by a space: ");
  scanf("%d %d", &rectangle->nw.x, &rectangle->nw.y);

  printf("Please enter the North East Coordinates seperated by a space: ");
  scanf("%d %d", &rectangle->ne.x, &rectangle->ne.y);

  printf("Please enter the South East Coordinates seperated by a space: ");
  scanf("%d %d", &rectangle->se.x, &rectangle->se.y);
}

extern int ValidateRect(struct rect rectangle)
{
  int ney = rectangle.ne.y;
  int nwy = rectangle.nw.y;
  int sey = rectangle.se.y;
  int swy = rectangle.sw.y;
  int nex = rectangle.ne.x;
  int nwx = rectangle.nw.x;
  int sex = rectangle.se.x;
  int swx = rectangle.sw.x;



  if (ney == nwy && sey == swy && nex == sex && nwx == swx)
  {
    return 1;
  }
  else
  {
    return 0;
  }
}

extern int RectArea(struct rect rectangle)
{
  int side1 = rectangle.ne.x - rectangle.nw.x;
  int side2 = rectangle.nw.y - rectangle.sw.y;
  int area = side1*side2;
  return area;
  return 0;
}

extern void RotateRect(struct rect *rectangle)
{
  int tnwy, tswy, tnex, tnwx, tswx;
  int horiside, vertiside;

  tnwy = *(&rectangle->nw.y);
  tswy = *(&rectangle->sw.y);
  tnex = *(&rectangle->ne.x);
  tnwx = *(&rectangle->nw.x);
  tswx = *(&rectangle->sw.x);

  horiside = tnex - tnwx;
  vertiside = tnwy - tswy;

  *(&rectangle->se.y) = tswy;
  *(&rectangle->se.x) = tswx;

  *(&rectangle->sw.y) = tswy + horiside;
  *(&rectangle->sw.x) = tswx;
  *(&rectangle->nw.y) = tswy + horiside;
  *(&rectangle->nw.x) = tswx + vertiside;
  *(&rectangle->ne.y) = tswy;
  *(&rectangle->ne.x) = tswx + vertiside;

}

extern void PrintRect(struct rect rectangle)
{
  printf("South West Coordinates: (%d, %d)\n", *(&rectangle.sw.x), *(&rectangle.sw.y));
  printf("North West Coordinates: (%d, %d)\n", *(&rectangle.nw.x), *(&rectangle.nw.y));
  printf("North East Coordinates: (%d, %d)\n", *(&rectangle.ne.x), *(&rectangle.ne.y));
  printf("South East Coordinates: (%d, %d)\n", *(&rectangle.se.x), *(&rectangle.se.y));
}
