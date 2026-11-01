#!/bin/bash


# C Programming Style
for (( i=1;i<=10;i=i+1))
do 
    echo "$i. Hello World "
done 

for item in $(seq 1 5) 
do 
    echo "$item. Hello for Item In" 
done

echo "+ Using While Loop" 
counter=1
while [[ $counter -le 5 ]]
do 
    echo "$counter. Hello While Loop"
    ((counter++))
done 