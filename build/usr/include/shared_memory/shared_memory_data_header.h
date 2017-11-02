#ifndef _SHARED_MEMORY_DATA_HEADER_INCLUDE
#define _SHARED_MEMORY_DATA_HEADER_INCLUDE

#define	SHARED_MEMORY_DATA_MAX_DIMENSIONS	100

typedef	struct	{
	char	big_endian;	/* big endian = 1, little endian = 0, bigendian = MSB is first byte read */
	char	ndim;		/* num dimensions - a byte is enough for max of 4 dimensions */
	char	datatype;	/* see 'shared_memory_data_type.h' for data types and their char equivalent */
	int	sz_datum,	/* size of one datum in bytes, e.g. float -> sizeof(float) */
		sz_data,	/* size of the whole data e.g. sz_dim1*sz_dim2*...*sz_datum */
		sz_items;	/* number of items (e.g. integers) */
	int	*sz_dim;	/* number of items in dimension X - note that even if you have 2 dimensions, you will still have an array of SHARED_MEMORY_DATA_MAX_DIMENSIONS */
} shared_memory_data_header;

char	hardware_endianess();
void	print_shared_memory_data_header(FILE *fh, shared_memory_data_header *h);
int	read_shared_memory_data_header(void *shm, shared_memory_data_header *h);
int	write_shared_memory_data_header(void *shm, shared_memory_data_header *h);
void	zero_shared_memory_data_header( shared_memory_data_header *h);
int	initialise_shared_memory_data_header(char *dimspec, shared_memory_data_header *h);
void	destroy_shared_memory_data_header(shared_memory_data_header *h);
int	sizeof_header(shared_memory_data_header *h);
#endif
