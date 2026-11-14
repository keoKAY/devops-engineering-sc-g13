## NOTE FOR NETWORK 

```bash
docker run -dp 3000:80 --name nginx-cont nginx


# running container using host network 
docker run -d  \
    --network host \
    --name nginx-cont nginx 

```


## Testing custom bridge network 
```bash
docker network create demo-network -d bridge
docker network ls
docker network inspect demo-network 

# terminal 1 
docker run -it --rm --name container1 \
    --network demo-network \
    busybox:latest
# terminal 2 
docker run -it --rm --name container2 busybox:latest
ping container1 
nslookup container1 

# terminal 3 
docker network connect demo-network container2
docker network disconnect demo-network container2 
```