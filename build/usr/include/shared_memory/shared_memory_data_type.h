#ifndef _SHARED_MEMORY_DATA_TYPE_HEADER_INCLUDE
#define _SHARED_MEMORY_DATA_TYPE_HEADER_INCLUDE


#define SHARED_MEMORY_DATA_TYPE_UNKNOWN	0
#define SHARED_MEMORY_DATA_TYPE_INT 	1
#define SHARED_MEMORY_DATA_TYPE_FLOAT   2
#define SHARED_MEMORY_DATA_TYPE_DOUBLE  3
#define SHARED_MEMORY_DATA_TYPE_LONG    4
#define SHARED_MEMORY_DATA_TYPE_CHAR    5

#define SIZEOF_SHARED_MEMORY_DATA_TYPE_INT() (sizeof(int))
#define SIZEOF_SHARED_MEMORY_DATA_TYPE_FLOAT() (sizeof(float))
#define SIZEOF_SHARED_MEMORY_DATA_TYPE_DOUBLE() (sizeof(double))
#define SIZEOF_SHARED_MEMORY_DATA_TYPE_LONG() (sizeof(long))
#define SIZEOF_SHARED_MEMORY_DATA_TYPE_CHAR() (sizeof(char))

int	shared_memory_data_type_size(char *type, char *datatype);

void	int2bytes(int what, char endian, unsigned char **result);
void	long2bytes(long int what, char endian, unsigned char **result);
void	float2bytes(float what, char endian, unsigned char **result);
void	double2bytes(double what, char endian, unsigned char **result);

int	bytes2int(char endian, unsigned char **bytes);
long int	bytes2long(char endian, unsigned char **bytes);
float	bytes2float(char endian, unsigned char **bytes);
double	bytes2double(char endian, unsigned char **bytes);

#endif
