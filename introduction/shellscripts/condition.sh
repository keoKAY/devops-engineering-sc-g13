#!/bin/bash

# check status code or exit code: $?
# 0 = success 
nginx -v  &> /dev/null 
if [[ $? -eq 0 ]]; then 
    echo "Nginx is already installed ✅" 
    # apply configuration .. 
else 
    echo "Nginx is NOT installed ❌"
    sudo apt install nginx -y 
fi 
