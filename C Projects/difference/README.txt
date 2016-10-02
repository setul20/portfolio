Setul Patel

Command:
	gcc -Wall -o difference difference.c
	./difference (file1name) (file2name)

Timing Difference Explanation:
For the first step what we are doing is we are taking a file that is saved on the hard drive and opening it and reading it character by character and it goes back to hard drive after each character is read than it compares each character to the character of the other file and than writes the difference into the new file.  The second step instead reads the file in hard drive and puts all the content in a dynamically alocated array which is on RAM and than commpares it and than writes the difference to the the new file. 
