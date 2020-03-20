#!/usr/bin/python3

import os
import sys
import binascii

KEY_LEN = 256//8 # 256 bits key = 32 bytes key
SEED_LEN = 32 # length of RNG seed

# Do a basic check at user input
def check_input():
    if len(sys.argv) != 2:
        print("Usage: python3 gen-key_py.py <keyfile>")
        quit()
    
    if sys.argv[1] == '-h' or sys.argv[1] == '--help':
        print("Usage: python3 gen-key_py.py <keyfile>")
        quit()


################ The actual script ################
check_input()

# Key Generation
aes_key = os.urandom(KEY_LEN)

# Never print this in production
print("Your key has been created! Here are it bytes:")
print(binascii.hexlify(aes_key))

# Write key to file
with open(sys.argv[1], 'wb') as file:
    file.write(aes_key)

# Replace the key in memory
aes_key = os.urandom(KEY_LEN)
