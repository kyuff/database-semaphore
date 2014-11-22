#!/bin/bash

echo "******CREATING DOCKER DATABASE******"
gosu postgres postgres --single <<- EOSQL
   CREATE DATABASE semaphore;
   CREATE USER sema WITH SUPERUSER PASSWORD 'semaphore'
   GRANT ALL PRIVILEGES ON DATABASE semaphore to sema;
EOSQL
echo ""
echo "******DOCKER DATABASE CREATED******"
