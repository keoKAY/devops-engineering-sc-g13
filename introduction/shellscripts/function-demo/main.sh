#!/bin/bash

# load function 
util_path="./util.sh"

# -f check if file exist 
if [ -f $util_path ]; then 
    echo "Sourcing the function file 🟢" 
    source $util_path
else 
    echo "$util_path NOT FOUND ❌" 
    exit 1 
fi 

echo "1. This is the main script " 
echo "Filename is $0" 

greeting "bona"
check_service "nginx" 
check_service "docker" 