#include <stdio.h>
#include <strings.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>

struct plane
{
	int pid;
	struct plane *next;
};

struct plane *start;
struct plane *end;
int mainpid;
int fuel;

void bomb(int signum)
{
	int bomber = getpid();
	printf("***Bomber %d to base, bombs away!***\nCommand:", bomber);
}

void crash(int signum)
{
	int target = getpid();
	if(target == mainpid)
	{
		printf("SOS! Plane has crashed!\nCommand:");
	}
	else
	{
		fuel = 100;
	}
}
void death(int signum)
{
	end = start;
	end -> next = (end -> next) -> next;
}

int main()
{
	setvbuf(stdout, NULL, _IONBF, 0);
	signal(SIGCHLD, death);
	signal(SIGUSR1, bomb);
	signal(SIGUSR2, crash);
	mainpid = getpid();

	start = (struct plane *)calloc(1, sizeof(struct plane));
	start -> next = NULL;
	int planepid, i;
	char *input[20];
	int mainloop  = 1;
	int valid;


	while(mainloop)
	{
		printf("Command:");
		scanf("%s", input);

		if(strcmp(input, "launch") == 0)
		{
			i = fork();

			if(i ==0)
			{
				fuel = 100;

				while(fuel>0)
				{
					if (fuel>55)
					{
						sleep(1);
						fuel-=5;
					}
					else
					{
						sleep(1);

						fuel-=15;
						if(fuel <= 40 && fuel > 0)
						{
							printf("***Bomber %d to base, %d fuel left***\nCommand:", getpid(), fuel);
						}
					}
				}

				if(fuel<=0)
				{
					mainloop =0;
					kill(mainpid, SIGUSR2);
				}
			}
			else
			{
				end = start;

				while(end->next != 0)
					end = end -> next;

				end ->next = (struct plane *)calloc(1, sizeof(struct plane));
				end = end -> next;
				end -> pid = i;
				end -> next = NULL;
			}
		}
		else if(strcmp(input, "status") == 0)
		{
			end = start;
			printf("The current planes are: ");
			while(end->next != 0)
			{
				printf("%d ", (end->next)->pid);
				end = end->next;
			}
			printf("\n");
		}
		else if(strcmp(input, "bomb") == 0)
		{
			scanf("%d", &planepid);
			int temp = planepid;
			valid = kill(planepid, SIGUSR1);
			if(valid)
			{
				printf("Invalid plane number\n");
			}
		}
		else if(strcmp(input, "refuel") == 0)
		{
			scanf("%d", &planepid);
			valid = kill(planepid, SIGUSR2);
			if(valid)
			{
				printf("Invalid plane number\n");
			}
		}
		else if(strcmp(input, "quit") == 0)
		{
			end = start;
			while(end->next != 0)
			{
				free(end);
				kill(end->pid, SIGKILL);
				end = end->next;
			}
			free(end);
			kill(end->pid, SIGKILL);
			exit(0);
		}
		else
			printf("Invalid Command\n");
	}
}
