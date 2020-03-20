#!/usr/bin/python3

import os
import sys
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import padding

ENCRYPT = 0
DECRYPT = 1

BLOCK_LEN_BITS = 128 # 128 bits
BLOCK_LEN_BYTES = BLOCK_LEN_BITS // 8 # 16 bytes

# Print help message
def print_usage():
    print('Usage: python3 filencrypt_py.py <keyfile> -d|-e <file>')
    print('Use -d to decrypt and -e to encrypt')

# Check user input
def check_input():
    if len(sys.argv) != 4 or sys.argv[1] == '-h' or sys.argv[1] == '--help':
        print_usage()
        quit()

    if sys.argv[2] == '-e':
        return ENCRYPT
    elif sys.argv[2] == '-d':
        return DECRYPT

# Encrypt the file
def encrypt(filename, key):
    # Generate iv
    iv = os.urandom(BLOCK_LEN_BYTES)

    # Open plain file
    with open(filename, 'rb') as plain_file:
        # Read data
        plain_data = plain_file.read()

        # Add padding to the data
        padder = padding.PKCS7(BLOCK_LEN_BITS).padder()
        padded_data = padder.update(plain_data) + padder.finalize()

        # Open encrypted file
        with open(filename + '.aes', 'wb') as encrypted_file:
            # Write iv
            encrypted_file.write(iv)

            # Init encryption
            cipher = Cipher(algorithms.AES(key), modes.CBC(iv), backend = default_backend())
            encryptor = cipher.encryptor()

            # Encrypt
            encyrpted_message = encryptor.update(padded_data)

            # Finalize encryption
            encryptor.finalize()

            encrypted_file.write(encyrpted_message)

            # success message
            print("File successfully encrypted; " + filename + ".aes has been generated.");

# Decrypt the file
def decrypt(filename, key):
    print("\nI don't know how to decrypt yet :(\n")

################ The actual script ################

mode = check_input()

# Read key from file
with open(sys.argv[1], 'rb') as file:
    aes_key = file.read()

if mode == ENCRYPT:
    encrypt(sys.argv[3], aes_key)
elif mode == DECRYPT:
    decrypt(sys.argv[3], aes_key)
