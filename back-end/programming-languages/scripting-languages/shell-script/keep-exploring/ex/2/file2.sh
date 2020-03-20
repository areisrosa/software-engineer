#!/bin/bash

file="/etc/passwd"

if [ -w $file ]
then
    echo "this file is writable."
else
    echo "this user has not permission for record in the file $file."
    ls -l $file
fi

