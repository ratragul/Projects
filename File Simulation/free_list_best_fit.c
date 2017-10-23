#include <string.h>
#include <stdlib.h>

#include "free_list.h"

/* Implement the best fit algorithm to find free space for the
   simulated file data.
 */

int get_free_block(FS *fs, int size) {
	Freeblock *first_node = fs->freelist;

	Freeblock *previous = fs->freelist;
	Freeblock *current = fs->freelist;
	Freeblock *next_node = current->next;

	int shortDifference = -1;
	int selected_offset = -1;

	while(current != NULL)
	{
		if (shortDifference == -1 || (current->length - size) < shortDifference )
		{
			if((current->length - size) >= 0)
			{
				shortDifference = current->length - size;
				selected_offset = current->offset;
			}
			
		}
		
		previous = current;
		current = next_node;
		if (next_node != NULL)
		{
			next_node = next_node->next;
		}		
	}

	previous = first_node;
	current = first_node;
	next_node = current->next;

	int counter = 0;
	while(current != NULL && counter == 0)
	{
		//if reached the node at which we add the file
		if (current->offset == selected_offset)
		{
			//if length of node is equal to the size of file
			if (size == current->length)
			{
				//if first node
				if (previous == current)
				{
					first_node = current->next;
					free(current);
				}
				//if last node
				else if(current->next == NULL)
				{
					previous->next = NULL;
					free(current);
				}
				//if in middle
				else
				{
					previous->next = next_node;
					free(current);
				}
			}
			//if not then we just decrease the size of the node
			else
			{
				current->offset = current->offset + size;
				current->length = current->length - size;
			}
			
			counter++;
		}
		else
		{
			previous = current;
			current = next_node;
			if (next_node != NULL)
			{
				next_node = next_node->next;
			}
			
		}

	}
	fs->freelist = first_node;

	if (selected_offset != -1)
	{
		return selected_offset;
	}
    return -1;
}


