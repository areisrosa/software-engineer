/*
 * This program generates a random AES 256 key
 * Usage: gen-key <key_filename>
 * Reference: https://wiki.openssl.org/index.php/Random_Numbers
 * Author: tonyk <andrealmeid@riseup.net> - ENIGMA
 * License: GPLv2
 */

#include <stdio.h>
#include <string.h>
#include <openssl/rand.h>
#include <openssl/err.h>

#define KEY_LEN 256/8 // 256 bits key = 32 bytes key
#define SEED_LEN 32 // length of RNG seed

typedef uint8_t byte;

/* Do a basic check at user input */
void checkInput(int argc, char *argv[]){
	if(argc != 2){
		printf("Usage: gen-key <keyfile>\n");
		exit(1);
	}

	if(!strcmp(argv[1], "--help")  || !strcmp(argv[1], "-h")){
		printf("Usage: gen-key <keyfile>\n");
		exit(1);
	}
}

/* OpenSSL default success return is 1
 * if ret != 1, print error message and
 * exit with error
 */
void handleErrors(int ret)
{
	if (ret != 1){
		ERR_print_errors_fp(stderr);
		abort();
	}
}

/* Ressed the OpenSSL RNG with a fresh seed
 * This isn't really necessary since OpenSSL will do it automatically
 */
void reseedRNG(){
	int ret = RAND_load_file("/dev/random", SEED_LEN);
	printf("Read %d bytes from /dev/random.\n", ret);

	if(ret != SEED_LEN){
		printf("ERROR: Could not get enough random bytes.\n");
		abort();
	}
}

int main(int argc, char *argv[]){

	byte aes_key[KEY_LEN]; // key buffer
	int ret, i;
	FILE *keyfile;

	checkInput(argc, argv);

	reseedRNG();

	// generation key
	// one can also use the more complex EVP_BytesToKey()
	ret = RAND_bytes(aes_key, sizeof(aes_key));
	handleErrors(ret);

	// never print this in production
	printf("Your AES key has %u bytes and it is:\n", KEY_LEN);
	for(i = 0; i < KEY_LEN; i++)
		printf("%02x ", aes_key[i]);
	printf("\n");

	// open file
	keyfile = fopen(argv[1], "wb");

	// write key to the file
	ret = fwrite(aes_key, KEY_LEN, 1, keyfile);
	if(ret != 1){
		printf("Error while writing key to file. Exiting.\n");
		exit(1);
	}

	printf("Key saved on file %s.\n", argv[1]);

	// replace the key in memory
	ret = RAND_bytes(aes_key, sizeof(aes_key));
	handleErrors(ret);

	return 0;
}
