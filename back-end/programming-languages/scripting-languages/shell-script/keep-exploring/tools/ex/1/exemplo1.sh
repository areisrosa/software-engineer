#!/bin/bash
file1="file"
file2="/etc/passwd"

touch file

if [ $file1 -nt $file2 ]
then
    echo "the $file1 is more new than the $file2"
    ls -l $file1
    ls -l $file2
else
    echo "the $file1 is not more new than the $file2 or is not link"
    ls -l $file1
    ls -l $file2
fi
