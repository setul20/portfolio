#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <signal.h>
#include <unistd.h>

int i;
int maincond;

void sighandler(int signumber){
	if (signumber == SIGINT)
	{
		if(i != 0)
		{
			printf("Received ctrl-c\n");
			printf(">");
			fflush(stdout);
			maincond = 0;
		}


	}
}

int main()
{
	char inputstring[80];
	i = 1;
	maincond = 1;
	int mainloop = 1;
	char *temp;
	int background = 1;
	int quit;


	signal(SIGINT, sighandler);

	while (mainloop)
	{
		if(maincond)
		{
			printf(">");
		}
		if (maincond == 0)
		{
			maincond = 1;
		}

		fgets(inputstring, sizeof(inputstring), stdin);

		temp = strchr(inputstring, '\n');

		while (temp!=NULL)
		{
			inputstring[temp-inputstring] = 0;
			if (inputstring[temp - inputstring-1] == '&')
			{
				background = 0;
				inputstring[temp-inputstring-1] = 0;
			}
			temp = strchr(temp+1,'\n');
		}

		quit = strcmp("exit", inputstring);

		if (quit == 0)
		{
			exit(0);
		}

		char ** result  = NULL;
		char *  temppointer    = strtok (inputstring, " ");
		int spaces = 0, j = 1;

		while (temppointer)
		{
			result = realloc (result, sizeof (char*) * ++spaces);
			if (result == NULL)
				exit (-1);
			result[spaces-1] = temppointer;
			temppointer = strtok (NULL, " ");
		}

		result = realloc (result, sizeof (char*) * (spaces+1));
		result[spaces] = 0;

		if(j != 0)
		{
			j = fork();
		}
		if (j == 0)
		{
			if(execvp(result[0],result) == -1)
			{
				printf("Command not found -- Child process exiting\n");
				fflush(stdout);
				exit(0);
			}
		}
		else
		{
			if(background)
			{
				wait(&i);
			}
		}
		free(result);
	}
}
