# NOTE 

```bash 
sudo apt install nginx tree fish -y 
# for certificates (tls,ssl)
sudo apt install certbot python3-certbot-nginx -y
```
- Install docker and docker compose 
- Install portainer (optional )
```bash
# Permission denied with docker  
sudo usermod -aG docker $USER
# manaully load the group 
newgrp docker 
```

## Deploy Service 
- sonarqube community (containers, using docker compose )
    - sonarqube 
    - postgres 
- jenkins server ( run on the server )

- configure the domain names  and https for each services using certbot and nginx 


```bash
sudo certbot --nginx --agree-tos -m lyvanna544@gmail.com  -d sc-sonar.akasdev.com --non-interactive

```
In order to get Certificate  
- http CHallenge 
    - port:80
    - domain name= Server IP run certbot 
- dns Challenges 