## Hash table

### Purpose

The overall purpose of a hash table is:
- Find, delete, insert elements at constant time;
- Use basically anything as the key of an array.

### Real world usages
- Associative arrays(like hashes in ruby, dictionaries in python, etc);
- Database indexing(although B-Tree is more popular);
- Caches(auxiliar data tables to improve access to data);

### Description

Underneath, a hash table is just like an array. 

The main difference here, is that we can use basically anything as the key of that array, provide you can use an algorithm to transform that thing into an integer, to map that integer into an index of the array.

This part of transforming anything into a integer, to use as an index of an array is called using a hash function. The hash function is the main feature of the hash table.
