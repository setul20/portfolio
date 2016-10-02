#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <dirent.h>
#include <errno.h>
#include <sys/stat.h>
#include <unistd.h>

void search(char *dir, char *filename, int *file)
{
	DIR *directory;
	struct dirent *entry;
	struct stat fileinfo;
	char currentdirectory[100];


	if((directory = opendir(dir)) == NULL)
	{
		fprintf(stderr,"Unable to open directory. Exiting the program...\n");
		exit(0);
	}

	chdir(dir);

	while((entry = readdir(directory)) != NULL)
	{
		stat(entry->d_name,&fileinfo);
		if(S_ISDIR(fileinfo.st_mode))
		{

			/* Ignore . and .. */
			if(strcmp(".",entry->d_name) == 0 || strcmp("..",entry->d_name) == 0)
				continue;

				/* Go to new indent level */
				search(entry->d_name, filename, &(*file));
			}
			if(strcmp(filename,entry->d_name) == 0)
			{
				*file = 1;
				if(getcwd(currentdirectory, sizeof(currentdirectory)) != NULL)
				{
					printf("file %s found in directory %s\n",filename, currentdirectory);
				}
			}
		}

		chdir("..");
		closedir(directory);
}

int main(int argc, char *argv[])
{
	char filename[100];
	char directory[100];
	int file = 0;

	if(argc != 3)
	{
		printf("usage: findfile <filename> <starting directory path>\n");
		exit(0);
	}

	strcpy(filename, argv[1]);
	strcpy(directory, argv[2]);

  search(directory, filename, &file);

	if(file == 0)
	{
		printf("The file '%s' was not found.\n", filename);
	}

}
