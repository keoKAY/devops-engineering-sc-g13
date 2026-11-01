#!/bin/bash
declare -a students # empty array 
users=("koko" "bona" "vipha"  "piseth" "pisey")
echo "First Name: ${users[0]}" 
echo "Fourth Name: ${users[3]}" 

# append value to array 
users+=("testing" "anotherone")

echo "All Names: ${users[@]}"

echo -e "\n+Print all name using loop"
for(( i=0; i<${#users[@]}; i++))
do 
    echo "Username: ${users[i]}"
done 

echo "+ For Item syntax"
for item in "${users[@]}"
do 
    echo "Username is : $item" 
done 