#!/bin/bash 


read -p "Enter your age: " age
read -p "Enter your grade: " grade 

echo -e "\n--------[OUTPUT]---------"
echo "Your Age is : $age" 
echo "Your Grade is : $grade"
if [[ $age -ge 18  &&  $grade -eq 12 ]]; then 
    echo "You are eligible for scholarship ✅"
else 
    echo "You are NOT elibigle ❌" 
fi 

# if (( $age >= 18 )); then  
#     echo "YOU ARE ELIGIBLE ✅ " 
# else 
#     echo "YOU ARE NOT ELIGIBLE ❌" 
# fi 
