#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>

#ifndef PROJECT_HASH_TABLE_H
#define PROJECT_HASH_TABLE_H

const int kTableSize = 100;
char* kDummy = "<dummy>";

typedef struct KeyValue {
  char* key;
  char* value;
} key_value;

typedef struct HashTable {
  key_value** data;
  int size;
} hash_table;

// creates a new hash table with size slots.
hash_table* create_table(int size);
// frees memory associated with given hash table.
void destroy_table(hash_table* table);
// universal string hashing algorithm
int hash(const char* key, const int m);
// outputs the content of the hash table
void print_debug(hash_table* table);
// returns true if the given key exists in the table
bool exists(const hash_table* table, const char* key);
// add the given key and object to hash table. If key exists, update the value.
void add(hash_table* table, const char* key, const key_value* object);
// returns the value associated with the given key, or NULL if it doesn't exist
char* get(const hash_table* table, const char* key);
// removes the value associated with key from the table.
void delete(hash_table* table, const char* key);

#endif
