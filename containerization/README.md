

**Virtualization**: 
    **Hypervisor**: virtualbox,vmware
    Hardware-level process isolations 

**Containerization** 
    OS-level process isolations
    **Container Engine**




- Dev -> Docker Desktop 

- Deploy -> **Docker Engine** 
    -> Install Portainer -> Open-source UI docker (Web Application) 
```bash
nginx web-server (443(https),80(http))
curl localhost:80 -> welcome 



image -> container

# download image from dockerhub to local machine 
docker pull nginx # (nginx:latest)
docker images # view images 
docker image ls 

# run container used nginx image 
docker run nginx 

# host-port:container-port 
# localhost:3000 -> nginx:80

docker run -d -p 3000:80 nginx

docker run -d -p 3000:80 --name nginx-cont nginx
docker stop nginx-cont 
docker rm nginx-cont # after stop , we can delete
docker rm -f nginx-cont 
docker logs -f nginx-cont
 
# volume = backup data from container 
docker volume create portainer_data

docker run -d -p 8000:8000 -p 9443:9443 --name portainer --restart=always -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce:lts



docker restart portainer 
docker logs -f portainer 

docker ps # list running container 
docker ps -a # list all container 
```


```bash 
docker container ls 
docker ps # running cont
docker ps -a
# delete all stopped container 
docker container prune 

# image = blueprint,template => class 
# container = obj created from image 

# list images 
docker image ls 
docker images 



```


+ Deploy Postgres Containers 

```bash 
# username: postgres 
# database: postgres 
docker run -dp 5432:5432 \
    -e POSTGRES_PASSWORD=password123 \
    --name postgres-cont postgres

docker run -dp 5432:5432 \
    -e POSTGRES_PASSWORD=password123 \
    -e POSTGRES_USER=postgresadmin \
    -e POSTGRES_DB=studentdb \
    --name postgres-cont postgres
docker logs -f postgres-cont 
```

## Writing your own dockerfile 

Dockerfile
```bash 
# Dockerfile
docker build -t image-name . 

# dev.Dockerfile 
docker build -t image-name -f dev.Dockerfile .
```
```bash
git clone https://github.com/keoKAY/reactjs-devop8-template.git reactjs


cd reactjs 
# Dockerfile  -> follow convention
# dev.Dockerfile 
# prod.Dockerfile , openshift.Dockerfile 

docker build -t dev-reactjs-img  .
docker run -dp 3000:3000 --name react-cont dev-reactjs-img 

docker builder ls
docker system df # check overall usage 
docker builder prune # delete  
```

Multi-staged dockerfile 
- Reduce image size ( by removing build dependencies )

```bash 
prod.Dockerfile 

docker build -t prod-react-img -f prod.Dockerfile .
docker run -dp 3001:80 --name react-cont2 prod-react-img 
```


## Docker Compose
Following the convention  
- compose.yaml , compose.yml 
- docker-compose.yaml , docker-compose.yml





Dockerfile , Image, Container 
Multi-containers environment -> declarative ( docker compose )

### Data Persistence 
- **Docker Volume** : object of docker used to store values from the containers  
- **Bind Mount**: backup data from containers using file system host 

docker -v 
docker --mount 

volumes: 
    - vol-name:container-path 
    - ./path:container-path ..
### Docker Network 
Bridge 
Overlay 
Host 
None 
MacVLAN
IPVLAN 

- Docker use docker0(built-in bridge network)
    - What containers running the port but no conflicts ?
    - Why need to map port (-p 3000:80) when we want to access the container running port 80 

#### Custom Bridge Networks: 
```bash 
docker network create custom-network --driver bridge 
```
- allow inter-communication between each container suing container name or service name 

#### Host Network 
COntainers attached itself to Host Network Interface
```bash 
docker run -d --network host spring-img
```

#### NONE network 
for testing, for isolate the container from other networks 

#### Overlay (Swarm-like environment)
- Docker Swarm 