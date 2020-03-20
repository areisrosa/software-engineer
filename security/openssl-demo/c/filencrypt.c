/*
 * This program encrypt/decrypt a file using AES given an existing key
 * Usage: filencrypt <keyfile> -d|-e <file>
 * Use -d to decrypt and -e to encrypt
 * Decrypt generates a <file>.asc and encrypt generates a <file>.aes
 * Reference: https://wiki.openssl.org/index.php/EVP_Symmetric_Encryption_and_Decryption
 * Author: tonyk <andrealmeid@riseup.net> - ENIGMA
 * License: GPLv2
 */

#include <stdio.h>
#include <string.h>
#include <openssl/rand.h>
#include <openssl/err.h>
#include <openssl/evp.h>

// mode operation flag
#define ENCRYPT 0
#define DECRYPT 1
#define ERROR -1

#define KEY_LEN 256/8 // 256 bits key = 32 bytes key
#define BLOCK_LEN 128/8 // AES block size = 16 bytes
#define BUF_LEN 16 * 64 // buffer size, it must be a 16 bytes multiple = 1024 bytes
#define CIPHER_MODE EVP_aes_256_cbc()

typedef uint8_t byte;

void printUsage(){
	printf("Usage: filencrypt <keyfile> -d|-e <file>\n");
	printf("Use -d to decrypt and -e to encrypt\n");
}

/* Do a basic check at user input and return the mode [encrypt, decrypt] */
int checkInput(int argc, char *argv[]){
	if (argc < 2) {
		printUsage();
		exit(1);
	}

	if (!strcmp(argv[1], "--help")  || !strcmp(argv[1], "-h") || argc != 4) {
		printUsage();
		exit(1);
	}

	if (!strcmp(argv[2], "-e"))
		return ENCRYPT;
	else if (!strcmp(argv[2], "-d"))
		return DECRYPT;

	printUsage();
	exit(1);
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

/* Open a key file from a given filename and place the content on a keybuffer */
int readKeyFile(char filename[], byte keybuffer[]){
	FILE *keyfile;

	keyfile = fopen(filename, "r+b");

	if (!keyfile) {
		printf("Error while reading keyfile. Exiting\n");
		return ERROR;
	}

	if (fread(keybuffer, KEY_LEN, 1, keyfile) != 1) {
		printf("Error while reading keyfile. Exiting\n");
		return ERROR;
	}

	fclose(keyfile);

	return 0;
}

/* Encrypt the file using the key and IV */
void encrypt(byte aes_key[], byte iv[], char filename[],
		FILE *in_file, FILE *out_file, EVP_CIPHER_CTX *ctx){

	int cipher_block_size = EVP_CIPHER_block_size(CIPHER_MODE);
	int ret, len, read_chars = 0;
	unsigned char buffer[BUF_LEN];
	unsigned char crypto_buffer[BUF_LEN + cipher_block_size];

	// TODO: check if iv creation failed
	RAND_bytes(iv, BLOCK_LEN * sizeof(byte));

	// Plain file
	in_file = fopen(filename, "r");
	if (!in_file) {
		printf("Error while opening %s. Exiting.\n", filename);
		return;
	}

	// Encrypted file
	out_file = fopen(strcat(filename, ".aes"), "wb");
	if (!out_file) {
		printf("Error while opening %s. Exiting.\n",
				strcat(filename, ".aes"));
		return;
	}

	// write IV from the file begin
	fwrite(iv, sizeof(byte), BLOCK_LEN, out_file);

	// init encrypt
	ret = EVP_EncryptInit_ex(ctx, CIPHER_MODE, NULL, aes_key, iv);
	handleErrors(ret);

	// while there are chars to read, read an encrypt
	do {
		read_chars = fread(buffer, sizeof(unsigned char),
				BUF_LEN, in_file);

		ret = EVP_EncryptUpdate(ctx, crypto_buffer, &len,
				buffer, read_chars);
		handleErrors(ret);

		fwrite(crypto_buffer, sizeof(unsigned char), len,
				out_file);

	} while(read_chars >= BUF_LEN);

	// finalize encryption
	ret = EVP_EncryptFinal(ctx, crypto_buffer, &len);
	handleErrors(ret);

	fwrite(crypto_buffer, sizeof(unsigned char), len,
			out_file);

	// success message
	printf("File successfully encrypted; %s has been generated.\n", filename);

	fclose(in_file);
	fclose(out_file);
}

/* Decrypt the file using the key and IV */
void decrypt(byte aes_key[], byte iv[], char filename[],
		FILE *in_file, FILE *out_file, EVP_CIPHER_CTX *ctx){
	puts("\nI don't know how to decrypt yet :(\n");
}

int main(int argc, char *argv[]){

	// defines if mode is encrypt/decrypt
	int mode;

	// file in plain text and encrypetd file
	FILE *file_plain = NULL, *file_encrypt = NULL;

	// crypto buffers
	byte aes_key[KEY_LEN], iv[BLOCK_LEN];

	// crypto context
	EVP_CIPHER_CTX *ctx;

	// get the mode [encrypt/decrypt]
	mode = checkInput(argc, argv);

	// load the AES key
	if (readKeyFile(argv[1], aes_key) == ERROR)
		return ERROR;

	// initialize crypto context
	ctx = EVP_CIPHER_CTX_new();
	if (!ctx)
		handleErrors(0);

	// do the operation
	if (mode == ENCRYPT)
		encrypt(aes_key, iv, argv[3], file_plain, file_encrypt, ctx);
	else if (mode == DECRYPT)
		decrypt(aes_key, iv, argv[3], file_encrypt, file_plain, ctx);

	// free ctx
	EVP_CIPHER_CTX_cleanup(ctx);

	return 0;
}
