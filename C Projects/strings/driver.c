#include <stdio.h>
#include <stdlib.h>
#include "strings.c"

int main()
{
  char stringone[50];
  char stringtwo[50];

  printf("enter a string: \t");
  scanf("%s", stringone);

  printf("length of stringone: \t%d\n", length(stringone));

  reverse(stringone);

  printf("reversed stringone: \t%s\n", stringone);

  printf("cloned pointer: \t%p\n", clone(stringone));

  printf("enter strings: \t");
  scanf("%s %s", stringone, stringtwo);

  printf("compared result: \t%d\n", compare(stringone, stringtwo));

  printf("concatnated pointer: \t%p\n", concat(stringone, stringtwo));

  printf("searched result: \t%d\n", search(stringone, stringtwo));

  insert(stringone, stringtwo, 0);
  printf("insert at 0: \t%s\n", stringone);

  insert(stringone, stringtwo, 7);
  printf("insert at 7: \t%s\n", stringone);

  insert(stringone, stringtwo, 3);
  printf("insert at 3: \t%s\n", stringone);

  char delimiter;
  printf("enter a string and delimter for the tokenizer\n");
  scanf("%s", stringone);
  scanf("%c", &delimiter);
  tokenize(stringone, delimiter,0);

  return 0;
}
