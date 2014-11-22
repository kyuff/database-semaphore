FROM ubuntu:14.10

RUN apt-get update && apt-get install -y openjdk-8-jre-headless \
				         postgresql-client \
    && apt-get clean

ENTRYPOINT psql --username=docker --host=db --dbname=docker --password
