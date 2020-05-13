#!/bin/bash

echo "Starting program at $(date)" # Date will be substituted

echo "Running program $0 with $# arguments with pid $$"

for file in "$@"; do
    grep foobar "$file" > /dev/null 2> /dev/null
    # When pattern is not found, grep has exit status
    # We redirect STDOUT and STDERR to a null register since we do at care
    # about them
    if [[ "$?" -ne 0 ]]; then
        echo "File $file does not heve any foobar, adding one"
        echo "# foobar" >> "$file"
    fi
done
