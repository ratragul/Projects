/* The functions operate on a linked list of free blocks.  Each node of the
 * list contains the starting location and the length of a free block.
 * 
 */

#include <string.h>
#include <stdlib.h>

#include "free_list.h"

/* Give free space back to the free list.  Since the list is ordered by 
 * location, this function is the same for both algorithms.
 */
void add_free_block(FS *fs, int location, int size) {
 	int counter = 0;
 	
	if (fs->freelist == NULL)
	{
		Freeblock *list = malloc(sizeof(fs->freelist));
		Freeblock *first_node = list;
		first_node->offset = 512;
		first_node->length = 1024;
		first_node->next = NULL;
		fs->freelist = list;
	}
	else
	{
		Freeblock *first_node = fs->freelist;
		Freeblock *previous  = fs->freelist;
		Freeblock *next_node = previous->next;

		while(next_node != NULL && counter == 0)
		{
			
			if ((previous->offset + previous->length) == location && (location + size) == next_node->offset)
			{
				previous->length = previous->length + size + next_node->length;
				previous->next = next_node->next;
				free(next_node);
				counter = 1;
			}
			else if((previous->offset + previous->length) == location)
			{
				previous->length = previous->length + size;
				counter = 1;
			}
			else if((location + size) == next_node->offset)
			{
				next_node->offset = location;
				next_node->length = next_node->length + size;
				counter = 1;
			}
			
			else if((location + size) < next_node->offset && (previous->offset + previous->length) < location)
			{
				Freeblock *new_node = malloc(sizeof(Freeblock));
				new_node->offset = location;
				new_node->length = size;
				previous->next = new_node;
				new_node->next = next_node;
				counter = 1;
			}
			else
			{
				previous = next_node;
				next_node = next_node->next;
			}
		}

		//if the location is way below the last freenode
		if (location > (previous->offset + previous->length) && counter != 1)
		{
			Freeblock *new_node = malloc(sizeof(Freeblock));
			new_node->offset = location;
			new_node->length = size;
			previous->next = new_node;
			new_node->next = NULL;
		}

		previous = first_node;
		//if adding on top of the first node and all of it
		if((location + size) == previous->offset && counter != 1)
		{
			previous->offset = location;
			previous->length = previous->length + size;
		}
		// if adding on top of the first node..partially (making new head)
		else if((location + size) < previous->offset && counter != 1)
		{
			Freeblock *new_head = malloc(sizeof(fs->freelist));
			first_node = new_head;
			new_head->offset = location;
			new_head->length = size;
			new_head->next = previous;
		}
		
		fs->freelist = first_node;
	}


	return;
}

/* Print the contents of the free list */

void show_freelist(FS *fs) {
	
		Freeblock *first_node = fs->freelist;
		int offset = first_node->offset;
		int length = first_node->length;
		int counter = 1;

		Freeblock *next_node = first_node->next;
		printf("Free List\n");
		printf("(offset: %d, length: %d)\n", offset, length);
		while(counter == 1 || next_node != NULL)
		{
			counter++;			
			if (next_node != NULL)
			{
				offset = next_node->offset;
				length = next_node->length;
				printf("(offset: %d, length: %d)\n", offset, length);
				next_node = next_node->next;
			}
		}
	
		fs->freelist = first_node;
	
	return;
}


/* To be used after the metadata has been read from a file, to rebuild the
 * free list.
 */
void rebuild_freelist(FS *fs) {
	
	Freeblock *first_node = malloc(sizeof(fs->freelist));
	Freeblock *previous = first_node;
	Freeblock *current_node = first_node;

	current_node->offset = 512;
	current_node->length = 1024;
	current_node->next = NULL;

	for (int i = 0; i < MAXFILES; i++)
	{
		Inode file = fs->metadata[i];
		while(current_node != NULL)
		{
			//file starting and ending is within this block
			if (file.offset >= current_node->offset && (file.length + file.offset) <= current_node->offset + current_node->length)
			{
				//if entire block is not being written to (to top)
				if ((file.length + file.offset != current_node->offset + current_node->length) && file.offset == current_node->offset)
				{
					current_node->offset = current_node->offset + file.length;
					current_node->length = current_node->length - file.length;
				}
				//if entire block is not being written to (to bottom)
				else if((file.length + file.offset == current_node->offset + current_node->length) && file.offset != current_node->offset)
				{
					current_node->length = current_node->length - file.length;
				}
				//entire block is getting written to
				else if(file.offset == current_node->offset && file.length == current_node->length)
				{
					//if first node
					if (previous == current_node)
					{
						if (current_node->next != NULL)
						{
							first_node = current_node->next;
						}
						else
						{
							first_node = NULL;
						}
						free(current_node);
					}

					//if last node
					else if (current_node->offset + current_node->length == 1536)
					{
						previous->next = NULL;
						free(current_node);
					}
					//if middle node
					else
					{
						previous->next = current_node->next;
						free(current_node);
					}
				}
				//split the freenode
				else
				{
					Freeblock *next_node = current_node->next;
					int temp_len = current_node->length;

					current_node->length = file.offset - current_node->offset;

					Freeblock *new_node = malloc(sizeof(fs->freelist));
					current_node->next = new_node;
					new_node->offset = file.length + file.offset;
					new_node->length = temp_len - current_node->length - file.length;
					new_node->next = next_node;
				}
			}
			else
			{
				previous = current_node;
				current_node = current_node->next;
			}
		}
		current_node = first_node;
	}

	fs->freelist = first_node;

    return;
}

