## NOTE for docker volume 

```bash 
# list vol 
docker volume ls 
docker volume create database-vol
docker volume inspect database-vol

# delete vol that not used by containers 
docker volume prune

# image 
docker pull postgres 
# port , mount 
docker image inspect postgres | grep -A 3 "Volume" 
```

- `-v`: volume 
- `--mount`: volume 

```bash 
docker volume create database-vol 

# username: postgres
# database: postgres 
docker run -dp 5432:5432 \
    -e POSTGRES_PASSWORD=12345 \
    -v database-vol:/var/lib/postgresql \
    --name postgres-cont postgres

docker inspect postgres
# create the new container that uses the old data 
docker rm -f postgres-cont 
docker run -dp 5433:5432 \ 
    -v database-vol:/var/lib/postgresql \
    --name postgres-cont2 postgres 
```

- Bind Mount: 
Store all the data from the container in host machine's directory 
```bash 
mkdir postgres-backup 
docker run -dp 5432:5432 \
    -e POSTGRES_PASSWORD=12345 \
    -v ./postgres-backup:/var/lib/postgresql \
    --name postgres-cont postgres
```
