#!/bin/bash

echo """
1. This is line one 
2. this is line two 
3. this is line three 
""" > echo-demo.conf 


cat << EOF > cat-demo.conf
1. this is first 
2. this is second 
3. this is third 
EOF

tee reverse-proxy.conf &> /dev/null << EOF
  server {
        listen 80;
        server_name ecom.istad.dev; # Change to your domain or subdomain

        location / {
            # Route traffic to the Docker service name and internal port
            proxy_pass http://localhost:3000; 
            
            # Forward critical client headers
            proxy_set_header Host \$host;
            proxy_set_header X-Real-IP \$remote_addr;
            proxy_set_header X-Forwarded-For \$proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto \$scheme;
        }
    }
EOF



