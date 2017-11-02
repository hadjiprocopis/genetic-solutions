#ifndef _ENDIANESS_INCLUDE
#define _ENDIANESS_INCLUDE

#define UVFS_BIG_ENDIAN      1
#define UVFS_LITTLE_ENDIAN   0

#define	B1	1
#define	B2	256
#define	B3	65536
#define	B4	16777216

#define BIGENDIAN2INT(b1,b2,b3,b4) ( (b1)*(B4) + (b2)*(B3) + (b3)*(B2) + (b4)*(B1) )
#define LITTLEENDIAN2INT(b1,b2,b3,b4) ( (b1)*(B1) + (b2)*(B2) + (b3)*(B3) + (b4)*(B4) )

char    hardware_endianess();
void	reverse_char_array(char *from, char *to, int size);
void	reverse_unsigned_char_array(unsigned char *from, unsigned char *to, int size);

#endif
