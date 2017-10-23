#include <string.h>
#include <stdlib.h>

#include "free_list.h"

/* Implement the first fit algorithm to find free space for the
   simulated file data.
 */

int get_free_block(FS *fs, int size) {

	Freeblock *first_node = fs->freelist;

	Freeblock *previous = fs->freelist;
	Freeblock *current = fs->freelist;

	int offset = 0;
	int counter = 1;
	while(current != NULL && counter == 1)
	{
		if (current->length > size)
		{
			offset = current->offset;
			current->offset = current->offset + size;
			current->length = current->length - size;
			counter++;
		}
		else if(current->length == size)
		{
			offset = current->offset;
			if (previous == current)
			{
				first_node = current->next;
				free(current);
			}
			else
			{
				previous->next = current->next;
				free(current);
			}
			counter++;
		}
		else
		{
			previous = current;
			current = current->next;
		}
	}
	fs->freelist = first_node;

	if (offset != 0)
	{
		return offset;
	}
    return -1;
}

